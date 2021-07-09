package com.astrazoey.universal;

import com.astrazoey.universal.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class UniversalTool implements ModInitializer {

    public static final String MOD_ID = "unitool";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
    }

}
