package com.game;

public abstract class RewardItem extends Item{
    private int scoreBonus;

    public int getScoreModifier(){
        return this.scoreBonus;
    }
}
