package io.github.witherdoggie.forgottenforest.world.processor;

import com.google.common.collect.ImmutableList;
import io.github.witherdoggie.forgottenforest.registry.BiomeRegistry;
import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
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

/************************************************************************************
 *
 * Processor to allow for blocks in nbt files to be replaced with blocks that match
 * the biome
 *
 ************************************************************************************/

public class RuinsVariableBlockProcessor extends StructureProcessor {

    //private static final Long2ObjectMap<Biome> CACHED_BIOMES = new Long2ObjectMap<Biome>(200) {};
    private final ArrayList<Block> GLOOMY_BLOCKS = new ArrayList<>(ImmutableList.of(BlockRegistry.GLOOMY_BRICKS, BlockRegistry.GLOOMY_BRICKS_SLAB, BlockRegistry.GLOOMY_BRICKS_STAIRS, BlockRegistry.GLOOMY_STONE));
    private final ArrayList<Block> FIRE_BLOCKS = new ArrayList<>(ImmutableList.of(BlockRegistry.FIRE_BRICKS, BlockRegistry.FIRE_BRICK_SLAB, BlockRegistry.FIRE_BRICK_STAIRS, BlockRegistry.FIRE_STONE));

    @Nullable
    @Override
    public Structure.StructureBlockInfo process(WorldView world, BlockPos pos, BlockPos pivot, Structure.StructureBlockInfo structureBlockInfo, Structure.StructureBlockInfo structureBlockInfo2, StructurePlacementData data) {

        RegistryKey<Biome> key = null;

        if(world instanceof ChunkRegion) {
            key = ((ChunkRegion) world).getRegistryManager().get(Registry.BIOME_KEY).getKey(world.getBiome(structureBlockInfo.pos)).get();
        }

        if(key.equals(BiomeRegistry.GLOOMY_FOREST_KEY) || key.equals(BiomeRegistry.GLOOMY_MOUNTAINS_KEY)){
            return new Structure.StructureBlockInfo(structureBlockInfo2.pos, changeBlockToBiome(structureBlockInfo, world.getBlockState(pos), GLOOMY_BLOCKS), structureBlockInfo2.nbt);
        }
        else if(key.equals(BiomeRegistry.FIRE_PLAINS_KEY) || key.equals(BiomeRegistry.FIRE_PITS_KEY)){
            return new Structure.StructureBlockInfo(structureBlockInfo2.pos, changeBlockToBiome(structureBlockInfo, world.getBlockState(pos), FIRE_BLOCKS), structureBlockInfo2.nbt);
        }

        return structureBlockInfo;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return null;
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
}