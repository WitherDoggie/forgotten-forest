package io.github.witherdoggie.forgottenforest.world.dimension;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class MidnightDimension {

    public static final RegistryKey<World> MIDNIGHT_WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, new Identifier(ForgottenForest.MODID, "midnight"));
    public static final RegistryKey<DimensionType> TYPE = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier(ForgottenForest.MODID, "midnight_default"));

}
