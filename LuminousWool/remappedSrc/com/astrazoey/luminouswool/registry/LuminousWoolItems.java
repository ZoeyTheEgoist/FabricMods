package com.astrazoey.luminouswool.registry;

import com.astrazoey.luminouswool.LuminousWool;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class LuminousWoolItems {



    public static final BlockItem LUMINOUS_WHITE_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_WHITE_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_ORANGE_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_ORANGE_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_MAGENTA_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_MAGENTA_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_LIGHT_BLUE_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_LIGHT_BLUE_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_YELLOW_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_YELLOW_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_LIME_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_LIME_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_PINK_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_PINK_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_GRAY_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_GRAY_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_LIGHT_GRAY_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_LIGHT_GRAY_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_CYAN_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_CYAN_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_PURPLE_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_PURPLE_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_BLUE_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_BLUE_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_BROWN_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_BROWN_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_GREEN_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_GREEN_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_RED_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_RED_WOOL, new Item.Settings());
    public static final BlockItem LUMINOUS_BLACK_WOOL = new BlockItem(LuminousWoolBlocks.LUMINOUS_BLACK_WOOL, new Item.Settings());

    public static final BlockItem LUMINOUS_WHITE_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_WHITE_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_ORANGE_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_ORANGE_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_MAGENTA_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_MAGENTA_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_LIGHT_BLUE_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_LIGHT_BLUE_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_YELLOW_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_YELLOW_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_LIME_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_LIME_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_PINK_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_PINK_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_GRAY_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_GRAY_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_LIGHT_GRAY_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_LIGHT_GRAY_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_CYAN_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_CYAN_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_PURPLE_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_PURPLE_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_BLUE_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_BLUE_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_BROWN_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_BROWN_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_GREEN_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_GREEN_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_RED_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_RED_CARPET, new Item.Settings());
    public static final BlockItem LUMINOUS_BLACK_CARPET = new BlockItem(LuminousWoolBlocks.LUMINOUS_BLACK_CARPET, new Item.Settings());

    private static void addItemsToColorfulBlocksTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(LUMINOUS_WHITE_WOOL);
        entries.add(LUMINOUS_ORANGE_WOOL);
        entries.add(LUMINOUS_MAGENTA_WOOL);
        entries.add(LUMINOUS_LIGHT_BLUE_WOOL);
        entries.add(LUMINOUS_YELLOW_WOOL);
        entries.add(LUMINOUS_LIME_WOOL);
        entries.add(LUMINOUS_PINK_WOOL);
        entries.add(LUMINOUS_GRAY_WOOL);
        entries.add(LUMINOUS_LIGHT_GRAY_WOOL);
        entries.add(LUMINOUS_CYAN_WOOL);
        entries.add(LUMINOUS_PURPLE_WOOL);
        entries.add(LUMINOUS_BLUE_WOOL);
        entries.add(LUMINOUS_BROWN_WOOL);
        entries.add(LUMINOUS_GREEN_WOOL);
        entries.add(LUMINOUS_RED_WOOL);
        entries.add(LUMINOUS_BLACK_WOOL);

        entries.add(LUMINOUS_WHITE_CARPET);
        entries.add(LUMINOUS_ORANGE_CARPET);
        entries.add(LUMINOUS_MAGENTA_CARPET);
        entries.add(LUMINOUS_LIGHT_BLUE_CARPET);
        entries.add(LUMINOUS_YELLOW_CARPET);
        entries.add(LUMINOUS_LIME_CARPET);
        entries.add(LUMINOUS_PINK_CARPET);
        entries.add(LUMINOUS_GRAY_CARPET);
        entries.add(LUMINOUS_LIGHT_GRAY_CARPET);
        entries.add(LUMINOUS_CYAN_CARPET);
        entries.add(LUMINOUS_PURPLE_CARPET);
        entries.add(LUMINOUS_BLUE_CARPET);
        entries.add(LUMINOUS_BROWN_CARPET);
        entries.add(LUMINOUS_GREEN_CARPET);
        entries.add(LUMINOUS_RED_CARPET);
        entries.add(LUMINOUS_BLACK_CARPET);
    }

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_white_wool"), LUMINOUS_WHITE_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_orange_wool"), LUMINOUS_ORANGE_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_magenta_wool"), LUMINOUS_MAGENTA_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_light_blue_wool"), LUMINOUS_LIGHT_BLUE_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_yellow_wool"), LUMINOUS_YELLOW_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_lime_wool"), LUMINOUS_LIME_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_pink_wool"), LUMINOUS_PINK_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_gray_wool"), LUMINOUS_GRAY_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_light_gray_wool"), LUMINOUS_LIGHT_GRAY_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_cyan_wool"), LUMINOUS_CYAN_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_purple_wool"), LUMINOUS_PURPLE_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_blue_wool"), LUMINOUS_BLUE_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_brown_wool"), LUMINOUS_BROWN_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_green_wool"), LUMINOUS_GREEN_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_red_wool"), LUMINOUS_RED_WOOL);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_black_wool"), LUMINOUS_BLACK_WOOL);

        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_white_carpet"), LUMINOUS_WHITE_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_orange_carpet"), LUMINOUS_ORANGE_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_magenta_carpet"), LUMINOUS_MAGENTA_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_light_blue_carpet"), LUMINOUS_LIGHT_BLUE_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_yellow_carpet"), LUMINOUS_YELLOW_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_lime_carpet"), LUMINOUS_LIME_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_pink_carpet"), LUMINOUS_PINK_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_gray_carpet"), LUMINOUS_GRAY_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_light_gray_carpet"), LUMINOUS_LIGHT_GRAY_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_cyan_carpet"), LUMINOUS_CYAN_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_purple_carpet"), LUMINOUS_PURPLE_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_blue_carpet"), LUMINOUS_BLUE_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_brown_carpet"), LUMINOUS_BROWN_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_green_carpet"), LUMINOUS_GREEN_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_red_carpet"), LUMINOUS_RED_CARPET);
        Registry.register(Registries.ITEM, new Identifier(LuminousWool.MOD_ID, "luminous_black_carpet"), LUMINOUS_BLACK_CARPET);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(LuminousWoolItems::addItemsToColorfulBlocksTabItemGroup);
    }

}
