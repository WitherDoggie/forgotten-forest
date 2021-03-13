package io.github.witherdoggie.forgottenforest.mixin;

import net.minecraft.block.Block;
import net.minecraft.world.gen.carver.Carver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(Carver.class)
public interface CarverInvoker {

    @Accessor("alwaysCarvableBlocks")
    Set<Block> getCarvableBlocks();

    @Accessor("alwaysCarvableBlocks")
    void setCarvableBlocks(Set<Block> blocks);
}
