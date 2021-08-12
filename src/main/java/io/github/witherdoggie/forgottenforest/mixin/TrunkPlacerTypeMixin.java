package io.github.witherdoggie.forgottenforest.mixin;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TrunkPlacerType.class)
public interface TrunkPlacerTypeMixin {

    @Invoker("register")
    public static <P extends TrunkPlacer> TrunkPlacerType<P> callRegister(String id, Codec<ForkingTrunkPlacer> codec) {
        throw new IllegalStateException();
    }
}

