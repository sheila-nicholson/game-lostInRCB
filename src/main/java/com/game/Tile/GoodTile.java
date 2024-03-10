/*
 * GoodTile.java
 * 
 * Class Description: Details all tiles that if stepped on provide a positive effect to the player (such as reward items)
 *
 * Authors: [put your names here] + Brendan
 * Last modified on: March 6, 2024 1:34 AM
 */


package com.game.Tile;

import com.game.Items.RewardItem;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GoodTile extends Tile {
    private RewardItem tileItem;
    private boolean tileSteppability;

/*    GoodTile(RewardItem param_item, Image param_image, int param_X, int param_y){
        this.tileItem = param_item;
        setPosition(param_X,param_y);
        setTileSprite(param_image);
    }*/
    GoodTile(){};
    public RewardItem getTileItem(){
        return this.tileItem;
    }

    public boolean tileSteppable() {
        return this.tileSteppability;
    }
}
