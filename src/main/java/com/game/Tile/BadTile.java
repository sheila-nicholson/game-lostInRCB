/*
 * BadTile.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Tile;

import com.game.Items.PunishmentItem;

import java.awt.*;

public class BadTile extends Tile {
    private PunishmentItem tileItem;

    BadTile(PunishmentItem param_item, Image param_image, int param_X, int param_y){
        this.tileItem = param_item;
        setPosition(param_X,param_y);
        setTileSprite(param_image);
    }

    public PunishmentItem getTileItem(){
        return this.tileItem;
    }
}
