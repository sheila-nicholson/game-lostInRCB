/*
 * MysteriousSmokeTile.java
 * 
 * Class Description: Secondary punishment which remains invisible throughout gametime but reveals itself briefly when player steps on it.
 *                    Causes significant slowness for 5 seconds.
 *
 * Authors: [put your names here] + Brendan
 * Last modified on: March 6, 2024 1:44 AM
 */


package com.game.Tile;

import java.awt.*;

public class MysteriousSmokeTile extends Tile {
    private int slowSpeed;
    private int handicapTime;
    private Image smokeSprite;
    private boolean isVisible;

/*    public MysteriousSmokeTile(int slowSpeed, int handicapTime, Image smokeSprite, boolean isVisible, Image paramTileSprite, int param_X, int param_y){
        this.slowSpeed = slowSpeed;
        this.handicapTime = handicapTime;
        this.smokeSprite = smokeSprite;
        this.isVisible = isVisible;
        //setTileSprite(paramTileSprite);
        setPosition(param_X,param_y);
    }*/

    public MysteriousSmokeTile(){
        this.tileSteppability = true;
        this.isLevelEndBool = false;
        this.isMysteriousSmokeTileBool = true;
    }

    public int getSpeedModifier(){
        return slowSpeed;
    }
    public void engageSmoke(){ 
        this.isVisible = true; // add a timer in main call to cycle between engage and hide
    }

    public void hideSmoke(){
        this.isVisible = false; // remains hidden until player steps on it, reveals itself momentarily, then goes back invisible
    }
}
