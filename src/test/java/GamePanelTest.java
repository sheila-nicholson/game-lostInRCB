import com.game.GamePanel.MainGamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import com.game.Characters.*;

import java.io.IOException;

class GamePanelTest {

    private MainGamePanel gamePanel;
    private Hero hero;
    private Enemy enemy;

    @BeforeEach
    void setUp() {
        gamePanel = new MainGamePanel();
        hero = gamePanel.getHero();
        enemy =gamePanel.getEnemy();
    }

    @Test
    void updateTest() throws IOException {
        gamePanel.update();
        verify(hero).update();
        verify(enemy).update();
    }
}
