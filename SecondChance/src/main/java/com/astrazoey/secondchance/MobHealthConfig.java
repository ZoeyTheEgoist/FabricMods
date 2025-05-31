package com.astrazoey.secondchance;

import com.google.gson.annotations.SerializedName;

public class MobHealthConfig {
    @SerializedName("damage_threshold")
    public float damageThreshold;


    public MobHealthConfig(float damageThreshold) {
        this.damageThreshold = damageThreshold;
    }

    @SuppressWarnings("all")
    public void setDamageThreshold(float damageThreshold) {
        this.damageThreshold=damageThreshold;
    }


}
