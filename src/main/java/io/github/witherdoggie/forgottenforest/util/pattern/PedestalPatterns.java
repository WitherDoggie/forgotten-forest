package io.github.witherdoggie.forgottenforest.util.pattern;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.HashMap;
import java.util.Map;

public class PedestalPatterns {

    private static PedestalPattern COW_SUMMON_PATTERN = new BindingRitualPattern(4, EntityType.COW, create(Items.WHEAT), create(Items.BEEF), create(Items.WHEAT), create(Items.BEEF));

    public static HashMap<Integer, PedestalPattern> bindingRitualPatterns = new HashMap(Map.ofEntries(
            Map.entry(0, COW_SUMMON_PATTERN)
    ));

    private static ItemStack create(Item item){
        return new ItemStack(item);
    }

    public static PedestalPattern findMatch(PedestalPattern pattern){
        for (int i = 0; i < bindingRitualPatterns.size(); i++){
            if(bindingRitualPatterns.get(i).matches(pattern)){
                return bindingRitualPatterns.get(i);
            }
        }
        //If an invalid pattern is found, we'll return null saying that no valid pattern was found
        return null;
    }
}
