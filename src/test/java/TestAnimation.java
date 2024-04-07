import com.game.Characters.*;
import com.game.GamePanel.MainGamePanel;
import com.game.Key.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestAnimation {

    private Hero hero;
    private Enemy enemy;
    private MainGamePanel gamePanel;

    public boolean areImagesEqual(BufferedImage img1, BufferedImage img2) {
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
    void setUp(){
        gamePanel = new MainGamePanel();
        gamePanel.setupGame("Easy");
        hero = gamePanel.getHero();
        enemy = gamePanel.getEnemy();
        gamePanel.g2 = (new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB)).createGraphics();
    }

    @Test
    void testSetImageWhenCharacterFaceLeft(){

        hero.setCurrentDirection(Direction.LEFT);
        hero.draw(gamePanel.g2);
        assertTrue(areImagesEqual(hero.leftImage, hero.currentImage));

        enemy.setCurrentDirection(Direction.LEFT);
        enemy.draw(gamePanel.g2);
        assertTrue(areImagesEqual(enemy.leftImage,enemy.currentImage));
    }

    @Test
    void testSetImageWhenCharacterFaceRight()  {

        hero.setCurrentDirection(Direction.RIGHT);
        hero.draw(gamePanel.g2);
        assertTrue(areImagesEqual(hero.rightImage, hero.currentImage));

        enemy.setCurrentDirection(Direction.RIGHT);
        enemy.draw(gamePanel.g2);
        assertTrue(areImagesEqual(enemy.rightImage,enemy.currentImage));
    }

    @Test
    void testSetImageWhenCharacterFaceUpOrDown()  {

        hero.setCurrentDirection(Direction.UP);
        hero.draw(gamePanel.g2);
        assertTrue(areImagesEqual((hero.getLastDirection() == Direction.LEFT)?hero.leftImage:hero.rightImage,hero.currentImage));

        enemy.setCurrentDirection(Direction.UP);
        enemy.draw(gamePanel.g2);
        assertTrue(areImagesEqual((enemy.getLastDirection() == Direction.LEFT)?enemy.leftImage:enemy.rightImage,enemy.currentImage));
    }




}