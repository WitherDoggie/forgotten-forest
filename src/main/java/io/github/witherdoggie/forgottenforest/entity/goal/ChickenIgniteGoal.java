package io.github.witherdoggie.forgottenforest.entity.goal;

import io.github.witherdoggie.forgottenforest.entity.SoulChickenEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.ChickenEntity;

import java.util.EnumSet;

public class ChickenIgniteGoal extends Goal {
    private SoulChickenEntity chicken;
    private LivingEntity target;

    public ChickenIgniteGoal(SoulChickenEntity chicken) {
        this.chicken = chicken;
        this.setControls(EnumSet.of(Goal.Control.MOVE));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.chicken.getTarget();
        return (this.chicken).getFuseSpeed() > 0 || livingEntity != null && this.chicken.squaredDistanceTo(livingEntity) < 9.0D;
    }

    public void start() {
        this.chicken.getNavigation().stop();
        this.target = this.chicken.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public void tick() {
        if (this.target == null) {
            (this.chicken).setFuseSpeed(-1);
        } else if (this.chicken.squaredDistanceTo(this.target) > 49.0D) {
            (this.chicken).setFuseSpeed(-1);
        } else if (!this.chicken.getVisibilityCache().canSee(this.target)) {
            (this.chicken).setFuseSpeed(-1);
        } else {
            (this.chicken).setFuseSpeed(1);
        }
    }
}
