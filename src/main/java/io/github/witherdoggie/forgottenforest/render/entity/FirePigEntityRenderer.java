package io.github.witherdoggie.forgottenforest.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.entity.FirePigEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class FirePigEntityRenderer extends MobEntityRenderer<FirePigEntity, PigEntityModel<FirePigEntity>> {

    public FirePigEntityRenderer(EntityRendererFactory.Context entityRenderDispatcher) {
        super(entityRenderDispatcher, new PigEntityModel(entityRenderDispatcher.getPart(EntityModelLayers.PIG)), 0.7F);
    }

    protected int getBlockLight(FirePigEntity entity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public Identifier getTexture(FirePigEntity pigEntity) {
        return new Identifier(ForgottenForest.MODID, "textures/entity/fire_pig/fire_pig.png");
    }

}
