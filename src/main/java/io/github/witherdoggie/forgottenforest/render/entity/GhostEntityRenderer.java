package io.github.witherdoggie.forgottenforest.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.entity.GhostEntity;
import io.github.witherdoggie.forgottenforest.registry.EntityRenderersRegistry;
import io.github.witherdoggie.forgottenforest.render.entity.model.GhostEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GhostEntityRenderer extends MobEntityRenderer<GhostEntity, GhostEntityModel> {

    public GhostEntityRenderer(EntityRendererFactory.Context entityRenderDispatcher) {
        super(entityRenderDispatcher, new GhostEntityModel(entityRenderDispatcher.getPart(EntityRenderersRegistry.MODEL_GHOST_LAYER)), 0.1f);
    }

    @Override
    public Identifier getTexture(GhostEntity entity) {
        return new Identifier(ForgottenForest.MODID, "textures/entity/ghost/ghost.png");
    }
}
