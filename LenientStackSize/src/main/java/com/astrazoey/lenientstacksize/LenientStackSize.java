package com.astrazoey.lenientstacksize;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;

public class LenientStackSize implements ModInitializer {
    public static final String MOD_ID = "lenientstacksize";

    @Override
    public void onInitialize() {
        //Mounts
        //for some reason horse armor works perfectly fine whereas
        //saddles have some trickery behind them due to saddles having
        //no max stack size. The HouseScreenHandlerMixin fixes this issue.
        SetMaxItemCount.set(Items.SADDLE, 64);
        SetMaxItemCount.set(Items.DIAMOND_HORSE_ARMOR, 64);
        SetMaxItemCount.set(Items.GOLDEN_HORSE_ARMOR, 64);
        SetMaxItemCount.set(Items.IRON_HORSE_ARMOR, 64);
        SetMaxItemCount.set(Items.LEATHER_HORSE_ARMOR, 64);


        //Books
        //The AnvilScreenHandlerMixin prevents entire stacks of enchanted books from
        //being consumed when enchanting
        SetMaxItemCount.set(Items.ENCHANTED_BOOK, 64);
        //A stack of writable books will not be entirely consumed
        //because it's handled in the ServerPlayerNetworkHandlerMixin
        SetMaxItemCount.set(Items.WRITABLE_BOOK, 64);
        SetMaxItemCount.set(Items.WRITTEN_BOOK, 64);
        SetMaxItemCount.set(Items.KNOWLEDGE_BOOK, 64);

        //Stews
        //Will not consume all the stew because
        //of the SuspiciousStewItemMixin and
        //MushroomStewItemMixin
        SetMaxItemCount.set(Items.MUSHROOM_STEW, 16);
        SetMaxItemCount.set(Items.SUSPICIOUS_STEW, 16);
        SetMaxItemCount.set(Items.RABBIT_STEW, 16);
        SetMaxItemCount.set(Items.BEETROOT_SOUP, 16);

        //Discs
        //a mixin prevents duplication glitches on
        //jukeboxes by setting the setRecord count to 1
        SetMaxItemCount.set(Items.MUSIC_DISC_11, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_13, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_BLOCKS, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_CAT, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_CHIRP, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_FAR, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_MALL, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_PIGSTEP, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_MELLOHI, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_STAL, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_STRAD, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_WAIT, 64);
        SetMaxItemCount.set(Items.MUSIC_DISC_WARD, 64);

        //Buckets
        SetMaxItemCount.set(Items.BUCKET, 64);
        //MilkBucketItemMixin allows you to get the bucket back
        //even with multiple milk
        SetMaxItemCount.set(Items.MILK_BUCKET, 16);
        //Lava, water, and all fish are handled
        //by the BucketItemMixin to prevent all the
        //fluids or fish in a stack from being dropped.
        //There's also a DispenserBehaviorMixin that
        //prevents the entire stack being dumped in
        //a dispenser.
        SetMaxItemCount.set(Items.LAVA_BUCKET, 16);
        SetMaxItemCount.set(Items.WATER_BUCKET, 16);

        //Stackable entity buckets behave really weirdly
        //so I'm just leaving this blank for the moment.
        //But the FilledBucketCriterionMixin exists there
        //to make sure the Tactical Fishing and Cutest
        //predator achievements trigger even if you're holding
        //a stack of water buckets.
        //SetMaxItemCount.set(Items.PUFFERFISH_BUCKET, 16);
        //SetMaxItemCount.set(Items.SALMON_BUCKET, 16);
        //SetMaxItemCount.set(Items.COD_BUCKET, 16);
        //SetMaxItemCount.set(Items.TROPICAL_FISH_BUCKET, 16);
        //SetMaxItemCount.set(Items.AXOLOTL_BUCKET, 16);

        //Powdered Snow is handled by PowderSnowBucketItemMixin
        //and prevents the entire stack from being dumped at once
        SetMaxItemCount.set(Items.POWDER_SNOW_BUCKET, 16);

        //No special reprogramming needed for the following items
        SetMaxItemCount.set(Items.ENDER_PEARL, 64);
        SetMaxItemCount.set(Items.SNOWBALL, 64);
        SetMaxItemCount.set(Items.EGG, 64);
        SetMaxItemCount.set(Items.ARMOR_STAND, 64);
        SetMaxItemCount.set(Items.CAKE, 64);
        SetMaxItemCount.set(Items.POTION, 16);


        SetMaxItemCount.set(Items.OAK_BOAT, 64);
        SetMaxItemCount.set(Items.ACACIA_BOAT, 64);
        SetMaxItemCount.set(Items.BIRCH_BOAT, 64);
        SetMaxItemCount.set(Items.JUNGLE_BOAT, 64);
        SetMaxItemCount.set(Items.SPRUCE_BOAT, 64);
        SetMaxItemCount.set(Items.DARK_OAK_BOAT, 64);

        SetMaxItemCount.set(Items.OAK_SIGN, 64);
        SetMaxItemCount.set(Items.ACACIA_SIGN, 64);
        SetMaxItemCount.set(Items.BIRCH_SIGN, 64);
        SetMaxItemCount.set(Items.JUNGLE_SIGN, 64);
        SetMaxItemCount.set(Items.SPRUCE_SIGN, 64);
        SetMaxItemCount.set(Items.DARK_OAK_SIGN, 64);
        SetMaxItemCount.set(Items.CRIMSON_SIGN, 64);
        SetMaxItemCount.set(Items.WARPED_SIGN, 64);

        SetMaxItemCount.set(Items.MINECART, 64);
        SetMaxItemCount.set(Items.CHEST_MINECART, 64);
        SetMaxItemCount.set(Items.FURNACE_MINECART, 64);
        SetMaxItemCount.set(Items.COMMAND_BLOCK_MINECART, 64);
        SetMaxItemCount.set(Items.HOPPER_MINECART, 64);
        SetMaxItemCount.set(Items.TNT_MINECART, 64);

        SetMaxItemCount.set(Items.WHITE_BANNER, 64);
        SetMaxItemCount.set(Items.BLACK_BANNER, 64);
        SetMaxItemCount.set(Items.BLUE_BANNER, 64);
        SetMaxItemCount.set(Items.BROWN_BANNER, 64);
        SetMaxItemCount.set(Items.CYAN_BANNER, 64);
        SetMaxItemCount.set(Items.GRAY_BANNER, 64);
        SetMaxItemCount.set(Items.GREEN_BANNER, 64);
        SetMaxItemCount.set(Items.LIME_BANNER, 64);
        SetMaxItemCount.set(Items.YELLOW_BANNER, 64);
        SetMaxItemCount.set(Items.ORANGE_BANNER, 64);
        SetMaxItemCount.set(Items.RED_BANNER, 64);
        SetMaxItemCount.set(Items.LIGHT_BLUE_BANNER, 64);
        SetMaxItemCount.set(Items.LIGHT_GRAY_BANNER, 64);
        SetMaxItemCount.set(Items.MAGENTA_BANNER, 64);
        SetMaxItemCount.set(Items.PINK_BANNER, 64);
        SetMaxItemCount.set(Items.PURPLE_BANNER, 64);

        SetMaxItemCount.set(Items.WHITE_BED, 64);
        SetMaxItemCount.set(Items.BLACK_BED, 64);
        SetMaxItemCount.set(Items.BLUE_BED, 64);
        SetMaxItemCount.set(Items.BROWN_BED, 64);
        SetMaxItemCount.set(Items.CYAN_BED, 64);
        SetMaxItemCount.set(Items.GRAY_BED, 64);
        SetMaxItemCount.set(Items.GREEN_BED, 64);
        SetMaxItemCount.set(Items.LIME_BED, 64);
        SetMaxItemCount.set(Items.YELLOW_BED, 64);
        SetMaxItemCount.set(Items.ORANGE_BED, 64);
        SetMaxItemCount.set(Items.RED_BED, 64);
        SetMaxItemCount.set(Items.LIGHT_BLUE_BED, 64);
        SetMaxItemCount.set(Items.LIGHT_GRAY_BED, 64);
        SetMaxItemCount.set(Items.MAGENTA_BED, 64);
        SetMaxItemCount.set(Items.PINK_BED, 64);
        SetMaxItemCount.set(Items.PURPLE_BED, 64);


    }
}
