package io.github.witherdoggie.forgottenforest.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class AntiPoisonEffect extends StatusEffect {

    public AntiPoisonEffect() {
        super(StatusEffectType.BENEFICIAL, 65535);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean isInstant() {
        return false;
    }
}
