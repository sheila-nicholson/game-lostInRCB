/*
 * Item.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Items;

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
