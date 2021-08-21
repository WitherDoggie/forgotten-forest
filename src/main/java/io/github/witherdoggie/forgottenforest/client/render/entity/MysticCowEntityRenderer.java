package io.github.witherdoggie.forgottenforest.client.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.client.render.feature.EnchantedCowFeatureRenderer;
import io.github.witherdoggie.forgottenforest.entity.MysticCowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class MysticCowEntityRenderer extends MobEntityRenderer<MysticCowEntity, CowEntityModel<MysticCowEntity>> {

    public MysticCowEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CowEntityModel(context.getPart(EntityModelLayers.COW)), 0.7F);
        this.addFeature(new EnchantedCowFeatureRenderer(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(MysticCowEntity entity) {
        return ForgottenForest.id("textures/entity/mystic_cow/mystic_cow.png");
    }
}
