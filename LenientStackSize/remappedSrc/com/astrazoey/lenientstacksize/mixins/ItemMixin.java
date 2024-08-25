package com.astrazoey.lenientstacksize.mixins;

import com.astrazoey.lenientstacksize.SetMaxItemCount;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = Item.class, priority = 999)
public class ItemMixin implements SetMaxItemCount {
    @Shadow
    @Final
    @Mutable
    private int maxCount;

    @Override
    public void setMaxItemCount(int maxItemCount) {
        this.maxCount = maxItemCount;
    }
}
