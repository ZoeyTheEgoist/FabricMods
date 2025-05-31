package com.astrazoey.secondchance.mixins;


import com.astrazoey.secondchance.Config;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.*;


import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    float playerHealth;
    float damageAmount;
    boolean validBraceSource;
    float damageRemainder = 1.0f;
    float damageThreshold = Config.playerHealthThreshold;

    @Inject(method = "applyDamage", at = @At("HEAD"))
    public void getPlayerHealth(ServerWorld world, DamageSource source, float amount, CallbackInfo ci) {
        playerHealth = this.getHealth();
        damageAmount = amount;
        validBraceSource = !source.isOf(DamageTypes.FALL) && !source.isOf(DamageTypes.OUT_OF_WORLD) && !source.isOf(DamageTypes.FALLING_BLOCK) && !source.isOf(DamageTypes.FALLING_STALACTITE) && !source.isOf(DamageTypes.FALLING_ANVIL);
    }

    @ModifyArg(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setHealth(F)V"), index = 0)
    private float adjustFinalHealth(float amount) {
        if(amount <= 0.0f && playerHealth >= damageThreshold && validBraceSource) {
            amount = damageRemainder;
        }
        return amount;
    }
}

