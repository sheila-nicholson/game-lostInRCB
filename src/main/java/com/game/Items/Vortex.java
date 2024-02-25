package com.game.Items;

import com.game.Position;

public class Vortex extends PunishmentItem {

    private String punishmentType = "Vortex";
    private int damagePoints = 5;

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
