package io.github.witherdoggie.forgottenforest.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class RottenAppleItem extends Item {

    public RottenAppleItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        tooltip.add(new TranslatableText("item.forgotten_forest.rotten_apple.tooltip").formatted(Formatting.RED));
    }
}
