package com.astrazoey.universal.registry;

import com.astrazoey.universal.UniversalTool;
import com.astrazoey.universal.MattockToolItem;
import com.astrazoey.universal.MattockToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final ToolItem MATTOCK = new MattockToolItem(MattockToolMaterial.INSTANCE, 3, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));

    

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(UniversalTool.MOD_ID, "mattock"), MATTOCK);
    }
}
