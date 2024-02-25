package com.game;

public class MediumCharacterFactory extends CharacterFactory{
    public Hero createHero(
            return Hero.getInstance(200); //temp speed
    );
    public abstract Enemy createEnemy(
             return Racoon.getInstance(100); //temp speed
    );
}
