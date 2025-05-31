package com.astrazoey.secondchance.mixins;

import com.astrazoey.secondchance.MobHealthInterface;
import com.astrazoey.secondchance.MobHealthType;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityType.class)
public class EntityTypeMixin implements MobHealthInterface {

    public MobHealthType healthType;

    @Override
    public void setMobHealthType(MobHealthType mobHealthType) {
        this.healthType = mobHealthType;
    }

    @Override
    public MobHealthType getMobHealthType(EntityType entityType) {
        return healthType;
    }
}
