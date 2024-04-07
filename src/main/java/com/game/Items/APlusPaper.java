package com.game.Items;

import com.game.GamePanel.MainGamePanel;

import java.util.concurrent.ThreadLocalRandom;
import com.game.Characters.Hero;

/**
 * Represents an A+ paper item in the game that grants the player a score bonus upon collection.
 * <p>
 * This class extends {@link RewardItem} to provide specific functionality for the A+ paper item,
 * including a predefined score bonus. When collected by the Hero, it increases the player's score,
 * symbolizing the acquisition of a valuable academic reward. Additionally, it includes a method to
 * update its position randomly within valid game bounds to maintain gameplay dynamics.
 */
public class APlusPaper extends RewardItem {

    private final int scoreBonus = 10;

    /**
     * Constructs an APlusPaper item associated with a specific game panel.
     * <p>
     * Initializes the item with its image, reward type, and sets the score bonus. The item's image
     * is loaded from the resources, and the item is set to the "APlusPaper" reward type.
     *
     * @param gamePanel The game panel to which this item belongs.
     */
    public APlusPaper(MainGamePanel gamePanel) {
        super(gamePanel);
        this.gamePanel = gamePanel;
        name = "APlusPaper";
        image = utilityTool.setImage("/Items/APlusPaper",gamePanel);
    }

    /**
     * Retrieves the score bonus amount provided by this item.
     * <p>
     * This method allows access to the specific score bonus value that the hero receives upon
     * collecting an A+ paper.
     *
     * @return The score bonus value.
     */
    public int getScoreModifier(){
        return this.scoreBonus;
    }

    /**
     * Defines the action to take upon collision with the Hero character.
     * <p>
     * When the Hero character collides with this item, this method is called to apply the score bonus
     * to the Hero, effectively "collecting" the item.
     *
     * @param hero The Hero character with which the item has collided.
     */
    public void collisionAction(Hero hero) {
        hero.addScore(scoreBonus);      // adds 10 to hero score
    }

    /**
     * Updates the item's position randomly within the game environment.
     * <p>
     * This method is intended to relocate the A+ paper to a new, valid position within the game world
     * to simulate dynamic placement and encourage exploration. The new position is chosen randomly but
     * is validated to ensure it is within appropriate bounds and not colliding with the Hero.
     */
    public void updateItemState() {

        boolean validPositionItem = false;
        boolean validPositionHero = false;
        int newRowPos;
        int newColPos;

        while(!validPositionItem && !validPositionHero) {
            // range of rows: 0-17
            // range of columns: 0-27
            newRowPos = ThreadLocalRandom.current().nextInt(0, 18);
            newColPos = ThreadLocalRandom.current().nextInt(0, 28);
            RewardItem checkPositionValid = new RewardItem(gamePanel);
            checkPositionValid.setPosition(newColPos, newRowPos);


            int tileNum = gamePanel.tileM.getMapTileNum()[newColPos][newRowPos];

            if (gamePanel.tileM.getTile()[tileNum].getTileType() == "floor") {
                validPositionItem = !(gamePanel.collisionChecker.isHeroIntersecting(checkPositionValid));
                validPositionHero = !(gamePanel.collisionChecker.isTileOccupied(gamePanel.item, checkPositionValid));
            }


            if(validPositionItem && validPositionHero)
                this.setPosition(newColPos, newRowPos);

        }
    }
}


