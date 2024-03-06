/*
 * PileOfBooks.java
 * 
 * Class Description: Primary punishment which incurs a 5 point penalty should the player come in contact.
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:13 AM
 */


package com.game.Items;

public class PileOfBooks extends RewardItem {

    private String punishmentType = "Pile of books";
    private int damagePoints = 5; 

    /**
     * Constructor
     */
    public PileOfBooks() {
    }

    public int getScoreModifier(){
        return this.damagePoints;
    }

    // play animation? play sound?

}
