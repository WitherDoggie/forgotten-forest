package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static ItemGroup BLOCKS;

    public static void initItemGroups() {

        BLOCKS = FabricItemGroupBuilder.build(new Identifier(ForgottenForest.MODID, "blocks"), () -> new ItemStack(BlockRegistry.GLOOMY_GRASS_BLOCK));
    }
}
