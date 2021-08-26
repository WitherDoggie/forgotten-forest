package io.github.witherdoggie.forgottenforest.client.render.block_entity;

import io.github.witherdoggie.forgottenforest.block.base.AbstractPedestalBaseBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;

public class PedestalBlockEntityRenderer<T extends AbstractPedestalBaseBlockEntity> implements BlockEntityRenderer<T> {

    public PedestalBlockEntityRenderer(BlockEntityRendererFactory.Context context){

    }

    @Override
    public void render(AbstractPedestalBaseBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemStack stack = blockEntity.getHeldItemStack();
        matrices.push();
        double offset = Math.sin((blockEntity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
        matrices.translate(0.5, 1.25 + offset, 0.5);

        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((blockEntity.getWorld().getTime() + tickDelta) * 4));
        int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, lightAbove, overlay, matrices, vertexConsumers, 0);
        matrices.pop();
    }
}
