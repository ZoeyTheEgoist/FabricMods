package com.astrazoey.lenientstacksize.mixins;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PowderSnowBucketItem;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PowderSnowBucketItem.class)
public class PowderSnowBucketItemMixin {
    @Redirect(method = "useOnBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setStackInHand(Lnet/minecraft/util/Hand;Lnet/minecraft/item/ItemStack;)V"))
    public void checkForStack(PlayerEntity playerEntity, Hand hand, ItemStack stack) {
        if(playerEntity.getStackInHand(hand).getCount() > 0) {
            System.out.println("get count is greater than 1");
            playerEntity.getInventory().insertStack(new ItemStack(Items.BUCKET));
            ItemStack newStack = playerEntity.getStackInHand(hand).copy();
            playerEntity.setStackInHand(hand, newStack);
        } else {
            System.out.println("get count is not greater than one");
            playerEntity.setStackInHand(hand, Items.BUCKET.getDefaultStack());
        }
    }
}
