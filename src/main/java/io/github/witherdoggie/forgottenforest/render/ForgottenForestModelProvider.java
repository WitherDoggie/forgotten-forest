package io.github.witherdoggie.forgottenforest.render;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.render.block.FFGoldOre;
import io.github.witherdoggie.forgottenforest.render.block.FFIronOre;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class ForgottenForestModelProvider implements ModelResourceProvider {

    public static final FFIronOre FF_IRON_ORE_MODEL = new FFIronOre();
    public static final Identifier FF_IRON_ORE_MODEL_BLOCK = new Identifier(ForgottenForest.MODID, "block/mod_iron_ore");
    public static final Identifier FF_IRON_ORE_MODEL_ITEM = new Identifier(ForgottenForest.MODID, "item/mod_iron_ore");

    public static final FFGoldOre FF_GOLD_ORE_MODEL = new FFGoldOre();
    public static final Identifier FF_GOLD_ORE_MODEL_BLOCK = new Identifier(ForgottenForest.MODID, "block/mod_gold_ore");
    public static final Identifier FF_GOLD_ORE_MODEL_ITEM = new Identifier(ForgottenForest.MODID, "item/mod_gold_ore");

    public static final FFGoldOre FF_COAL_ORE_MODEL = new FFGoldOre();
    public static final Identifier FF_COAL_ORE_MODEL_BLOCK = new Identifier(ForgottenForest.MODID, "block/mod_coal_ore");
    public static final Identifier FF_COAL_ORE_MODEL_ITEM = new Identifier(ForgottenForest.MODID, "item/mod_coal_ore");

    public static final FFGoldOre FF_LAPIS_ORE_MODEL = new FFGoldOre();
    public static final Identifier FF_LAPIS_ORE_MODEL_BLOCK = new Identifier(ForgottenForest.MODID, "block/mod_lapis_ore");
    public static final Identifier FF_LAPIS_ORE_MODEL_ITEM = new Identifier(ForgottenForest.MODID, "item/mod_lapis_ore");

    public static final FFGoldOre FF_DIAMOND_ORE_MODEL = new FFGoldOre();
    public static final Identifier FF_DIAMOND_ORE_MODEL_BLOCK = new Identifier(ForgottenForest.MODID, "block/mod_diamond_ore");
    public static final Identifier FF_DIAMOND_ORE_MODEL_ITEM = new Identifier(ForgottenForest.MODID, "item/mod_diamond_ore");

    public static final FFGoldOre FF_REDSTONE_ORE_MODEL = new FFGoldOre();
    public static final Identifier FF_REDSTONE_ORE_MODEL_BLOCK = new Identifier(ForgottenForest.MODID, "block/mod_redstone_ore");
    public static final Identifier FF_REDSTONE_ORE_MODEL_ITEM = new Identifier(ForgottenForest.MODID, "item/mod_redstone_ore");

    @Override
    public @Nullable UnbakedModel loadModelResource(Identifier identifier, ModelProviderContext modelProviderContext) throws ModelProviderException {
        if(identifier.equals(FF_IRON_ORE_MODEL_BLOCK) || identifier.equals(FF_IRON_ORE_MODEL_ITEM)) {
            return FF_IRON_ORE_MODEL;
        }
        else if(identifier.equals(FF_GOLD_ORE_MODEL_BLOCK) || identifier.equals(FF_GOLD_ORE_MODEL_ITEM)){
            return FF_GOLD_ORE_MODEL;
        }
        else if(identifier.equals(FF_COAL_ORE_MODEL_BLOCK) || identifier.equals(FF_COAL_ORE_MODEL_ITEM)){
            return FF_COAL_ORE_MODEL;
        }
        else if(identifier.equals(FF_LAPIS_ORE_MODEL_BLOCK) || identifier.equals(FF_LAPIS_ORE_MODEL_ITEM)){
            return FF_LAPIS_ORE_MODEL;
        }
        else if(identifier.equals(FF_DIAMOND_ORE_MODEL_BLOCK) || identifier.equals(FF_DIAMOND_ORE_MODEL_ITEM)){
            return FF_DIAMOND_ORE_MODEL;
        }
        else if(identifier.equals(FF_REDSTONE_ORE_MODEL_BLOCK) || identifier.equals(FF_REDSTONE_ORE_MODEL_ITEM)){
            return FF_REDSTONE_ORE_MODEL;
        }
        else {
            return null;
        }
    }
}
