package com.game.GamePanel;

//import javax.awt.event.KeyEvent;
import com.game.Key.KeyHandler;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;


public class GamePanel extends JPanel implements Runnable{

    //still need to update the object and methods related to tail
    private BufferedImage img;
    private Graphics2D g;
    private boolean running = false;
    KeyHandler keyHandler = new KeyHandler();
    private int FPS = 60;

    Thread thread;

    public synchronized void startGame(){
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public GamePanel(){ //not finished
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }

    public void update(){

    }

    public void render(){
        //need fillReact

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

           if(System.currentTimeMillis() - timer > 1000000000) {
               System.out.println("FPS:" + updates);
               updates = 0;
               timer = System.currentTimeMillis();
           }


       }

    }
}
