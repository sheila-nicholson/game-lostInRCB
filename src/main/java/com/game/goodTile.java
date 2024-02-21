package com.game;

import java.awt.*;

public class goodTile extends Tile{
    private rewardItem tileItem;

    goodTile(rewardItem param_item, Image param_image){
        this.tileItem = param_item;
        setTileSprite(param_image);
    }
    public rewardItem getTileItem(){
        return this.tileItem;
    }
}
