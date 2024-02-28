/*
 * CharacterFactory.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Factory;

import com.game.Character.Enemy;
import com.game.Character.Hero;

public abstract class CharacterFactory{
    public abstract Hero createHero();
    public abstract Enemy createEnemy();

}
