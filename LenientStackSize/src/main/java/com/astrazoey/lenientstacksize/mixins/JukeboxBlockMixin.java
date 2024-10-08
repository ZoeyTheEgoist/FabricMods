package com.astrazoey.lenientstacksize.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(JukeboxBlockEntity.class)
public class JukeboxBlockMixin {

    @Inject(method="setStack", at=@At("HEAD"), cancellable = true)
    public void setCountToOne(ItemStack stack, CallbackInfo ci) {
        if (stack.isIn(ItemTags.MUSIC_DISCS)) {
            stack.setCount(1);
        }
    }





}
