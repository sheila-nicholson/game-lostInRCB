package com.game;

import java.awt.*;

public class goodTile extends Tile{
    private rewardItem tileItem;

    goodTile(rewardItem param_item, Image param_image, int param_X, int param_y){
        this.tileItem = param_item;
        setPosition(param_X,param_y);
        setTileSprite(param_image);
    }
    public rewardItem getTileItem(){
        return this.tileItem;
    }
}
