package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.render.entity.SoulSpiderEntityRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class EntityRenderersRegistry {

    public static void initRenderers(){

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_SPIDER, (dispatcher, context) -> {
            return new SoulSpiderEntityRenderer(dispatcher);
        });
    }
}
