package io.github.witherdoggie.forgottenforest.item.materials;

import io.github.witherdoggie.forgottenforest.registry.ItemRegistry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FireiteToolMaterial implements ToolMaterial {

    public static final FireiteToolMaterial INSTANCE = new FireiteToolMaterial();

    @Override
    public int getDurability() {
        return 2018;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.0F;
    }

    @Override
    public float getAttackDamage() {
        return 4.0F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemRegistry.FIREITE_GEM);
    }
}
