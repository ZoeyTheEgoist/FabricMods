package com.astrazoey.lenientstacksize.mixins;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.FilledBucketCriterion;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BucketItem.class)
public class BucketItemMixin {

    /**
     * @author Astrazoey
     */
    @Overwrite
    public static ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
        if (player == null || !player.getAbilities().creativeMode) {
            if (stack.getCount() <= 1) {
                return new ItemStack(Items.BUCKET);
            }

            if (player != null) {
                player.getInventory().insertStack(new ItemStack(Items.BUCKET));
                ItemStack newStack = stack.copy();
                newStack.decrement(1);
                return newStack;
            }
        }
        return stack;
    }

}
