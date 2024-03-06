/*
 * RewardItem.java
 * 
 * Class Description: Main subcategory of any items that have a positive effect on the player.
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:17 AM
 */


package com.game.Items;

public abstract class RewardItem extends Item {
    private int scoreBonus;
    private String rewardType = ""; // tbd

    public int getScoreModifier(){
        return this.scoreBonus;
    }
}
