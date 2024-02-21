package com.game;

public class Coffee extends RewardItem {

    private String rewardType = "Coffee";
    private int scoreBonus = 5;
    private int modifierSeconds = 5;

    /**
     * Constructor
     */
    public Coffee() {
    }

    public int getModifierSeconds() {
        return this.modifierSeconds;
    }

    public int getScoreModifier(){
        return this.scoreBonus;
    }
}
