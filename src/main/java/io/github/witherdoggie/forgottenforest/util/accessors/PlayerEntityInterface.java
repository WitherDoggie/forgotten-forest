package io.github.witherdoggie.forgottenforest.util.accessors;

public interface PlayerEntityInterface {

    int getCurrentSoulCount();

    void setCurrentSoulCount(int soulCount);

    void resetSoulCount();

    void decrementSoulCount();

    void incrementSoulCount();
}
