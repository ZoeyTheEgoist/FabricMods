package com.astrazoey.lenientstacksize;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;

public class ConfigNew {

    private static final File configFile = FabricLoader.getInstance().getConfigDir().resolve("lenientstacksize_config.json").toFile();
    private static final Path configFilePath = FabricLoader.getInstance().getConfigDir().resolve("lenientstacksize_config.json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static LinkedHashMap<String, ItemStackConfig> configList;

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
            ConfigNew.configList = gson.fromJson(reader, new TypeToken<LinkedHashMap<String, ItemStackConfig>>(){}.getType());

            if(configList == null) {
                ConfigNew.configFile.delete();
                System.out.println("LENIENT STACK SIZE: Config file is null and deleted. Generating new config.");
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

    public static void registerConfigListItems() {
        for(int i = 0; i < configList.size(); i++) {
            Object configEntry = configList.keySet().toArray()[i];
            ItemStackConfig itemStackConfig = configList.get(configEntry);
            String itemName = (String) configEntry;
            int maxCount = itemStackConfig.maxCount;


            System.out.println("Found entry at " + i + ". It is called \"" + itemName + "\" and has a max stack of " + itemStackConfig + ".");

            Identifier itemIdentifier = new Identifier(itemName);
            ThreadLocal<Identifier> localItemIdentifier = new ThreadLocal<Identifier>();
            localItemIdentifier.set(itemIdentifier);

            Item registerItem = Registry.ITEM.get(localItemIdentifier.get());

            //ItemStackInterface.setCountType(registerItem, new ItemStackType(new ItemStackType.Settings().maxCount(maxCount)));
            SetMaxItemCount.set(registerItem, maxCount);


        }
    }

    public static void loadConfig(boolean modOutOfDate) {

        if(modOutOfDate && Files.exists(configFilePath)) {
            try {
                System.out.println("mod is out of date! resetting file!");
                Files.delete(configFilePath);
                configList = null;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to delete config file.");
                return;
            }
        }

        if(ConfigNew.configFile.exists()) {
            if(!readConfigList()) {
                System.out.println("Failed to read config list.");
                return;
            }
        } else {
            try {
                Files.createFile(configFilePath);
                save();
            } catch (Exception e) {
                if(!generateNewConfigFile()) {
                    System.out.println("Failed to generate new config file");
                    return;
                }
            }
        }


        if(configList == null) {
            if(!readConfigList()) {
                System.out.println("LENIENT STACK SIZE: Failed to read config.");
                return;
            }
        }

        registerConfigListItems();
    }

    public static void read() {
        LinkedHashMap<String, ItemStackConfig> defaultConfig = new LinkedHashMap<>();

        //Mounts
        addConfigEntry(defaultConfig, "minecraft:saddle", 64);
        addConfigEntry(defaultConfig, "minecraft:diamond_horse_armor", 64);
        addConfigEntry(defaultConfig, "minecraft:golden_horse_armor", 64);
        addConfigEntry(defaultConfig, "minecraft:iron_horse_armor", 64);
        addConfigEntry(defaultConfig, "minecraft:leather_horse_armor", 64);

        //Books
        addConfigEntry(defaultConfig, "minecraft:enchanted_book", 64);
        addConfigEntry(defaultConfig, "minecraft:writable_book", 64);
        addConfigEntry(defaultConfig, "minecraft:written_book", 64);
        addConfigEntry(defaultConfig, "minecraft:knowledge_book", 64);

        //Stews & Soups
        addConfigEntry(defaultConfig, "minecraft:mushroom_stew", 16);
        addConfigEntry(defaultConfig, "minecraft:suspicious_stew", 16);
        addConfigEntry(defaultConfig, "minecraft:rabbit_stew", 16);
        addConfigEntry(defaultConfig, "minecraft:beetroot_soup", 16);

        //Discs
        addConfigEntry(defaultConfig, "minecraft:music_disc_11", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_13", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_blocks", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_cat", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_chirp", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_far", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_mall", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_pigstep", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_mellohi", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_stal", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_strad", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_wait", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_ward", 64);
        addConfigEntry(defaultConfig, "minecraft:music_disc_otherside", 64);

        //Buckets
        addConfigEntry(defaultConfig, "minecraft:bucket", 64);
        addConfigEntry(defaultConfig, "minecraft:milk_bucket", 16);
        addConfigEntry(defaultConfig, "minecraft:lava_bucket", 16);
        addConfigEntry(defaultConfig, "minecraft:water_bucket", 16);
        addConfigEntry(defaultConfig, "minecraft:pufferfish_bucket", 16);
        addConfigEntry(defaultConfig, "minecraft:salmon_bucket", 16);
        addConfigEntry(defaultConfig, "minecraft:cod_bucket", 16);
        addConfigEntry(defaultConfig, "minecraft:tropical_fish_bucket", 16);
        addConfigEntry(defaultConfig, "minecraft:axolotl_bucket", 16);
        addConfigEntry(defaultConfig, "minecraft:powder_snow_bucket", 16);

        //Misc
        addConfigEntry(defaultConfig, "minecraft:ender_pearl", 64);
        addConfigEntry(defaultConfig, "minecraft:snowball", 64);
        addConfigEntry(defaultConfig, "minecraft:egg", 64);
        addConfigEntry(defaultConfig, "minecraft:armor_stand", 64);
        addConfigEntry(defaultConfig, "minecraft:cake", 64);
        addConfigEntry(defaultConfig, "minecraft:potion", 16);
        addConfigEntry(defaultConfig, "minecraft:splash_potion", 1);
        addConfigEntry(defaultConfig, "minecraft:lingering_potion", 1);
        addConfigEntry(defaultConfig, "minecraft:totem_of_undying", 1);

        //Boats
        addConfigEntry(defaultConfig, "minecraft:oak_boat", 64);
        addConfigEntry(defaultConfig, "minecraft:acacia_boat", 64);
        addConfigEntry(defaultConfig, "minecraft:birch_boat", 64);
        addConfigEntry(defaultConfig, "minecraft:jungle_boat", 64);
        addConfigEntry(defaultConfig, "minecraft:spruce_boat", 64);
        addConfigEntry(defaultConfig, "minecraft:dark_oak_boat", 64);

        //Signs
        addConfigEntry(defaultConfig, "minecraft:oak_sign", 64);
        addConfigEntry(defaultConfig, "minecraft:acacia_sign", 64);
        addConfigEntry(defaultConfig, "minecraft:birch_sign", 64);
        addConfigEntry(defaultConfig, "minecraft:jungle_sign", 64);
        addConfigEntry(defaultConfig, "minecraft:spruce_sign", 64);
        addConfigEntry(defaultConfig, "minecraft:dark_oak_sign", 64);
        addConfigEntry(defaultConfig, "minecraft:crimson_sign", 64);
        addConfigEntry(defaultConfig, "minecraft:warped_sign", 64);

        //Minecarts
        addConfigEntry(defaultConfig, "minecraft:minecart", 64);
        addConfigEntry(defaultConfig, "minecraft:chest_minecart", 64);
        addConfigEntry(defaultConfig, "minecraft:furnace_minecart", 64);
        addConfigEntry(defaultConfig, "minecraft:command_block_minecart", 64);
        addConfigEntry(defaultConfig, "minecraft:hopper_minecart", 64);
        addConfigEntry(defaultConfig, "minecraft:tnt_minecart", 64);

        //Banners
        addConfigEntry(defaultConfig, "minecraft:white_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:black_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:blue_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:brown_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:cyan_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:gray_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:green_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:lime_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:yellow_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:orange_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:red_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:light_blue_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:light_gray_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:magenta_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:pink_banner", 64);
        addConfigEntry(defaultConfig, "minecraft:purple_banner", 64);

        //Beds
        addConfigEntry(defaultConfig, "minecraft:white_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:black_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:blue_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:brown_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:cyan_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:gray_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:green_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:lime_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:yellow_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:orange_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:red_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:light_blue_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:light_gray_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:magenta_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:pink_bed", 64);
        addConfigEntry(defaultConfig, "minecraft:purple_bed", 64);

        File directory = configFile.getParentFile();
        if(directory.exists()) {
            try (FileWriter writer = new FileWriter(configFile)) {
                gson.toJson(defaultConfig, writer);
            } catch (IOException e) {
                System.out.println("LENIENT STACK SIZE: Could not generate new config file!");
                throw new RuntimeException("Could not save config file", e);
            }
        } else {
            System.out.println("LENIENT STACK SIZE: Directory does not exist!");
        }

    }

    public static void addConfigEntry(LinkedHashMap<String, ItemStackConfig> config, String name, int count) {
        ItemStackConfig maxCount = new ItemStackConfig(count);
        config.put(name, maxCount);
    }

}
