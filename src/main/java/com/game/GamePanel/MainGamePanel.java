package com.game.GamePanel;

import com.game.AssetSetter;
import com.game.Characters.*;
import com.game.Characters.EnemyMovement.PathFinder;

import com.game.CollisionChecker;
import com.game.GameTerminator.DefaultGameTerminator;
import com.game.GameTerminator.GameTerminator;
import com.game.Items.APlusPaper;
import com.game.Items.Item;
import com.game.Key.KeyHandler;
import com.game.Tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Manages the main game panel, rendering, and game loop.
 * <p>
 * This class extends {@link JPanel} and implements {@link Runnable} to manage the game's main loop,
 * rendering, and interactions. It initializes and updates game components, processes user input,
 * and handles rendering of the game world and UI elements.
 *
 */
public class MainGamePanel extends GamePanel {

    protected int timeElapsed;    // time elapsed since game started in seconds
    public Thread thread;

    public KeyHandler keyHandler = new KeyHandler(this);
    public TileManager tileM = new TileManager(this,"Easy"); //default
    public PathFinder pathFinder = new PathFinder(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public GameTerminator gameTerminator;


    /**
     * Initializes the game panel with default settings.
     * <p>
     * Sets up the game panel size, background color, double buffering, and input handling. It initializes
     * the hero and the enemy characters with default parameters.
     */
    public MainGamePanel(){
        super();
        this.addKeyListener(keyHandler);
        this.hero = new Hero(4,this.keyHandler,this);
        this.enemy = new Enemy(2,this); //default
        this.item = new Item[25];
        gameTerminator = new DefaultGameTerminator(this);
    }

    /**
     * Sets the game's difficulty level and initializes game components accordingly.
     * <p>
     * Depending on the difficulty level, different enemies are spawned, and other game parameters
     * are adjusted. This method also initializes the {@link TileManager}, {@link AssetSetter}, and
     * sets the initial enemy for the game based on the difficulty.
     *
     * @param diff A {@link String} representing the game's difficulty level.
     */
    public void  setupGame(String diff) {
        hero.diff = diff;
        tileM = new TileManager(this,diff);
        assetSetter.setObject(diff);
        setEnemy();
    }

    /**
     * Starts the game loop in a new thread.
     * <p>
     * This method checks if the game is already running to prevent multiple instances of the game loop.
     * It then starts a new thread that controls the game loop, updating and rendering the game state.
     */
    public void  startGame(String diff){
        //public synchronized void startGame
        if(running) return;
        running = true;

        setupGame(diff);
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Sets the enemy based on the current game difficulty level.
     * <p>
     * Depending on the difficulty level determined by the {@link TileManager}, this method
     * initializes the {@code enemy} field with a specific type of enemy. Different enemies
     * are assigned for different difficulty levels, each with its own speed setting.
     */
    public void setEnemy(){
        switch (tileM.getMapDifficulty()) {
            case "Easy" -> this.enemy = new ZombieProfessor(2, this); //temp speed for testing
            case "Medium" -> this.enemy = new Bear(3, this); //temp speed for testing
            case "Hard" -> this.enemy = new FailedExam(4, this); //temp speed for testing
        }
    }

    /**
     * Updates the game state, including player, enemy movements, and interactions.
     * <p>
     * This method is called within the game loop to handle game logic updates, such as character
     * movements, collision detection, and interactions between game objects.
     *
     * @throws IOException if there is an error loading resources.
     */
    public void alertItemState() {

        // Move the position of APlusPaper items every 10 seconds
        for (Item value : item) {
            if (value instanceof APlusPaper)
                value.updateItemState();
        }
    }

}
