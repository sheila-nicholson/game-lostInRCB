/*
 * Game.java
 * 
 * Class Description: Main class, where all the stuff happens. 
 *
 * Authors: [put your names here]
 * Last modified on: March 5, 2024 1:53 AM
 */


package com.game;

import com.game.GamePanel.GamePanel;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
//        System.out.println("hello world");
        //to run using maven, first type "mvn compile" and then "mvn exec:java"

        JFrame window = new JFrame();
        GamePanel gamePanel = new GamePanel();
        gamePanel.startGame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Lost in RCB");         // Placeholder name - can be updated later
        window.add(gamePanel);
        window.pack();


        window.setLocationRelativeTo(null);     // centers window in screen
        window.setVisible(true);


    }
}