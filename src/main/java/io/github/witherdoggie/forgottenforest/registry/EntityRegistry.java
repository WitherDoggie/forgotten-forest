package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.entity.SoulSpiderEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {

    public static EntityType<SoulSpiderEntity> SOUL_SPIDER = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SoulSpiderEntity:: new).dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build();

    public static void initEntities(){

        Registry.register(Registry.ENTITY_TYPE, new Identifier(ForgottenForest.MODID, "soul_spider"), SOUL_SPIDER);
        FabricDefaultAttributeRegistry.register(SOUL_SPIDER, SoulSpiderEntity.createSoulSpiderAttributes());
    }
}
