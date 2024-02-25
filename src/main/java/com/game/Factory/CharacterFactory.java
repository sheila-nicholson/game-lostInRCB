package com.game.Factory;

import com.game.Character.Enemy;
import com.game.Character.Hero;

public abstract class CharacterFactory{
    public abstract Hero createHero();
    public abstract Enemy createEnemy();

}
