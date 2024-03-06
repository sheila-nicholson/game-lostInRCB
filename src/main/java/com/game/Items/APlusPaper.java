/*
 * APlusPaper.java
 * 
 * Class Description: Details the bonus reward (+10 points)
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:01 AM
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
        // set position, no need to randomize, harder level = less spawn
        this.timeAvaliable = 10; // seconds or milliseconds?
    }

    public int getScoreModifier(){
        return this.scoreBonus;
    }

    public int getTimeAvaliable() {
        return this.timeAvaliable;
    }
}
