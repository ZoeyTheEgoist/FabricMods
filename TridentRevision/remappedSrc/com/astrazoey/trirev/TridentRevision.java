package com.astrazoey.trirev;

import com.astrazoey.trirev.registry.TridentItems;
import net.fabricmc.api.ModInitializer;

public class TridentRevision implements ModInitializer {

    public static final String MOD_ID = "trirev";


    @Override
    public void onInitialize() {
        TridentItems.registerItems();
    }

}
