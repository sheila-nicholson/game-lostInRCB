/*
 * EasyCharacterFactory.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Factory;

import com.game.Character.*;

public class EasyCharacterFactory extends CharacterFactory {
    public Hero createHero() {
        return Hero.getInstance(90); //temp speed - fastest speed throughout all levels? subject to change?
    }
    public Enemy createEnemy() {
            return Raccoon.getInstance(100);
    }
}
