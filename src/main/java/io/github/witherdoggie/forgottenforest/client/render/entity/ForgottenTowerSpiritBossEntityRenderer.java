package io.github.witherdoggie.forgottenforest.client.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.entity.boss.ForgottenTowerSpiritBossEntity;
import io.github.witherdoggie.forgottenforest.registry.EntityRenderersRegistry;
import io.github.witherdoggie.forgottenforest.client.render.entity.model.ForgottenTowerSpiritBossEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ForgottenTowerSpiritBossEntityRenderer extends MobEntityRenderer<ForgottenTowerSpiritBossEntity, ForgottenTowerSpiritBossEntityModel> {

    public ForgottenTowerSpiritBossEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ForgottenTowerSpiritBossEntityModel(context.getPart(EntityRenderersRegistry.MODEL_TOWER_SPIRIT_LAYER)), 0.4f);
    }

    @Override
    public Identifier getTexture(ForgottenTowerSpiritBossEntity entity) {
        return new Identifier(ForgottenForest.MODID, "textures/entity/forgotten_spirit/forgotten_spirit.png");
    }
}
