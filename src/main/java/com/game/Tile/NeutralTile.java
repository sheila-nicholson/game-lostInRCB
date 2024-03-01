/*
 * NeutralTile.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Tile;

import java.awt.*;

public class NeutralTile extends Tile {
    NeutralTile(Image param_sprite, int param_X, int param_y){
        setTileSprite(param_sprite);
        setPosition(param_X,param_y);
    }
}
