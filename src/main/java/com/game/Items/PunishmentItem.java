/*
 * PunishmentItem.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Items;

public abstract class PunishmentItem extends Item {
    private int damagePoints;

    public int getScoreModifier(){
        return this.damagePoints;
    }
}
