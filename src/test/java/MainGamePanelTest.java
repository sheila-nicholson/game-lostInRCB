import com.game.GamePanel.MainGamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
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
    void paintComponentShouldDrawWithoutErrors() {

        gamePanel.setPreferredSize(new Dimension(800, 600));
        gamePanel.setSize(gamePanel.getPreferredSize());

        BufferedImage bufferedImage = new BufferedImage(
                gamePanel.getWidth(),
                gamePanel.getHeight(),
                BufferedImage.TYPE_INT_ARGB
        );

        Graphics graphics = bufferedImage.getGraphics();
        assertDoesNotThrow(() -> gamePanel.paintComponent(graphics),
                "The paintComponent method should not throw an exception."
        );

        graphics.dispose();
    }

}

