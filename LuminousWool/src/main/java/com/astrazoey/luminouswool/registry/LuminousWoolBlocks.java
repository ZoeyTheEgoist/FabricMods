package com.astrazoey.luminouswool.registry;

import com.astrazoey.luminouswool.LuminousWool;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.render.block.entity.BedBlockEntityRenderer;
import net.minecraft.item.Items;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LuminousWoolBlocks {

    private static Block.Settings luminousWool() {
        return FabricBlockSettings
                .of(Material.WOOL)
                .sounds(BlockSoundGroup.WOOL)
                .strength(0.8f, 0.8f)
                .emissiveLighting((state, world, pos) -> true)
                .luminance(3)
                .breakByTool(FabricToolTags.SHEARS);
    }


    public static final Block LUMINOUS_WHITE_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_ORANGE_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_MAGENTA_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_LIGHT_BLUE_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_YELLOW_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_LIME_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_PINK_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_GRAY_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_LIGHT_GRAY_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_CYAN_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_PURPLE_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_BLUE_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_BROWN_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_GREEN_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_RED_WOOL = new Block(luminousWool());
    public static final Block LUMINOUS_BLACK_WOOL = new Block(luminousWool());




    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_white_wool"), LUMINOUS_WHITE_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_orange_wool"), LUMINOUS_ORANGE_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_magenta_wool"), LUMINOUS_MAGENTA_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_light_blue_wool"), LUMINOUS_LIGHT_BLUE_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_yellow_wool"), LUMINOUS_YELLOW_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_lime_wool"), LUMINOUS_LIME_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_pink_wool"), LUMINOUS_PINK_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_gray_wool"), LUMINOUS_GRAY_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_light_gray_wool"), LUMINOUS_LIGHT_GRAY_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_cyan_wool"), LUMINOUS_CYAN_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_purple_wool"), LUMINOUS_PURPLE_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_blue_wool"), LUMINOUS_BLUE_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_brown_wool"), LUMINOUS_BROWN_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_green_wool"), LUMINOUS_GREEN_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_red_wool"), LUMINOUS_RED_WOOL);
        Registry.register(Registry.BLOCK, new Identifier(LuminousWool.MOD_ID, "luminous_black_wool"), LUMINOUS_BLACK_WOOL);
    }
}
