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

import java.awt.*;
import java.io.IOException;

public class Enemy extends Character {

    protected int damagePoints = 0;
    protected int movementSpeed = 0; // variable based on level
    
    protected static Enemy instance = null;
    protected void setDefaultPosition(){
        this.setPosition(0,100); // temporary value at NW corner
        // easier to set enemy's position consistently since there's three different
        // enemies (one for each level)
        // upon selecting difficulty level either character's position is also
        // static or spawns closer to the enemy with each harder difficulty
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
    public void draw (Graphics2D g2){};
    public void getImage(){

//        try{
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    };

    // call moveCharacter with traversing salesman algorithm to hunt for Hero

    public void damagePlayer() {
/* 
        if (position of enemy == position of hero) {
            end the current level with current score and display result
        }

    */

    }

    public int scoreModifier() {

/*
 *      if (game is ended) {
 * 
 *          damagePoints -= 20; // arbitrary value?
 * 
 *      }
 * 
 */

    }
}
