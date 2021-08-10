package io.github.witherdoggie.forgottenforest.entity.goal;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.GameRules;

import java.util.Random;

public class CreateItemWhenBreedingGoal extends AnimalMateGoal {

    private ItemStack itemStack;

    public CreateItemWhenBreedingGoal(AnimalEntity animal, double chance, ItemStack stack) {
        super(animal, chance);
        this.itemStack = stack;
    }

    protected void breed() {
        ServerPlayerEntity serverPlayerEntity = this.animal.getLovingPlayer();
        if (serverPlayerEntity == null && this.mate.getLovingPlayer() != null) {
            serverPlayerEntity = this.mate.getLovingPlayer();
        }

        if (serverPlayerEntity != null) {
            serverPlayerEntity.incrementStat(Stats.ANIMALS_BRED);
            Criteria.BRED_ANIMALS.trigger(serverPlayerEntity, this.animal, this.mate, null);
        }

        this.animal.resetLoveTicks();
        this.mate.resetLoveTicks();
        Random random = this.animal.getRandom();

        ItemEntity spawnedItem = new ItemEntity(this.world, animal.getX(), animal.getY(), animal.getZ(), itemStack);
        this.world.spawnEntity(spawnedItem);
        if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
            this.world.spawnEntity(new ExperienceOrbEntity(this.world, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
        }

    }
}
