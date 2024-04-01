import com.game.Character.Enemy;
import com.game.Character.Hero;
import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;
import com.game.Key.KeyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;


public class TestAnimation {

    private Hero hero;
    private GamePanel gamePanel;

    public boolean areImagesEqual(BufferedImage img1, BufferedImage img2) {
        if(img1 == null || img2 == null) return false;
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            return false;
        }

        for (int x = 0; x < img1.getWidth(); x++) {
            for (int y = 0; y < img1.getHeight(); y++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    @BeforeEach
    void setHero(){
        gamePanel = new GamePanel();
        KeyHandler keyHandler = new KeyHandler(gamePanel);
        hero = Hero.getInstance(4, keyHandler,gamePanel);

    }

    @Test
    void testAnimationWhenCharMoveRight(){
        hero.moveRight(hero.getMovementSpeed());
        Graphics2D mockGraphics = mock(Graphics2D.class);
        hero.draw(mockGraphics);
        assertTrue(areImagesEqual(hero.rightImage,hero.currentImage));
    }

    //not finish (need integration test)

}