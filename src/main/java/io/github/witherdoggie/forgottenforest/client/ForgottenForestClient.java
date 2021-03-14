package io.github.witherdoggie.forgottenforest.client;

import io.github.witherdoggie.forgottenforest.registry.EntityRenderersRegistry;
import io.github.witherdoggie.forgottenforest.render.BlockRenderLayerUtil;
import io.github.witherdoggie.forgottenforest.render.ForgottenForestModelProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;

@Environment(EnvType.CLIENT)
public class ForgottenForestClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new ForgottenForestModelProvider());
        BlockRenderLayerUtil.initRenderFixes();
        EntityRenderersRegistry.initRenderers();
    }
}
