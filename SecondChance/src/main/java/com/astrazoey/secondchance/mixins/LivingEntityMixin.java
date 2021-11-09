package com.astrazoey.secondchance.mixins;

import com.astrazoey.secondchance.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {


    float entityHealth;
    float damageAmount;
    boolean validBraceSource;
    float damageRemainder = 0.0f;
    float damageThreshold = 1000.0f;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract float getHealth();

    @Inject(method = "applyDamage", at = @At("HEAD"), cancellable = true)
    public void getEntityHealth(DamageSource source, float amount, CallbackInfo ci) {

        EntityType entityType = this.getType();

        entityHealth = this.getHealth();
        damageAmount = amount;
        damageRemainder = 1.0f;

        validBraceSource = !source.isFromFalling() && !source.isOutOfWorld() && !source.isFallingBlock() && !(source.getAttacker() instanceof PlayerEntity);

        if(entityType == EntityType.WOLF) {
            damageThreshold = Config.wolfHealthThreshold;
        } else if (entityType == EntityType.PARROT) {
            damageThreshold = Config.parrotHealthThreshold;
        } else if (entityType == EntityType.CAT) {
            damageThreshold = Config.catHealthThreshold;
        } else if ((entityType == EntityType.VILLAGER)
                || (entityType == EntityType.WANDERING_TRADER)) {
            damageThreshold = Config.villagerHealthThreshold;
        } else if (entityType == EntityType.AXOLOTL) {
            damageThreshold = Config.axolotlHealthThreshold;
        } else if ((entityType == EntityType.HORSE)
                || (entityType == EntityType.DONKEY)
                || (entityType == EntityType.SKELETON_HORSE)
                || (entityType == EntityType.ZOMBIE_HORSE)
                || (entityType == EntityType.MULE)
                || (entityType == EntityType.LLAMA)
                || (entityType == EntityType.TRADER_LLAMA)){
            damageThreshold = Config.mountHealthThreshold;
        } else if (entityType == EntityType.SNOW_GOLEM) {
            damageThreshold = Config.snowGolemHealthThreshold;
        } else if (entityType == EntityType.IRON_GOLEM) {
            damageThreshold = Config.ironGolemHealthThreshold;
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
