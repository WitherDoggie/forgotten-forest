package io.github.witherdoggie.forgottenforest.mixin;

import io.github.witherdoggie.forgottenforest.registry.StatusEffectRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StatusEffect.class)
public class StatusEffectMixin {

    @Redirect(method = "applyUpdateEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
    private boolean checkForAntiPoison(LivingEntity entity1, DamageSource source, float amount, LivingEntity entity, int amplifier){

        if(!entity.hasStatusEffect(StatusEffectRegistry.ANTI_POISON_EFFECT)){
            entity.damage(DamageSource.MAGIC, 1.0F);
            return true;
        }
        else {
            return false;
        }
    }
}
