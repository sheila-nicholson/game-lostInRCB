/*
 * Coffee.java
 * 
 * Class Description: Details the additional, optional reward that offers no points.
 *                    However, collecting (drinking) coffee grants movement speed bonus for 5 seconds.
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:06 AM
 */


package com.game.Items;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Coffee extends RewardItem {

    private int scoreBonus = 3; // unsure, temporary value
    private int modifierSeconds = 5;

    /**
     * Constructor
     */
    public Coffee() {
        this.rewardType = RewardType.COFFEE;
        // set position, no need to randomize, harder level = less spawn
        name = "Coffee";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Items/Coffee.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public int getModifierSeconds() {
        return this.modifierSeconds;
    }

    public int getScoreModifier(){
        return this.scoreBonus;
    }

    public void collisionAction() {
    }
}
