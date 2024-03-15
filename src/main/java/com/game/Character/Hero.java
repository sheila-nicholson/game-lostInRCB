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
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
    public int coffeeTimeEnd;
    public int currentTime;



    // deliberate choice to spawn on opposite corner (as far as away as possible)
    // from enemy
    protected void setDefaultPosition(){
        //    this.setPosition(this.gamePanel.tileSize,this.gamePanel.tileSize);
        this.setPosition(50,0);
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

    public void update() throws IOException {
        //not finished
        //        if(isInvincible){
        //
        //        }
        if(keyHandler.getPressed(Direction.UP)){

            this.currentDirection = Direction.UP;
            //this.moveUp(movementSpeed);

        }else if (keyHandler.getPressed(Direction.DOWN)) {

            this.currentDirection = Direction.DOWN;
            //this.moveDown(movementSpeed);

        }else if (keyHandler.getPressed(Direction.LEFT)) {

            this.lastDirection = this.currentDirection;
            this.currentDirection = Direction.LEFT;
            //this.moveLeft(movementSpeed);

        }else if (keyHandler.getPressed(Direction.RIGHT)) {

            this.lastDirection = this.currentDirection;
            this.currentDirection = Direction.RIGHT;
            //this.moveRight(movementSpeed);

        }
        //chec tile collision
        collisionOn = false;
        //System.out.println(collisionOn);
        gamePanel.collisionChecker.checkTile(this);
        if (collisionOn == false){
            if(keyHandler.getPressed(Direction.UP)){
                //this.currentDirection = Direction.UP;
                this.moveUp(movementSpeed);

            }else if (keyHandler.getPressed(Direction.DOWN)) {

                //this.currentDirection = Direction.DOWN;
                this.moveDown(movementSpeed);

            }else if (keyHandler.getPressed(Direction.LEFT)) {

                //this.lastDirection = this.currentDirection;
                //this.currentDirection = Direction.LEFT;
                this.moveLeft(movementSpeed);

            }else if (keyHandler.getPressed(Direction.RIGHT)) {

                //this.lastDirection = this.currentDirection;
                //this.currentDirection = Direction.RIGHT;
                this.moveRight(movementSpeed);

            }
        }
        //chec tile collision
        collisionOn = false;
        reachedEndOn = false;
        mysteriousSmokeTileOn = false;
        //System.out.println(collisionOn);
        gamePanel.collisionChecker.checkTile(this);
        if (collisionOn == false){
            if(keyHandler.getPressed(Direction.UP)){
                this.moveUp(movementSpeed);

            }else if (keyHandler.getPressed(Direction.DOWN)) {
                this.moveDown(movementSpeed);

            }else if (keyHandler.getPressed(Direction.LEFT)) {
                this.moveLeft(movementSpeed);

            }else if (keyHandler.getPressed(Direction.RIGHT)) {
                this.moveRight(movementSpeed);

            }
        }
        if (reachedEndOn == true){
            //gamePanel.setVisible(false);
            gamePanel.tileM.setSpriteChange(4,"dark_brown");
        }
        if(mysteriousSmokeTileOn == true){
            gamePanel.tileM.setSpriteChange(5,"smoke");
        }

        //check enemy collision
        int enemyIndex = gamePanel.collisionChecker.checkEnemy(this,true);
        interactEnemy(enemyIndex);

        // Check item collision:
        int itemIndex = gamePanel.collisionChecker.checkItem(this, true);
        pickUpItem(itemIndex);
    }

    public void interactEnemy(int enemyIndex){
        // System.out.println("collision"); //for testing
    }

    public void pickUpItem(int itemIndex) {

        currentTime = gamePanel.getTimeElapsedSec();
        Item[] item = gamePanel.getItem();
        if(itemIndex != 999) { // if there is no hero-item collision index = 999
            item[itemIndex].collisionAction(this);
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

    public boolean getAlive(){return this.alive;}

    public void deathAnimation() {
        // graphics
    }

}

