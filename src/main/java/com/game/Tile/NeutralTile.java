/*
 * NeutralTile.java
 * 
 * Class Description: Describes all other tiles on the map that don't provide an advantage or a detriment to the character.
 *
 * Authors: [put your names here] + Brendan
 * Last modified on: March 6, 2024 1:46 AM
 */


package com.game.Tile;

import java.awt.*;

public class NeutralTile extends Tile {

    private Image tileSprite;
    private boolean tileSteppability;

/*    NeutralTile(Image param_sprite, int param_X, int param_y){
        setTileSprite(param_sprite);
        setPosition(param_X,param_y);
    }*/

    public boolean tileSteppable() {
        return this.tileSteppability;
    }
}
