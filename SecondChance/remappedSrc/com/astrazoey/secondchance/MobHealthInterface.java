package com.astrazoey.secondchance;

import net.minecraft.entity.EntityType;

public interface MobHealthInterface {
    static void setHealthType(EntityType entityType, MobHealthType mobHealthType) {
        if(entityType == null) {
        } else {
            ((MobHealthInterface) entityType).setMobHealthType(mobHealthType);
        }
    }

    static MobHealthType getHealthType(EntityType entityType) {
        MobHealthType healthType = ((MobHealthInterface) entityType).getMobHealthType(entityType);

        if(healthType != null) {
            //System.out.println("Health type is not null for " + entityType);
            return healthType;
        } else {
            //System.out.println("Health type is null for " + entityType);
            return new MobHealthType(new MobHealthType.Settings().healthThreshold(50000f));
        }
    }

    void setMobHealthType(MobHealthType mobHealthType);
    MobHealthType getMobHealthType(EntityType entityType);
}
