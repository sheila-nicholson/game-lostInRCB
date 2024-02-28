/*
 * Hero.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Character;

import com.game.Score;

import javax.swing.JPanel;
import javax.swing. JFrame;

public class Hero extends Character implements Score{

    private int currentScore = 100; //default
    protected static Hero instance = null;
    protected boolean alive  = true;
    protected double invincibletime;
    protected boolean isInvincible = false;


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

    public boolean checkScore(){ // iff true terminate game
        return currentScore > 0;
    }

    public int getScore(){ return this.currentScore;}

    public void setScore(int score){

        if(!isInvincible) {
            this.currentScore = score; //temp
        }
    }

    public void addScore(int score){
        this.currentScore += score;
    }

    public void minusScore(int score){
        if(!isInvincible){
            this.currentScore -= score;
            if(!this.checkScore()) {
                alive = false;
            }
        }
    }

    public boolean getAlive(){return this.alive;}

    public void update(){
        if(isInvincible){
            //set runtime out limit
        }

    }

}

