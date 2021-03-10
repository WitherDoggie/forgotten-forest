package io.github.witherdoggie.forgottenforest.mixin;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BrewingRecipeRegistry.class)
public interface BrewingRecipeRegistryAccessor {

    @Invoker("registerPotionRecipe")
    public static void getPotionRegistry(Potion input, Item item, Potion output) {
        throw new AssertionError();
    }
}
