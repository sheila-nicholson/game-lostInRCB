package com.game;

public abstract class EasyCharacterFactory extends CharacterFactory{
    public Hero createHero(
            return Hero.getInstance(150); //temp speed
    );
    public abstract Enemy createEnemy(
             return Racoon.getInstance(100);
    );
}
