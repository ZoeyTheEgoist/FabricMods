package com.astrazoey.scorch.registry;

import com.astrazoey.scorch.GunpowderRevision;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GunpowderRevisionItems {

    public static final BlockItem PYRACK = new BlockItem(GunpowderRevisionBlocks.PYRACK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem IGNISTONE = new BlockItem(GunpowderRevisionBlocks.IGNISTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(GunpowderRevision.MOD_ID, "pyrack"), PYRACK);
        Registry.register(Registry.ITEM, new Identifier(GunpowderRevision.MOD_ID, "ignistone"), IGNISTONE);
    }

}
