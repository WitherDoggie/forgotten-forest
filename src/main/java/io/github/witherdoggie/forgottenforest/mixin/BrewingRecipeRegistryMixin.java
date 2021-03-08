package io.github.witherdoggie.forgottenforest.mixin;

import io.github.witherdoggie.forgottenforest.registry.ItemRegistry;
import io.github.witherdoggie.forgottenforest.registry.PotionRegistry;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {

    @Inject(method = "registerDefaults", at = @At("TAIL"))
    private static void addPotionRecipes(CallbackInfo ci){

        BrewingRecipeRegistryAccessor.getPotionRegistry(Potions.AWKWARD, ItemRegistry.SOULLESS_SOUL, PotionRegistry.SOUL_SERUM);
    }
}
