package com.game.Tile;

import com.game.Items.RewardItem;

import java.awt.*;

public class GoodTile extends Tile {
    private RewardItem tileItem;

    GoodTile(RewardItem param_item, Image param_image, int param_X, int param_y){
        this.tileItem = param_item;
        setPosition(param_X,param_y);
        setTileSprite(param_image);
    }
    public RewardItem getTileItem(){
        return this.tileItem;
    }
}
