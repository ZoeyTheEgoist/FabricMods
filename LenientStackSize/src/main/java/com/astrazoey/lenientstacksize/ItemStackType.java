package com.astrazoey.lenientstacksize;

public class ItemStackType {

    public int maxCount;

    public ItemStackType(ItemStackType.Settings settings) {
        this.maxCount = settings.maxCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public static class Settings {
        int maxCount;

        public Settings() {

        }

        public ItemStackType.Settings maxCount(int maxCount) {
            this.maxCount = maxCount;
            return this;
        }
    }

}
