package com.astrazoey.lenientstacksize.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(JukeboxBlock.class)
public class JukeboxBlockMixin {

    @Redirect(method = "setRecord", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/JukeboxBlockEntity;setRecord(Lnet/minecraft/item/ItemStack;)V"))
    public void setCountToOne(JukeboxBlockEntity jukeboxBlockEntity, ItemStack stack) {
        ItemStack newStack = stack.copy();
        newStack.setCount(1);
        jukeboxBlockEntity.setRecord(newStack);
    }
}
