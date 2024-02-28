/*
 * Tile.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */
3

package com.game.Tile;

import com.game.Position;

import java.awt.*;

public abstract class Tile extends Position {
    private Image tileSprite;

    public Image getTileSprite() {
        return this.tileSprite;
    }
    public void setTileSprite(Image param_sprite){
        this.tileSprite = param_sprite;
    }
}
