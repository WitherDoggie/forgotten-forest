package io.github.witherdoggie.forgottenforest.item.materials.tool;

import io.github.witherdoggie.forgottenforest.registry.ItemRegistry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class OrchiumToolMaterial implements ToolMaterial {

    public static final OrchiumToolMaterial INSTANCE = new OrchiumToolMaterial();

    @Override
    public int getDurability() {
        return 1178;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7.0F;
    }

    @Override
    public float getAttackDamage() {
        return 2.5F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemRegistry.ORCHIUM_INGOT);
    }
}
