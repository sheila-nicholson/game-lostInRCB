/*
 * UI.java
 *
 * Class Description: Handles the UI aspect
 *
 * Authors: Jonas
 * Last modified on: March 11, 2014 5:57 PM
 */

package com.game;

import com.game.GamePanel.GamePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
    GamePanel gp;
    Font a40;
    public boolean visibleText = false;
    public String words = "";

    public UI(GamePanel gp) {
        this.gp = gp;
        a40 = new Font("Arial", Font.BOLD, 40);
    }

    public void showMessage(String text) {

        words = text;
        visibleText = true;
    }

    public void draw(Graphics2D gr2D) {

        gr2D.setFont(a40);
        gr2D.setColor(Color.CYAN);
        gr2D.drawString("Score:", 150,40);

        if (visibleText) {
            gr2D.setFont(gr2D.getFont().deriveFont(24F));
            gr2D.drawString(words, gp.tileSize*10, gp.tileSize*11);
        }
    }
}
