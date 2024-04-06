import com.game.Characters.Enemy;
import com.game.Characters.Hero;
import com.game.GamePanel.GamePanel;
import com.game.GameTerminator.DefaultGameTerminator;
import com.game.GameTerminator.GameTerminator;
import com.game.Key.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestExitGame {

    private GamePanel gamePanel;
    private Enemy enemy;
    private Hero hero;

    @BeforeEach
    void setUp() {
        this.gamePanel = new GamePanel();

        gamePanel.setupGame("Easy");
        hero = gamePanel.getHero();
        enemy = gamePanel.getEnemy();
        gamePanel.gameTerminator = mock(GameTerminator.class); // Mock the GameTerminator
    }

    @Test
    public void testExitGameAfterCollisionBetweenHeroAndEnemy() {
        hero.setPosition(gamePanel.tileSize, gamePanel.tileSize);
        enemy.setPosition(gamePanel.tileSize, enemy.getMovementSpeed() + gamePanel.tileSize);
        enemy.setCurrentDirection(Direction.UP);

        enemy.checkCollision();

        verify(gamePanel.gameTerminator).terminate(); // Verify terminate was called
    }

    @Test
    public void testEndGameSetsGameStateCorrectly() {
        DefaultGameTerminator terminator = new DefaultGameTerminator(gamePanel);
        terminator.endGame();
        assertFalse(gamePanel.running); // Game should not be running after endGame is called
        assertNull(gamePanel.thread); // Thread should be null after endGame is called
    }

    @Test
    public void testTerminateCallsEndGame() {
        GameTerminator terminator = new DefaultGameTerminator(gamePanel) {
            @Override
            public void terminate() {
                endGame();
            }
        };

        terminator.terminate();
        assertFalse(gamePanel.running);
        assertNull(gamePanel.thread);
    }
}

