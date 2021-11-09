package com.astrazoey.secondchance;

import net.fabricmc.loader.api.FabricLoader;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Config {

    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("second-chance.properties");

    private static final String PLAYER_HEALTH_THRESHOLD = "player-health-threshold";
    public static float playerHealthThreshold = 13.5f;

    private static final String WOLF_HEALTH_THRESHOLD = "wolf-health-threshold";
    public static float wolfHealthThreshold = 4f;

    private static final String PARROT_HEALTH_THRESHOLD = "parrot-health-threshold";
    public static float parrotHealthThreshold = 3f;

    private static final String CAT_HEALTH_THRESHOLD = "cat-health-threshold";
    public static float catHealthThreshold = 5f;

    private static final String VILLAGER_HEALTH_THRESHOLD = "villager-health-threshold";
    public static float villagerHealthThreshold = 13.5f;

    private static final String AXOLOTL_HEALTH_THRESHOLD = "axolotl-health-threshold";
    public static float axolotlHealthThreshold = 4f;

    private static final String MOUNT_HEALTH_THRESHOLD = "mount-health-threshold";
    public static float mountHealthThreshold = 15f;

    private static final String SNOW_GOLEM_HEALTH_THRESHOLD = "snow-golem-health-threshold";
    public static float snowGolemHealthThreshold = 2f;

    private static final String IRON_GOLEM_HEALTH_THRESHOLD = "iron-golem-health-threshold";
    public static float ironGolemHealthThreshold = 20f;

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
            props.store(out, "Second Chance Configuration");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        Properties props = new Properties();
        if (!Files.exists(CONFIG_PATH)) {
            try {
                Files.createFile(CONFIG_PATH);
                save();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

        try (InputStream stream = Files.newInputStream(CONFIG_PATH)) {
            props.load(stream);
            assign(props);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void read(Properties props) {
        props.setProperty(PLAYER_HEALTH_THRESHOLD, String.valueOf(playerHealthThreshold));
        props.setProperty(WOLF_HEALTH_THRESHOLD, String.valueOf(wolfHealthThreshold));
        props.setProperty(PARROT_HEALTH_THRESHOLD, String.valueOf(parrotHealthThreshold));
        props.setProperty(CAT_HEALTH_THRESHOLD, String.valueOf(catHealthThreshold));
        props.setProperty(VILLAGER_HEALTH_THRESHOLD, String.valueOf(villagerHealthThreshold));
        props.setProperty(AXOLOTL_HEALTH_THRESHOLD, String.valueOf(axolotlHealthThreshold));
        props.setProperty(MOUNT_HEALTH_THRESHOLD, String.valueOf(mountHealthThreshold));
        props.setProperty(SNOW_GOLEM_HEALTH_THRESHOLD, String.valueOf(snowGolemHealthThreshold));
        props.setProperty(IRON_GOLEM_HEALTH_THRESHOLD, String.valueOf(ironGolemHealthThreshold));
    }

    public static void assign(Properties props) {
        playerHealthThreshold = defaultFloat(props.getProperty(PLAYER_HEALTH_THRESHOLD), 13.5f); //player health threshold
        wolfHealthThreshold = defaultFloat(props.getProperty(WOLF_HEALTH_THRESHOLD), 4f); //half health
        parrotHealthThreshold = defaultFloat(props.getProperty(PARROT_HEALTH_THRESHOLD), 3f); //half health
        catHealthThreshold = defaultFloat(props.getProperty(CAT_HEALTH_THRESHOLD), 5f); //half health
        villagerHealthThreshold = defaultFloat(props.getProperty(VILLAGER_HEALTH_THRESHOLD), 13.5f); //same as player
        axolotlHealthThreshold = defaultFloat(props.getProperty(AXOLOTL_HEALTH_THRESHOLD), 4f); //the value axolotls play dead
        mountHealthThreshold = defaultFloat(props.getProperty(MOUNT_HEALTH_THRESHOLD), 15f); //the minimum max health of a mount
        snowGolemHealthThreshold = defaultFloat(props.getProperty(SNOW_GOLEM_HEALTH_THRESHOLD), 2f); //half health
        ironGolemHealthThreshold = defaultFloat(props.getProperty(IRON_GOLEM_HEALTH_THRESHOLD), 20f); //fifth health
    }

    private static float defaultFloat(String amount, float defaultOption) {
        return amount == null ? defaultOption : Float.parseFloat(amount);
    }
}
