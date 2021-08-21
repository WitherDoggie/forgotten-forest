package io.github.witherdoggie.forgottenforest.client.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.entity.SoulSpiderEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SoulSpiderEntityRenderer extends SpiderEntityRenderer<SoulSpiderEntity> {

    public SoulSpiderEntityRenderer(EntityRendererFactory.Context entityRenderDispatcher) {
        super(entityRenderDispatcher);
        this.shadowRadius *= 0.4F;
    }

    protected void scale(SoulSpiderEntity soulSpiderEntity, MatrixStack matrixStack, float f) {
        matrixStack.scale(0.4F, 0.4F, 0.4F);
    }

    public Identifier getTexture(SoulSpiderEntity soulSpiderEntity) {
        return new Identifier(ForgottenForest.MODID, "textures/entity/soul_spider/soul_spider.png");
    }
}
