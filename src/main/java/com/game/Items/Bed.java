package com.game.Items;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import com.game.Character.Hero;
import com.game.GamePanel.GamePanel;

/**
 * Represents a bed item in the game, serving as a main reward for the player.
 * <p>
 * Collecting a bed rewards the player with points and contributes towards level completion.
 * Each bed is worth a set number of points, and players must collect all beds within a level
 * to unlock the finish. This class extends {@link RewardItem} to implement the specific behaviors
 * and properties associated with bed items.
 *
 * @author:
 */
public class Bed extends RewardItem {

    private int scoreBonus = 5;
    private boolean collected = false; // true means door to finish level is unlocked

    /**
     * Constructs a Bed item associated with a specific game panel.
     * <p>
     * Initializes the item with its image and sets the score bonus for collecting the bed.
     * The bed's image is loaded from resources, and it's marked with the "Bed" reward type.
     *
     * @param gamePanel The game panel to which this bed item belongs.
     */
    public Bed(GamePanel gamePanel) {
        this.rewardType = RewardType.BED;
        name = "Bed";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Items/Bed.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
        // set position, no need to randomize, harder level = more spawn
    }

    /**
     * Retrieves the score bonus amount provided by this bed item.
     * <p>
     * This method allows access to the specific score bonus value that the hero receives upon
     * collecting a bed.
     *
     * @return The score bonus value.
     */
    public int getScoreModifier(){
        return this.scoreBonus;
    }

    /**
     * Defines the action to take upon collision with the Hero character.
     * <p>
     * When the Hero character collides with this bed item, this method is called to apply the score bonus
     * to the Hero, effectively "collecting" the bed and contributing towards level completion.
     *
     * @param hero The Hero character with which the bed has collided.
     */
    public void collisionAction(Hero hero) {
        hero.addScore(scoreBonus);      // adds 5 to hero score

    }

}
