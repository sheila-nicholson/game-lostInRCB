package com.game.Items;

public class APlusPaper extends RewardItem {

    private String rewardType = "A+ Paper";
    private int scoreBonus = 10;
    private int timeAvaliable;

    /**
     * Constructor
     */
    public APlusPaper() {
    }

    public int getScoreModifier(){
        return this.scoreBonus;
    }

    public int getTimeAvaliable() {
        return this.timeAvaliable;
    }
}
