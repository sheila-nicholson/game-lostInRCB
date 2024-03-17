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

import com.game.GamePanel.GamePanel;
import com.game.Position;

import java.awt.*;
import java.awt.image.BufferedImage;
import com.game.Character.Hero;

public abstract class Item extends Position {

    public BufferedImage image;
    public String name;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 48;
    public int solidAreaDefaultY = 48;
    public boolean collision = true;
    protected GamePanel gamePanel;
    protected int xCoordinate;
    protected int yCoordinate;

    public void draw(Graphics2D g2, GamePanel gp) {

        int screenX = getXPosition();
        int screenY = getYPosition();

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

    public void updateItemState() {

    }

    public void collisionAction(Hero hero) {

    }

    public void setPosition(int param_X, int param_y) { // setter
        xCoordinate = param_X;
        yCoordinate = param_y;
        super.setPosition(param_X * 48, param_y * 48);
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    private Image itemSprite;
    private int modifierSeconds; //not sure what this used for, but still fix it
    private int timeAvaliable;

    public void setItemSprite(Image param_sprite){
        this.itemSprite = param_sprite;
    }
    public Image getItemSprite(){
        return this.itemSprite;
    }
//    public int getScoreModifer() {
//        return 0;
//    }
    public int getModifierSeconds() { // addition -> necessary?
        return this.modifierSeconds;
    }

    public int getTimeAvaliable() { // addition -> necessary?
        return this.timeAvaliable;
    }
}
