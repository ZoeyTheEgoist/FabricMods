package com.astrazoey.luminouswool;

import com.astrazoey.luminouswool.registry.LuminousWoolBlocks;
import com.astrazoey.luminouswool.registry.LuminousWoolItems;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.particle.GlowParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;

import java.util.List;
import java.util.Map;

public class LuminousWool implements ModInitializer {

    public static final String MOD_ID = "lumiwool";

    public static final ImmutableMap<Block, Block> WOOL_TO_LUMINOUS_WOOL = ImmutableMap.<Block, Block>builder()
            .put(Blocks.WHITE_WOOL, LuminousWoolBlocks.LUMINOUS_WHITE_WOOL)
            .put(Blocks.ORANGE_WOOL, LuminousWoolBlocks.LUMINOUS_ORANGE_WOOL)
            .put(Blocks.MAGENTA_WOOL, LuminousWoolBlocks.LUMINOUS_MAGENTA_WOOL)
            .put(Blocks.LIGHT_BLUE_WOOL, LuminousWoolBlocks.LUMINOUS_LIGHT_BLUE_WOOL)
            .put(Blocks.YELLOW_WOOL, LuminousWoolBlocks.LUMINOUS_YELLOW_WOOL)
            .put(Blocks.LIME_WOOL, LuminousWoolBlocks.LUMINOUS_LIME_WOOL)
            .put(Blocks.PINK_WOOL, LuminousWoolBlocks.LUMINOUS_PINK_WOOL)
            .put(Blocks.GRAY_WOOL, LuminousWoolBlocks.LUMINOUS_GRAY_WOOL)
            .put(Blocks.LIGHT_GRAY_WOOL, LuminousWoolBlocks.LUMINOUS_LIGHT_GRAY_WOOL)
            .put(Blocks.CYAN_WOOL, LuminousWoolBlocks.LUMINOUS_CYAN_WOOL)
            .put(Blocks.PURPLE_WOOL, LuminousWoolBlocks.LUMINOUS_PURPLE_WOOL)
            .put(Blocks.BLUE_WOOL, LuminousWoolBlocks.LUMINOUS_BLUE_WOOL)
            .put(Blocks.BROWN_WOOL, LuminousWoolBlocks.LUMINOUS_BROWN_WOOL)
            .put(Blocks.GREEN_WOOL, LuminousWoolBlocks.LUMINOUS_GREEN_WOOL)
            .put(Blocks.RED_WOOL, LuminousWoolBlocks.LUMINOUS_RED_WOOL)
            .put(Blocks.BLACK_WOOL, LuminousWoolBlocks.LUMINOUS_BLACK_WOOL)
            .build();


    @Override
    public void onInitialize() {

        LuminousWoolBlocks.registerBlocks();
        LuminousWoolItems.registerItems();

        UseBlockCallback.EVENT.register((player, world, hand, hitresult) -> {
            if (/*player.isHolding(Items.GLOW_INK_SAC)*/player.getStackInHand(hand).getItem() == Items.GLOW_INK_SAC) {

                //player.getItemsHand();

                var pos = hitresult.getBlockPos();
                var block = world.getBlockState(pos);

                if (block.isIn(BlockTags.WOOL)) {

                    var luminous = WOOL_TO_LUMINOUS_WOOL.get(block.getBlock());
                    if(luminous != null) {

                        //Change Block
                        world.setBlockState(pos, WOOL_TO_LUMINOUS_WOOL.get(block.getBlock()).getDefaultState());

                        //Particle and Sound
                        world.playSound(null, pos, SoundEvents.ENTITY_SLIME_DEATH, SoundCategory.BLOCKS, 1f, 2f);
                        world.syncWorldEvent(player, 3005, pos, 1);

                        /*
                        if(world.isClient) {
                            for (int i = 0; i <= 50; i++) {
                                world.addParticle(ParticleTypes.GLOW_SQUID_INK, pos.getX(), pos.getY(), pos.getZ(), 0.0d, 0.0d, 0.0d);


                            }
                        }*/

                        //Decrement Glow Ink if not in creative mode
                        if(!player.isCreative()) {
                            ItemStack heldItem = player.getStackInHand(hand);
                            heldItem.decrement(1);
                        }

                        return ActionResult.SUCCESS;
                    } else {
                        return ActionResult.PASS;
                    }
                }
            } else {
                System.out.println("no glow ink");
                return ActionResult.PASS;
            }

            return ActionResult.PASS;
        });

    }
}
