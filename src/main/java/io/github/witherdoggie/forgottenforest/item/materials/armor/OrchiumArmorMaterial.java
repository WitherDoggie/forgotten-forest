package io.github.witherdoggie.forgottenforest.item.materials.armor;

import io.github.witherdoggie.forgottenforest.registry.ItemRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class OrchiumArmorMaterial implements ArmorMaterial {

    public static final OrchiumArmorMaterial INSTANCE = new OrchiumArmorMaterial();

    private static final int [] BASE_DURABILITY = new int [] {13, 15, 16, 11};
    private static final int [] BASE_PROTECTION = new int [] {3, 5, 6, 3};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 25;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return BASE_PROTECTION[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemRegistry.ORCHIUM_INGOT);
    }

    @Override
    public String getName() {
        return "orchium";
    }

    @Override
    public float getToughness() {
        return 3.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.8F;
    }
}
