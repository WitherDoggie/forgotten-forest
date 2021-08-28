package io.github.witherdoggie.forgottenforest.util.pattern;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public abstract class PedestalPattern {

    protected ArrayList itemStackList;

    public PedestalPattern(int numberOfPedestals, ItemStack ... itemStacks){
        itemStackList = new ArrayList<ItemStack>(numberOfPedestals);
        for(ItemStack itemStack : itemStacks){
            itemStackList.add(itemStack);
        }
    }

    public void add(ItemStack stack){
        itemStackList.add(stack);
    }

    public ItemStack get(int key){
        return (ItemStack) itemStackList.get(key);
    }

    public boolean sizeMatch(PedestalPattern pattern){
        return this.itemStackList.size() == pattern.itemStackList.size() ? true : false;
    }

    public boolean matches(PedestalPattern pattern){
        for(int i = 0; i < itemStackList.size(); i++){
            if(!(this.itemStackList.get(i) == pattern.itemStackList.get(i))){
                return false;
            }
        }
        return true;
    }
}
