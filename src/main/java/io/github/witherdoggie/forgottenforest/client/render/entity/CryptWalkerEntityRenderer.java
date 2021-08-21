package io.github.witherdoggie.forgottenforest.client.render.entity;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.entity.CryptWalkerEntity;
import io.github.witherdoggie.forgottenforest.client.render.entity.model.CryptWalkerEntityModel;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class CryptWalkerEntityRenderer extends BipedEntityRenderer<CryptWalkerEntity, CryptWalkerEntityModel<CryptWalkerEntity>> {

    public CryptWalkerEntityRenderer(EntityRendererFactory.Context context, CryptWalkerEntityModel entityModel, float f) {
        super(context, entityModel, f);
    }

    @Override
    public Identifier getTexture(CryptWalkerEntity entity) {
        return ForgottenForest.id("textures/entity/cryptwalker/crypt_walker.png");
    }
}
