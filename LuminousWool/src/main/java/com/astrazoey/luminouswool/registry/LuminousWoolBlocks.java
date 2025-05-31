package com.astrazoey.luminouswool.registry;

import com.astrazoey.luminouswool.LuminousWool;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class LuminousWoolBlocks {

    private static Block.Settings luminousWool() {
        return Block.Settings
                .copy(Blocks.WHITE_WOOL)
                //.sounds(BlockSoundGroup.WOOL)
                //.strength(0.8f, 0.8f)
                .emissiveLighting((state, world, pos) -> true)
                .luminance(state -> 3);
    }

    private static CarpetBlock.Settings luminousCarpet() {
        return AbstractBlock.Settings
                .copy(Blocks.WHITE_CARPET)
                //.sounds(BlockSoundGroup.WOOL)
                //.strength(0.1f, 0.1f)
                .emissiveLighting((state, world, pos) -> true)
                .luminance(state -> 3);
    }

    public static final Block LUMINOUS_WHITE_WOOL = register(
            "luminous_white_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_ORANGE_WOOL = register(
            "luminous_orange_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_MAGENTA_WOOL = register(
            "luminous_magenta_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_LIGHT_BLUE_WOOL = register(
            "luminous_light_blue_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_YELLOW_WOOL = register(
            "luminous_yellow_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_LIME_WOOL = register(
            "luminous_lime_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_PINK_WOOL = register(
            "luminous_pink_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_GRAY_WOOL = register(
            "luminous_gray_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_LIGHT_GRAY_WOOL = register(
            "luminous_light_gray_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_CYAN_WOOL = register(
            "luminous_cyan_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_PURPLE_WOOL = register(
            "luminous_purple_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_BLUE_WOOL = register(
            "luminous_blue_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_BROWN_WOOL = register(
            "luminous_brown_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_GREEN_WOOL = register(
            "luminous_green_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_RED_WOOL = register(
            "luminous_red_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_BLACK_WOOL = register(
            "luminous_black_wool",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    public static final Block LUMINOUS_WHITE_CARPET = register(
            "luminous_white_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_ORANGE_CARPET = register(
            "luminous_orange_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_MAGENTA_CARPET = register(
            "luminous_magenta_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_LIGHT_BLUE_CARPET = register(
            "luminous_light_blue_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_YELLOW_CARPET = register(
            "luminous_yellow_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_LIME_CARPET = register(
            "luminous_lime_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_PINK_CARPET = register(
            "luminous_pink_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_GRAY_CARPET = register(
            "luminous_gray_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_LIGHT_GRAY_CARPET = register(
            "luminous_light_gray_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_CYAN_CARPET = register(
            "luminous_cyan_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_PURPLE_CARPET = register(
            "luminous_purple_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_BLUE_CARPET = register(
            "luminous_blue_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_BROWN_CARPET = register(
            "luminous_brown_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_GREEN_CARPET = register(
            "luminous_green_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_RED_CARPET = register(
            "luminous_red_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );
    public static final Block LUMINOUS_BLACK_CARPET = register(
            "luminous_black_carpet",
            CarpetBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).emissiveLighting((state, world, pos) -> true).luminance(state -> 3),
            true
    );

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LuminousWool.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LuminousWool.MOD_ID, name));
    }

    public static void registerBlocks() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_WHITE_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_ORANGE_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_MAGENTA_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_LIGHT_BLUE_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_YELLOW_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_LIME_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_PINK_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_GRAY_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_LIGHT_GRAY_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_CYAN_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_PURPLE_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_BLUE_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_BROWN_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_GREEN_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_RED_WOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_BLACK_WOOL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_WHITE_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_ORANGE_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_MAGENTA_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_LIGHT_BLUE_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_YELLOW_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_LIME_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_PINK_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_GRAY_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_LIGHT_GRAY_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_CYAN_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_PURPLE_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_BLUE_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_BROWN_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_GREEN_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_RED_CARPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(LuminousWoolBlocks.LUMINOUS_BLACK_CARPET);
        });

    }
}
