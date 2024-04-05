import com.game.Character.*;
import com.game.CollisionChecker;
import com.game.GamePanel.GamePanel;
import com.game.Items.*;
import com.game.Key.KeyHandler;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestItemScoreBonus {
    private CollisionChecker collisionChecker;
    private GamePanel gamePanel;
    private Hero hero;
    private Enemy enemy;
    private Item[] items;

    @BeforeEach
    public void setUp() {
        this.gamePanel = new GamePanel();
        KeyHandler keyHandler = new KeyHandler(gamePanel);
        this.hero = Hero.getInstance(4, keyHandler,gamePanel);
        gamePanel.item[0] = new APlusPaper(gamePanel);
        gamePanel.item[1] = new Bed(gamePanel);
        gamePanel.item[2] = new Coffee(gamePanel);
        gamePanel.item[3] = new PileOfBooks(gamePanel);
        gamePanel.item[4] = new Vortex(gamePanel);
    }

    @Test
    public void heroPicksUpAPlusPaper() {

        int initialScore = hero.getScore();
        hero.pickUpItem(0);
        int scoreAfterPickup = hero.getScore();
        int scoreDiff = scoreAfterPickup - initialScore;
        assertEquals(10, scoreDiff);
    }

    @Test
    public void heroPicksUpBed() {

        int initialScore = hero.getScore();
        hero.pickUpItem(1);
        int scoreAfterPickup = hero.getScore();
        int scoreDiff = scoreAfterPickup - initialScore;
        assertEquals(5, scoreDiff);
    }

    @Test
    public void heroPicksUpCoffee() {

        int initialScore = hero.getScore();
        hero.pickUpItem(2);
        int scoreAfterPickup = hero.getScore();
        int scoreDiff = scoreAfterPickup - initialScore;
        assertEquals(5, scoreDiff);
    }

    @Test
    public void heroPicksUpPileOfBooks() {

        int initialScore = hero.getScore();
        hero.pickUpItem(3);
        int scoreAfterPickup = hero.getScore();
        int scoreDiff = scoreAfterPickup - initialScore;
        assertEquals(-5, scoreDiff);
    }

    @Test
    public void heroPicksUpVortex() {

        int initialScore = hero.getScore();
        try {
            hero.pickUpItem(4); // This will throw an exception as it will attempt to move the hero position
        } catch (NullPointerException e) {
            // ignore the exception that is thrown
        }
        int scoreAfterPickup = hero.getScore();
        int scoreDiff = scoreAfterPickup - initialScore;
        assertEquals(-5, scoreDiff);
    }
}
