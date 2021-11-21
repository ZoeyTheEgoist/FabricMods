package com.astrazoey.luminouswool;

import com.astrazoey.luminouswool.registry.LuminousWoolBlocks;
import com.astrazoey.luminouswool.registry.LuminousWoolItems;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;


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
            //carpet
            .put(Blocks.WHITE_CARPET, LuminousWoolBlocks.LUMINOUS_WHITE_CARPET)
            .put(Blocks.ORANGE_CARPET, LuminousWoolBlocks.LUMINOUS_ORANGE_CARPET)
            .put(Blocks.MAGENTA_CARPET, LuminousWoolBlocks.LUMINOUS_MAGENTA_CARPET)
            .put(Blocks.LIGHT_BLUE_CARPET, LuminousWoolBlocks.LUMINOUS_LIGHT_BLUE_CARPET)
            .put(Blocks.YELLOW_CARPET, LuminousWoolBlocks.LUMINOUS_YELLOW_CARPET)
            .put(Blocks.LIME_CARPET, LuminousWoolBlocks.LUMINOUS_LIME_CARPET)
            .put(Blocks.PINK_CARPET, LuminousWoolBlocks.LUMINOUS_PINK_CARPET)
            .put(Blocks.GRAY_CARPET, LuminousWoolBlocks.LUMINOUS_GRAY_CARPET)
            .put(Blocks.LIGHT_GRAY_CARPET, LuminousWoolBlocks.LUMINOUS_LIGHT_GRAY_CARPET)
            .put(Blocks.CYAN_CARPET, LuminousWoolBlocks.LUMINOUS_CYAN_CARPET)
            .put(Blocks.PURPLE_CARPET, LuminousWoolBlocks.LUMINOUS_PURPLE_CARPET)
            .put(Blocks.BLUE_CARPET, LuminousWoolBlocks.LUMINOUS_BLUE_CARPET)
            .put(Blocks.BROWN_CARPET, LuminousWoolBlocks.LUMINOUS_BROWN_CARPET)
            .put(Blocks.GREEN_CARPET, LuminousWoolBlocks.LUMINOUS_GREEN_CARPET)
            .put(Blocks.RED_CARPET, LuminousWoolBlocks.LUMINOUS_RED_CARPET)
            .put(Blocks.BLACK_CARPET, LuminousWoolBlocks.LUMINOUS_BLACK_CARPET)
            .build();


    @Override
    public void onInitialize() {

        LuminousWoolBlocks.registerBlocks();
        LuminousWoolItems.registerItems();

        UseBlockCallback.EVENT.register((player, world, hand, hitresult) -> {
            if (player.getStackInHand(hand).getItem() == Items.GLOW_INK_SAC) {

                var pos = hitresult.getBlockPos();
                var block = world.getBlockState(pos);

                if (block.isIn(BlockTags.WOOL) || block.isIn(BlockTags.CARPETS)) {

                    var luminous = WOOL_TO_LUMINOUS_WOOL.get(block.getBlock());
                    if(luminous != null) {

                        //Change Block
                        world.setBlockState(pos, WOOL_TO_LUMINOUS_WOOL.get(block.getBlock()).getDefaultState());

                        //Particle and Sound
                        world.playSound(null, pos, SoundEvents.ITEM_GLOW_INK_SAC_USE, SoundCategory.BLOCKS, 1f, 0.8f);
                        world.syncWorldEvent(player, 3005, pos, 1);

                        //Stats and Advancements
                        ItemStack heldItem = player.getStackInHand(hand);
                        Item item = heldItem.getItem();
                        player.incrementStat(Stats.USED.getOrCreateStat(item));
                        if (player instanceof ServerPlayerEntity) {
                            Criteria.ITEM_USED_ON_BLOCK.test((ServerPlayerEntity)player, pos, heldItem);
                        }

                        //Decrement Glow Ink if not in creative mode
                        if(!player.isCreative()) {
                            heldItem.decrement(1);
                        }

                        return ActionResult.SUCCESS;
                    } else {
                        return ActionResult.PASS;
                    }
                }
            } else {
                return ActionResult.PASS;
            }

            return ActionResult.PASS;
        });

    }
}
