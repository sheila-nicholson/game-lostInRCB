import com.game.Characters.Enemy;
import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSearchPath {

    private GamePanel gamePanel;
    private Enemy enemy;

    @BeforeEach
    void setUp(){
        gamePanel = new GamePanel();
        gamePanel.setupGame("Easy");
        enemy = gamePanel.getEnemy();

    }

    @Test
    void testAdjustedEnemyDirectionWhenHeroStandOnRightUpPositionFromEnemy() {

        enemy.setPosition(2 * gamePanel.tileSize, 14 * gamePanel.tileSize); // Starting position of the enemy
        int goalCol = 5;
        int goalRow = 5;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.UP || enemy.getCurrentDirection() == Direction.RIGHT;
        assertTrue(isDirectionCorrect);
    }

    @Test
    void testAdjustedEnemyDirectionWhenHeroStandOnLeftUpPositionFromEnemy() {

        enemy.setPosition(10 * gamePanel.tileSize, 14 * gamePanel.tileSize); // Starting position of the enemy
        int goalCol = 5;
        int goalRow = 5;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.UP || enemy.getCurrentDirection() == Direction.LEFT;
        assertTrue(isDirectionCorrect);
    }

    @Test
    void testAdjustedEnemyDirectionWhenHeroStandOnRightDownPositionFromEnemy() {

        enemy.setPosition(2 * gamePanel.tileSize, 5 * gamePanel.tileSize); // Starting position of the enemy
        int goalCol = 5;
        int goalRow = 14;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.DOWN || enemy.getCurrentDirection() == Direction.RIGHT;
        assertTrue(isDirectionCorrect);
    }

    @Test
    void testAdjustedEnemyDirectionWhenHeroStandOnLeftDownPositionFromEnemy() {

        enemy.setPosition( 6 * gamePanel.tileSize, 5 * gamePanel.tileSize); // Starting position of the enemy
        int goalCol = 5;
        int goalRow = 14;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.DOWN || enemy.getCurrentDirection() == Direction.LEFT;
        assertTrue(isDirectionCorrect);
    }

    @Test
    void testAdjustedEnemyDirectionWhenHeroStandOnLeftPositionFromEnemy() {

        enemy.setPosition( 6 * gamePanel.tileSize, 5 * gamePanel.tileSize); // Starting position of the enemy
        int goalCol = 2;
        int goalRow = 5;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.LEFT;
        assertTrue(isDirectionCorrect);
    }


    @Test
    void testAdjustedEnemyDirectionWhenHeroStandOnRightPositionFromEnemy() {

        enemy.setPosition( 2 * gamePanel.tileSize, 5 * gamePanel.tileSize); // Starting position of the enemy
        int goalCol = 6;
        int goalRow = 5;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.RIGHT;
        assertTrue(isDirectionCorrect);
    }

    @Test
    void testAdjustedEnemyDirectionWhenHeroStandOnUpPositionFromEnemy() {

        enemy.setPosition( 2 * gamePanel.tileSize, 5 * gamePanel.tileSize); // Starting position of the enemy
        int goalCol = 2;
        int goalRow = 2;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.UP;
        assertTrue(isDirectionCorrect);
    }


    @Test
    void testAdjustedEnemyDirectionWhenHeroStandOnDownPositionFromEnemy() {

        enemy.setPosition( 2 * gamePanel.tileSize, 2 * gamePanel.tileSize); // Starting position of the enemy
        int goalCol = 2;
        int goalRow = 5;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.DOWN;
        assertTrue(isDirectionCorrect);
    }


    @Test
    void testAdjustedEnemyDirectionWithObstacleOnUpSideAndHeroOnLeftUpSide() {

        enemy.setPosition( 5 * gamePanel.tileSize-2, 6 * gamePanel.tileSize-1); // Starting position of the enemy
        int goalCol = 4;
        int goalRow = 4;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.UP || enemy.getCurrentDirection() == Direction.LEFT;
        assertTrue(isDirectionCorrect);
    }

    @Test
    void testAdjustedEnemyDirectionWithObstacleOnLeftSideAndHeroOnLeftUpSide() {

        enemy.setPosition( 5 * gamePanel.tileSize, 10 * gamePanel.tileSize-1); // Starting position of the enemy
        int goalCol = 4;
        int goalRow = 9;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.UP || enemy.getCurrentDirection() == Direction.LEFT;
        assertTrue(isDirectionCorrect);
    }

    @Test
    void testAdjustedEnemyDirectionWithObstacleOnUpSideAndHeroOnRightUpSide() {

        enemy.setPosition( 7 * gamePanel.tileSize+2, 6 * gamePanel.tileSize-1); // Starting position of the enemy
        int goalCol = 8;
        int goalRow = 5;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.UP || enemy.getCurrentDirection() == Direction.RIGHT;
        assertTrue(isDirectionCorrect);
    }


    @Test
    void testAdjustedEnemyDirectionWithObstacleOnRightSideAndHeroOnRightUpSide() {

        enemy.setPosition( 6 * gamePanel.tileSize+2, 7 * gamePanel.tileSize-1); // Starting position of the enemy
        int goalCol = 7;
        int goalRow = 6;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.UP || enemy.getCurrentDirection() == Direction.RIGHT;
        assertTrue(isDirectionCorrect);
    }


    @Test
    void testAdjustedEnemyDirectionWithObstacleOnLeftSideAndHeroOnLeftDownSide() {

        enemy.setPosition( 8 * gamePanel.tileSize-1, 5 * gamePanel.tileSize+2); // Starting position of the enemy
        int goalCol = 7;
        int goalRow = 6;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.DOWN || enemy.getCurrentDirection() == Direction.LEFT;
        assertTrue(isDirectionCorrect);
    }

    @Test
    void testAdjustedEnemyDirectionWithObstacleOnDownSideAndHeroOnLeftDownSide() {

        enemy.setPosition( 11 * gamePanel.tileSize-1, 4 * gamePanel.tileSize+2); // Starting position of the enemy
        int goalCol = 10;
        int goalRow = 5;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.DOWN || enemy.getCurrentDirection() == Direction.LEFT;
        assertTrue(isDirectionCorrect);
    }


    @Test
    void testAdjustedEnemyDirectionWithObstacleOnDownSideAndHeroOnRightDownSide() {

        enemy.setPosition( 7 * gamePanel.tileSize+10, 4 * gamePanel.tileSize);
        int goalCol = 8;
        int goalRow = 5;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.DOWN || enemy.getCurrentDirection() == Direction.LEFT;
        assertTrue(isDirectionCorrect);
    }



    @Test
    void testAdjustedEnemyDirectionWithObstacleOnDownSideAndHeroOnRightDownSide2() {

        enemy.setPosition( 8 * gamePanel.tileSize+2, 7 * gamePanel.tileSize);
        int goalCol = 9;
        int goalRow = 8;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.DOWN || enemy.getCurrentDirection() == Direction.RIGHT;
        assertTrue(isDirectionCorrect);
    }

    @Test
    void testAdjustedEnemyDirectionWithObstacleOnRightSideAndHeroOnRightDownSide() {

        enemy.setPosition( 9 * gamePanel.tileSize+2, 4 * gamePanel.tileSize);
        int goalCol = 10;
        int goalRow = 5;

        enemy.searchPath(goalCol, goalRow);

        boolean isDirectionCorrect = enemy.getCurrentDirection() == Direction.DOWN || enemy.getCurrentDirection() == Direction.RIGHT;
        assertTrue(isDirectionCorrect);
    }


}
