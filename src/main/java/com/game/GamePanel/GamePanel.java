package com.game.GamePanel;

//import javax.awt.event.KeyEvent;
import com.game.Character.Enemy;
import com.game.Character.Hero;
import com.game.Key.KeyHandler;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements Runnable{

    //still need to update the object and methods related to tail
    private static int width;
    private static int height;
    private BufferedImage img;
    private Graphics2D g;
    private boolean running = false;
    KeyHandler keyHandler = new KeyHandler(this);
    private int FPS = 60;
    Thread thread;

    private Hero player;

    public synchronized void startGame(){
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public GamePanel(Hero player, Enemy enemy){ //not finished
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.player = player;

    }

    //not finished
    public void update(){


    }

    public void render(){
        //need fillReact
        if (g != null) {
            g.setColor(new Color(33, 30, 39));
            g.fillRect(0, 0, width, height);
        }

    }

    public void draw(){
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double frameInterval = 1000000000 / FPS;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;

       while (running){
           System.out.println("running");
           long now = System.nanoTime();
           delta += (now - lastTime) / frameInterval;
           lastTime = now;
           while(delta >= 1){
               this.update();
               delta--;
               updates++;
           }
           render();

           if(System.currentTimeMillis() - timer > 1000000000) {
               System.out.println("FPS:" + updates);
               updates = 0;
               timer = System.currentTimeMillis();
           }
       }

    }
}
