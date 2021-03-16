package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.entity.SoulChickenEntity;
import io.github.witherdoggie.forgottenforest.entity.SoulSkeletonEntity;
import io.github.witherdoggie.forgottenforest.entity.SoulSpiderEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {

    public static EntityType<SoulSpiderEntity> SOUL_SPIDER = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulSpiderEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build();
    public static EntityType<SoulSkeletonEntity> SOUL_SKELETON = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulSkeletonEntity::new).dimensions(EntityDimensions.fixed(0.7f, 2.4f)).build();
    public static EntityType<SoulChickenEntity> SOUL_CHICKEN = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulChickenEntity::new).dimensions(EntityDimensions.fixed(0.7f, 0.5f)).build();

    public static void initEntities() {

        Registry.register(Registry.ENTITY_TYPE, new Identifier(ForgottenForest.MODID, "soul_spider"), SOUL_SPIDER);
        FabricDefaultAttributeRegistry.register(SOUL_SPIDER, SoulSpiderEntity.createSoulSpiderAttributes());

        Registry.register(Registry.ENTITY_TYPE, new Identifier(ForgottenForest.MODID, "soul_skeleton"), SOUL_SKELETON);
        FabricDefaultAttributeRegistry.register(SOUL_SKELETON, SoulSkeletonEntity.createSoulSkeletonAttributes());

        Registry.register(Registry.ENTITY_TYPE, new Identifier(ForgottenForest.MODID, "soul_chicken"), SOUL_CHICKEN);
        FabricDefaultAttributeRegistry.register(SOUL_CHICKEN, SoulChickenEntity.createSoulChickenAttributes());
    }
}
