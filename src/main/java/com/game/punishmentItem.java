package com.game;

public abstract class punishmentItem {
    private int damagePoints;

    public int getScoreModifier(){
        return this.damagePoints;
    }
}
