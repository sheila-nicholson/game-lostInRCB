package com.game.GameTerminator;

import com.game.GamePanel.GamePanel;

import javax.swing.*;

public class DefaultGameTerminator implements GameTerminator {

    private GamePanel gamePanel;

    public DefaultGameTerminator(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void endGame(){
        System.out.println("Game over! Thank you for playing.");
        gamePanel.running = false;
        gamePanel.thread = null;
    }

    @Override
    public void terminate() {
        endGame(); // Update the game state to reflect it's over
        System.exit(0);

    }
}