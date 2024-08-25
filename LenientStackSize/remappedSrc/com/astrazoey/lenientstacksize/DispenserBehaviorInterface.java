package com.astrazoey.lenientstacksize;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public interface DispenserBehaviorInterface {
    public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack);
}
