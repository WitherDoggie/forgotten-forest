package io.github.witherdoggie.forgottenforest.mixin;

import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlockStateMixin {

    @Inject(method = "onEntityCollision", at = @At("TAIL"))
    private void burnPlayer(World world, BlockPos pos, Entity entity, CallbackInfo ci){
        if(entity instanceof PlayerEntity && world.getBlockState(pos).getBlock() == BlockRegistry.FIRE_GRASS){
            entity.setOnFireFor(2);
        }

       /* if(entity instanceof LivingEntity && world.getBlockState(pos).getBlock() == BlockRegistry.POISON_WATER){
            ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1));
        }*/
    }
}
