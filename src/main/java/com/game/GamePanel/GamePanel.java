/*
 * GamePanel.java
 *
 * Class Description: Handles the UI interface
 *
 *
 * Authors: [put your names here] + Jonas ???
 * Last modified on: March 6 1:00 AM
 */

package com.game.GamePanel;


//import javax.awt.event.KeyEvent;
import com.game.AssetSetter;
import com.game.Character.Enemy;
import com.game.Character.EnemyMovement.PathFinder;
import com.game.Character.Hero;
import com.game.Character.ZombieProfessor;

import com.game.CollisionChecker;
import com.game.Items.APlusPaper;
import com.game.Items.Item;
import com.game.Key.KeyHandler;
import com.game.Tile.TileManager;
import com.game.UI;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


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
    //public TileManager tileM = new TileManager(this);
    public PathFinder pathFinder = new PathFinder(this);
    private int timeElapsed;    // time elapsed since game started in seconds

    Thread thread;
    public AssetSetter assetSetter = new AssetSetter(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    private Hero hero;
    private Enemy enemy;

    private Item[] item = new Item[15];  // item slots - dictates how many items can be displayed at one time


    public Hero getHero() {
        return this.hero;
    }
    public Enemy getEnemy() {
        return this.enemy;
    }
    public Item[] getItem() {
        return this.item;
    }

    public synchronized void startGame(){
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void setupGame() {
        tileM = new TileManager(this);
        assetSetter.setObject();
    }


    public GamePanel(){ //not finished

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyHandler);
        this.hero = Hero.getInstance(4,this.keyHandler,this);
        this.enemy = new ZombieProfessor(3,this); //temp speed for testing

    }
    public void update() throws IOException {
        hero.update();
//        enemy.update();
        System.out.println(enemy.update());
    }

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
                item[i].updateItemState(this);
        }
    }

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
