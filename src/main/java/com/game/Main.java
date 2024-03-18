package com.game;

import com.game.GamePanel.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Load background image
        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(Main.class.getResourceAsStream("/Title/title.jpg")); // Provide path to your image
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImagePanel backgroundPanel = new ImagePanel(backgroundImage);
        backgroundPanel.setLayout(new BorderLayout());

        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(130, 0, 0, 0)); // Add top padding
        JButton easyButton = new JButton("Easy");
        JButton mediumButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");

        // Make buttons bigger, white, and square
        Dimension buttonSize = new Dimension(120, 120); // Set width and height to the same value for square buttons
        Color buttonColor = Color.WHITE;
        easyButton.setPreferredSize(buttonSize);
        easyButton.setFont(new Font("Arial", Font.BOLD, 30));
        easyButton.setBackground(buttonColor);
        easyButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add black border for a square shape

        mediumButton.setPreferredSize(buttonSize);
        mediumButton.setFont(new Font("Arial", Font.BOLD, 30));
        mediumButton.setBackground(buttonColor);
        mediumButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add black border for a square shape

        hardButton.setPreferredSize(buttonSize);
        hardButton.setFont(new Font("Arial", Font.BOLD, 30));
        hardButton.setBackground(buttonColor);
        hardButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add black border for a square shape

        // Add action listeners to the buttons
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame("Easy");
            }
        });
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame("Medium");
            }
        });
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame("Hard");
            }
        });

        buttonPanel.setOpaque(false);
        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);

        // Create exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size as desired
        exitButton.setForeground(Color.WHITE); // Set text color
        exitButton.setBackground(Color.RED); // Set background color
        exitButton.setFocusPainted(false); // Remove focus border
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 80, 0)); // Add bottom padding
        bottomPanel.setOpaque(false); // Make the panel transparent
        bottomPanel.add(exitButton);

        // Add components to the background panel
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        backgroundPanel.add(bottomPanel, BorderLayout.SOUTH); // Add bottom panel with exit button

        mainPanel.add(backgroundPanel);
        window.setContentPane(mainPanel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Lost in RCB");
        window.setSize(864, 864); // Set window size
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    // Method to start the game with selected difficulty
    private static void startGame(String difficulty) {
        // Implement your game startup logic here based on difficulty
        System.out.println("Starting game with difficulty: " + difficulty);
        JFrame gameWindow = new JFrame();
        GamePanel gamePanel = new GamePanel();
        gamePanel.setupGame(difficulty);
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

// JPanel subclass for displaying background image
class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}