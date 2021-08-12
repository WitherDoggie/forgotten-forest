package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.world.processor.RuinsVariableBlockProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.registry.Registry;

public class ProcessorRegistry {

    public static StructureProcessorType<RuinsVariableBlockProcessor> RUINS_BLOCK_PROCESSOR = () -> RuinsVariableBlockProcessor.CODEC;

    public static void initStructureProcessors(){

        Registry.register(Registry.STRUCTURE_PROCESSOR, ForgottenForest.id("ruins_variable_block_processor"), RUINS_BLOCK_PROCESSOR);
    }
}
