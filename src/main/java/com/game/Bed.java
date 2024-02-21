package com.game;

import java.awt.*;

public class Bed extends rewardItem {

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
