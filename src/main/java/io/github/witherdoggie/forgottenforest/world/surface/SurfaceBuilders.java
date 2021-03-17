package io.github.witherdoggie.forgottenforest.world.surface;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class SurfaceBuilders {

    public static final SurfaceBuilder<QuadarySurfaceConfig> GLOOMY_SURFACE_BUILDER = Registry.register(Registry.SURFACE_BUILDER, new Identifier(ForgottenForest.MODID, "gloomy_surface_builder"), new ModBiomeSurfaceBuilder());
    public static final SurfaceBuilder<QuadarySurfaceConfig> FIRE_SURFACE_BUILDER = Registry.register(Registry.SURFACE_BUILDER, new Identifier(ForgottenForest.MODID, "fire_surface_builder"), new ModBiomeSurfaceBuilder());
    public static final SurfaceBuilder<QuinteroSurfaceConfig> FIRE_PITS_SURFACE_BUILDER = Registry.register(Registry.SURFACE_BUILDER, new Identifier(ForgottenForest.MODID, "fire_pits_surface_builder"), new ModBiomeSurfaceBuilderFluid());

    public static void initSurfaceBuilders(){
    }
}
