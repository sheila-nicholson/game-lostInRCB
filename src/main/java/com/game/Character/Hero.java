package com.game.Character;

import com.game.Score;

public class Hero extends Character implements Score {
    private int currentScore;
    protected static Hero instance = null;
    protected void setDefaultPosition(){
        this.setPosition(100,100);//temp
    }
    protected Hero(int speed){
        super(speed);
        this.currentScore = 100; //temp
    }
    public static synchronized Hero getInstance(int speed) {
        if (instance == null) {
            instance = new Hero(speed);
        }else{
            instance.movementSpeed = speed;
        }
        return instance;
    }

    public boolean checkScore(){
        return currentScore > 0;
    }

    public int getScore(){
        return this.currentScore;
    }

    public void setScore(int score){
        this.currentScore = score; //temp
    }

}
