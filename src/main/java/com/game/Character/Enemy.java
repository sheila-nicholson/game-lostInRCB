/*
 * Enemy.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Character;

import java.io.IOException;

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

    public void update(){};
    public void draw (){};
    public void getImage(){
//        try{
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    };
}
