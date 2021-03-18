package io.github.witherdoggie.forgottenforest.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.PigEntityRenderer;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Identifier;

public class FirePigEntityRenderer extends PigEntityRenderer {

    public FirePigEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(PigEntity pigEntity) {
        return new Identifier(ForgottenForest.MODID, "textures/entity/fire_pig/fire_pig.png");
    }
}
