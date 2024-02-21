package com.game;

public abstract class rewardItem extends Item{
    private int scoreBonus;

    public int getScoreModifier(){
        return this.scoreBonus;
    }
}
