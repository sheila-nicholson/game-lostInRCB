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
