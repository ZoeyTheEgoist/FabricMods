package com.astrazoey.lenientstacksize;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class LenientStackSize implements ModInitializer {
    public static final String MOD_ID = "lenientstacksize";

    @Override
    public void onInitialize() {

        //Registers Config
        Identifier identifier = new Identifier(MOD_ID);
        ServerLifecycleEvents.SERVER_STARTING.register(identifier, callbacks -> {
            System.out.println("LENIENT STACK SIZE: Starting starting. Loading config.");
            initializeConfig();
        });

        ServerLifecycleEvents.START_DATA_PACK_RELOAD.register(identifier, (server, serverResourceManager) -> {
            System.out.println("LENIENT STACK SIZE: Server data pack reload. Loading config.");
            initializeConfig();
        });


        //Config.load();

        /*
        //Mounts
        //for some reason horse armor works perfectly fine whereas
        //saddles have some trickery behind them due to saddles having
        //no max stack size. The HouseScreenHandlerMixin fixes this issue.
        SetMaxItemCount.set(Items.SADDLE, Config.saddleStackSizeValue);
        SetMaxItemCount.set(Items.DIAMOND_HORSE_ARMOR, Config.horseArmorStackSizeValue);
        SetMaxItemCount.set(Items.GOLDEN_HORSE_ARMOR, Config.horseArmorStackSizeValue);
        SetMaxItemCount.set(Items.IRON_HORSE_ARMOR, Config.horseArmorStackSizeValue);
        SetMaxItemCount.set(Items.LEATHER_HORSE_ARMOR, Config.horseArmorStackSizeValue);


        //Books
        //The AnvilScreenHandlerMixin prevents entire stacks of enchanted books from
        //being consumed when enchanting
        SetMaxItemCount.set(Items.ENCHANTED_BOOK, Config.enchantedBookStackSizeValue);
        //A stack of writable books will not be entirely consumed
        //because it's handled in the ServerPlayerNetworkHandlerMixin
        SetMaxItemCount.set(Items.WRITABLE_BOOK, Config.writableBookStackSizeValue);
        SetMaxItemCount.set(Items.WRITTEN_BOOK, Config.writtenBookStackSizeValue);
        SetMaxItemCount.set(Items.KNOWLEDGE_BOOK, Config.knowledgeBookStackSizeValue);

        //Stews
        //Will not consume all the stew because
        //of the SuspiciousStewItemMixin and
        //MushroomStewItemMixin
        SetMaxItemCount.set(Items.MUSHROOM_STEW, Config.stewStackSizeValue);
        SetMaxItemCount.set(Items.SUSPICIOUS_STEW, Config.stewStackSizeValue);
        SetMaxItemCount.set(Items.RABBIT_STEW, Config.stewStackSizeValue);
        SetMaxItemCount.set(Items.BEETROOT_SOUP, Config.stewStackSizeValue);

        //Discs
        //a mixin prevents duplication glitches on
        //jukeboxes by setting the setRecord count to 1
        SetMaxItemCount.set(Items.MUSIC_DISC_11, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_13, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_BLOCKS, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_CAT, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_CHIRP, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_FAR, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_MALL, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_PIGSTEP, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_MELLOHI, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_STAL, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_STRAD, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_WAIT, Config.discStackSizeValue);
        SetMaxItemCount.set(Items.MUSIC_DISC_WARD, Config.discStackSizeValue);

        //Buckets
        SetMaxItemCount.set(Items.BUCKET, Config.bucketStackSizeValue);
        //MilkBucketItemMixin allows you to get the bucket back
        //even with multiple milk
        SetMaxItemCount.set(Items.MILK_BUCKET, Config.milkBucketStackSizeValue);
        //Lava, water, and all fish are handled
        //by the BucketItemMixin to prevent all the
        //fluids or fish in a stack from being dropped.
        //There's also a DispenserBehaviorMixin that
        //prevents the entire stack being dumped in
        //a dispenser.
        SetMaxItemCount.set(Items.LAVA_BUCKET, Config.lavaBucketStackSizeValue);
        SetMaxItemCount.set(Items.WATER_BUCKET, Config.waterBucketStackSizeValue);

        //Stackable entity buckets behave really weirdly
        //so I'm just leaving this default for the moment.
        //But the FilledBucketCriterionMixin exists there
        //to make sure the Tactical Fishing and Cutest
        //predator achievements trigger even if you're holding
        //a stack of water buckets.
        SetMaxItemCount.set(Items.PUFFERFISH_BUCKET, 1);
        SetMaxItemCount.set(Items.SALMON_BUCKET, 1);
        SetMaxItemCount.set(Items.COD_BUCKET, 1);
        SetMaxItemCount.set(Items.TROPICAL_FISH_BUCKET, 1);
        SetMaxItemCount.set(Items.AXOLOTL_BUCKET, 1);

        //Powdered Snow is handled by PowderSnowBucketItemMixin
        //and prevents the entire stack from being dumped at once
        SetMaxItemCount.set(Items.POWDER_SNOW_BUCKET, Config.powderSnowBucketStackSizeValue);

        //No special reprogramming needed for the following items
        SetMaxItemCount.set(Items.ENDER_PEARL, Config.enderPearlStackSizeValue);
        SetMaxItemCount.set(Items.SNOWBALL, Config.snowballStackSizeValue);
        SetMaxItemCount.set(Items.EGG, Config.eggStackSizeValue);
        SetMaxItemCount.set(Items.ARMOR_STAND, Config.armorStandStackSizeValue);
        SetMaxItemCount.set(Items.CAKE, Config.cakeStackSizeValue);
        SetMaxItemCount.set(Items.POTION, Config.potionStackSizeValue);

        SetMaxItemCount.set(Items.OAK_BOAT, Config.boatStackSizeValue);
        SetMaxItemCount.set(Items.ACACIA_BOAT, Config.boatStackSizeValue);
        SetMaxItemCount.set(Items.BIRCH_BOAT, Config.boatStackSizeValue);
        SetMaxItemCount.set(Items.JUNGLE_BOAT, Config.boatStackSizeValue);
        SetMaxItemCount.set(Items.SPRUCE_BOAT, Config.boatStackSizeValue);
        SetMaxItemCount.set(Items.DARK_OAK_BOAT, Config.boatStackSizeValue);

        SetMaxItemCount.set(Items.OAK_SIGN, Config.signStackSizeValue);
        SetMaxItemCount.set(Items.ACACIA_SIGN, Config.signStackSizeValue);
        SetMaxItemCount.set(Items.BIRCH_SIGN, Config.signStackSizeValue);
        SetMaxItemCount.set(Items.JUNGLE_SIGN, Config.signStackSizeValue);
        SetMaxItemCount.set(Items.SPRUCE_SIGN, Config.signStackSizeValue);
        SetMaxItemCount.set(Items.DARK_OAK_SIGN, Config.signStackSizeValue);
        SetMaxItemCount.set(Items.CRIMSON_SIGN, Config.signStackSizeValue);
        SetMaxItemCount.set(Items.WARPED_SIGN, Config.signStackSizeValue);

        SetMaxItemCount.set(Items.MINECART, Config.minecartStackSizeValue);
        SetMaxItemCount.set(Items.CHEST_MINECART, Config.minecartStackSizeValue);
        SetMaxItemCount.set(Items.FURNACE_MINECART, Config.minecartStackSizeValue);
        SetMaxItemCount.set(Items.COMMAND_BLOCK_MINECART, Config.minecartStackSizeValue);
        SetMaxItemCount.set(Items.HOPPER_MINECART, Config.minecartStackSizeValue);
        SetMaxItemCount.set(Items.TNT_MINECART, Config.minecartStackSizeValue);

        SetMaxItemCount.set(Items.WHITE_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.BLACK_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.BLUE_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.BROWN_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.CYAN_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.GRAY_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.GREEN_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.LIME_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.YELLOW_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.ORANGE_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.RED_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.LIGHT_BLUE_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.LIGHT_GRAY_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.MAGENTA_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.PINK_BANNER, Config.bannerStackSizeValue);
        SetMaxItemCount.set(Items.PURPLE_BANNER, Config.bannerStackSizeValue);

        SetMaxItemCount.set(Items.WHITE_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.BLACK_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.BLUE_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.BROWN_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.CYAN_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.GRAY_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.GREEN_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.LIME_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.YELLOW_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.ORANGE_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.RED_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.LIGHT_BLUE_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.LIGHT_GRAY_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.MAGENTA_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.PINK_BED, Config.bedStackSizeValue);
        SetMaxItemCount.set(Items.PURPLE_BED, Config.bedStackSizeValue);


        //Supported Items that I'm defaulting to 1
        //You may change these in the config
        SetMaxItemCount.set(Items.TOTEM_OF_UNDYING, Config.totemStackSizeValue);
        SetMaxItemCount.set(Items.LINGERING_POTION, Config.lingeringPotionStackSizeValue);
        SetMaxItemCount.set(Items.SPLASH_POTION, Config.splashPotionStackSizeValue);

         */
    }

    public static void initializeConfig() {
        Config.load(false);
        boolean modOutOfDate = Config.isOutOfDate();
        ConfigNew.loadConfig(modOutOfDate);
        Config.load(modOutOfDate);
    }
}
