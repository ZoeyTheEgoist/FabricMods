package com.astrazoey.scorch.mixins;

import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {

    @Inject(method = "drop", at = @At("HEAD"))
    private static void addSaddleToDrop(PiglinEntity piglin, List<ItemStack> list, Vec3d vec3d, CallbackInfo ci) {
        if(piglin.world.random.nextInt(6) == 0) {
            list.clear();
            list.add(new ItemStack(Items.SADDLE, 1));
        }
    }
}
