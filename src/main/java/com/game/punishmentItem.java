package com.game;

public abstract class punishmentItem extends Item{
    private int damagePoints;

    public int getScoreModifier(){
        return this.damagePoints;
    }
}
