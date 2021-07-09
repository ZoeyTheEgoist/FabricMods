package com.astrazoey.trirev.registry;

import com.astrazoey.trirev.TridentRevision;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TridentItems {

    public static final Item ELDER_FRAGMENT = new Item(new Item.Settings().group(ItemGroup.MISC));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(TridentRevision.MOD_ID, "elder_fragment"), ELDER_FRAGMENT);
    }
}
