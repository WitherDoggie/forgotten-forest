package io.github.witherdoggie.forgottenforest.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class SoulSerumEffect extends StatusEffect {

    public SoulSerumEffect() {
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
