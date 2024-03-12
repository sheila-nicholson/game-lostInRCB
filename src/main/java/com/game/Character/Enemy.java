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

import static java.lang.Math.abs;

public class Enemy extends Character {

    protected int damagePoints = 0;
    protected int movementSpeed;
    protected boolean collision = false;
    public int actionCounter = 0;

    //override by other classes
    protected void setDefaultPosition() {
    }

    public void getImage() {
    }

    public Enemy(int speed, GamePanel gamePanel) {
        super(speed, gamePanel);
        this.movementSpeed = speed;
        this.solidArea = new Rectangle(0, 0, 1, 1);
//        this.setPosition(gamePanel.screenWidth - 2 * gamePanel.tileSize, gamePanel.screenHeight - 2 * gamePanel.tileSize);
        this.setPosition(16 * gamePanel.tileSize, 16* gamePanel.tileSize);
        this.solidAreaDefaultX = gamePanel.tileSize;
        this.solidAreaDefaultY = gamePanel.tileSize;
        this.solidArea = new Rectangle();
        this.solidArea.x = 0;
        this.solidArea.y = 0;
        this.solidArea.width = this.solidAreaDefaultX - 3;
        this.solidArea.height = this.solidAreaDefaultY - 3;
    }

    public void setAction() {
        actionCounter++;
        Random random = new Random();
        int i = random.nextInt(100) + 1;

        if (actionCounter == 180) {//temp
            if (i <= 25) {
                currentDirection = Direction.UP;
            } else if (i <= 50) {
                currentDirection = Direction.DOWN;
            } else if (i <= 75) {
                currentDirection = Direction.LEFT;
            } else {
                currentDirection = Direction.RIGHT;
            }
        }
    }

    public void positionToggle(){
        if(currentDirection == Direction.RIGHT){
            currentDirection = Direction.LEFT;
        }else if(currentDirection == Direction.LEFT){
            currentDirection = Direction.RIGHT;
        }else if(currentDirection == Direction.DOWN){
            currentDirection = Direction.UP;
        }else{
            currentDirection = Direction.DOWN;
        }
    }

    public Direction update() {

        setAction();
        this.collisionOn = false; //temp
        reachedEndOn = false;
        gamePanel.collisionChecker.checkTile(this);

        while(collisionOn){
            this.collisionOn = false;
            setAction();
//            positionToggle();
            gamePanel.collisionChecker.checkTile(this);
        }

        if(!collisionOn) {
            switch (currentDirection) {
                case UP:
                    this.moveUp(movementSpeed);
//                    this.setPosition(gamePanel.screenWidth,gamePanel.screenHeight);
                    return Direction.UP;
//                   break;
                case DOWN:
                    this.moveDown(movementSpeed);
                    return Direction.DOWN;
//                    break;
                case LEFT:

                    this.moveLeft(movementSpeed);
                    return Direction.LEFT;
//                break;
                case RIGHT:

                    this.moveRight(movementSpeed);
                    return Direction.RIGHT;
//                break;
            }
        }

        return Direction.DOWN;
    }

}
