package com.astrazoey.lenientstacksize;

import com.google.gson.annotations.SerializedName;

public class ItemStackConfig {
    @SerializedName("max_count")
    public int maxCount;

    public ItemStackConfig(int maxCount) {
        this.maxCount = maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }


}
