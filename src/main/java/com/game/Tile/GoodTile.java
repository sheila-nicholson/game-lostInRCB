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

    GoodTile(boolean tileSteppability, boolean isLevelEndBool){
        this.tileSteppability = tileSteppability;
        this.isLevelEndBool = isLevelEndBool;
    };


}
