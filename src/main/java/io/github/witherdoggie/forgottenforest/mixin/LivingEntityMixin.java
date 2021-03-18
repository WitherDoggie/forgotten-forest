package io.github.witherdoggie.forgottenforest.mixin;

import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "baseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;tickStatusEffects()V"))
    private void addPoisonWater(CallbackInfo ci){

        if(this.isInPoisonWater(((LivingEntity) (Object)this))){
            ((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1));
        }
    }

    public boolean isInPoisonWater(LivingEntity entity) {
        return !((EntityAccessor)entity).getFirstUpdate() && ((EntityAccessor)entity).getFluidHeight().getDouble(BlockRegistry.POISON_WATER_TAG) > 0.0D;
    }
}
