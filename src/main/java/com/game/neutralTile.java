package com.game;

import java.awt.*;

public class neutralTile extends Tile{
    neutralTile(Image param_sprite, int param_X, int param_y){
        setTileSprite(param_sprite);
        setPosition(param_X,param_y);
    }
}
