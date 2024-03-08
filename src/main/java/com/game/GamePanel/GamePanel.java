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
import com.game.Character.Enemy;
import com.game.Character.Hero;
import com.game.Key.KeyHandler;
//import sun.font.EAttribute;           // unsure what this for

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements Runnable{

    //still need to update the object and methods related to tail
    // Screen settings:
    final int originalTileSize = 16; // I changed this because the screen size was too large, not sure if optimal, feel free to update
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;   // 48x48 tile (due to scaling)
    final int maxScreenCol = 28;        // Changed according to UI mockup
    final int maxScreeRow = 18;         // Changed according to UI mockup
    final int screenWidth = tileSize * maxScreenCol;    // (48*28) = 1,344 pixels
    final int screenHeight = tileSize * maxScreeRow ;   // (48*18) = 864 pixels

    private static int width;
    private static int height;
    private BufferedImage img;
    private Graphics g;
    private boolean running = false;
    KeyHandler keyHandler = new KeyHandler(this);
    private int FPS = 60; // unnecessary?
    Thread thread;

    private Hero hero;
    private Enemy enemy;

    public synchronized void startGame(){
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public GamePanel(){ //not finished
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyHandler);
        this.hero = Hero.getInstance(4,this.keyHandler,this);
        this.enemy = Enemy.getInstance(5);
    }

    public void update(){
        hero.update();
//        enemy.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        hero.draw(g2);
        g2.dispose();
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double frameInterval = 1000000000.0 / FPS;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / frameInterval;
            lastTime = now;

            while (delta >= 1) {
                this.update();
                this.repaint();
                delta--;
                updates++;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                System.out.println("FPS:" + updates); // unnecessary?
                updates = 0;
                timer += 1000; // Increment timer by 1 second
            }
       }
    }

}
