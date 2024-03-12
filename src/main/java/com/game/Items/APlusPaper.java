/*
 * APlusPaper.java
 * 
 * Class Description: Details the bonus reward (+10 points)
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:01 AM
 */


package com.game.Items;

import com.game.GamePanel.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;


public class APlusPaper extends RewardItem {

    private int scoreBonus = 10;
    private int timeAvaliable;

    private GamePanel gp;

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

    public void updateItemState(GamePanel gp) {
        this.gp = gp;
        boolean validPosition = false;
        int newRowPos;
        int newColPos;

        while(!validPosition) {

            // range of rows: 0-17
            // range of columns: 0-27
            newRowPos = ThreadLocalRandom.current().nextInt(0, 18);
            newColPos = ThreadLocalRandom.current().nextInt(0, 28);
            this.setPosition(newColPos * gp.tileSize, newRowPos * gp.tileSize);

            if(gp.tileM.mapTileNum[newColPos][newRowPos] == 3) {

                validPosition = !(gp.collisionChecker.isHeroIntersecting(this));        // TODO: ensure hero collision is not an issue
            }
        }
    }
}


