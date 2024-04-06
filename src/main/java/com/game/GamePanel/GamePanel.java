package com.game.GamePanel;

import com.game.Characters.Enemy;
import com.game.Characters.Hero;
import com.game.Items.Item;
import com.game.Tile.TileManager;
import com.game.UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public abstract class GamePanel extends JPanel implements Runnable, ScreenSetting{

    protected int timeElapsedSec;
    public boolean running = false;

    protected Hero hero;
    protected Enemy enemy;
    public Item[] item;
    public Graphics2D g2;
    public TileManager tileM;
    public int FPS = 60;

    public UI ui = new UI((MainGamePanel) this);

    public Hero getHero() {
        return this.hero;
    }
    public Enemy getEnemy() {
        return this.enemy;
    }
    public Item[] getItem() {
        return this.item;
    }
    public int getTimeElapsedSec() {
        return timeElapsedSec;
    }

    protected abstract void alertItemState();

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
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
        g2 = (Graphics2D)g;

        tileM.draw(g2);
        // items on map
        for (Item item : item) {
            if (item != null) {
                item.draw(g2, (MainGamePanel) this);
            }
        }

        enemy.draw(g2);
        hero.draw(g2);
        ui.draw(g2);
        g2.dispose();
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
