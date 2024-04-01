package com.game.Items;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import com.game.Character.Hero;
import com.game.GamePanel.GamePanel;

/**
 * Represents a coffee item in the game that temporarily increases the Hero's movement speed.
 * <p>
 * Upon collection, this item awards the Hero a score bonus and temporarily boosts their movement
 * speed, simulating the energizing effect of coffee. This class extends {@link RewardItem} to
 * implement specific behaviors and properties associated with coffee items, including the duration
 * of the speed boost and the score bonus provided.
 */
public class Coffee extends RewardItem {

    private int scoreBonus = 5;
    private int modifierSeconds = 5;
    private int increaseSpeed = 6;

    /**
     * Constructs a Coffee item associated with a specific game panel.
     * <p>
     * Initializes the item with its image, reward type, and sets the score bonus and speed boost
     * effect. The coffee item's image is loaded from resources, and it is set to the "Coffee"
     * reward type.
     *
     * @param gamePanel The game panel to which this coffee item belongs.
     */
    public Coffee(GamePanel gamePanel) {
        super(gamePanel);
        this.rewardType = RewardType.COFFEE;
        // set position, no need to randomize, harder level = less spawn
        name = "Coffee";
        image = utilityTool.setImage("/Items/Coffee",gamePanel);

    }

    /**
     * Retrieves the duration of the speed modifier effect in seconds.
     * <p>
     * This method allows access to the specific time duration that the Hero's speed boost
     * will last upon collecting a coffee.
     *
     * @return The duration of the speed boost effect in seconds.
     */
    public int getModifierSeconds() {
        return this.modifierSeconds;
    }

    /**
     * Retrieves the score bonus amount provided by this coffee item.
     * <p>
     * This method allows access to the specific score bonus value that the Hero receives upon
     * collecting a coffee.
     *
     * @return The score bonus value.
     */
    public int getScoreModifier(){
        return this.scoreBonus;
    }

    /**
     * Defines the action to take upon collision with the Hero character.
     * <p>
     * When the Hero character collides with this coffee item, this method is called to apply
     * both the score bonus and the temporary speed boost to the Hero, effectively "collecting"
     * the coffee and enhancing the Hero's capabilities for a short duration.
     *
     * @param hero The Hero character with which the coffee has collided.
     */
    public void collisionAction(Hero hero) {
        hero.addScore(scoreBonus);      // adds 5 to hero score
        hero.setMovementSpeed(increaseSpeed);       // increases hero speed for 5 seconds
        hero.coffeeTimeEnd = (hero.currentTime + 5);

    }

}
