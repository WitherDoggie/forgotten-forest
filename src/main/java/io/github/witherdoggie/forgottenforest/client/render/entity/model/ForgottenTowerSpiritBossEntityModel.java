package io.github.witherdoggie.forgottenforest.client.render.entity.model;

import io.github.witherdoggie.forgottenforest.entity.boss.ForgottenTowerSpiritBossEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ForgottenTowerSpiritBossEntityModel extends SinglePartEntityModel<ForgottenTowerSpiritBossEntity> {

    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart lArm;
    private final ModelPart rArm;

    public ForgottenTowerSpiritBossEntityModel(ModelPart root){
        this.root = root;
        this.head = root.getChild(EntityModelPartNames.HEAD);
        this.body = root.getChild(EntityModelPartNames.BODY);
        this.lArm = root.getChild(EntityModelPartNames.LEFT_ARM);
        this.rArm = root.getChild(EntityModelPartNames.RIGHT_ARM);
    }

    public static TexturedModelData getTexturedModelData(){

        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0,0).cuboid(-4.0F, -6.0F, -2.0F, 7.0F, 9.0F, 5.0F), ModelTransform.pivot(0F, 0F, 0F));
        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(41,0).cuboid(-3.0F, -10.0F, -2.0F, 5.0F, 4.0F, 5.0F), ModelTransform.pivot(0F, 0F, 0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(0,22).cuboid(-6.0F, -6.0F, -1.0F, 2.0F, 6.0F, 3.0F), ModelTransform.pivot(0F, 0F, 0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(10,22).mirrored().cuboid(3.0F, -6.0F, -1.0F, 2.0F, 6.0F, 3.0F), ModelTransform.pivot(0F, 0F, 0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        matrixStack.scale(4.0F, 4.0F, 4.0F);
        matrixStack.translate(0.0F, 0.2F, 0.0F);
        root.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public void setAngles(ForgottenTowerSpiritBossEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.yaw = headYaw * 0.017453292F;
    }
}
