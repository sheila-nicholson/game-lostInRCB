package com.game;

public abstract class Character extends Position{

    private static Character instance = null;
    private Character(){}

    public static synchronized AbstractSingleton getInstance() {
        if (instance == null) {
            instance = new ConcreteSingleton();
        }
        return instance;
    }

    public void moveCharacter() {
        return;
    }

    public void displayCharacter() {
        return;
    }

}
