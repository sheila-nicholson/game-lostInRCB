package com.game;

import com.game.GamePanel.GamePanel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        JPanel titleScreen = new JPanel();
        JButton startButton = new JButton("Start Game");
        JLabel titleLabel = new JLabel("Lost in RCB");

        // Set font and size for title label
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add action listener to the start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
                // Remove the title screen after starting the game
                window.remove(titleScreen);
            }
        });

        titleScreen.setLayout(new BorderLayout());
        titleScreen.add(titleLabel, BorderLayout.NORTH);
        titleScreen.add(startButton, BorderLayout.CENTER);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Lost in RCB");         // Placeholder name - can be updated later
        window.add(titleScreen);
        window.setPreferredSize(new Dimension(600, 400)); // Set window size
        window.pack();

        window.setLocationRelativeTo(null);     // centers window in screen
        window.setVisible(true);
    }

    // Method to start the game
    private static void startGame() {
        JFrame gameWindow = new JFrame();
        GamePanel gamePanel = new GamePanel();
        gamePanel.setupGame();
        gamePanel.startGame();

        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setResizable(false);
        gameWindow.setTitle("Lost in RCB");         // Placeholder name - can be updated later
        gameWindow.add(gamePanel);
        gameWindow.pack();

        gameWindow.setLocationRelativeTo(null);     // centers window in screen
        gameWindow.setVisible(true);
    }
}
