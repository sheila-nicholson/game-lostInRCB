package com.game;


public abstract class DifficultCharacterFactory extends CharacterFactory{
    public Hero createHero(
            return Hero.getInstance(100);//temp speed
    );
    public abstract Enemy createEnemy(
             return Racoon.getInstance(100); //temp speed
    );
}
