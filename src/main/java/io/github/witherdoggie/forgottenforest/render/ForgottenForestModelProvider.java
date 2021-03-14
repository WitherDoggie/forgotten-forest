package io.github.witherdoggie.forgottenforest.render;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.render.block.FFIronOre;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class ForgottenForestModelProvider implements ModelResourceProvider {

    public static final Identifier FF_IRON_ORE_MODEL = new Identifier(ForgottenForest.MODID, "block/mod_iron_ore");

    @Override
    public @Nullable UnbakedModel loadModelResource(Identifier identifier, ModelProviderContext modelProviderContext) throws ModelProviderException {
        if(identifier.equals(FF_IRON_ORE_MODEL)) {
            return new FFIronOre();
        } else {
            return null;
        }
    }
}
