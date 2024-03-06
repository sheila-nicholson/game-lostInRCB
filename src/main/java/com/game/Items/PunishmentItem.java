/*
 * PunishmentItem.java
 * 
 * Class Description: Main subcategory of any items that have a negative effect on the player.
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:16 AM
 */


package com.game.Items;

public abstract class PunishmentItem extends Item {
    private int damagePoints; // only applicable to pileOfBooks - vortex and smoke don't penalize points

    public int getScoreModifier(){
        return this.damagePoints;
    }
}
