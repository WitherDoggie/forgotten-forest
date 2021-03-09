package io.github.witherdoggie.forgottenforest.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.client.render.entity.ChickenEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.Identifier;

public class SoulChickenEntityRenderer extends ChickenEntityRenderer {

    public SoulChickenEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    protected void scale(ChickenEntity chickenEntity, MatrixStack matrixStack, float f) {
        matrixStack.scale(0.6F, 0.6F, 0.6F);
    }

    @Override
    public Identifier getTexture(ChickenEntity chickenEntity) {
        return new Identifier(ForgottenForest.MODID, "textures/entity/soul_chicken/soul_chicken.png");
    }
}
