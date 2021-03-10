package io.github.witherdoggie.forgottenforest.mixin;

import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Feature.class)
public class FeatureMixin {

    @Inject(method = "isSoil(Lnet/minecraft/block/Block;)Z", at = @At("HEAD"), cancellable = true)
    private static void isSoil(Block block, CallbackInfoReturnable cir) {
        if (block == BlockRegistry.GLOOMY_GRASS_BLOCK || block == BlockRegistry.GLOOMY_DIRT) {
            cir.setReturnValue(true);
        }
    }
}
