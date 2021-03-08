package io.github.witherdoggie.forgottenforest.client;

import io.github.witherdoggie.forgottenforest.registry.EntityRenderersRegistry;
import io.github.witherdoggie.forgottenforest.render.BlockRenderLayerUtil;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ForgottenForestClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerUtil.initRenderFixes();
        EntityRenderersRegistry.initRenderers();
    }
}
