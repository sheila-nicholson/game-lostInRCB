/*
 * PileOfBooks.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Items;

public class PileOfBooks extends RewardItem {

    private String punishmentType = "Pile of books";
    private int damagePoints = 5; // or just make it a signed int that can go negative to keep it to one system of points perhaps?

    /**
     * Constructor
     */
    public PileOfBooks() {
    }

    public int getScoreModifier(){
        return this.damagePoints;
    }

}
