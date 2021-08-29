package com.astrazoey.scorch.mixins;

import com.astrazoey.scorch.StriderHairInterface;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.StriderEntityRenderer;
import net.minecraft.client.render.entity.model.StriderEntityModel;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(StriderEntityRenderer.class)
public abstract class StriderEntityRendererMixin extends MobEntityRenderer<StriderEntity, StriderEntityModel<StriderEntity>> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/strider/strider.png");
    private static final Identifier COLD_TEXTURE = new Identifier("textures/entity/strider/strider_cold.png");
    private static final Identifier TEXTURE_HAIRLESS = new Identifier("textures/entity/strider/strider_no_hair.png");
    private static final Identifier COLD_TEXTURE_HAIRLESS = new Identifier("textures/entity/strider/strider_cold_no_hair.png");

    private static final Identifier TEXTURE_HAIR_1 = new Identifier("textures/entity/strider/strider_hair_1.png");
    private static final Identifier COLD_TEXTURE_HAIR_1 = new Identifier("textures/entity/strider/strider_cold_hair_1.png");

    private static final Identifier TEXTURE_HAIR_2 = new Identifier("textures/entity/strider/strider_hair_2.png");
    private static final Identifier COLD_TEXTURE_HAIR_2 = new Identifier("textures/entity/strider/strider_cold_hair_2.png");

    private static final Identifier TEXTURE_HAIR_3 = new Identifier("textures/entity/strider/strider_hair_3.png");
    private static final Identifier COLD_TEXTURE_HAIR_3 = new Identifier("textures/entity/strider/strider_cold_hair_3.png");

    private static final Identifier TEXTURE_HAIR_4 = new Identifier("textures/entity/strider/strider_hair_4.png");
    private static final Identifier COLD_TEXTURE_HAIR_4 = new Identifier("textures/entity/strider/strider_cold_hair_4.png");

    private static final Identifier TEXTURE_HAIR_5 = new Identifier("textures/entity/strider/strider_hair_5.png");
    private static final Identifier COLD_TEXTURE_HAIR_5 = new Identifier("textures/entity/strider/strider_cold_hair_5.png");

    public StriderEntityRendererMixin(EntityRendererFactory.Context context, StriderEntityModel<StriderEntity> entityModel, float f) {
        super(context, entityModel, f);
    }

    @Override
    public Identifier getTexture(StriderEntity striderEntity) {

        StriderHairInterface x = (StriderHairInterface) striderEntity;

        if(striderEntity.isCold()) {
            if(x.hasHair()) {
                switch(x.getHairStyle()) {
                    case 1:
                        return COLD_TEXTURE_HAIR_1;
                    case 2:
                        return COLD_TEXTURE_HAIR_2;
                    case 3:
                        return COLD_TEXTURE_HAIR_3;
                    case 4:
                        return COLD_TEXTURE_HAIR_4;
                    case 5:
                        return COLD_TEXTURE_HAIR_5;
                    default:
                        return COLD_TEXTURE;
                }
            } else {
                return COLD_TEXTURE_HAIRLESS;
            }
        } else {
            if(x.hasHair()) {
                switch(x.getHairStyle()) {
                    case 1:
                        return TEXTURE_HAIR_1;
                    case 2:
                        return TEXTURE_HAIR_2;
                    case 3:
                        return TEXTURE_HAIR_3;
                    case 4:
                        return TEXTURE_HAIR_4;
                    case 5:
                        return TEXTURE_HAIR_5;
                    default:
                        return TEXTURE;
                }
            } else {
                return TEXTURE_HAIRLESS;
            }
        }
    }
}
