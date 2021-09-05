package com.astrazoey.lenientstacksize.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AnvilScreenHandler.class)
public class AnvilScreenHandlerMixin {

    /*
    int slot0Count;
    int slot1Count;

    @Redirect(method = "onTakeOutput", at = @At(value = "INVOKE", target = "Lnet/minecraft/inventory/Inventory;setStack(ILnet/minecraft/item/ItemStack;)V", ordinal = 0))
    private void storeSlot0Count(Inventory inventory, int slot, ItemStack stack) {
        ItemStack outputStack = inventory.getStack(0);
        slot0Count = outputStack.getCount();
        inventory.setStack(0, ItemStack.EMPTY);
        System.out.println("Initial output amount = " + slot0Count);
    }*/

    @Redirect(method = "onTakeOutput", at = @At(value = "INVOKE", target = "Lnet/minecraft/inventory/Inventory;setStack(ILnet/minecraft/item/ItemStack;)V", ordinal = 3))
    private void setDecrementSlot1StackCount(Inventory inventory, int slot, ItemStack stack) {
        ItemStack newStack = inventory.getStack(1);
        //slot1Count = newStack.getCount();
        newStack.decrement(1);
        inventory.setStack(1, newStack);
    }
}
