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

public class Vortex extends PunishmentItem {

    private String punishmentType = "Vortex";
    // private int damagePoints = 5; you don't lose points in phase 1?

    /**
     * Constructor
     */
    public Vortex() {
    }

    public int getScoreModifier(){
        return this.damagePoints; // unnecessary? 
    }

    public Position moveCharacter() {

        /* if (difficulty == easy) {
            Position cannot be ANYWHERE close to other punishments
        } else if (difficulty = medium) {
            Position cannot be SOMEWHAT close to other punishments
        } else if (difficulty = hard) {
            Position cannot be REALLY close to other punishments
        }
         */

        return new Position();
    }

}
