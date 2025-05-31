package com.astrazoey.secondchance;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.util.Identifier;

public class Client implements ClientModInitializer {

    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        Identifier identifier = Identifier.tryParse(SecondChance.MOD_ID);
        ClientLifecycleEvents.CLIENT_STARTED.register(identifier, callbacks -> {
            System.out.println("SecondChance: Client started. Loading config.");
            SecondChance.initializeConfig();
        });
    }
}
