package com.astrazoey.luminouswool.registry;

import com.astrazoey.luminouswool.LuminousWool;
import net.minecraft.block.BedBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LuminousWoolItems {

    //public static final BlockItem LUMINOUS_WHITE_BED = new BlockItem(LuminousWoolBlocks.LUMINOUS_WHITE_BED, new Item.Settings().group(ItemGroup.DECORATIONS));

    public static final BlockItem LUMINOUS_WHITE_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_WHITE_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_ORANGE_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_ORANGE_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_MAGENTA_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_MAGENTA_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_LIGHT_BLUE_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_LIGHT_BLUE_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_YELLOW_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_YELLOW_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_LIME_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_LIME_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_PINK_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_PINK_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_GRAY_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_GRAY_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_LIGHT_GRAY_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_LIGHT_GRAY_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_CYAN_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_CYAN_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_PURPLE_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_PURPLE_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_BLUE_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_BLUE_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_BROWN_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_BROWN_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_GREEN_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_GREEN_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_RED_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_RED_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem LUMINOUS_BLACK_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_BLACK_WOOL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    public static void registerItems() {

        //Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_white_bed"), LUMINOUS_WHITE_BED);

        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_white_wool"), LUMINOUS_WHITE_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_orange_wool"), LUMINOUS_ORANGE_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_magenta_wool"), LUMINOUS_MAGENTA_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_light_blue_wool"), LUMINOUS_LIGHT_BLUE_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_yellow_wool"), LUMINOUS_YELLOW_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_lime_wool"), LUMINOUS_LIME_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_pink_wool"), LUMINOUS_PINK_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_gray_wool"), LUMINOUS_GRAY_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_light_gray_wool"), LUMINOUS_LIGHT_GRAY_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_cyan_wool"), LUMINOUS_CYAN_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_purple_wool"), LUMINOUS_PURPLE_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_blue_wool"), LUMINOUS_BLUE_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_brown_wool"), LUMINOUS_BROWN_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_green_wool"), LUMINOUS_GREEN_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_red_wool"), LUMINOUS_RED_WOOL);
        Registry.register(Registry.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_black_wool"), LUMINOUS_BLACK_WOOL);
    }

}
