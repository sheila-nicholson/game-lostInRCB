package com.game;

import java.awt.*;

public class mysteriousSmokeTile extends Tile{
    private int slowSpeed;
    private int handicapTime;
    private Image smokeSprite;
    private boolean isVisible;

    public mysteriousSmokeTile(int slowSpeed, int handicapTime, Image smokeSprite, boolean isVisible, Image paramTileSprite, int param_X, int param_y){
        this.slowSpeed = slowSpeed;
        this.handicapTime = handicapTime;
        this.smokeSprite = smokeSprite;
        this.isVisible = isVisible;
        setTileSprite(paramTileSprite);
        setPosition(param_X,param_y);
    }
    public int getSpeedModifier(){
        return slowSpeed;
    }
    public void engageSmoke(){
        this.isVisible = true;
    }
}
