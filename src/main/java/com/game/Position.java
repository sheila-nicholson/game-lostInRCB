/*
 * Position.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game;

public class Position {
    private int X;
    private int Y;

    public Position(){
        this.X = 0;
        this.Y = 0;
    }

    public Position(int param_X, int param_y){
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
    public int getYPosition(){ return this.Y;}


    public void moveUp(int s){this.Y+=s;}
    public void moveDown(int s){this.Y-=s;}
    public void moveRight(int s){this.X-=s;}
    public void moveLeft(int s){this.X+=s;}
}
