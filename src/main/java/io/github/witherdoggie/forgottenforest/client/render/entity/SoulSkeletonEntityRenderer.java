package io.github.witherdoggie.forgottenforest.client.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.WitherSkeletonEntityRenderer;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

public class SoulSkeletonEntityRenderer extends WitherSkeletonEntityRenderer {

    public SoulSkeletonEntityRenderer(EntityRendererFactory.Context entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(AbstractSkeletonEntity abstractSkeletonEntity) {
        return new Identifier(ForgottenForest.MODID, "textures/entity/soul_skeleton/soul_skeleton.png");
    }
}
