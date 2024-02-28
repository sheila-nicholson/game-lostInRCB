/*
 * Bed.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Items;

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
