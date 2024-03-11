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
import com.game.Key.Direction;
import com.game.Key.KeyHandler;
import com.game.Score;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Hero extends Character implements Score{

    private int currentScore = 0; //default should be 0...
    protected static Hero instance = null;
    protected boolean alive  = true;
    protected double invincibletime;
    protected boolean isInvincible = false;
    // invincibility not required since in phase 1 we discussed
    // whenever the hero goes through the vortex there's a minimum distance
    // they spawn away from any threats
    protected KeyHandler keyHandler;
    protected GamePanel gamePanel;

    // deliberate choice to spawn on opposite corner (as far as away as possible)
    // from enemy
    protected void setDefaultPosition(){
        //    this.setPosition(this.gamePanel.tileSize,this.gamePanel.tileSize);
        this.setPosition(100,0);
        currentDirection = Direction.RIGHT;
        lastDirection = Direction.RIGHT;
    }

    protected Hero(int speed, KeyHandler keyHandler, GamePanel gamePanel){
        super(speed);
        this.keyHandler = keyHandler;
        this.gamePanel = gamePanel;
        this.solidAreaDefaultX = gamePanel.tileSize;
        this.solidAreaDefaultY = gamePanel.tileSize;
        this.setDefaultPosition();
        getImage();

    }

    public void getImage() {
        try{
            rightImage = ImageIO.read(getClass().getResourceAsStream("/Hero/Student_right.png"));
            leftImage = ImageIO.read(getClass().getResourceAsStream("/Hero/Student_left.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        switch (currentDirection){
            case LEFT:
                image = leftImage;
                break;
            case RIGHT:
                image = rightImage;
                break;
            default:
                image = (lastDirection == Direction.LEFT)?leftImage:rightImage;
                break;
        }
        g2.drawImage(image,this.getXPosition(), this.getYPosition(), gamePanel.tileSize,gamePanel.tileSize,null);

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

        // Check object collision:
        int itemIndex = gamePanel.collisionChecker.checkObject(this, true);
        pickUpItem(itemIndex);
    }

    public void pickUpItem(int itemIndex) {

        if(itemIndex != 999) {
            gamePanel.item[itemIndex].collisionAction();    // to be implemented
            gamePanel.item[itemIndex] = null;

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
        if(!isInvincible){ // what scenario exists that requires invincibility?
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

