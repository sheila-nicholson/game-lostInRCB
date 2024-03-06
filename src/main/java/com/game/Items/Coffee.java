/*
 * Coffee.java
 * 
 * Class Description: Details the additional, optional reward that offers no points.
 *                    However, collecting (drinking) coffee grants movement speed bonus for 5 seconds.
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:06 AM
 */


package com.game.Items;

public class Coffee extends RewardItem {

    private String rewardType = "Coffee";
    private int scoreBonus = 3; // unsure, temporary value
    private int modifierSeconds = 5;

    /**
     * Constructor
     */
    public Coffee() {
        // set position, no need to randomize, harder level = less spawn
    }

    public int getModifierSeconds() {
        return this.modifierSeconds;
    }

    public int getScoreModifier(){
        return this.scoreBonus;
    }
}
