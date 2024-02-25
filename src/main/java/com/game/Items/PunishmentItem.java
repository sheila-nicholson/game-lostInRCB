package com.game.Items;

public abstract class PunishmentItem extends Item {
    private int damagePoints;

    public int getScoreModifier(){
        return this.damagePoints;
    }
}
