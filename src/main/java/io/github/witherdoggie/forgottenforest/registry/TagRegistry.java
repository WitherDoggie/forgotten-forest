package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.tag.Tag;

public class TagRegistry {

    public static final Tag<EntityType<?>> LIFE_EGG_ENTITIES = net.fabricmc.fabric.api.tag.TagRegistry.entityType(ForgottenForest.id("life_egg_entities"));
    public static final Tag<Block> TRANSMUTABLE_BLOCKS = net.fabricmc.fabric.api.tag.TagRegistry.block(ForgottenForest.id("transmutable_blocks"));
}
