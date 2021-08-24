package io.github.witherdoggie.forgottenforest.util.accessors;

/********************************
 *
 * Duck interface for PlayerEntityMixin
 *
 ********************************/
public interface PlayerEntityInterface {

    int getCurrentSoulCount();

    void setCurrentSoulCount(int soulCount);

    void resetSoulCount();

    void decrementSoulCount();

    void decrementSoulCount(int amount);

    void incrementSoulCount();

    void incrementSoulCount(int amount);
}
