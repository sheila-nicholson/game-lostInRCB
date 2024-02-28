/*
 * APlusPaper.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


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
