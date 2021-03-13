package io.github.witherdoggie.forgottenforest.world.surface;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class SurfaceBuilders {

    public static final SurfaceBuilder<QuadarySurfaceConfig> GLOOMY_SURFACE_BUILDER = Registry.register(Registry.SURFACE_BUILDER, new Identifier(ForgottenForest.MODID, "gloomy_surface_builder"), new GloomyBiomeSurfaceBuilder());

    public static void initSurfaceBuilders(){
        System.out.println(Registry.SURFACE_BUILDER.getKey(GLOOMY_SURFACE_BUILDER));
    }


}
