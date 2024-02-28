/*
 * RewardItem.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Items;

public abstract class RewardItem extends Item {
    private int scoreBonus;

    public int getScoreModifier(){
        return this.scoreBonus;
    }
}
