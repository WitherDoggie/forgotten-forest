package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.render.entity.*;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class EntityRenderersRegistry {

    public static void initRenderers() {

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_SPIDER, (dispatcher, context) -> new SoulSpiderEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_SKELETON, ((entityRenderDispatcher, context) -> new SoulSkeletonEntityRenderer(entityRenderDispatcher)));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_CHICKEN, ((entityRenderDispatcher, context) -> new SoulChickenEntityRenderer(entityRenderDispatcher)));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.GHOST, ((entityRenderDispatcher, context) -> new GhostEntityRenderer(entityRenderDispatcher)));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.FIRE_PIG, (((entityRenderDispatcher, context) -> new FirePigEntityRenderer(entityRenderDispatcher))));
    }
}
