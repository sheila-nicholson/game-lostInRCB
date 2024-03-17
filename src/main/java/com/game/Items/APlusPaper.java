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
import com.game.Character.Hero;


public class APlusPaper extends RewardItem {

    private final int scoreBonus = 10;

    /**
     * Constructor
     */
    public APlusPaper(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.rewardType = RewardType.APLUSPAPAER;
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

    public void collisionAction(Hero hero) {
        hero.addScore(scoreBonus);      // adds 10 to hero score
    }

    public void updateItemState() {

        boolean validPosition = false;
        int newRowPos;
        int newColPos;

        while(!validPosition) {
            // range of rows: 0-17
            // range of columns: 0-27
            newRowPos = ThreadLocalRandom.current().nextInt(0, 18);
            newColPos = ThreadLocalRandom.current().nextInt(0, 28);
            APlusPaper checkPositionValid = new APlusPaper(gamePanel);
            checkPositionValid.setPosition(newColPos, newRowPos);
            //this.setPosition(newColPos * gp.tileSize, newRowPos * gp.tileSize);


            int tileNum = gamePanel.tileM.getMapTileNum()[newColPos][newRowPos];

            if (gamePanel.tileM.getTile()[tileNum].getTileType() == "floor")
                validPosition = !(gamePanel.collisionChecker.isHeroIntersecting(this));

            if(validPosition)
                this.setPosition(newColPos * gamePanel.tileSize, newRowPos * gamePanel.tileSize);

        }
    }
}


