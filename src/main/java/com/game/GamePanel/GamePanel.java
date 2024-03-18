package com.game.GamePanel;

import com.game.AssetSetter;
import com.game.Character.*;
import com.game.Character.EnemyMovement.PathFinder;

import com.game.CollisionChecker;
import com.game.Items.APlusPaper;
import com.game.Items.Item;
import com.game.Key.KeyHandler;
import com.game.Tile.TileManager;
import com.game.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Manages the main game panel, rendering, and game loop.
 * <p>
 * This class extends {@link JPanel} and implements {@link Runnable} to manage the game's main loop,
 * rendering, and interactions. It initializes and updates game components, processes user input,
 * and handles rendering of the game world and UI elements.
 *
 * @author: [put your names here]
 */
public class GamePanel extends JPanel implements Runnable{

    //still need to update the object and methods related to tail
    // Screen settings:
    final int originalTileSize = 16; // I changed this because the screen size was too large, not sure if optimal, feel free to update
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;   // 48x48 tile (due to scaling)
    public final int maxScreenCol = 28;        // Changed according to UI mockup - range of columns: 0-27
    public final int maxScreeRow = 18;         // Changed according to UI mockup - range of rows: 0-17
    public final int screenWidth = tileSize * maxScreenCol;    // (48*28) = 1,344 pixels
    public final int screenHeight = tileSize * maxScreeRow ;   // (48*18) = 864 pixels
    private int difficulty;

    private static int width;
    private static int height;
    private BufferedImage img;
    private Graphics g;
    private boolean running = false;
    KeyHandler keyHandler = new KeyHandler(this);
    private int FPS = 60;

    private int timeElapsedSec;    // time elapsed since game started in seconds
    public UI ui = new UI(this);

    public TileManager tileM;
    public PathFinder pathFinder = new PathFinder(this);
    private int timeElapsed;    // time elapsed since game started in seconds

    Thread thread;
    public AssetSetter assetSetter = new AssetSetter(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    private Hero hero;
    private Enemy enemy;

    public Item[] item = new Item[25]; // item slots - dictates how many items can be displayed at one time


    public Hero getHero() {
        return this.hero;
    }
    public Enemy getEnemy() {
        return this.enemy;
    }
    public Item[] getItem() {
        return this.item;
    }

    /**
     * Initializes the game panel with default settings.
     * <p>
     * Sets up the game panel size, background color, double buffering, and input handling. It initializes
     * the hero and the enemy characters with default parameters.
     */
    public GamePanel(){ //not finished

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyHandler);
        this.hero = Hero.getInstance(4,this.keyHandler,this);
        this.enemy = new ZombieProfessor(3,this); //temp speed for testing

    }

    public void closeGamePanel() {
        JFrame frame = (JFrame) getTopLevelAncestor();
        if (frame != null) {
            frame.dispose();
        }
    }
    /**
     * Starts the game loop in a new thread.
     * <p>
     * This method checks if the game is already running to prevent multiple instances of the game loop.
     * It then starts a new thread that controls the game loop, updating and rendering the game state.
     */
    public synchronized void startGame(){
        if(running) return;
        running = true;
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
        if(tileM.getMapDifficulty().equals("Easy")){
            this.enemy = new ZombieProfessor(2,this); //temp speed for testing
        }else if(tileM.getMapDifficulty().equals("Medium")){
            this.enemy = new Bear(3,this); //temp speed for testing
        }else if(tileM.getMapDifficulty().equals("Hard")){
            this.enemy = new FailedExam(3,this); //temp speed for testing
        }else if(tileM.getMapDifficulty().equals("Infinite")){
            this.enemy = new ZombieProfessor(3,this); //temp speed for testing
        }
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
    public void setupGame(String diff) {
        if (diff == "Infinite"){
            hero.infinite = true;
        }
        else{
            hero.infinite = false;
        }
        hero.diff = diff;

        tileM = new TileManager(this,diff);

        assetSetter.setObject(diff);

        setEnemy();

    }

    /**
     * Updates the game state, including player, enemy movements, and interactions.
     * <p>
     * This method is called within the game loop to handle game logic updates, such as character
     * movements, collision detection, and interactions between game objects.
     *
     * @throws IOException if there is an error loading resources.
     */
    public void update() throws IOException {
        hero.update();
        enemy.update();
//        System.out.println(enemy.update());
    }

    /**
     * Renders the game world and UI components to the screen.
     * <p>
     * This method overrides {@link JPanel#paintComponent(Graphics)} to custom draw the game's world and
     * UI elements. It is called as part of the swing repaint mechanism.
     *
     * @param g The {@link Graphics} context used for drawing.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);

        // items on map
        for(int i = 0; i < item.length; i++) {
            if (item[i] != null) {
                item[i].draw(g2, this);
            }
        }

        enemy.draw(g2);
        hero.draw(g2);
        ui.draw(g2);
        g2.dispose();
    }

    public int getTimeElapsedSec() {
        return timeElapsedSec;
    }

    public void alertItemState() {

        // Move the position of APlusPaper items every 10 seconds
        for(int i = 0; i < item.length; i++) {

            if(item[i] instanceof APlusPaper)
                item[i].updateItemState();
        }
    }

    /**
     * The main game loop that controls game updates and rendering.
     * <p>
     * This method runs in a separate thread and is responsible for the game's timing mechanism,
     * ensuring that updates and rendering occur at a consistent rate. It calculates the delta
     * time between frames to update game states and re-renders the game at a fixed rate. Additionally,
     * it handles periodic tasks such as updating item states and managing power-up effects' durations.
     */
    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double frameInterval = 1000000000.0 / FPS;
        double delta = 0;
        long timer = System.currentTimeMillis();
        long start = System.currentTimeMillis();    // Used to calculate timeElapsed
        int updates = 0;
        timeElapsedSec = 0;
        int previousTimeElapsedSec = 0;

        while (running) {
            long now = System.nanoTime();
            long current = System.currentTimeMillis();  // Used to calculated timeElapsed
            delta += (now - lastTime) / frameInterval;
            lastTime = now;
            timeElapsedSec = (int) (current - start) / 1000;

            // Calls updateItemState() every 10 seconds that has elapsed
            if (previousTimeElapsedSec != timeElapsedSec && timeElapsedSec % 10 == 0) {
                alertItemState();
                previousTimeElapsedSec = timeElapsedSec;
            }

            // Used for ending speed modification effect from coffee object - original hero speed = 4
            if (hero.coffeeTimeEnd == timeElapsedSec) {
                hero.setMovementSpeed(4);
            }

            while (delta >= 1) {
                try {
                    this.update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                this.repaint();
                delta--;
                updates++;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                //System.out.println("FPS:" + updates); // for testing purposes
                updates = 0;
                timer += 1000; // Increment timer by 1 second
                timeElapsedSec++;
            }
        }
    }
}
