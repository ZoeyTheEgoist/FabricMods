package com.astrazoey.scorch;

import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class PrimedPyrackBlock extends PyrackBlock {

    public PrimedPyrackBlock(Settings settings) {super (settings); }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.getBlockTickScheduler().schedule(pos, this, 3);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.removeBlock(pos, false);
        detonate(world, pos);
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos blockPos, Explosion explosion) {
        //empty
    }



}
