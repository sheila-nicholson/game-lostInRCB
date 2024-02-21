package com.game;

import java.awt.*;

public abstract class Item{
    private Image itemSprite;

    public void setItemSprite(Image param_sprite){
        this.itemSprite = param_sprite;
    }
    public Image getItemSprite(){
        return this.itemSprite;
    }

    public int getScoreModifer() {
        return 0;
    }
}
