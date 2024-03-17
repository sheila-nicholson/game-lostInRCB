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
    public int actionCounter = 0;

    //override by other classes
    protected void setDefaultPosition(){
        currentDirection = Direction.RIGHT;
        lastDirection = Direction.RIGHT;
    }
    public void getImage() {}

    public Enemy(int speed, GamePanel gamePanel) {
        super(speed, gamePanel);
        this.movementSpeed = speed;
        this.solidAreaDefaultX = gamePanel.tileSize;
        this.solidAreaDefaultY = gamePanel.tileSize;
        this.solidArea = new Rectangle(0, 0, this.solidAreaDefaultX-3, this.solidAreaDefaultY-3);
        setDefaultPosition();
        this.setPosition(2 * gamePanel.tileSize, 14* gamePanel.tileSize);
    }

    @Override
    public void checkCollision() {
        gamePanel.collisionChecker.checkTile(this);
        gamePanel.collisionChecker.checkPlayer(this);
        int index = gamePanel.collisionChecker.checkCharacter(this,gamePanel.getHero());
        if(index != 999){
            System.exit(0);//test for terminating the game after collision between enemy and hero
        }
    }

    public void setAction() {

        if(onPath){

                int goalCol = (gamePanel.getHero().getXPosition() + gamePanel.getHero().solidArea.x)/gamePanel.tileSize;
                int goalRow = (gamePanel.getHero().getYPosition() + gamePanel.getHero().solidArea.y)/gamePanel.tileSize;
                searchPath(goalCol,goalRow);

        }else{

            actionCounter++;
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (actionCounter == 2) {//temp
                if (i <= 25) {
                    currentDirection = Direction.UP;
                } else if (i <= 50) {
                    currentDirection = Direction.DOWN;
                } else if (i <= 75) {
                    currentDirection = Direction.LEFT;
                } else {
                    currentDirection = Direction.RIGHT;
                }
                gamePanel.collisionChecker.checkTile(this);
            }

        }

    }

    public Direction update() {

        reachedEndOn = false;
        collisionOn = false;
        checkCollision();
        setAction();

        if(!collisionOn) {
            switch (currentDirection) {
                case UP:
                    this.moveUp(movementSpeed);
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
