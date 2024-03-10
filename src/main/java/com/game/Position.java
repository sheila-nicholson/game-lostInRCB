/*
 * Position.java
 * 
 * Class Description: Reflects the position of all entities (character/items) primarily.
 *
 * Authors: [put your names here]
 * Last modified on: March 6, 2024 1:51 AM
 */


package com.game;

import com.game.Key.Direction;

import java.awt.*;

public class Position {
    private int X;
    private int Y;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 48;
    public int solidAreaDefaultY = 48;
    protected Direction currentDirection;
    protected int movementSpeed;
    protected boolean collisionOn;

    public Position(){ // default constructor
        this.X = 0;
        this.Y = 0;
    }

    public Position(int param_X, int param_y){ // parameterized constructor
        this.X = param_X;
        this.Y = param_y;
    }

    public void setPosition(int param_X, int param_y){ // setter
        this.X = param_X;
        this.Y = param_y;
    }

    public int getXPosition(){ // getter X
        return this.X;
    }
    public int getYPosition(){ // getter Y
        return this.Y;
    }

    public void moveUp(int s){this.Y-=s;}
    public void moveDown(int s){this.Y+=s;}
    public void moveRight(int s){this.X+=s;}
    public void moveLeft(int s){this.X-=s;}


}
