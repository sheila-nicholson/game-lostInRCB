package com.game.Factory;
import com.game.Character.*;

public class DifficultCharacterFactory extends CharacterFactory {
    public Hero createHero() {
        return Hero.getInstance(100); //temp speed
    }

    public Enemy createEnemy() {
        return FailedExam.getInstance(100); //temp speed
    }

    public DifficultCharacterFactory(){

    }
}
