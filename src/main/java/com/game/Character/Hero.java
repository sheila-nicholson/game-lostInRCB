package com.game.Character2;

import com.game.Score;

public class Hero extends Character implements Score {
    private int currentScore;
    protected void setDefaultPosition(){
        this.setPosition(100,100);//temp
    }
    private Hero(int speed){
        super(speed);
        this.score = 100; //temp
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
        return score > 0;
    }

    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score; //temp
    }

}
