/*
 * Vortex.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */

3
package com.game.Items;

import com.game.Position;

public class Vortex extends PunishmentItem {

    private String punishmentType = "Vortex";
    private int damagePoints = 5; // or just make it a signed int that can go negative to keep it to one system of points perhaps? (copy pasted from pileofbooks)

    /**
     * Constructor
     */
    public Vortex() {
    }

    public int getScoreModifier(){
        return this.damagePoints;
    }

    public Position moveCharacter() {
        return new Position();
    }

}
