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

/**
 * Abstract base class for all game characters, providing common attributes and functionality.
 * <p>
 * This class encapsulates the main attributes shared by all characters present in the game world,
 * excluding the main menu. It includes movement mechanics, animation handling, and collision detection,
 * among others. Characters derived from this class can be either player-controlled or AI-driven entities
 * within the game environment.
 *
 * @author Yanjun Qian
 */
public abstract class Character extends Position {

    protected boolean up, down, left, right, fallen;
    // fallen -> vortex effect, false -> enemy with character
    protected Animation currentAnimation;
    public BufferedImage leftImage, rightImage;
    protected GamePanel gamePanel;

    //up1, up2, down1, down2, .... if we still have time
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public boolean onPath = true; //temp for testing

    /**
     * Sets the default position of the character within the game world.
     * Must be implemented by subclasses to define initial character placement.
     */
    protected abstract void setDefaultPosition();

    /**
     * Loads the character's image resources.
     * Must be implemented by subclasses to specify character appearance.
     */
    public abstract void getImage();

    /**
     * Performs the character's current action, which may include movement or other behaviors.
     * Can be overridden by subclasses to define specific character actions.
     */
    public void setAction(){};

    /**
     * Constructs a Character with specified movement speed and associates it with a game panel.
     *
     * @param speed the movement speed of the character
     * @param gamePanel the game panel the character belongs to
     */
    protected Character(int speed, GamePanel gamePanel){
            this.setDefaultPosition();
            this.movementSpeed = speed;
            this.gamePanel = gamePanel;
            this.getImage();
    }

    /**
     * Draws the character on the game panel.
     *
     * @param g2 the Graphics2D object used for drawing
     */
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

    /**
     * Sets the image for the character based on the provided name.
     *
     * @param name the name of the image resource
     * @return the scaled BufferedImage of the character
     */
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

    /**
     * Updates the character's movement speed.
     *
     * @param speed the new movement speed of the character
     */
    public void setMovementSpeed(int speed){
        this.movementSpeed = speed;
    }

    /**
     * Sets the character's fallen state, affecting its interaction with vortex effects.
     *
     * @param f the new fallen state
     */
    public void setFallen(boolean f){
        this.fallen = f;
    }

    /**
     * Checks for and handles collisions with various game elements.
     */
    public void checkCollision() {
        gamePanel.collisionChecker.checkTile(this);
        gamePanel.collisionChecker.checkItem(this,false);
        gamePanel.collisionChecker.checkPlayer(this);
        gamePanel.collisionChecker.checkCharacter(this,gamePanel.getHero());
        gamePanel.collisionChecker.checkCharacter(this,gamePanel.getEnemy());
    }

    /**
     * Initiates pathfinding from the character's current position to a specified goal.
     *
     * @param goalCol the column index of the goal position
     * @param goalRow the row index of the goal position
     */
    public void searchPath(int goalCol, int goalRow){
        int startCol = (getXPosition() + solidArea.x)/gamePanel.tileSize;
        int startRow = (getYPosition() + solidArea.y)/gamePanel.tileSize;

        gamePanel.pathFinder.setNode(startCol,startRow,goalCol,goalRow,this);
        if(gamePanel.pathFinder.search()){
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
                checkCollision();
                if(collisionOn)
                    currentDirection = Direction.LEFT;


            }else if(enTopY > nextY && enLeftX < nextX){
                //up or right
                currentDirection = Direction.UP;
                checkCollision();
                if(collisionOn)
                    currentDirection = Direction.RIGHT;


            }else if(enTopY < nextY && enLeftX > nextX){
                //down and left
                currentDirection = Direction.DOWN;
                checkCollision();
                if(collisionOn)
                    currentDirection = Direction.LEFT;


            }else if(enTopY < nextY && enLeftX < nextX){
                //up or right
                currentDirection = Direction.DOWN;
                checkCollision();
                if(collisionOn)
                    currentDirection = Direction.RIGHT;


            }
        }

    }

}
