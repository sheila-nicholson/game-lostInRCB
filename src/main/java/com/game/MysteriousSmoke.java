package com.game;

public class MysteriousSmoke extends PunishmentItem {

    private String punishmentType = "Mysterious Smoke";
    private int damagePoints = 5;
    private int modifierSeconds = 5;

    private boolean hidden = true;

    /**
     * Constructor
     */
    public MysteriousSmoke() {
    }

    public int getScoreModifier(){
        return this.damagePoints;
    }

    public int getModifierSeconds() {
        return this.modifierSeconds;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean getHidden() {
        return this.hidden;
    }
}
