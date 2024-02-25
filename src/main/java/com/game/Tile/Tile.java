package com.game;

import java.awt.*;

public abstract class Tile extends Position{
    private Image tileSprite;

    public Image getTileSprite() {
        return this.tileSprite;
    }
    public void setTileSprite(Image param_sprite){
        this.tileSprite = param_sprite;
    }
}
