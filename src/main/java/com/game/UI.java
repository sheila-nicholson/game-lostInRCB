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

    public UI(GamePanel gp) {
        this.gp = gp;
        a40 = new Font("Arial", Font.BOLD, 40);
    }

    public void draw(Graphics2D gr2D) {

        gr2D.setFont(a40);
        gr2D.setColor(Color.CYAN);
        gr2D.drawString("HI GUYS WELCOME TO MY MINECRAFT WORLD", 50,50);
    }
}
