package com.astrazoey.secondchance;

public class MobHealthType {

    public float healthThreshold;

    public MobHealthType(MobHealthType.Settings settings) {
        this.healthThreshold = settings.healthThreshold;
    }

    public float getHealthThreshold() {
        return healthThreshold;
    }



    public static class Settings {
        float healthThreshold;

        public Settings() {

        }

        public MobHealthType.Settings healthThreshold(float healthThreshold) {
            this.healthThreshold = healthThreshold;
            return this;
        }


    }

}
