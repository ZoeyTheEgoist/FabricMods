package com.astrazoey.lenientstacksize;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.util.Identifier;

public class Client implements ClientModInitializer {

    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        Identifier identifier = new Identifier(LenientStackSize.MOD_ID);
        ClientLifecycleEvents.CLIENT_STARTED.register(identifier, callbacks -> {
            System.out.println("INDEXED: Client started. Loading config.");
            LenientStackSize.initializeConfig();
        });
    }
}
