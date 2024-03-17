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
import java.util.Objects;

/**
 * Represents the hero character controlled by the player in the game.
 * <p>
 * This class extends the {@link Character} class, adding functionality for player input handling,
 * scoring, and unique interactions such as item pickups and enemy encounters. It manages the hero's
 * movement, animation, collision detection, and game state interactions.
 */
public class Hero extends Character implements Score{


    private int currentScore = 0;
    protected static Hero instance = null;
    protected boolean alive  = true;
    protected boolean isInvincible = false;
    protected KeyHandler keyHandler;
    public int coffeeTimeEnd;
    public int currentTime;
    public boolean infinite;

    /**
     * Initializes the hero character with specific speed, position, and input handling.
     * <p>
     * Positions the hero at a predefined location in the game world and sets up key handling
     * for player movement and actions. Loads the hero's image resources and initializes the hero's
     * collision area.
     *
     * @param speed the movement speed of the hero
     * @param keyHandler the key handler for processing player input
     * @param gamePanel the game panel the hero belongs to
     */
    protected Hero(int speed, KeyHandler keyHandler, GamePanel gamePanel){
        super(speed,gamePanel);
        this.keyHandler = keyHandler;
        this.gamePanel = gamePanel;
        this.solidAreaDefaultX = gamePanel.tileSize;
        this.solidAreaDefaultY = gamePanel.tileSize;
        this.solidArea = new Rectangle(0, 0, this.solidAreaDefaultX-5, this.solidAreaDefaultY-5);
        this.setDefaultPosition();
        this.setScore(20);
        this.alive = true;

        getImage();
    }

    protected void setDefaultPosition(){
        //    this.setPosition(this.gamePanel.tileSize,this.gamePanel.tileSize);
        this.setPosition(50,50);
        currentDirection = Direction.RIGHT;
        lastDirection = Direction.RIGHT;
    }

    /**
     * Loads the image resources specifically for the hero character.
     * <p>
     * Overrides the {@code getImage} method in the superclass to load images representing
     * the hero character's appearance.
     */
    @Override
    public void getImage() {
        try{
            rightImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Hero/Student_right.png")));
            leftImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Hero/Student_left.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Draws the hero character on the game panel.
     * <p>
     * This method overrides the {@code draw} method in the superclass, rendering the hero character
     * on the game panel based on the current direction and position.
     *
     * @param g2 the Graphics2D object used for drawing
     */
    @Override
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
     * Updates the hero's state based on player input and game environment interactions.
     * <p>
     * Manages movement, collision detection, enemy interactions, and item pickups. Also handles
     * game state transitions such as reaching the end of a level or encountering an enemy.
     *
     * @throws IOException if there is an error loading image resources
     */
    public void update() throws IOException {
        if(keyHandler.getPressed(Direction.UP)){

            this.currentDirection = Direction.UP;

        }else if (keyHandler.getPressed(Direction.DOWN)) {

            this.currentDirection = Direction.DOWN;

        }else if (keyHandler.getPressed(Direction.LEFT)) {

            this.lastDirection = this.currentDirection;
            this.currentDirection = Direction.LEFT;

        }else if (keyHandler.getPressed(Direction.RIGHT)) {

            this.lastDirection = this.currentDirection;
            this.currentDirection = Direction.RIGHT;

        }
        //check tile collision
        collisionOn = false;

        gamePanel.collisionChecker.checkTile(this);
        gamePanel.collisionChecker.checkPlayer(this);

        if (!collisionOn){
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
        //check tile collision
        collisionOn = false;
        reachedEndOn = false;
        mysteriousSmokeTileOn = false;
        //System.out.println(collisionOn);
        gamePanel.collisionChecker.checkTile(this);
        if (!collisionOn){
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

        if (reachedEndOn){
            if (this.infinite){
                setDefaultPosition();
                gamePanel.assetSetter.setObject("Infinite");

            }
            else{
                System.exit(0);//test for terminating the game after collision between hero and enemy
            }

        }
        if(mysteriousSmokeTileOn){
            gamePanel.tileM.setSpriteChange(5,"smoke");

        }

        //check enemy collision
        int enemyIndex = gamePanel.collisionChecker.checkCharacter(this,gamePanel.getEnemy());
        interactEnemy(enemyIndex);

        // Check item collision:
        int itemIndex = gamePanel.collisionChecker.checkItem(this, true);
        pickUpItem(itemIndex);
    }

    /**
     * Handles interaction with an enemy character.
     *
     * @param enemyIndex the index of the encountered enemy
     */
    public void interactEnemy(int enemyIndex){

        if(enemyIndex != 999) {
             System.out.println("collision"); //for testing
            System.exit(0);//test for terminating the game after collision between hero and enemy
            this.alive = false;
        }
    }

    /**
     * Manages the action of picking up an item and its effects on the hero.
     *
     * @param itemIndex the index of the item to be picked up
     */
    public void pickUpItem(int itemIndex) {

        currentTime = gamePanel.getTimeElapsedSec();
        Item[] item = gamePanel.getItem();
        if(itemIndex != 999) { // if there is no hero-item collision index = 999
            item[itemIndex].collisionAction(this);
            item[itemIndex] = null;

        }
    }

    /**
     * Retrieves the singleton instance of the Hero, creating it if it does not already exist.
     *
     * @param speed the speed of the hero
     * @param keyHandler the key handler for the hero
     * @param gamePanel the game panel to which the hero belongs
     * @return the singleton instance of the Hero
     */
    public static synchronized Hero getInstance(int speed,KeyHandler keyHandler,GamePanel gamePanel) {
        if (instance == null) {
            instance = new Hero(speed,keyHandler,gamePanel);
        }
        return instance;
    }

    /**
     * Checks if the current score is greater than zero.
     * <p>
     * This method is used to determine if the hero has accumulated any score points.
     * It can be used in game logic to trigger certain events or validate game state conditions.
     *
     * @return {@code true} if the current score is greater than 0, otherwise {@code false}.
     */
    public boolean checkScore(){
        return currentScore > 0;
    }

    /**
     * Retrieves the current score of the hero.
     * <p>
     * This method provides access to the hero's current score, allowing other parts of the
     * game to display or otherwise use the score value.
     *
     * @return the current score of the hero.
     */
    public int getScore(){ return this.currentScore;} // GETTER

    /**
     * Sets the hero's score to a specified value.
     * <p>
     * Allows for the direct setting of the hero's score, unless the hero is in an invincible state.
     * In an invincible state, the score cannot be directly modified to prevent unintended score reduction.
     *
     * @param score the new score value to set for the hero.
     */
    public void setScore(int score){ // SETTER

        if(!isInvincible) {
            this.currentScore = score; 
        }
    }


    /**
     * Increments the hero's score by a specified amount.
     * <p>
     * This method adds the specified amount to the current score, allowing for score increases
     * resulting from game events such as collecting items or defeating enemies.
     *
     * @param score the amount to add to the current score.
     */
    public void addScore(int score){
        this.currentScore += score;
    }

    /**
     * Retrieves the alive status of the hero.
     * <p>
     * This method is used to check if the hero is still alive in the game. It can be utilized
     * in game logic to determine the outcome of certain events or interactions, such as whether
     * the game should continue or end based on the hero's survival.
     *
     * @return {@code true} if the hero is alive, otherwise {@code false}.
     */
    public boolean getAlive(){return this.alive;}

}

