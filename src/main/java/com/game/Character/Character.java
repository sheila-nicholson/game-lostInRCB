/*
 * Character.java
 * 
 * Class Description: Main attributes of all characters in the game.
 *                    Will be present through all iterations of the game in the
 *                    map (not the main menu).
 *
 * Authors: [put your names here]
 * Last modified on: March 5 10:47 AM
 */

package com.game.Character;

import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;
import com.game.Position;
import com.game.UtilityTool;
import javafx.animation.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.dnd.DragGestureEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.DigestException;
import java.util.Random;

public abstract class Character extends Position {

    protected boolean up, down, left, right, fallen;
    // fallen -> vortex effect, false -> enemy with character
    protected Animation currentAnimation;
    public BufferedImage leftImage, rightImage;
    protected GamePanel gamePanel;

    //up1, up2, down1, down2, .... if we still have time
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public boolean onPath = false;


    protected abstract void setDefaultPosition();
    public abstract void getImage();
    public void setAction(){};

    protected Character(int speed, GamePanel gamePanel){
            this.setDefaultPosition();
            this.movementSpeed = speed;
            this.gamePanel = gamePanel;
            this.getImage();
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

    public BufferedImage setImage(String name){
        BufferedImage image = null;
        UtilityTool uTool = new UtilityTool();
        try{
            image = ImageIO.read(getClass().getResourceAsStream( name + ".png"));
            image = uTool.scaleImage(image, gamePanel.tileSize,gamePanel.tileSize);

        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }

    public void setMovementSpeed(int speed){
        this.movementSpeed = speed;
    }
    public void setFallen(boolean f){
        this.fallen = f;
    }

    public void searchPath(int goalCol, int goalRow){
        int startCol = (getXPosition() + solidArea.x)/gamePanel.tileSize;
        int startRow = (getYPosition() + solidArea.y)/gamePanel.tileSize;

        gamePanel.pathFinder.setNode(startCol,startRow,goalCol,goalRow,this);
        if(gamePanel.pathFinder.search() == true){
            //next worldX & worldY
            int nextX = gamePanel.pathFinder.pathList.get(0).col * gamePanel.tileSize;
            int nextY = gamePanel.pathFinder.pathList.get(0).row * gamePanel.tileSize;

            //charater's solidarea position
            int enLeftX = getXPosition() + solidArea.x;
            int enRightX = getXPosition() + solidArea.x + solidArea.width;
            int enTopY = getYPosition() + solidArea.y;
            int enBottomY = getYPosition() + solidArea.y + solidArea.height;

            if(enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gamePanel.tileSize){
                currentDirection = Direction.UP;
            }else if(enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gamePanel.tileSize){
                currentDirection = Direction.DOWN;
            }else if(enTopY >= nextY && enBottomY < nextY + gamePanel.tileSize){
                if(enLeftX > nextX)
                    currentDirection = Direction.LEFT;
                if(enLeftX < nextX)
                    currentDirection = Direction.RIGHT;
            }else if(enTopY > nextY && enLeftX > nextX){
                //up or right
                currentDirection = Direction.UP;
                //checkCollison();
                if(collisionOn)
                    currentDirection = Direction.LEFT;

            }else if(enTopY > nextY && enLeftX < nextX){
                //up or right
                currentDirection = Direction.UP;
                //checkCollison();
                if(collisionOn)
                    currentDirection = Direction.RIGHT;

            }else if(enTopY < nextY && enLeftX > nextX){
                //up or right
                currentDirection = Direction.DOWN;
                //checkCollison();
                if(collisionOn)
                    currentDirection = Direction.LEFT;

            }else if(enTopY < nextY && enLeftX < nextX){
                //up or right
                currentDirection = Direction.DOWN;
                //checkCollison();
                if(collisionOn)
                    currentDirection = Direction.RIGHT;

            }


        }

    }


}
