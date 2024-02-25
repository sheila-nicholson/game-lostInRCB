package com.game;

import java.awt.*;

public class NeutralTile extends Tile{
    NeutralTile(Image param_sprite, int param_X, int param_y){
        setTileSprite(param_sprite);
        setPosition(param_X,param_y);
    }
}
