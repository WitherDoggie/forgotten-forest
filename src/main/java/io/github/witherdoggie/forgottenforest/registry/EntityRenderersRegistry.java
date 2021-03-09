package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.render.entity.SoulChickenEntityRenderer;
import io.github.witherdoggie.forgottenforest.render.entity.SoulSkeletonEntityRenderer;
import io.github.witherdoggie.forgottenforest.render.entity.SoulSpiderEntityRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class EntityRenderersRegistry {

    public static void initRenderers(){

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_SPIDER, (dispatcher, context) -> new SoulSpiderEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_SKELETON, ((entityRenderDispatcher, context) -> new SoulSkeletonEntityRenderer(entityRenderDispatcher)));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_CHICKEN, ((entityRenderDispatcher, context) -> new SoulChickenEntityRenderer(entityRenderDispatcher)));

    }
}
