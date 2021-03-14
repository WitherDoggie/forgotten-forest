package io.github.witherdoggie.forgottenforest.render.block;

import com.mojang.datafixers.util.Pair;
import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.registry.BiomeRegistry;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.*;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class FFRedstoneOre implements BakedModel, UnbakedModel, FabricBakedModel {

    private Mesh [] meshes = new Mesh[2];
    private Mesh mesh_gloomy = meshes[0];
    private Mesh mesh_arkian = meshes[1];
    private int inBiome = 0;
    private ModelTransformation transformation;
    private static final Identifier DEFAULT_BLOCK_MODEL = new Identifier("minecraft:block/block");

    private static final SpriteIdentifier[] SPRITE_IDENTIFIERS = new SpriteIdentifier[] {
            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(ForgottenForest.MODID, "block/mod_redstone_ore_gloomy")),
            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("minecraft:block/redstone_ore"))
    };
    private Sprite[] SPRITES = new Sprite[2];

    @Override
    public boolean isVanillaAdapter() {
        return false;
    }

    @Override
    public void emitBlockQuads(BlockRenderView blockRenderView, BlockState blockState, BlockPos blockPos, Supplier<Random> supplier, RenderContext renderContext) {

        QuadEmitter emitter = renderContext.getEmitter();
        Biome biome = MinecraftClient.getInstance().world.getBiome(blockPos);
        World world = MinecraftClient.getInstance().world;

        if(BiomeRegistry.biomeMatches(world, biome, BiomeRegistry.GLOOMY_FOREST_KEY)){
            inBiome = 0;
        }
        else {
            inBiome = 1;
        }

        emitter.spriteBake(0, SPRITES[inBiome], MutableQuadView.BAKE_LOCK_UV);
        renderContext.meshConsumer().accept(meshes[inBiome]);
    }

    @Override
    public void emitItemQuads(ItemStack itemStack, Supplier<Random> supplier, RenderContext renderContext) {
        renderContext.meshConsumer().accept(meshes[inBiome]);
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
        return null;
    }

    @Override
    public boolean useAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean hasDepth() {
        return false;
    }

    @Override
    public boolean isSideLit() {
        return false;
    }

    @Override
    public boolean isBuiltin() {
        return false;
    }

    @Override
    public Sprite getSprite() {
        return SPRITES[0];
    }

    @Override
    public ModelTransformation getTransformation() {
        return transformation;
    }

    @Override
    public ModelOverrideList getOverrides() {
        return ModelOverrideList.EMPTY;
    }

    @Override
    public Collection<Identifier> getModelDependencies() {
        return Arrays.asList(DEFAULT_BLOCK_MODEL);
    }

    @Override
    public Collection<SpriteIdentifier> getTextureDependencies(Function<Identifier, UnbakedModel> unbakedModelGetter, Set<Pair<String, String>> unresolvedTextureReferences) {
        return Arrays.asList(SPRITE_IDENTIFIERS);
    }

    @Nullable
    @Override
    public BakedModel bake(ModelLoader loader, Function<SpriteIdentifier, Sprite> textureGetter, ModelBakeSettings rotationContainer, Identifier modelId) {

        for(int i = 0; i < 2; i++) {
            SPRITES[i] = textureGetter.apply(SPRITE_IDENTIFIERS[i]);
        }

        JsonUnbakedModel defaultBlockModel = (JsonUnbakedModel) loader.getOrLoadModel(DEFAULT_BLOCK_MODEL);
        transformation = defaultBlockModel.getTransformations();

        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderer.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        int count = 0;
        for(Mesh mesh : meshes){
            for(Direction direction : Direction.values()) {
                emitter.square(direction, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f);
                emitter.spriteBake(0, SPRITES[count], MutableQuadView.BAKE_LOCK_UV);
                emitter.spriteColor(0, -1, -1, -1, -1);
                emitter.emit();
            }
            mesh = builder.build();
            meshes[count] = mesh;
            count++;
        }
        return this;
    }
}

