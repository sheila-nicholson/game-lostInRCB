package com.game.Items;

import com.game.GamePanel.GamePanel;
import com.game.Position;

import java.awt.*;
import java.awt.image.BufferedImage;
import com.game.Character.Hero;
import com.game.UtilityTool;

/**
 * Serves as the base class for all items in the game, defining common properties and methods.
 * <p>
 * This abstract class extends {@link Position} to include positional data and implements common
 * item behaviors such as drawing the item on the screen, handling item state updates, and defining
 * collision actions. Specific item classes extend this base class to implement item-specific
 * behaviors and effects.
 */
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
    public ItemType itemType;
    public UtilityTool utilityTool = new UtilityTool();


    /**
     * Draws the item on the game panel.
     *
     * @param g2 The Graphics2D object used for drawing.
     * @param gp The game panel where the item is to be drawn.
     */
    public void draw(Graphics2D g2, GamePanel gp) {

        int screenX = getXPosition();
        int screenY = getYPosition();

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

    /**
     * Updates the state of the item. Override in subclasses to implement state logic.
     */
    public void updateItemState() {

    }

    /**
     * Defines the action to take when the item collides with the Hero. Override in subclasses.
     *
     * @param hero The Hero character with which the item has collided.
     */
    public void collisionAction(Hero hero) {}

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
