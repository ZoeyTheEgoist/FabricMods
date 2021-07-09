package com.astrazoey.scorch.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.NetherrackBlock;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;


@Mixin(NetherrackBlock.class)
public class NetherrackBlockMixin extends Block {

    public NetherrackBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        Random r = new Random();
        int result = r.nextInt(100-1);

        if(result < 6) {
            Block.dropStack(world, pos, Items.GUNPOWDER.getDefaultStack());
        } else if(result < 60) {
            Block.dropStack(world, pos, Items.NETHERRACK.getDefaultStack());
        }

    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

}
