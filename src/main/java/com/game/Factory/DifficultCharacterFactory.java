/*
 * DifficultCharacterFactory.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Factory;
import com.game.Character.*;

public class DifficultCharacterFactory extends CharacterFactory {
    public Hero createHero() {
        return Hero.getInstance(70); //temp speed
        // hero should be slower than enemies throughout ALL stages of difficulty
    }

    public Enemy createEnemy() {
        return FailedExam.getInstance(100); //temp speed
    }

    public DifficultCharacterFactory(){

    }
}

