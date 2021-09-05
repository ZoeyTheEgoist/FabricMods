package com.astrazoey.lenientstacksize;

import net.minecraft.item.Item;

//Massive thank you to Gegy for making this process easy for me.
public interface SetMaxItemCount {
    static void set(Item item, int count) {
        ((SetMaxItemCount) item).setMaxItemCount(count);
    }

    void setMaxItemCount(int count);
}