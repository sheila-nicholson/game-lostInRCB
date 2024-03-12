/*
 * UI.java
 *
 * Class Description: Handles the UI aspect
 *
 * Authors: Jonas
 * Last modified on: March 11, 2014 5:57 PM
 */

package com.game;

import com.game.Character.Hero;
import com.game.GamePanel.GamePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Font a40, a60;
    public boolean visibleText = false;
    public String words = "";
    int wordsTime = 0;
    double timer;
    DecimalFormat deForm = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        a40 = new Font("Arial", Font.PLAIN, 40);
        a60 = new Font("Arial", Font.BOLD, 60);
    }

    public void showMessage(String text) {

        words = text;
        visibleText = true;
    }

    public void draw(Graphics2D gr2D) {

        /* UNCOMMENT THIS FOR GAME OVER
        if (gameFinished) {
            gr2D.setFont(a60);
            gr2D.setColor(Color.GREEN);

            String txt;
            int txtLen;
            int x, y;

            txt = "Game Over" // add conditionals for victory or loss
            txtLen = (int)gr2D.getFontMetrics().getStringBounds(txt, gr2D).getWidth();
            x = gp.screenWidth/2 - txtLen/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            gr2D.drawString(txt, x, y);

            gp.gameThread = null;
        }
        */
        gr2D.setFont(a40);
        gr2D.setColor(Color.BLUE);
        gr2D.drawString("Score = WIP",150,40);

        timer +=(double)1/60;
        gr2D.drawString("Time:"+deForm.format(timer), gp.tileSize*20, 40);

        if (visibleText) {
            gr2D.setFont(gr2D.getFont().deriveFont(24F));
            gr2D.drawString(words, gp.tileSize*10, gp.tileSize*11);

            wordsTime++;
            if (wordsTime > 45) {
                wordsTime = 0;
                visibleText = false;
            }
        }
    }
}
