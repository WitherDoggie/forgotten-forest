package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.effects.AntiPoisonEffect;
import io.github.witherdoggie.forgottenforest.effects.SoulSerumEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class StatusEffectRegistry {

    public static final SoulSerumEffect SOUL_SERUM = new SoulSerumEffect();
    public static final AntiPoisonEffect ANTI_POISON_EFFECT = new AntiPoisonEffect();

    public static void initEffects() {

        Registry.register(Registry.STATUS_EFFECT, new Identifier(ForgottenForest.MODID, "soul_serum"), SOUL_SERUM);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(ForgottenForest.MODID, "anti_poison"), ANTI_POISON_EFFECT);
    }
}
