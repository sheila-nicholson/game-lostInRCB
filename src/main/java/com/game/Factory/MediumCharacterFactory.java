/*
 * MediumCharacterFactory.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Factory;

import com.game.Character.Enemy;
import com.game.Character.Hero;
import com.game.Character.ZoombieProfessor;

public class MediumCharacterFactory extends CharacterFactory {
    public Hero createHero() {
        return Hero.getInstance(80); //temp speed - see easy + difficult for why it's 80
    }
    public Enemy createEnemy() {
        return ZoombieProfessor.getInstance(100); //temp speed
    }
}
