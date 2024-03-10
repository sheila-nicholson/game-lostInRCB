/*
 * APlusPaper.java
 * 
 * Class Description: Details the bonus reward (+10 points)
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:01 AM
 */


package com.game.Items;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class APlusPaper extends RewardItem {

    private int scoreBonus = 10;
    private int timeAvaliable;

    /**
     * Constructor
     */
    public APlusPaper() {
        this.rewardType = RewardType.APLUSPAPAER;
        // set position, no need to randomize, harder level = less spawn
        this.timeAvaliable = 10; // seconds or milliseconds?
        name = "APlusPaper";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Items/APlusPaper.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public int getScoreModifier(){
        return this.scoreBonus;
    }

    public int getTimeAvaliable() {
        return this.timeAvaliable;
    }

    public void collisionAction() {
    }

}


