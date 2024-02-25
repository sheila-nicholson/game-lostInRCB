package com.game.Character2;

public class Enemy extends java.lang.Character {
    protected void setDefaultPosition(){
        this.setPosition(0,100);//temp
    }

    private Enemy(int speed){
        super((char)speed);
        this.score = 100; //temp
    }
    public static synchronized Enemy getInstance(int speed) {
        if (instance == null) {
            instance = new Enemy(speed);
        }else{
            instance.movementSpeed = speed;
        }
        return instance;
    }
}
