package io.github.witherdoggie.forgottenforest.client.render.entity.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.HostileEntity;

public class CryptWalkerEntityModel <T extends HostileEntity> extends BipedEntityModel<T> {

    public CryptWalkerEntityModel(ModelPart root) {
        super(root);
    }
}
