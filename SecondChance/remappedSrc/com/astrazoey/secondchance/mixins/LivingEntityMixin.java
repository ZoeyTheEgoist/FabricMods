package com.astrazoey.secondchance.mixins;

import com.astrazoey.secondchance.MobHealthInterface;
import com.astrazoey.secondchance.MobHealthType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements MobHealthInterface {


    float entityHealth;
    float damageAmount;
    boolean validBraceSource;
    float damageRemainder = 0.0f;
    float damageThreshold = 1000.0f;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract float getHealth();

    @Inject(method = "applyDamage", at = @At("HEAD"))
    public void getEntityHealth(ServerWorld world, DamageSource source, float amount, CallbackInfo ci) {

        EntityType<?> entityType = this.getType();

        entityHealth = this.getHealth();
        damageAmount = amount;
        damageRemainder = 1.0f;

        validBraceSource = !source.isOf(DamageTypes.FALL) && !source.isOf(DamageTypes.OUT_OF_WORLD) && !source.isOf(DamageTypes.FALLING_BLOCK) && !source.isOf(DamageTypes.FALLING_STALACTITE) && !source.isOf(DamageTypes.FALLING_ANVIL) && !(source.getAttacker() instanceof PlayerEntity);

        if(entityType != null) {
            MobHealthType mobHealthType = MobHealthInterface.getHealthType(entityType);
            damageThreshold = mobHealthType.getHealthThreshold();
        }

    }



    @ModifyArg(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setHealth(F)V"), index = 0)
    private float adjustFinalHealth(float amount) {
        if(amount <= 0.0f && entityHealth >= damageThreshold && validBraceSource) {
            amount = damageRemainder;
        }
        return amount;
    }
}
