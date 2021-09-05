package com.astrazoey.lenientstacksize.mixins;

import net.minecraft.advancement.criterion.FilledBucketCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FilledBucketCriterion.class)
public class FilledBucketCriterionMixin {

    //this is needed to make sure the Cutest Predator and Tactical Fishing advancements trigger when you have more than 1 water bucket in your stack
    @Inject(method = "trigger", at = @At("HEAD"))
    public void setStackSizeToOne(ServerPlayerEntity player, ItemStack stack, CallbackInfo ci) {
        stack.setCount(1);
    }

}
