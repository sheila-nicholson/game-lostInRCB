/*
 * Game.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
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
        window.setTitle("Game");
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }
}