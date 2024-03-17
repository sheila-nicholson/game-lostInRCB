package com.game.Character;

import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;

import java.awt.*;
import java.util.Random;

/**
 * Represents an enemy character within the game.
 * <p>
 * This class extends the {@link Character} class, specializing it for enemy behavior.
 * Enemies can automatically navigate towards the player character, checking for collisions
 * and initiating actions based on their AI logic. The {@code Enemy} class provides mechanisms
 * for setting default positions, handling images, custom collision detection, and defining
 * enemy-specific actions such as movement patterns and interactions with the player.
 */
public class Enemy extends Character {

    protected int damagePoints = 0;
    public int actionCounter = 0;

    /**
     * Sets the default position and orientation of the enemy character.
     * This method is intended to be overridden by subclasses for custom positioning.
     */
    @Override
    protected void setDefaultPosition(){
        currentDirection = Direction.RIGHT;
        lastDirection = Direction.RIGHT;
    }
    /**
     * Loads the image resources for the enemy character.
     * This method is intended to be overridden by subclasses to specify enemy appearance.
     */
    @Override
    public void getImage() {}

    /**
     * Constructs an {@code Enemy} with specified speed and associates it with a game panel.
     *
     * @param speed the movement speed of the enemy
     * @param gamePanel the game panel the enemy belongs to
     */
    public Enemy(int speed, GamePanel gamePanel) {
        super(speed, gamePanel);
        this.movementSpeed = speed;
        this.solidAreaDefaultX = gamePanel.tileSize;
        this.solidAreaDefaultY = gamePanel.tileSize;
        this.solidArea = new Rectangle(0, 0, this.solidAreaDefaultX-3, this.solidAreaDefaultY-3);
        setDefaultPosition();
        this.setPosition(2 * gamePanel.tileSize, 14* gamePanel.tileSize);
    }

    /**
     * Checks for and handles collisions specific to the enemy character.
     * This includes interactions with tiles, the player, and other characters.
     */
    @Override
    public void checkCollision() {
        gamePanel.collisionChecker.checkTile(this);
        gamePanel.collisionChecker.checkPlayer(this);
        int index = gamePanel.collisionChecker.checkCharacter(this,gamePanel.getHero());
        if(index != 999){
            this.gamePanel.getHero().alive = false;
            System.exit(0);//test for terminating the game after collision between enemy and hero
        }
    }

    /**
     * Determines and initiates the enemy's actions based on its AI logic.
     * Actions may include pathfinding towards the player or random movement.
     */
    @Override
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

    /**
     * Updates the enemy's state and handles movement based on the current direction.
     * <p>
     * This method manages collision detection, action decisions, and movement execution.
     * It ensures that the enemy navigates the game world according to its AI behavior.
     *
     * @return The current direction of the enemy after the update.
     */
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
