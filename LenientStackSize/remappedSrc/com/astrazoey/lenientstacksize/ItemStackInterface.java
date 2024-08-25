package com.astrazoey.lenientstacksize;

import net.minecraft.item.Item;

public interface ItemStackInterface {

    static void setCountType(Item item, ItemStackType itemStackType) {
        if(item != null) {
            ((ItemStackInterface) itemStackType).setItemStackType(itemStackType);
        }
    }

    static ItemStackType getItemType(Item item) {
        return ((ItemStackInterface) item).getItemStackType(item);
    }



    void setItemStackType(ItemStackType itemStackType);
    ItemStackType getItemStackType(Item item);

}
