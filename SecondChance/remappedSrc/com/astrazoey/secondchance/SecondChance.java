package com.astrazoey.secondchance;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class SecondChance implements ModInitializer {

	public static final String MOD_ID = "secondchance";

	@Override
	public void onInitialize() {


		//Registers Config
		Identifier identifier = Identifier.tryParse(MOD_ID);
		ServerLifecycleEvents.SERVER_STARTING.register(identifier, callbacks -> {
			System.out.println("SECOND CHANCE: Starting. Loading config.");
			initializeConfig();
		});

		ServerLifecycleEvents.START_DATA_PACK_RELOAD.register(identifier, (server, serverResourceManager) -> {
			System.out.println("SECOND CHANCE: Server data pack reload. Loading config.");
			initializeConfig();
		});



	}

	public static void initializeConfig() {
		Config.load(false);
		boolean modOutOfDate = Config.isOutOfDate();
		ConfigNew.loadConfig(modOutOfDate);
		Config.load(modOutOfDate);
	}
}
