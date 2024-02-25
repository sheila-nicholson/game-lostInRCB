package com.game;

public class Hero extends Character implements Score{
    private int currentScore;
    private Hero(){
        super();
        this.score = 100; //temp
    }

    public void checkScore(){
        return score > 0;
    }

    public getScore(){
        return this.score;
    }

    public void setScore(){
        this.score = 100; //temp
    }

}
