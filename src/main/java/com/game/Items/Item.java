/*
 * Item.java
 * 
 * Class Description: Main attributes of all positive (reward) and negative (punishment) items in the game.
 *                    Only present during game runtime throughout a level.
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:11 AM
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

    public int getModifierSeconds() { // addition -> necessary?
        return this.modifierSeconds;
    }

    public int getTimeAvaliable() { // addition -> necessary?
        return this.timeAvaliable;
    }
}
