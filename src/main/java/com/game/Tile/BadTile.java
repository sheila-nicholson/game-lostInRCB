/*
 * BadTile.java
 * 
 * Class Description: Details all tiles that if stepped on provide a negative effect to the player (such as punishment items)
 *
 * Authors: [put your names here] + Brendan
 * Last modified on: March 6, 2024 1:30 AM
 */


package com.game.Tile;

import com.game.Items.PunishmentItem;

import java.awt.*;

public class BadTile extends Tile {
    private PunishmentItem tileItem;
    private Image tileSprite;
    private boolean tileSteppability;

    BadTile(PunishmentItem param_item, Image param_image, int param_X, int param_y){
        this.tileItem = param_item;
        setPosition(param_X,param_y);
        setTileSprite(param_image);
    }

    public Item getTileItem() {
        return this.tileItem;
    }

    public boolean tileSteppable() {
        return this.tileSteppability;
    }
}
