/*
 * Enemy.java
 * 
 * Class Description: Main attributes of all three enemies who will chase the player.
 *                    If they make contact with the character the game ends in a loss.
 *
 * Authors: [put your names here]
 * Last modified on: March 5 11:27 AM
 */


package com.game.Character;

import com.game.Key.Direction;

import java.awt.*;
import java.io.IOException;

public class Enemy extends Character {

    protected int damagePoints = 0;
    protected int movementSpeed = 0;
    protected boolean collision = false;

    protected static Enemy instance = null;

    protected void setDefaultPosition(){
        this.setPosition(0,100);
        currentDirection = Direction.RIGHT;
        lastDirection = Direction.RIGHT;
    }

    protected Enemy(int speed){
        super(speed);
        this.setDefaultPosition();
    }

    public static synchronized Enemy getInstance(int speed) {
        if (instance == null) {
            instance = new Enemy(speed);
        }
        return instance;
    }

    public void update(){};
    public void draw (Graphics2D g2){};
    public void getImage(){

//        try{
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    };


    public void damagePlayer() {
/*
        if (position of enemy == position of hero) {
            end the current level with current score and display result
        }

    */
    }
}
