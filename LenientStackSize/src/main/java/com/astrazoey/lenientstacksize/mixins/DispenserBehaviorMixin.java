package com.astrazoey.lenientstacksize.mixins;

import com.astrazoey.lenientstacksize.DispenserBehaviorInterface;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.entity.DispenserBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FluidModificationItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net/minecraft/block/dispenser/DispenserBehavior$8")
public class DispenserBehaviorMixin implements DispenserBehaviorInterface {
    private ItemDispenserBehavior fallbackBehavior = new ItemDispenserBehavior();


    public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {

        ItemStack emptyBucketStack = new ItemStack(Items.BUCKET);

        FluidModificationItem fluidModificationItem = (FluidModificationItem) stack.getItem();
        BlockPos blockPos = pointer.getPos().offset((Direction) pointer.getBlockState().get(DispenserBlock.FACING));
        World world = pointer.getWorld();
        if (fluidModificationItem.placeFluid((PlayerEntity) null, world, blockPos, (BlockHitResult) null)) {
            fluidModificationItem.onEmptied((PlayerEntity) null, world, stack, blockPos);

            if (stack.getCount() > 1) {
                System.out.println("Found stack! Get count = " + stack.getCount());
                ItemStack newStack = stack.copy();
                newStack.decrement(1);

                if (((DispenserBlockEntity)pointer.getBlockEntity()).addToFirstFreeSlot(emptyBucketStack.copy()) < 0) {
                    this.fallbackBehavior.dispense(pointer, emptyBucketStack.copy());
                }

                return newStack;
            } else {
                System.out.println("No stack! Converting to bucket!");
                return new ItemStack(Items.BUCKET);
            }

        } else {
            System.out.println("Fallback behavior activated!");
            return this.fallbackBehavior.dispense(pointer, stack);
        }
    }
}
