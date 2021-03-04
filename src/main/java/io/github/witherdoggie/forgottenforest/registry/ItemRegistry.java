package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    public static final Item ORCHIUM_INGOT = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

    public static void initItems(){

        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "orchium_ingot"), ORCHIUM_INGOT);

    }
}
