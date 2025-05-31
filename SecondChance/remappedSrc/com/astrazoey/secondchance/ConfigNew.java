package com.astrazoey.secondchance;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;

public class ConfigNew {

    private static final File configFile = FabricLoader.getInstance().getConfigDir().resolve("second_chance_config.json").toFile();
    private static final Path configFilePath = FabricLoader.getInstance().getConfigDir().resolve("second_chance_config.json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static LinkedHashMap<String, MobHealthConfig> configList;

    public static void save() {
        read();
    }

    private static boolean generateNewConfigFile() {
        try {
            Files.createFile(configFilePath);
            save();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean readConfigList() {
        try(FileReader reader = new FileReader(ConfigNew.configFile)) {
            ConfigNew.configList = gson.fromJson(reader, new TypeToken<LinkedHashMap<String, MobHealthConfig>>(){}.getType());

            if(configList == null) {
                ConfigNew.configFile.delete();
                System.out.println("SECOND CHANCE: Config file is null and deleted. Generating new config.");
                if(!generateNewConfigFile()) {
                    return false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void registerConfigListMobs() {
        for(int i = 0; i < configList.size(); i++) {
            Object configEntry = configList.keySet().toArray()[i];
            MobHealthConfig mobHealthConfig = configList.get(configEntry);
            String mobName = (String) configEntry;
            float healthThreshold = mobHealthConfig.damageThreshold;


            //System.out.println("Found entry at " + i + ". It is called \"" + mobName + "\" and has a threshold of " + mobHealthConfig + ".");

            Identifier mobIdentifier = Identifier.tryParse(mobName);
            ThreadLocal<Identifier> localMobIdentifier = new ThreadLocal<Identifier>();
            localMobIdentifier.set(mobIdentifier);

            EntityType<?> registerEntity = Registries.ENTITY_TYPE.getEntry(localMobIdentifier.get());

            MobHealthInterface.setHealthType(registerEntity, new MobHealthType(new MobHealthType.Settings().healthThreshold(healthThreshold)));


        }
    }

    public static void loadConfig(boolean modOutOfDate) {

        if(modOutOfDate && Files.exists(configFilePath)) {
            try {
                System.out.println("Second Chance is out of date! Resetting config file!");
                Files.delete(configFilePath);
                configList = null;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Second Chance: Failed to delete config file.");
                return;
            }
        }

        if(ConfigNew.configFile.exists()) {
            if(!readConfigList()) {
                System.out.println("Second Chance: Failed to read config list.");
                return;
            }
        } else {
            try {
                Files.createFile(configFilePath);
                save();
            } catch (Exception e) {
                if(!generateNewConfigFile()) {
                    System.out.println("Second Chance: Failed to generate new config file");
                    return;
                }
            }
        }


        if(configList == null) {
            if(!readConfigList()) {
                System.out.println("SECOND CHANCE: Failed to read config.");
                return;
            }
        }

        registerConfigListMobs();
    }

    public static void read() {
        LinkedHashMap<String, MobHealthConfig> defaultConfig = new LinkedHashMap<>();


        //Utils
        addConfigEntry(defaultConfig, "minecraft:allay", 13.5f);

        //Pets
        addConfigEntry(defaultConfig, "minecraft:wolf", 4f);
        addConfigEntry(defaultConfig, "minecraft:parrot", 3f);
        addConfigEntry(defaultConfig, "minecraft:cat", 5f);
        addConfigEntry(defaultConfig, "minecraft:axolotl", 4f);

        //People
        addConfigEntry(defaultConfig, "minecraft:villager", 13.5f);
        addConfigEntry(defaultConfig, "minecraft:wandering_trader", 13.5f);

        //Mounts
        addConfigEntry(defaultConfig, "minecraft:horse", 15f);
        addConfigEntry(defaultConfig, "minecraft:donkey", 15f);
        addConfigEntry(defaultConfig, "minecraft:mule", 15f);
        addConfigEntry(defaultConfig, "minecraft:skeleton_horse", 15f);
        addConfigEntry(defaultConfig, "minecraft:zombie_horse", 15f);
        addConfigEntry(defaultConfig, "minecraft:llama", 15f);
        addConfigEntry(defaultConfig, "minecraft:trader_llama", 15f);
        addConfigEntry(defaultConfig, "minecraft:camel", 15f);

        //Golens
        addConfigEntry(defaultConfig, "minecraft:snow_golem", 2f);
        addConfigEntry(defaultConfig, "minecraft:iron_golem", 20f);


        File directory = configFile.getParentFile();
        if(directory.exists()) {
            try (FileWriter writer = new FileWriter(configFile)) {
                gson.toJson(defaultConfig, writer);
            } catch (IOException e) {
                System.out.println("SECOND CHANCE: Could not generate new config file!");
                throw new RuntimeException("Second Chance: Could not save config file", e);
            }
        } else {
            System.out.println("SECOND CHANCE: Directory does not exist!");
        }

    }

    public static void addConfigEntry(LinkedHashMap<String, MobHealthConfig> config, String name, float health) {
        MobHealthConfig mobHealth = new MobHealthConfig(health);
        config.put(name, mobHealth);
    }



}
