/*
 * Hero.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game.Character;

import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;
import com.game.Key.Key;
import com.game.Key.KeyHandler;
import com.game.Score;

import javax.swing.JPanel;
import javax.swing. JFrame;
import java.awt.*;

public class Hero extends Character implements Score{

    private int currentScore = 100; //default
    protected static Hero instance = null;
    protected boolean alive  = true;
    protected double invincibletime;
    protected boolean isInvincible = false;
    protected KeyHandler keyHandler;
    protected GamePanel gamePanel;


    protected void setDefaultPosition(){
        this.setPosition(100,100);//temp
    }

    protected Hero(int speed, KeyHandler keyHandler, GamePanel gamePanel){
        super(speed);
        this.keyHandler = keyHandler;
        this.gamePanel = gamePanel;
        this.setDefaultPosition();
    }

    public void getImage(){
//        try{
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }

    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(this.getXPosition(),this.getYPosition(),gamePanel.tileSize,gamePanel.tileSize);

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

            this.currentDirection = Direction.LEFT;
            this.moveLeft(movementSpeed);

        }else if (keyHandler.getPressed(Direction.RIGHT)) {

            this.currentDirection = Direction.RIGHT;
            this.moveRight(movementSpeed);

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


}

