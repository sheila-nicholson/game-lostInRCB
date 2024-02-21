package com.game;

import java.awt.*;

public class badTile extends Tile{
    private punishmentItem tileItem;

    badTile(punishmentItem param_item, Image param_image){
        this.tileItem = param_item;
        setTileSprite(param_image);
    }

    public punishmentItem getTileItem(){
        return this.tileItem;
    }
}
