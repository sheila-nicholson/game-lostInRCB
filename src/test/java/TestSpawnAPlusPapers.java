import com.game.GamePanel.MainGamePanel;
import com.game.Items.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestSpawnAPlusPapers {

    private MainGamePanel gamePanel;
    private String difficulty = "Easy";

    @BeforeEach
    public void setUp() {
        this.gamePanel = new MainGamePanel();
        gamePanel.setupGame(difficulty);

    }

    // cannot place item b/c item already present
    @Test
    public void placementNotAllowedItemAlreadyPresent(){

        boolean validPosition;
        APlusPaper testItem = new APlusPaper(gamePanel);
        testItem.setPosition(22,1);
        validPosition = !(gamePanel.collisionChecker.isTileOccupied(gamePanel.item, testItem));
        assertFalse(validPosition);
    }

    // cannot place item b/c not floor
    @Test
    public void placementNotAllowedNotFloor(){

        boolean validPosition;
        APlusPaper testItem = new APlusPaper(gamePanel);
        testItem.setPosition(0,0);
        int tileNum = gamePanel.tileM.getMapTileNum()[0][0];
        validPosition = gamePanel.tileM.getTile()[tileNum].getTileType() == "floor";
        assertFalse(validPosition);
    }

    // cannot place item b/c hero present
    @Test
    public void placementNotAllowedHeroAlreadyPresent(){

        boolean validPosition;
        APlusPaper testItem = new APlusPaper(gamePanel);
        testItem.setPosition(1,1);
        validPosition = !(gamePanel.collisionChecker.isHeroIntersecting(testItem));
        assertFalse(validPosition);
    }

    // can place item → is floor, item not present, enemy not present
    @Test
    public void placementAllowed(){

        boolean validPositionItem;
        boolean validPositionHero;
        boolean validPositionFloor;
        APlusPaper testItem = new APlusPaper(gamePanel);
        testItem.setPosition(6,1);
        int tileNum = gamePanel.tileM.getMapTileNum()[6][1];
        validPositionItem = !(gamePanel.collisionChecker.isTileOccupied(gamePanel.item, testItem));
        validPositionHero = !(gamePanel.collisionChecker.isHeroIntersecting(testItem));
        validPositionFloor = gamePanel.tileM.getTile()[tileNum].getTileType() == "floor";

        assertTrue(validPositionItem);
        assertTrue(validPositionHero);
        assertTrue(validPositionFloor);
    }

    // APlusPaper location is different after spawn
    @Test
    public void doesAPlusPaperReSpawn(){
        int orgPosX = gamePanel.item[3].getXPosition();
        int orgPosY = gamePanel.item[3].getYPosition();
        gamePanel.item[3].updateItemState();
        int respawnPosX = gamePanel.item[3].getXPosition();
        int respawnPosY = gamePanel.item[3].getYPosition();
        boolean xPosChanged = orgPosX != respawnPosX;
        boolean yPosChanged = orgPosY != respawnPosY;
        boolean moved = xPosChanged || yPosChanged;
        assertTrue(moved);
    }
}














