import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;
import com.game.Key.KeyHandler;
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
    void testKeyPressUP() {
        KeyEvent keyEvent = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        keyHandler.keyPressed(keyEvent);
        assertTrue(keyHandler.getPressed(Direction.UP));
    }

    @Test
    void testKeyPressDown() {
        KeyEvent keyEvent = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
        keyHandler.keyPressed(keyEvent);
        assertTrue(keyHandler.getPressed(Direction.DOWN));
    }

    @Test
    void testKeyPressLeft() {
        KeyEvent keyEvent = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A');
        keyHandler.keyPressed(keyEvent);
        assertTrue(keyHandler.getPressed(Direction.LEFT));
    }

    @Test
    void testKeyPressRight() {
        KeyEvent keyEvent = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
        keyHandler.keyPressed(keyEvent);
        assertTrue(keyHandler.getPressed(Direction.RIGHT));
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
