package io.github.witherdoggie.forgottenforest.world.processor;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import io.github.witherdoggie.forgottenforest.registry.BiomeRegistry;
import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import io.github.witherdoggie.forgottenforest.registry.ProcessorRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Property;
import net.minecraft.structure.Structure;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/************************************************************************************
 *
 * Processor to allow for blocks in nbt files to be replaced with blocks that match
 * the biome
 *
 ************************************************************************************/

public class RuinsVariableBlockProcessor extends StructureProcessor {

    public static final Codec<RuinsVariableBlockProcessor> CODEC = Codec.unit(RuinsVariableBlockProcessor::new);

    private static final Map<WorldView, Map<Long, Biome>> MINI_BIOMEPOS_CACHE = new HashMap<>();
    private final ArrayList<Block> GLOOMY_BLOCKS = new ArrayList<>(ImmutableList.of(BlockRegistry.GLOOMY_BRICKS, BlockRegistry.GLOOMY_BRICKS_SLAB, BlockRegistry.GLOOMY_BRICKS_STAIRS, BlockRegistry.GLOOMY_STONE));
    private final ArrayList<Block> FIRE_BLOCKS = new ArrayList<>(ImmutableList.of(BlockRegistry.FIRE_BRICKS, BlockRegistry.FIRE_BRICK_SLAB, BlockRegistry.FIRE_BRICK_STAIRS, BlockRegistry.FIRE_STONE));

    @Nullable
    @Override
    public Structure.StructureBlockInfo process(WorldView world, BlockPos pos, BlockPos pivot, Structure.StructureBlockInfo structureBlockInfo, Structure.StructureBlockInfo structureBlockInfo2, StructurePlacementData data) {

        /* TODO: Still need to implement some sort of biome caching to reduce resource use */
        RegistryKey<Biome> key = null;
        Biome biome = getCachedBiome(world, pos);

        if(world instanceof ChunkRegion) {
            key = ((ChunkRegion) world).getRegistryManager().get(Registry.BIOME_KEY).getKey(world.getBiome(structureBlockInfo2.pos)).get();
        }

        if(key.equals(BiomeRegistry.GLOOMY_FOREST_KEY) || key.equals(BiomeRegistry.GLOOMY_MOUNTAINS_KEY)){
            Structure.StructureBlockInfo temp =  new Structure.StructureBlockInfo(structureBlockInfo2.pos, changeBlockToBiome(structureBlockInfo, structureBlockInfo.state, GLOOMY_BLOCKS), structureBlockInfo2.nbt);
            return temp;
        }
        else if(key.equals(BiomeRegistry.FIRE_PLAINS_KEY) || key.equals(BiomeRegistry.FIRE_PITS_KEY)){

            Structure.StructureBlockInfo temp =  new Structure.StructureBlockInfo(structureBlockInfo2.pos, changeBlockToBiome(structureBlockInfo, structureBlockInfo.state, FIRE_BLOCKS), structureBlockInfo2.nbt);
            return temp;
        }

        return structureBlockInfo;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return ProcessorRegistry.RUINS_BLOCK_PROCESSOR;
    }

    private <T extends Comparable<T>> BlockState copyProperties(BlockState originalState, BlockState copyState, Property<T> property){
        return originalState.with(property, copyState.get(property));
    }

    /* Block Changers: Will replace the nbt files default stone bricks into blocks that fit with the biome the structure spawns in */
    public BlockState changeBlockToBiome(Structure.StructureBlockInfo structureBlockInfo, BlockState originalState, ArrayList<Block> blocks){

        BlockState newBlockState = originalState;

        if(originalState.getBlock() == Blocks.STONE_BRICKS){
            newBlockState = blocks.get(0).getDefaultState();
            for(Property<?> property : structureBlockInfo.state.getProperties()){
                if(newBlockState.contains(property)){
                    newBlockState = copyProperties(newBlockState, structureBlockInfo.state, property);
                }
            }
        }

        else if(originalState.getBlock() == Blocks.STONE_BRICK_SLAB){
            newBlockState = blocks.get(1).getDefaultState();
            for(Property<?> property : structureBlockInfo.state.getProperties()){
                if(newBlockState.contains(property)){
                    newBlockState = copyProperties(newBlockState, structureBlockInfo.state, property);
                }
            }
        }

        else if(originalState.getBlock() == Blocks.STONE_BRICK_STAIRS){
            newBlockState = blocks.get(2).getDefaultState();
            for(Property<?> property : structureBlockInfo.state.getProperties()){
                if(newBlockState.contains(property)){
                    newBlockState = copyProperties(newBlockState, structureBlockInfo.state, property);
                }
            }
        }

        else if(originalState.getBlock() == Blocks.STONE){
            newBlockState = blocks.get(3).getDefaultState();
            for(Property<?> property : structureBlockInfo.state.getProperties()){
                if(newBlockState.contains(property)){
                    newBlockState = copyProperties(newBlockState, structureBlockInfo.state, property);
                }
            }
        }

        return newBlockState;
    }

    private Biome getCachedBiome(WorldView worldView, BlockPos structurePos) {
        Map<Long, Biome> worldSpecificBiomes = MINI_BIOMEPOS_CACHE.computeIfAbsent(worldView, (keyPos) -> new HashMap<>());
        BlockPos biomePos = new BlockPos(structurePos.getX() >> 2, 0, structurePos.getZ() >> 2);
        Biome biome = worldSpecificBiomes.computeIfAbsent(biomePos.asLong(), (keyPos) -> worldView.getBiome(structurePos));
        if(worldSpecificBiomes.size() > 20) worldSpecificBiomes.clear();
        return biome;
    }
}