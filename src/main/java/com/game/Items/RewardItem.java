package com.game.Items;

import com.game.GamePanel.GamePanel;

/**
 * Represents items in the game that reward the player upon collection.
 * <p>
 * This abstract class extends {@link Item} to define items that have beneficial effects,
 * primarily providing score bonuses to the player. Specific reward items extend this class
 * to implement various types of rewards. It includes a base implementation for retrieving
 * the score modifier associated with each reward item, which can be overridden by subclasses
 * for item-specific behavior.
 */
public abstract class RewardItem extends Item {
    private int scoreBonus;
    protected RewardType rewardType; // tbd

    public RewardItem(GamePanel gamePanel){this.itemType = ItemType.Reward;}

    /**
     * Retrieves the score bonus amount provided by this reward item.
     * <p>
     * This method allows access to the specific score bonus value that the player receives upon
     * collecting the reward item. It forms the basis for reward items to influence the player's score
     * positively.
     *
     * @return The score bonus value associated with the reward item.
     */
    public int getScoreModifier(){
        return this.scoreBonus;
    }


}
