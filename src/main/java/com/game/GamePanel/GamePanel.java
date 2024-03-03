package com.game.GamePanel;

//import javax.awt.event.KeyEvent;
import com.game.Character.Enemy;
import com.game.Character.Hero;
import com.game.Key.KeyHandler;
import sun.font.EAttribute;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements Runnable{

    //still need to update the object and methods related to tail
    final int originalTileSize = 48;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 48;
    final int maxScreeRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreeRow ;

    private static int width;
    private static int height;
    private BufferedImage img;
    private Graphics g;
    private boolean running = false;
    KeyHandler keyHandler = new KeyHandler(this);
    private int FPS = 60;
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
                System.out.println("FPS:" + updates);
                updates = 0;
                timer += 1000; // Increment timer by 1 second
            }
       }
    }

}
