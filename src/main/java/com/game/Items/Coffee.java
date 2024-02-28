/*
 * Coffee.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Items;

public class Coffee extends RewardItem {

    private String rewardType = "Coffee";
    private int scoreBonus = 5; // unsure, temporary value
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
