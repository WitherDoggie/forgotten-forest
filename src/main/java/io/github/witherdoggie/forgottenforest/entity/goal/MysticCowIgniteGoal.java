package io.github.witherdoggie.forgottenforest.entity.goal;

import io.github.witherdoggie.forgottenforest.entity.MysticCowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class MysticCowIgniteGoal extends Goal {

    private MysticCowEntity mysticCowEntity;
    private LivingEntity target;

    public MysticCowIgniteGoal(MysticCowEntity mysticCowEntity) {
        this.mysticCowEntity = mysticCowEntity;
        this.setControls(EnumSet.of(Goal.Control.MOVE));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.mysticCowEntity.getTarget();
        return (this.mysticCowEntity).getFuseSpeed() > 0 || livingEntity != null && this.mysticCowEntity.squaredDistanceTo(livingEntity) < 9.0D;
    }

    public void start() {
        this.mysticCowEntity.getNavigation().stop();
        this.target = this.mysticCowEntity.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public void tick() {
        if (this.target == null) {
            (this.mysticCowEntity).setFuseSpeed(-1);
        } else if (this.mysticCowEntity.squaredDistanceTo(this.target) > 49.0D) {
            (this.mysticCowEntity).setFuseSpeed(-1);
        } else if (!this.mysticCowEntity.getVisibilityCache().canSee(this.target)) {
            (this.mysticCowEntity).setFuseSpeed(-1);
        } else {
            (this.mysticCowEntity).setFuseSpeed(1);
        }
    }
}
