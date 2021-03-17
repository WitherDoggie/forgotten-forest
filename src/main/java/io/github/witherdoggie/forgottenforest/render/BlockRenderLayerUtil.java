package io.github.witherdoggie.forgottenforest.render;

import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BlockRenderLayerUtil {

    public static void initRenderFixes() {

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.GLOOMY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.GLOOMY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.FIRE_GRASS, RenderLayer.getCutout());
    }
}
