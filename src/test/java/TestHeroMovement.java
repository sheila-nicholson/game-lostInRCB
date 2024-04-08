import com.game.Characters.Hero;
import com.game.GamePanel.MainGamePanel;
import com.game.Key.KeyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHeroMovement {

    private Hero hero;

    @BeforeEach
    void setHero(){
        MainGamePanel gamePanel = new MainGamePanel();
        KeyHandler keyHandler = new KeyHandler(gamePanel);
        hero = gamePanel.getHero();
    }

    @Test
    void testHeroMoveRight(){
        int expectX = hero.getXPosition() + hero.getMovementSpeed();
        hero.moveRight(hero.getMovementSpeed());
        assertEquals(expectX,hero.getXPosition());
    }

    @Test
    void testHeroMoveLeft(){
        int expectX = hero.getXPosition() - hero.getMovementSpeed();
        hero.moveLeft(hero.getMovementSpeed());
        assertEquals(expectX,hero.getXPosition());

    }

    @Test
    void testHeroMoveUp(){
        int expectY = hero.getYPosition() - hero.getMovementSpeed();
        hero.moveUp(hero.getMovementSpeed());
        assertEquals(expectY,hero.getYPosition());

    }

    @Test
    void testHeroMoveDown(){
        int expectY = hero.getYPosition() + hero.getMovementSpeed();
        hero.moveDown(hero.getMovementSpeed());
        assertEquals(expectY,hero.getYPosition());
    }

}
