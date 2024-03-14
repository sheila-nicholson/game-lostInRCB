/*
 * Hero.java
 * 
 * Class Description: Main attributes of the character (hero) controlled
 *                    by the player throughout the levels.
 *
 * Authors: [put your names here]
 * Last modified on: March 5, 11:44 AM
 */
package com.game.Character;

import com.game.GamePanel.GamePanel;
import com.game.Items.Item;
import com.game.Key.Direction;
import com.game.Key.KeyHandler;
import com.game.Score;

import java.awt.*;

public class Hero extends Character implements Score{

    private int currentScore = 0;
    protected static Hero instance = null;
    protected boolean alive  = true;
    protected boolean isInvincible = false;
    protected double invincibletime;
    // invincibility not required since in phase 1 we discussed
    // whenever the hero goes through the vortex there's a minimum distance
    // they spawn away from any threats
    protected KeyHandler keyHandler;

    // deliberate choice to spawn on opposite corner (as far as away as possible)
    // from enemy
    protected void setDefaultPosition(){
        //    this.setPosition(this.gamePanel.tileSize,this.gamePanel.tileSize);
        this.setPosition(100,0);
        currentDirection = Direction.RIGHT;
        lastDirection = Direction.RIGHT;
    }

    protected Hero(int speed, KeyHandler keyHandler, GamePanel gamePanel){
        super(speed,gamePanel);
        this.keyHandler = keyHandler;
        this.gamePanel = gamePanel;
        this.solidAreaDefaultX = gamePanel.tileSize;
        this.solidAreaDefaultY = gamePanel.tileSize;
        this.setDefaultPosition();
        this.solidArea = new Rectangle();
        this.solidArea.x = 0;
        this.solidArea.y = 0;
        this.solidArea.width = this.solidAreaDefaultX-5;
        this.solidArea.height = this.solidAreaDefaultY-5;

        getImage();
    }

    public void getImage() {

        rightImage = setImage("/Hero/Student_right");
        leftImage = setImage("/Hero/Student_left");
    }

    public void update(){
        //not finished
        //        if(isInvincible){
        //
        //        }

        if(keyHandler.getPressed(Direction.UP)){

            this.currentDirection = Direction.UP;
            this.moveUp(movementSpeed);

        }else if (keyHandler.getPressed(Direction.DOWN)) {

            this.currentDirection = Direction.DOWN;
            this.moveDown(movementSpeed);

        }else if (keyHandler.getPressed(Direction.LEFT)) {

            this.lastDirection = this.currentDirection;
            this.currentDirection = Direction.LEFT;
            this.moveLeft(movementSpeed);

        }else if (keyHandler.getPressed(Direction.RIGHT)) {

            this.lastDirection = this.currentDirection;
            this.currentDirection = Direction.RIGHT;
            this.moveRight(movementSpeed);

        }

        //check enemy collision
        int enemyIndex = gamePanel.collisionChecker.checkEnemy(this,true);
        interactEnemy(enemyIndex);

        // Check object collision:
        int itemIndex = gamePanel.collisionChecker.checkObject(this, true);
        pickUpItem(itemIndex);
    }

    public void interactEnemy(int enemyIndex){
        System.out.println("collision"); //for testing
    }

    public void pickUpItem(int itemIndex) {

         Item[] item = gamePanel.getItem();
        if(itemIndex != 999) {
            item[itemIndex].collisionAction();    // to be implemented
            item[itemIndex] = null;

        }
    }

    public static synchronized Hero getInstance(int speed,KeyHandler keyHandler,GamePanel gamePanel) {
        if (instance == null) {
            instance = new Hero(speed,keyHandler,gamePanel);
        }
        return instance;
    }

    public boolean checkScore(){
        return currentScore > 0;
    }

    public int getScore(){ return this.currentScore;} // GETTER

    public void setScore(int score){ // SETTER

        if(!isInvincible) {
            this.currentScore = score; 
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

    public void deathAnimation() {
        // graphics
    }

}

