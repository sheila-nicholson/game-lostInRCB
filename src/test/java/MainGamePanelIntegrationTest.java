import com.game.Characters.*;
import com.game.GamePanel.GamePanel;
import com.game.GamePanel.MainGamePanel;
import com.game.Key.Direction;
import com.game.Tile.TileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

public class MainGamePanelIntegrationTest {
    private MainGamePanel gamePanel;

    @BeforeEach
    void setUp(){
        gamePanel = new MainGamePanel();
    }

    @Test
    void runShouldUpdateAndRenderEnemyMovementWhenHeroOnTheLeftTopSideOfEnemy() throws InterruptedException {

        assertFalse(gamePanel.isRunning());
        gamePanel.getHero().setPosition(2*gamePanel.tileSize, 4*gamePanel.tileSize);
        gamePanel.startGame("Medium");
        gamePanel.thread.sleep(4000);

        assertTrue(gamePanel.getHero().update());
        assertTrue(gamePanel.getEnemy().update());
        gamePanel.gameTerminator.endGame();
        assertFalse(gamePanel.isRunning());

    }

    @Test
    void runShouldUpdateAndRenderEnemyMovementWhenHeroOnTheRightBottomSideOfEnemy() throws InterruptedException {

        assertFalse(gamePanel.isRunning());
        gamePanel.getEnemy().setPosition(2*gamePanel.tileSize, 2*gamePanel.tileSize);
        gamePanel.startGame("Medium");
        gamePanel.thread.sleep(1000);
        gamePanel.getHero().setPosition(14*gamePanel.tileSize, 4*gamePanel.tileSize);
        assertTrue(gamePanel.getHero().update());
        assertTrue(gamePanel.getEnemy().update());

        gamePanel.gameTerminator.endGame();
        assertFalse(gamePanel.isRunning());
    }


    @Test
    void testGameLevelOfDifficulty(){

        gamePanel.startGame("Easy");
        gamePanel.tileM = new TileManager(gamePanel,"Easy");
        assertEquals("Easy", gamePanel.getDifficulty());
        gamePanel.gameTerminator.endGame();

        gamePanel.startGame("Medium");
        gamePanel.tileM = new TileManager(gamePanel,"Medium");
        assertEquals("Medium", gamePanel.getDifficulty());
        gamePanel.gameTerminator.endGame();

        gamePanel.startGame("Hard");
        gamePanel.tileM = new TileManager(gamePanel,"Hard");
        assertEquals("Hard", gamePanel.getDifficulty());
        gamePanel.gameTerminator.endGame();
    }


}

