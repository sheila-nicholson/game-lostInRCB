import com.game.Character.Hero;
import com.game.GamePanel.GamePanel;
import com.game.Key.KeyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class testHeroMovement {

    private Hero hero;

    @BeforeEach
    void setHero(){
        GamePanel gamePanel = new GamePanel();
        KeyHandler keyHandler = new KeyHandler(gamePanel);
        hero = Hero.getInstance(4, keyHandler,gamePanel);
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
