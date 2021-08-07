package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.entity.*;
import io.github.witherdoggie.forgottenforest.entity.projectile.EggOfLifeEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;

public class EntityRegistry {

    public static EntityType<SoulSpiderEntity> SOUL_SPIDER = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulSpiderEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build();
    public static EntityType<SoulSkeletonEntity> SOUL_SKELETON = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulSkeletonEntity::new).dimensions(EntityDimensions.fixed(0.7f, 2.4f)).build();
    public static EntityType<SoulChickenEntity> SOUL_CHICKEN = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulChickenEntity::new).dimensions(EntityDimensions.fixed(0.7f, 0.5f)).build();
    public static EntityType<GhostEntity> GHOST = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GhostEntity::new).dimensions(EntityDimensions.fixed(0.7f, 1.7f)).build();
    public static EntityType<FirePigEntity> FIRE_PIG = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FirePigEntity::new).dimensions(EntityDimensions.fixed(0.9F, 0.9F)).trackRangeBlocks(10).build();
    public static EntityType<EggOfLifeEntity> EGG_OF_LIFE = FabricEntityTypeBuilder.<EggOfLifeEntity>create(SpawnGroup.MISC, EggOfLifeEntity::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10).build();

    public static void initEntities() {

        Registry.register(Registry.ENTITY_TYPE, new Identifier(ForgottenForest.MODID, "soul_spider"), SOUL_SPIDER);
        FabricDefaultAttributeRegistry.register(SOUL_SPIDER, SoulSpiderEntity.createSoulSpiderAttributes());

        Registry.register(Registry.ENTITY_TYPE, new Identifier(ForgottenForest.MODID, "soul_skeleton"), SOUL_SKELETON);
        FabricDefaultAttributeRegistry.register(SOUL_SKELETON, SoulSkeletonEntity.createSoulSkeletonAttributes());

        Registry.register(Registry.ENTITY_TYPE, new Identifier(ForgottenForest.MODID, "soul_chicken"), SOUL_CHICKEN);
        FabricDefaultAttributeRegistry.register(SOUL_CHICKEN, SoulChickenEntity.createSoulChickenAttributes());

        Registry.register(Registry.ENTITY_TYPE, new Identifier(ForgottenForest.MODID, "ghost"), GHOST);
        FabricDefaultAttributeRegistry.register(GHOST, GhostEntity.createGhostAttributes());

        Registry.register(Registry.ENTITY_TYPE, new Identifier(ForgottenForest.MODID, "fire_pig"), FIRE_PIG);
        FabricDefaultAttributeRegistry.register(FIRE_PIG, FirePigEntity.createFirePigAttributes());

        Registry.register(Registry.ENTITY_TYPE, ForgottenForest.id("egg_of_life"), EGG_OF_LIFE);

        SpawnRestrictionAccessor.callRegister(SOUL_SPIDER,  SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        SpawnRestrictionAccessor.callRegister(SOUL_SKELETON,  SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        SpawnRestrictionAccessor.callRegister(SOUL_CHICKEN,  SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
        SpawnRestrictionAccessor.callRegister(FIRE_PIG,  SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> true);
    }
}
