package com.astrazoey.scorch.mixins;

import com.astrazoey.scorch.PyrackBlock;
import com.astrazoey.scorch.registry.GunpowderRevisionBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Random;


@Mixin(FireBlock.class)
public class FireBlockMixin extends Block {


    public FireBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(
            method = "trySpreadingFire",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getBlock()Lnet/minecraft/block/Block;"),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void trySpreadingFire(
            World world, BlockPos pos, int spreadFactor, Random rand, int currentAge, CallbackInfo ci,
            int spreadChance, BlockState blockState
    ) {
        Block block = blockState.getBlock();
        if (blockState.getBlock() == GunpowderRevisionBlocks.PYRACK) {
            PyrackBlock var10000 = (PyrackBlock)block;
            PyrackBlock.detonate(world, pos);
        }
    }


}
