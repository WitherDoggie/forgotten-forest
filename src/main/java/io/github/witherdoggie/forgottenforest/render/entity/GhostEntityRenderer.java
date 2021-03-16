package io.github.witherdoggie.forgottenforest.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.entity.GhostEntity;
import io.github.witherdoggie.forgottenforest.render.entity.model.GhostEntityModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GhostEntityRenderer extends MobEntityRenderer<GhostEntity, GhostEntityModel> {

    public GhostEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new GhostEntityModel(), 0.1f);
    }

    @Override
    public Identifier getTexture(GhostEntity entity) {
        return new Identifier(ForgottenForest.MODID, "textures/entity/ghost/ghost.png");
    }
}
