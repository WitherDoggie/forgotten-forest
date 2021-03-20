package io.github.witherdoggie.forgottenforest.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.entity.FirePigEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.PigEntityRenderer;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;

public class FirePigEntityRenderer extends MobEntityRenderer<FirePigEntity, PigEntityModel<FirePigEntity>> {

    public FirePigEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new PigEntityModel(), 0.7F);
    }

    protected int getBlockLight(FirePigEntity entity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public Identifier getTexture(FirePigEntity pigEntity) {
        return new Identifier(ForgottenForest.MODID, "textures/entity/fire_pig/fire_pig.png");
    }

}
