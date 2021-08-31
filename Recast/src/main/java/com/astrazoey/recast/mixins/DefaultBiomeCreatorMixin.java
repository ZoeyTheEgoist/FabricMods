package com.astrazoey.recast.mixins;



import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.DefaultBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.OptionalInt;

@Mixin(DefaultBiomeCreator.class)
public class DefaultBiomeCreatorMixin {

    public DefaultBiomeCreatorMixin() {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
    }

    @Redirect(method = "createMountains", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/gen/feature/DefaultBiomeFeatures;addBatsAndMonsters(Lnet/minecraft/world/biome/SpawnSettings$Builder;)V"))
    private static void addPhantoms(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PHANTOM, 2, 4, 6));
    }


    /*
    @Inject(method="createMountains", at = @At(value = "RETURN"), cancellable = true)
    private static void addPhantoms(CallbackInfoReturnable ci) {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PHANTOM, 100, 4, 6));
    }*/
}
