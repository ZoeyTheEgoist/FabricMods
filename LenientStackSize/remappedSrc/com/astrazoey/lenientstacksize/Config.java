package com.astrazoey.lenientstacksize;

import net.fabricmc.loader.api.FabricLoader;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Config {

    private static final float MOD_VERSION = 1.2f;

    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("lenientstacksize.properties");

    private static final String MOD_VERSION_KEY = "mod-version";
    private static float modVersion = MOD_VERSION;

    public static final String ENABLE_CONFIG_UPDATES_KEY = "enable-config-updates";
    private static boolean enableConfigUpdates = true;

    public static void save() {
        Properties props = new Properties();
        read(props);

        if (!Files.exists(CONFIG_PATH)) {
            try {
                Files.createFile(CONFIG_PATH);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

        try (OutputStream out = Files.newOutputStream(CONFIG_PATH)) {
            props.store(out, "Lenient Stack Size Configuration\nCAUTION: Values over 64 and below 1 are NOT supported!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void load(boolean modOutOfDate) {

        if (modOutOfDate && Files.exists(CONFIG_PATH)) {
            try {
                System.out.println("Mod is out of date! Resetting file!");
                modVersion = MOD_VERSION; //update mod version
                Files.delete(CONFIG_PATH);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to delete config file.");
                return;
            }
        }

        if (!Files.exists(CONFIG_PATH)) {
            try {
                Files.createFile(CONFIG_PATH);
                save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Properties props = new Properties();
        try (InputStream stream = Files.newInputStream(CONFIG_PATH)) {
            props.load(stream);
            assign(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read(Properties props) {
        props.setProperty(MOD_VERSION_KEY, String.valueOf(modVersion));
        props.setProperty(ENABLE_CONFIG_UPDATES_KEY, String.valueOf(enableConfigUpdates));

    }

    // Call when changing properties in-game.
    public static void assign(Properties props) {
        modVersion = defaultFloat(props.getProperty(MOD_VERSION_KEY), MOD_VERSION);
        enableConfigUpdates = defaultBoolean(props.getProperty(ENABLE_CONFIG_UPDATES_KEY), true);
    }

    private static boolean defaultBoolean(String bool, boolean defaultOption) {
        return bool == null ? defaultOption : Boolean.parseBoolean(bool);
    }

    private static int defaultInteger(String amount, int defaultOption) {
        return amount == null ? defaultOption : Integer.parseInt(amount);
    }

    private static float defaultFloat(String amount, float defaultOption) {
        return amount == null ? defaultOption : Float.parseFloat(amount);
    }

    public static boolean isOutOfDate() {
        return (modVersion != MOD_VERSION) && enableConfigUpdates;
    }
}
