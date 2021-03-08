package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PotionRegistry {

    public static final Potion SOUL_SERUM = new Potion((new StatusEffectInstance[]{new StatusEffectInstance(StatusEffectRegistry.SOUL_SERUM, 3600)}));

    public static void initPotions(){

        Registry.register(Registry.POTION, new Identifier(ForgottenForest.MODID, "soul_serum"), SOUL_SERUM);
    }
}
