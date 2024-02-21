package com.game;

import java.awt.*;

public class Coffee extends rewardItem {

    private string rewardType = "Coffee";
    private int scoreBonus = 5;
    private int modifierSeconds = 5;
    private Image coffee;

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
