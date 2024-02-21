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

    public void setPosition(int param_X, int param_y){
        this.X = param_X;
        this.Y = param_y;
    }

    public int getXPosition(){
        return this.X;
    }

    public int getYPosition(){
        return this.Y;
    }
}
