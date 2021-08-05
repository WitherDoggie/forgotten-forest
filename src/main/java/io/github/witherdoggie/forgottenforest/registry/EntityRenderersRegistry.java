package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.render.entity.*;
import io.github.witherdoggie.forgottenforest.render.entity.model.GhostEntityModel;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class EntityRenderersRegistry {

    public static final EntityModelLayer MODEL_GHOST_LAYER = new EntityModelLayer(ForgottenForest.id("ghost"), "main");

    public static void initRenderers() {

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_SPIDER, (context) -> new SoulSpiderEntityRenderer(context));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_SKELETON, (context) -> new SoulSkeletonEntityRenderer(context));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_CHICKEN, (context) -> new SoulChickenEntityRenderer(context));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.GHOST, (context) -> new GhostEntityRenderer(context));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.FIRE_PIG, (( context) -> new FirePigEntityRenderer(context)));

        EntityModelLayerRegistry.registerModelLayer(MODEL_GHOST_LAYER, GhostEntityModel::getTexturedModelData);
    }
}
