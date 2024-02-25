package com.game;

public class Bed extends RewardItem {

    private String rewardType = "Bed";
    private int scoreBonus = 5;

    /**
     * Constructor
     */
    public Bed() {
    }

    public int getScoreModifier(){
        return this.scoreBonus;
    }

}
