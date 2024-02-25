package com.game;

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

}
