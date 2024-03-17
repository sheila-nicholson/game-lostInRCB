package com.game.Items;

/**
 * Represents items that have negative effects on the player, such as reducing score.
 * <p>
 * This abstract class extends {@link Item} to define punishment items within the game.
 * It includes properties such as the type of punishment and the amount of damage or
 * score reduction associated with the item. Specific punishment items extend this class.
 */
public abstract class PunishmentItem extends Item {

    protected PunishmentType punishmentType;
    protected int damagePoints;

    /**
     * Retrieves the score reduction or damage points associated with the punishment item.
     * Override in subclasses to return specific damage points.
     *
     * @return The amount of score reduction or damage.
     */
    public int getScoreModifier(){
        // only applicable to pileOfBooks - vortex and smoke don't penalize points
        int damagePoints = 0;
        return damagePoints;
    }


}
