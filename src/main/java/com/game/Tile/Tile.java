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
    private boolean tileSteppable;

    public Image getTileSprite() {
        return this.tileSprite;
    }
    public void setTileSprite(BufferedImage param_sprite){
        this.tileSprite = param_sprite;
    }

    public boolean tileSteppable() {
        return this.tileSteppable;
    }
}
