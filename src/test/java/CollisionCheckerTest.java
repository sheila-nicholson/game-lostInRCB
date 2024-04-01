import com.game.Character.Hero;
import com.game.CollisionChecker;
import com.game.GamePanel.GamePanel;
import com.game.Items.APlusPaper;
import com.game.Items.*;
import com.game.Key.KeyHandler;
import com.game.Tile.TileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class CollisionCheckerTest {

    private CollisionChecker collisionChecker;
    private GamePanel gamePanel;
    //private Item[] items;
    private String difficulty = "easy";


    @BeforeEach
    public void setUp() {
        this.gamePanel = new GamePanel();
        this.collisionChecker = gamePanel.collisionChecker;
        gamePanel.setupGame(difficulty);

    }

    @Test
    public void itemPlacementAllowed(){

        APlusPaper testItem = new APlusPaper(gamePanel);
        testItem.setPosition(1, 18);
        APlusPaper testItem2 = new APlusPaper(gamePanel);
        testItem.setPosition(50, 50);
        Item[] itemArr = {testItem2};
        boolean validPosition;
        validPosition = !collisionChecker.isHeroIntersecting(testItem) &&
                !collisionChecker.isTileOccupied(itemArr, testItem);
        assertTrue(validPosition);
    }

    @Test
    public void itemPlacementNotAllowed(){

        APlusPaper testItem = new APlusPaper(gamePanel);
        testItem.setPosition(1, 0);
        APlusPaper testItem2 = new APlusPaper(gamePanel);
        testItem2.setPosition(1, 0);
        Item[] itemArr = {testItem2};
        boolean validPosition;
        validPosition = !collisionChecker.isHeroIntersecting(testItem) && !collisionChecker.isTileOccupied(itemArr, testItem);
        assertFalse(validPosition);

    }


}
