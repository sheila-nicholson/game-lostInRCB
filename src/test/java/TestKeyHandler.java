package com.game.Key;

import com.game.GamePanel.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.event.KeyEvent;

public class TestKeyHandler {
    private GamePanel gamePanel;
    private KeyHandler keyHandler;

    @BeforeEach
    void setUp() {
        gamePanel = mock(GamePanel.class);
        keyHandler = new KeyHandler(gamePanel);
    }

    @Test
    void testKeyPress() {
        KeyEvent keyEvent = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        keyHandler.keyPressed(keyEvent);
        assertTrue(keyHandler.getPressed(Direction.UP));
    }

    @Test
    void testKeyRelease() {
        KeyEvent pressEvent = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        keyHandler.keyPressed(pressEvent);

        KeyEvent releaseEvent = new KeyEvent(gamePanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        keyHandler.keyReleased(releaseEvent);
        assertFalse(keyHandler.getPressed(Direction.UP));
    }

    @Test
    void testSpecificKeyState() {
        KeyEvent pressEventD = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
        keyHandler.keyPressed(pressEventD);
        assertTrue(keyHandler.getPressed(Direction.RIGHT));

        KeyEvent releaseEventD = new KeyEvent(gamePanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
        keyHandler.keyReleased(releaseEventD);
        assertFalse(keyHandler.getPressed(Direction.RIGHT));
    }
}
