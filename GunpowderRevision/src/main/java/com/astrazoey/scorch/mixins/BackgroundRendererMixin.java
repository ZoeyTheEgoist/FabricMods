package com.astrazoey.scorch.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.CameraSubmersionType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.feature.OceanRuinFeature;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {

    @ModifyConstant(method = "applyFog", constant = @Constant(floatValue = 192.0F, ordinal = 1))
    private static float modifyFogEnd(float distance) {
        //to do, change this value depending on the biome the player is in
        return 3072.0F;
    }

    @ModifyConstant(method = "applyFog", constant = @Constant(floatValue = 0.05F))
    private static float modifyFogStart(float distance) {
        return 0.01F;
    }
}
