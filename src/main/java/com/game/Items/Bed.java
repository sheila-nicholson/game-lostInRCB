/*
 * Bed.java
 * 
 * Class Description: Details the main reward of the game.
 *                    Each 'bed' is worth 5 points.
 *                    Player must collect all beds in a level to finish it.
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:03 AM
 */


package com.game.Items;

public class Bed extends RewardItem {

    private String rewardType = "Bed";
    private int scoreBonus = 5;
    private boolean collected = false; // true means door to finish level is unlocked

    /**
     * Constructor
     */
    public Bed() {
        // set position, no need to randomize, harder level = more spawn
    }

    public int getScoreModifier(){
        return this.scoreBonus;
    }

}
