package com.astrazoey.scorch;
import com.astrazoey.scorch.criterion.MineIgnistoneCriterion;
import com.astrazoey.scorch.criterion.ShearStriderCriterion;
import com.astrazoey.scorch.criterion.ShootPyrackCriterion;
import com.astrazoey.scorch.criterion.StyleStriderCriterion;
import com.astrazoey.scorch.mixins.CriterionRegistryAccessor;
import com.astrazoey.scorch.mixins.StriderEntityMixin;
import com.astrazoey.scorch.registry.GunpowderRevisionBlocks;
import com.astrazoey.scorch.registry.GunpowderRevisionEvents;
import com.astrazoey.scorch.registry.GunpowderRevisionItems;
import com.astrazoey.scorch.registry.GunpowderRevisionSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class GunpowderRevision implements ModInitializer {

    public static final String MOD_ID = "scorch";

    public static final ConfiguredFeature<?,?> PYRACK_CONFIGURED_LOW = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER, GunpowderRevisionBlocks.PYRACK.getDefaultState(),
            27))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(
                    YOffset.fixed(7),
                    YOffset.fixed(15)))))
            .spreadHorizontally()
            .repeat(2);

    public static final ConfiguredFeature<?,?> PYRACK_CONFIGURED_HIGH = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER, GunpowderRevisionBlocks.PYRACK.getDefaultState(),
            15))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(
                    YOffset.fixed(40),
                    YOffset.fixed(120)))))
            .spreadHorizontally()
            .repeat(8);

    public static ShearStriderCriterion SHEAR_STRIDER = new ShearStriderCriterion();
    public static StyleStriderCriterion STYLE_STRIDER = new StyleStriderCriterion();
    public static ShootPyrackCriterion SHOOT_PYRACK = new ShootPyrackCriterion();
    public static MineIgnistoneCriterion MINE_IGNISTONE = new MineIgnistoneCriterion();

    //private static final Identifier PIGLIN_LOOT_TABLE_ID = LootTables.PIGLIN_BARTERING_GAMEPLAY;


    private void successfullyUsedItem(PlayerEntity player, ItemStack heldItem, Item item) {
        player.incrementStat(Stats.USED.getOrCreateStat(item));
        if(!player.isCreative()) {
            heldItem.decrement(1);
        }
    }


    @Override
    public void onInitialize() {

        //Registration
        GunpowderRevisionBlocks.registerBlocks();
        GunpowderRevisionItems.registerItems();
        GunpowderRevisionSounds.registerSounds();
        GunpowderRevisionEvents.registerEvents();

        //Criterion Registration
        CriterionRegistryAccessor.registerCriterion(SHEAR_STRIDER);
        CriterionRegistryAccessor.registerCriterion(STYLE_STRIDER);
        CriterionRegistryAccessor.registerCriterion(SHOOT_PYRACK);
        CriterionRegistryAccessor.registerCriterion(MINE_IGNISTONE);



        //Ore Generation
        RegistryKey<ConfiguredFeature<?, ?>> pyrackLow = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("scorch", "pyrack_low"));
        RegistryKey<ConfiguredFeature<?, ?>> pyrackHigh = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("scorch", "pyrack_high"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pyrackLow.getValue(), PYRACK_CONFIGURED_LOW);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pyrackHigh.getValue(), PYRACK_CONFIGURED_HIGH);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, pyrackLow);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES, BiomeKeys.SOUL_SAND_VALLEY, BiomeKeys.CRIMSON_FOREST), GenerationStep.Feature.UNDERGROUND_ORES, pyrackHigh);


        //STRUCTURES

        GunpowderRevisionStructures.setupAndRegisterStructureFeatures();
        GunpowderRevisionConfiguredStructures.registerConfiguredStructures();


        BiomeModifications.create(new Identifier(MOD_ID, "debug_structure"))
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.foundInTheNether(),
                        context -> {
                    context.getGenerationSettings().addBuiltInStructure(GunpowderRevisionConfiguredStructures.CONFIGURED_DEBUG_STRUCTURE);
                        }
                        );

        BiomeModifications.create(new Identifier(MOD_ID, "debris_structure"))
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.foundInTheNether(),
                        context -> {
                            context.getGenerationSettings().addBuiltInStructure(GunpowderRevisionConfiguredStructures.CONFIGURED_DEBRIS_STRUCTURE);
                        }
                );

        BiomeModifications.create(new Identifier(MOD_ID, "wither_sanctum"))
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.foundInTheNether(),
                        context -> {
                            context.getGenerationSettings().addBuiltInStructure(GunpowderRevisionConfiguredStructures.CONFIGURED_WITHER_SANCTUM);
                        }
                );

    }
}