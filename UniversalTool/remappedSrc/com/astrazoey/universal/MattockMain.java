package com.astrazoey.universal;

import com.astrazoey.universal.registry.MattockItemRegistry;
import net.fabricmc.api.ModInitializer;

public class MattockMain implements ModInitializer {

    public static final String MOD_ID = "unitool";

    @Override
    public void onInitialize() {
        MattockItemRegistry.registerItems();
    }

}
