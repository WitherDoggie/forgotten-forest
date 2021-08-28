package io.github.witherdoggie.forgottenforest.util.pattern;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;

public class BindingRitualPattern extends PedestalPattern {

    protected EntityType<?> entityType;

    public BindingRitualPattern(int numberOfPedestals, EntityType<?> entityType, ItemStack... itemStacks) {
        super(numberOfPedestals, itemStacks);
        this.entityType = entityType;
    }

    public EntityType<?> getEntityType(){
        return this.entityType;
    }
}
