package io.github.witherdoggie.forgottenforest.client.render.feature;

import io.github.witherdoggie.forgottenforest.registry.EntityRenderersRegistry;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.Identifier;

public class EnchantedCowFeatureRenderer<T extends CowEntity & SkinOverlayOwner> extends GlintOverlayFeatureRenderer<T, CowEntityModel<T>> {

    private final CowEntityModel<T> model;

    public EnchantedCowFeatureRenderer(FeatureRendererContext<T, CowEntityModel<T>> context, EntityModelLoader loader) {
        super(context);
        this.model = new CowEntityModel(loader.getModelPart(EntityRenderersRegistry.ENTITY_GLINT));
    }

    @Override
    protected float getEnergySwirlX(float partialAge) {
        return 0;
    }

    @Override
    protected Identifier getEnergySwirlTexture() {
        return new Identifier("textures/misc/enchanted_item_glint.png");
    }

    @Override
    protected EntityModel<T> getEnergySwirlModel() {
        return this.model;
    }
}
