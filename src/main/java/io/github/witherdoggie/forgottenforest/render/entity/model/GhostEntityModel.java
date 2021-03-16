package io.github.witherdoggie.forgottenforest.render.entity.model;

import io.github.witherdoggie.forgottenforest.entity.GhostEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class GhostEntityModel extends EntityModel<GhostEntity> {
    private final ModelPart bone;

    public GhostEntityModel() {
        textureWidth = 64;
        textureHeight = 32;
        bone = new ModelPart(this);
        bone.setPivot(0.0F, 24.0F, 0.0F);
        bone.setTextureOffset(0, 0).addCuboid(-6.0F, -17.0F, -2.0F, 11.0F, 17.0F, 5.0F, 0.0F, false);

    }

    @Override
    public void setAngles(GhostEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }

}
