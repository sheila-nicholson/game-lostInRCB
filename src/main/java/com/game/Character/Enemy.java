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

import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;

import java.awt.*;
import java.util.Random;

public class Enemy extends Character {

    protected int damagePoints = 0;
    protected int movementSpeed;
    protected boolean collision = false;
    public int actionCounter = 0;

    //override by other classes
    protected void setDefaultPosition(){}
    public void getImage() {}

    public Enemy(int speed, GamePanel gamePanel){
        super(speed,gamePanel);
        this.movementSpeed = speed;
        this.solidAreaDefaultX = gamePanel.tileSize;
        this.solidAreaDefaultY = gamePanel.tileSize;
        this.setDefaultPosition();
        this.solidArea = new Rectangle();
        this.solidArea.x = 0;
        this.solidArea.y = 0;
        this.solidArea.width = this.solidAreaDefaultX-5;
        this.solidArea.height = this.solidAreaDefaultY-5;
    }

    public void setAction(){

        if(onPath == true){
            int goalCol = gamePanel.getHero().getXPosition() + (gamePanel.getHero().solidArea.x)/gamePanel.tileSize;
            int goalRow = gamePanel.getHero().getYPosition() + (gamePanel.getHero().solidArea.y)/gamePanel.tileSize;

            searchPath(goalCol,goalRow);
        }
        actionCounter ++;
        Random random = new Random();
        int i = random.nextInt(100)+1;

    if(actionCounter == 180){//temp
            if (i <= 25) {
                currentDirection = Direction.UP;
            } else if (i <= 50) {
                currentDirection = Direction.DOWN;
            } else if (i <= 75) {
                currentDirection = Direction.LEFT;
            }else{
                currentDirection = Direction.RIGHT;
            }
        }
    }


    public void checkCollision(){//update later 22:33/46:44
        collisionOn = false;
//      gamePanel.collisionChecker.
    }

    public void update(){
        //check collison
        //checkCollision();
        collisionOn = false;
        setAction();
        this.collisionOn = false; //temp
        gamePanel.collisionChecker.checkTile(this);
        if(!collisionOn){
            switch (currentDirection){
                case UP: this.moveUp(movementSpeed); break;
                case DOWN: this.moveDown(movementSpeed); break;
                case LEFT:  this.moveLeft(movementSpeed); break;
                case RIGHT:  this.moveRight(movementSpeed); break;
            }
        }
    }
}
