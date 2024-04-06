package com.game;

import com.game.GamePanel.GamePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

/**
 * Manages and renders the user interface elements in the game.
 * <p>
 * This class is responsible for drawing UI components such as the score, game timer,
 * and temporary messages on the screen. It uses custom fonts and formatting to present
 * information clearly to the player during gameplay.
 */
public class UI{

    GamePanel gp;
    Font a40, a60, a80BIG;
    private boolean visibleText = false;
    private String words = "";
    private int wordsTime = 0;
    private double timer;
    DecimalFormat deForm = new DecimalFormat("#0.00");
    public boolean gameDone = false;

    /**
     * Constructs a UI manager for a specific game panel.
     *
     * @param gp The game panel where UI elements are to be rendered.
     */
    public UI(GamePanel gp) {
        this.gp = gp;
        a40 = new Font("Arial", Font.PLAIN, 40);
        a60 = new Font("Arial", Font.BOLD, 60);
        a80BIG = new Font("Arial", Font.BOLD, 80);
    }

    /**
     * Displays a temporary message at a predetermined location on the screen.
     *
     * @param text The message text to display.
     */
    public void showMessage(String text) {
        words = text;
        visibleText = true;
    }

    /**
     * Draws UI elements such as the score, timer, and temporary messages on the screen.
     *
     * @param gr2D The Graphics2D object used for drawing UI components.
     */
    public void draw(Graphics2D gr2D) {

        if (gameDone) {

            gr2D.setFont(a60);
            gr2D.setColor(Color.YELLOW);

            String endtext;
            int endtextlen;
            int a;
            int b;

            endtext = "You got all the rewards and escaped RCB!";
            endtextlen = (int)gr2D.getFontMetrics().getStringBounds(endtext, gr2D).getWidth();

            a = gp.screenWidth/2 - endtextlen/2;
            b = gp.screenHeight/2 - (gp.tileSize*3);
            gr2D.drawString(endtext, a, b);

            gr2D.setColor(Color.ORANGE);

            endtext = "Your total score is " + gp.getHero().getScore() + " points.";
            endtextlen = (int)gr2D.getFontMetrics().getStringBounds(endtext, gr2D).getWidth();

            a = gp.screenWidth/2 - endtextlen/2;
            b = gp.screenHeight/2 + (gp.tileSize*2);
            gr2D.drawString(endtext, a, b);

            gr2D.setFont(a80BIG);
            gr2D.setColor(Color.GREEN);

            endtext = "You took " + deForm.format(timer) + "s to escape RCB.";
            endtextlen = (int)gr2D.getFontMetrics().getStringBounds(endtext, gr2D).getWidth();

            a = gp.screenWidth/2 - endtextlen/2;
            b = gp.screenHeight/2 + (gp.tileSize*4);
            gr2D.drawString(endtext, a, b);

        } else {

            gr2D.setFont(a40);
            gr2D.setColor(Color.WHITE);


            gr2D.drawString("Score = " + gp.getHero().getScore(), 150, 40);

            timer += (double) 1 / 60;
            gr2D.drawString("Time:" + deForm.format(timer), gp.tileSize * 20, 40);

            if (visibleText) {
                gr2D.setFont(gr2D.getFont().deriveFont(24F));
                gr2D.drawString(words, gp.tileSize * 10, gp.tileSize * 11);

                wordsTime++;
                if (wordsTime > 45) {
                    wordsTime = 0;
                    visibleText = false;
                }
            }
        }
    }
}
