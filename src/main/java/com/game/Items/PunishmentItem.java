package com.game.Items;

import com.game.GamePanel.MainGamePanel;

/**
 * Represents items that have negative effects on the player, such as reducing score.
 * <p>
 * This abstract class extends {@link Item} to define punishment items within the game.
 * It includes properties such as the type of punishment and the amount of damage or
 * score reduction associated with the item. Specific punishment items extend this class.
 */
public abstract class PunishmentItem extends Item {

    protected int damagePoints;

    public PunishmentItem(MainGamePanel gamePanel){
        this.itemType = ItemType.Punishment;
    }



}
