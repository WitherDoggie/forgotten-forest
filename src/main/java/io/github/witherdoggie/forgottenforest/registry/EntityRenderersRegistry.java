package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.client.render.entity.*;
import io.github.witherdoggie.forgottenforest.client.render.entity.model.ForgottenTowerSpiritBossEntityModel;
import io.github.witherdoggie.forgottenforest.client.render.entity.model.GhostEntityModel;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class EntityRenderersRegistry {

    public static final EntityModelLayer MODEL_GHOST_LAYER = new EntityModelLayer(ForgottenForest.id("ghost"), "main");
    public static final EntityModelLayer MODEL_TOWER_SPIRIT_LAYER = new EntityModelLayer(ForgottenForest.id("forgotten_tower_spirit"), "main");
    public static final EntityModelLayer ENTITY_GLINT = new EntityModelLayer(ForgottenForest.id("misc/entity_glint"), "main");

    public static void initRenderers() {

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_SPIDER, (context) -> new SoulSpiderEntityRenderer(context));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_SKELETON, (context) -> new SoulSkeletonEntityRenderer(context));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SOUL_CHICKEN, (context) -> new SoulChickenEntityRenderer(context));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.GHOST, (context) -> new GhostEntityRenderer(context));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.FIRE_PIG, (( context) -> new FirePigEntityRenderer(context)));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.EGG_OF_LIFE, (context) -> new FlyingItemEntityRenderer<>(context));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.FORGOTTEN_TOWER_SPIRIT, (context) -> new ForgottenTowerSpiritBossEntityRenderer(context));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.MYSTIC_COW, (context) -> new MysticCowEntityRenderer(context));

        EntityModelLayerRegistry.registerModelLayer(MODEL_GHOST_LAYER, GhostEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_TOWER_SPIRIT_LAYER, ForgottenTowerSpiritBossEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ENTITY_GLINT, CowEntityModel::getTexturedModelData);
    }
}
