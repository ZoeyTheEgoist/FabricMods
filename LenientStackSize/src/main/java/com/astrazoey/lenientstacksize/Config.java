package com.astrazoey.lenientstacksize;

import net.fabricmc.loader.api.FabricLoader;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Config {

    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("lenientstacksize.properties");;

    private static final String SADDLE_STACK_SIZE_KEY = "saddle-stack-size";
    public static int saddleStackSizeValue = 64;
    private static final String HORSE_ARMOR_STACK_SIZE_KEY = "horse-armor-stack-size";
    public static int horseArmorStackSizeValue = 64;

    private static final String ENCHANTED_BOOK_STACK_SIZE_KEY = "enchanted-book-stack-size";
    public static int enchantedBookStackSizeValue = 64;
    private static final String WRITABLE_BOOK_STACK_SIZE_KEY = "writable-book-stack-size";
    public static int writableBookStackSizeValue = 64;
    private static final String WRITTEN_BOOK_STACK_SIZE_KEY = "written-book-stack-size";
    public static int writtenBookStackSizeValue = 64;
    private static final String KNOWLEDGE_BOOK_STACK_SIZE_KEY = "knowledge-book-stack-size";
    public static int knowledgeBookStackSizeValue = 64;

    private static final String STEW_STACK_SIZE_KEY = "stew-stack-size";
    public static int stewStackSizeValue = 16;

    private static final String DISC_STACK_SIZE_KEY = "disc-stack-size";
    public static int discStackSizeValue = 64;

    private static final String BUCKET_STACK_SIZE_KEY = "bucket-stack-size";
    public static int bucketStackSizeValue = 64;
    private static final String MILK_BUCKET_STACK_SIZE_KEY = "milk-bucket-stack-size";
    public static int milkBucketStackSizeValue = 16;
    private static final String LAVA_BUCKET_STACK_SIZE_KEY = "lava-bucket-stack-size";
    public static int lavaBucketStackSizeValue = 16;
    private static final String WATER_BUCKET_STACK_SIZE_KEY = "water-bucket-stack-size";
    public static int waterBucketStackSizeValue = 16;
    private static final String POWDER_SNOW_BUCKET_STACK_SIZE_KEY = "powder-snow-bucket-stack-size";
    public static int powderSnowBucketStackSizeValue = 16;

    private static final String ENDER_PEARL_STACK_SIZE_KEY = "ender-pearl-stack-size";
    public static int enderPearlStackSizeValue = 64;
    private static final String SNOWBALL_STACK_SIZE_KEY = "snowball-stack-size";
    public static int snowballStackSizeValue = 64;
    private static final String EGG_STACK_SIZE_KEY = "egg-stack-size";
    public static int eggStackSizeValue = 64;
    private static final String ARMOR_STAND_STACK_SIZE_KEY = "armor-stand-stack-size";
    public static int armorStandStackSizeValue = 64;
    private static final String CAKE_STACK_SIZE_KEY = "cake-stack-size";
    public static int cakeStackSizeValue = 64;

    private static final String POTION_STACK_SIZE_KEY = "potion-stack-size";
    public static int potionStackSizeValue = 16;
    private static final String SPLASH_POTION_STACK_SIZE_KEY = "splash-potion-stack-size";
    public static int splashPotionStackSizeValue = 1;
    private static final String LINGERING_POTION_STACK_SIZE_KEY = "lingering-potion-stack-size";
    public static int lingeringPotionStackSizeValue = 1;

    private static final String BOAT_STACK_SIZE_KEY = "boat-stack-size";
    public static int boatStackSizeValue = 64;
    private static final String SIGN_STACK_SIZE_KEY = "sign-stack-size";
    public static int signStackSizeValue = 64;
    private static final String MINECART_STACK_SIZE_KEY = "minecart-stack-size";
    public static int minecartStackSizeValue = 64;
    private static final String BANNER_STACK_SIZE_KEY = "banner-stack-size";
    public static int bannerStackSizeValue = 64;
    private static final String BED_STACK_SIZE_KEY = "bed-stack-size";
    public static int bedStackSizeValue = 64;

    private static final String TOTEM_STACK_SIZE_KEY = "totem-stack-size";
    public static int totemStackSizeValue = 1;

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
        props.setProperty(SADDLE_STACK_SIZE_KEY, String.valueOf(saddleStackSizeValue));
        props.setProperty(HORSE_ARMOR_STACK_SIZE_KEY, String.valueOf(horseArmorStackSizeValue));

        props.setProperty(ENCHANTED_BOOK_STACK_SIZE_KEY, String.valueOf(enchantedBookStackSizeValue));
        props.setProperty(WRITABLE_BOOK_STACK_SIZE_KEY, String.valueOf(writableBookStackSizeValue));
        props.setProperty(WRITTEN_BOOK_STACK_SIZE_KEY, String.valueOf(writtenBookStackSizeValue));
        props.setProperty(KNOWLEDGE_BOOK_STACK_SIZE_KEY, String.valueOf(knowledgeBookStackSizeValue));

        props.setProperty(STEW_STACK_SIZE_KEY, String.valueOf(stewStackSizeValue));
        props.setProperty(DISC_STACK_SIZE_KEY, String.valueOf(discStackSizeValue));
        props.setProperty(BUCKET_STACK_SIZE_KEY, String.valueOf(bucketStackSizeValue));
        props.setProperty(LAVA_BUCKET_STACK_SIZE_KEY, String.valueOf(lavaBucketStackSizeValue));
        props.setProperty(WATER_BUCKET_STACK_SIZE_KEY, String.valueOf(waterBucketStackSizeValue));
        props.setProperty(POWDER_SNOW_BUCKET_STACK_SIZE_KEY, String.valueOf(powderSnowBucketStackSizeValue));
        props.setProperty(MILK_BUCKET_STACK_SIZE_KEY, String.valueOf(milkBucketStackSizeValue));

        props.setProperty(ENDER_PEARL_STACK_SIZE_KEY, String.valueOf(enderPearlStackSizeValue));
        props.setProperty(SNOWBALL_STACK_SIZE_KEY, String.valueOf(snowballStackSizeValue));
        props.setProperty(EGG_STACK_SIZE_KEY, String.valueOf(eggStackSizeValue));
        props.setProperty(ARMOR_STAND_STACK_SIZE_KEY, String.valueOf(armorStandStackSizeValue));
        props.setProperty(CAKE_STACK_SIZE_KEY, String.valueOf(cakeStackSizeValue));

        props.setProperty(POTION_STACK_SIZE_KEY, String.valueOf(potionStackSizeValue));
        props.setProperty(SPLASH_POTION_STACK_SIZE_KEY, String.valueOf(splashPotionStackSizeValue));
        props.setProperty(LINGERING_POTION_STACK_SIZE_KEY, String.valueOf(lingeringPotionStackSizeValue));

        props.setProperty(BOAT_STACK_SIZE_KEY, String.valueOf(boatStackSizeValue));
        props.setProperty(SIGN_STACK_SIZE_KEY, String.valueOf(signStackSizeValue));
        props.setProperty(MINECART_STACK_SIZE_KEY, String.valueOf(minecartStackSizeValue));
        props.setProperty(BANNER_STACK_SIZE_KEY, String.valueOf(bannerStackSizeValue));
        props.setProperty(BED_STACK_SIZE_KEY, String.valueOf(bedStackSizeValue));

        props.setProperty(TOTEM_STACK_SIZE_KEY, String.valueOf(totemStackSizeValue));

    }

    // Call when changing properties in-game.
    public static void assign(Properties props) {
        saddleStackSizeValue = defaultInteger(props.getProperty(SADDLE_STACK_SIZE_KEY), 64);
        horseArmorStackSizeValue = defaultInteger(props.getProperty(HORSE_ARMOR_STACK_SIZE_KEY), 64);

        writableBookStackSizeValue = defaultInteger(props.getProperty(WRITABLE_BOOK_STACK_SIZE_KEY), 64);
        writtenBookStackSizeValue = defaultInteger(props.getProperty(WRITTEN_BOOK_STACK_SIZE_KEY), 64);
        enchantedBookStackSizeValue = defaultInteger(props.getProperty(ENCHANTED_BOOK_STACK_SIZE_KEY), 64);
        knowledgeBookStackSizeValue = defaultInteger(props.getProperty(KNOWLEDGE_BOOK_STACK_SIZE_KEY), 64);

        stewStackSizeValue = defaultInteger(props.getProperty(STEW_STACK_SIZE_KEY), 16);
        discStackSizeValue = defaultInteger(props.getProperty(DISC_STACK_SIZE_KEY), 64);

        bucketStackSizeValue = defaultInteger(props.getProperty(BUCKET_STACK_SIZE_KEY), 64);
        waterBucketStackSizeValue = defaultInteger(props.getProperty(WATER_BUCKET_STACK_SIZE_KEY), 16);
        lavaBucketStackSizeValue = defaultInteger(props.getProperty(LAVA_BUCKET_STACK_SIZE_KEY), 16);
        milkBucketStackSizeValue = defaultInteger(props.getProperty(MILK_BUCKET_STACK_SIZE_KEY), 16);
        powderSnowBucketStackSizeValue = defaultInteger(props.getProperty(POWDER_SNOW_BUCKET_STACK_SIZE_KEY), 16);

        enderPearlStackSizeValue = defaultInteger(props.getProperty(ENDER_PEARL_STACK_SIZE_KEY), 64);
        snowballStackSizeValue = defaultInteger(props.getProperty(SNOWBALL_STACK_SIZE_KEY), 64);
        eggStackSizeValue = defaultInteger(props.getProperty(EGG_STACK_SIZE_KEY), 64);
        armorStandStackSizeValue = defaultInteger(props.getProperty(ARMOR_STAND_STACK_SIZE_KEY), 64);
        cakeStackSizeValue = defaultInteger(props.getProperty(CAKE_STACK_SIZE_KEY), 64);

        potionStackSizeValue = defaultInteger(props.getProperty(POTION_STACK_SIZE_KEY), 16);
        splashPotionStackSizeValue = defaultInteger(props.getProperty(SPLASH_POTION_STACK_SIZE_KEY), 1);
        lingeringPotionStackSizeValue = defaultInteger(props.getProperty(LINGERING_POTION_STACK_SIZE_KEY), 1);

        boatStackSizeValue = defaultInteger(props.getProperty(BOAT_STACK_SIZE_KEY), 64);
        signStackSizeValue = defaultInteger(props.getProperty(SIGN_STACK_SIZE_KEY), 64);
        minecartStackSizeValue = defaultInteger(props.getProperty(MINECART_STACK_SIZE_KEY), 64);
        bannerStackSizeValue = defaultInteger(props.getProperty(BANNER_STACK_SIZE_KEY), 64);
        bedStackSizeValue = defaultInteger(props.getProperty(BED_STACK_SIZE_KEY), 64);

        totemStackSizeValue = defaultInteger(props.getProperty(TOTEM_STACK_SIZE_KEY), 1);
    }

    private static boolean defaultBoolean(String bool, boolean defaultOption) {
        return bool == null ? defaultOption : Boolean.parseBoolean(bool);
    }

    private static int defaultInteger(String amount, int defaultOption) {
        return amount == null ? defaultOption : Integer.parseInt(amount);
    }
}
