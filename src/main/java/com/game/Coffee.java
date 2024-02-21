package com.game;

import java.awt.*;

public class Coffee extends rewardItem {

    private String rewardType = "Coffee";
    private int scoreBonus = 5;
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
