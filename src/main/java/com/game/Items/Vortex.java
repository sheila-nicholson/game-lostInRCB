/*
 * Vortex.java
 * 
 * Class Description: Secondary punishment which is visible to the player, but upon contact teleports
 *                    the player's character to a random different position on the map.
 *                    Based on difficulty, there is a variable distance from which this teleport is away from all punishments.
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:19 AM
 */

 
package com.game.Items;

import com.game.Position;
import com.game.GamePanel.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import com.game.Character.Hero;

public class Vortex extends PunishmentItem {

    private PunishmentType punishmentType = PunishmentType.VORTEX;
    private int damagePoints = -5;

    /**
     * Constructor
     */
    public Vortex(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
        name = "Vortex";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Items/Vortex.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public int getScoreModifier(){
        return this.damagePoints; // unnecessary?
    }

    public void collisionAction(Hero hero) {
        hero.addScore(damagePoints);      // adds -5 to hero score

        boolean validPosition = false;
        int newRowPos;
        int newColPos;

        while(!validPosition) {
            // range of rows: 0-17
            // range of columns: 0-27
            newRowPos = ThreadLocalRandom.current().nextInt(0, 18);
            newColPos = ThreadLocalRandom.current().nextInt(0, 28);
            Vortex checkPositionValid = new Vortex(gamePanel);
            checkPositionValid.setPosition(newColPos, newRowPos);
            //hero.setPosition(newColPos * gamePanel.tileSize, newRowPos * gamePanel.tileSize);
            int tileNum = gamePanel.tileM.getMapTileNum()[newColPos][newRowPos];

            if (gamePanel.tileM.getTile()[tileNum].getTileType() == "floor")
                validPosition = !(gamePanel.collisionChecker.isEnemyIntersecting(checkPositionValid)); //

            if(validPosition)
                hero.setPosition(newColPos * gamePanel.tileSize, newRowPos * gamePanel.tileSize);

        }
    }

    public void updateItemState() {

    }

}
