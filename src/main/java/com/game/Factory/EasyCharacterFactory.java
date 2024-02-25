package com.game.Factory;

import com.game.Character.*;

public abstract class EasyCharacterFactory extends CharacterFactory {
    public Hero createHero() {
        return Hero.getInstance(150); //temp speed
    }
    public Enemy createEnemy() {
            return Raccoon.getInstance(100);
    }
}
