package com.game.Items;

import com.game.Characters.Hero;
import com.game.GamePanel.MainGamePanel;

/**
 * Represents items in the game that reward the player upon collection.
 * <p>
 * This abstract class extends {@link Item} to define items that have beneficial effects,
 * primarily providing score bonuses to the player. Specific reward items extend this class
 * to implement various types of rewards. It includes a base implementation for retrieving
 * the score modifier associated with each reward item, which can be overridden by subclasses
 * for item-specific behavior.
 */
public class RewardItem extends Item {
    protected int scoreBonus;

    public RewardItem(MainGamePanel gamePanel){this.itemType = ItemType.Reward;}

    public void collisionAction(Hero hero) {}


}
