package io.github.witherdoggie.forgottenforest.mixin;

import io.github.witherdoggie.forgottenforest.registry.StructureRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.LakeFeature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

/* Stop lakes from interrupting crypt generation */
@Mixin(LakeFeature.class)
public class LakeFeatureMixin {

    @Inject(
            method = "generate",
            at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/StructureWorldAccess;getStructures(Lnet/minecraft/util/math/ChunkSectionPos;Lnet/minecraft/world/gen/feature/StructureFeature;)Ljava/util/stream/Stream;"),
            cancellable = true
    )
    private void stopLakeGeneration(FeatureContext<SingleStateFeatureConfig> context, CallbackInfoReturnable<Boolean> cir) {
        ChunkSectionPos pos = ChunkSectionPos.from(context.getOrigin());
        if (context.getWorld().getStructures(pos, StructureRegistry.CRYPT).findAny().isPresent()) {
            cir.setReturnValue(false);
        }
    }
}
