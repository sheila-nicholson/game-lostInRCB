/*
 * Tile.java
 * 
 * Class Description: Sums up all main attributes of all tiles (all types) in the game.
 *
 * Authors: [put your names here] + Brendan
 * Last modified on: March 6, 2024 1:48 AM
 */


package com.game.Tile;

import com.game.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile extends Position {
    private BufferedImage tileSprite;
    public boolean collision = false;
    public boolean levelEnd = false;
    protected boolean tileSteppability;
    protected boolean isLevelEndBool;
    protected boolean isMysteriousSmokeTileBool;
    protected String tileType;

    public Image getTileSprite() {
        return this.tileSprite;
    }
    public void setTileSprite(BufferedImage param_sprite){
        this.tileSprite = param_sprite;
    }
    public boolean tileSteppable() {
        return this.tileSteppability;
    }
    public boolean isLevelEnd() {
        return this.isLevelEndBool;
    }
    public boolean isMysteriousSmokeTile(){
        return this.isMysteriousSmokeTileBool;
    }
    public void setTileType(String inp){
        this.tileType = inp;
    }
    public String getTileType(){
        return this.tileType;
    }
    public int getTileTypeIndex(){
        if (this.getTileType() == "outer wall"){
            return 0;
        }
        else if (this.getTileType() == "start"){
            return 1;
        }
        else if (this.getTileType() == "inner wall") {
            return 2;
        }
        else if (this.getTileType() == "floor"){
            return 3;
        }
        else if (this.getTileType() == "end"){
            return 4;
        }
        else if (this.getTileType() == "smoke"){
            return 5;
        }
        else{
            return 0;
        }
    }
}
