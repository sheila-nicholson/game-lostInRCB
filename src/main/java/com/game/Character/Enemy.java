package com.game.Character;

public class Enemy extends Character {

    protected static Enemy instance = null;
    protected void setDefaultPosition(){
        this.setPosition(0,100);//temp
    }

    protected Enemy(int speed){
        super(speed);
    }
    public static synchronized Enemy getInstance(int speed) {
        if (instance == null) {
            instance = new Enemy(speed);
        }
        return instance;
    }
}
