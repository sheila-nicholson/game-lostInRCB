import com.game.GamePanel.MainGamePanel;
import com.game.Items.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import com.game.Characters.*;

public class TestVortexMoveHero {

    private MainGamePanel gamePanel;
    private String difficulty = "Easy";
    private static Hero hero;
    private Enemy enemy;

    @BeforeEach
    public void setUp() {
        this.gamePanel = new MainGamePanel();
        gamePanel.setupGame(difficulty);
        hero = gamePanel.getHero();
        enemy = gamePanel.getEnemy();

    }

//    - hero cannot move to new tile b/c map tile is anything other than a ‘floor’ tile
    @Test
    public void placementNotAllowedNotFloor(){

        boolean validPosition;
        hero.setPosition(0,0);
        int tileNum = gamePanel.tileM.getMapTileNum()[0][0];
        validPosition = gamePanel.tileM.getTile()[tileNum].getTileType() == "floor";
        assertFalse(validPosition);
    }

//- hero cannot move to new tile b/c enemy already present
    @Test
    public void placementNotAllowedEnemy(){

        boolean validPosition;
        int enemyXCoord = enemy.getXPosition();
        int enemyYCoord = enemy.getYPosition();
        RewardItem dummyItem = new RewardItem(gamePanel);
        dummyItem.setPosition(enemyXCoord/48, enemyYCoord/48);
        validPosition = !(gamePanel.collisionChecker.isEnemyIntersecting(dummyItem));
        assertFalse(validPosition);
    }

//- hero move is valid (tile is floor, item not present, enemy not present)
    @Test
    public void placementAllowed(){

        boolean validPositionEnemy;
        boolean validPositionFloor;
        hero.setPosition(6,1);
        int tileNum = gamePanel.tileM.getMapTileNum()[6][1];
        RewardItem dummyItem = new RewardItem(gamePanel);
        validPositionEnemy = !(gamePanel.collisionChecker.isEnemyIntersecting(dummyItem));
        validPositionFloor = gamePanel.tileM.getTile()[tileNum].getTileType() == "floor";
        assertTrue(validPositionEnemy);
        assertTrue(validPositionFloor);
    }

    //- has the hero’s position actually changed after interaction with vortex
    @Test
    public void doesHeroLocationChange(){
        int orgPosX = hero.getXPosition();
        int orgPosY = hero.getYPosition();
        gamePanel.item[12].collisionAction(hero);
        int respawnPosX = hero.getXPosition();
        int respawnPosY = hero.getYPosition();
        boolean xPosChanged = orgPosX != respawnPosX;
        boolean yPosChanged = orgPosY != respawnPosY;
        boolean moved = xPosChanged || yPosChanged;
        assertTrue(moved);
    }
}
