import com.game.Characters.Enemy;
import com.game.Characters.EnemyMovement.PathFinder;
import com.game.GamePanel.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPathFinder {

    private GamePanel gamePanel;
    private Enemy enemy;
    private PathFinder pathFinder;

    @BeforeEach
    public void setUp() {

        gamePanel = new GamePanel();
        gamePanel.setupGame("Medium");
        enemy = gamePanel.getEnemy();
        pathFinder = gamePanel.pathFinder;

    }

    @Test
    public void testEnemySearchToGoalWithShortDistance() {

        //the map index limit is Row:18,Col:28
        int startCol = 1;
        int startRow = 1;
        int goalCol = 4;
        int goalRow = 4;

        enemy.setPosition(startCol * gamePanel.tileSize, startRow * gamePanel.tileSize);

        pathFinder.setNode(startCol, startRow, goalCol, goalRow, enemy);

       // Run the pathfinding search
        boolean pathFound = pathFinder.search();
        assertTrue(pathFound);

    }


    @Test
    public void testEnemySearchToGoalWithLongDistance() {

        //the map index limit is Row:18,Col:28
        int startCol = 1;
        int startRow = 1;
        int goalCol = 25;
        int goalRow = 16;

        enemy.setPosition(startCol * gamePanel.tileSize, startRow * gamePanel.tileSize);
        pathFinder.setNode(startCol, startRow, goalCol, goalRow, enemy);
        boolean pathFound = pathFinder.search();
        assertTrue(pathFound);

    }


    @Test
    public void testSearchWithCollsion() {
        int startCol = 1;
        int startRow = 1;
        int goalCol = 27;
        int goalRow = 16;

        enemy.setPosition(startCol * gamePanel.tileSize, startRow * gamePanel.tileSize);
        pathFinder.setNode(startCol, startRow, goalCol, goalRow, enemy);

        // Run the pathfinding search
        boolean pathFound = pathFinder.search();
        assertTrue(pathFound);

    }

    @Test
    public void testSearchWithPositionThatHeroAndEnemyOnTheSamePosition() {
        pathFinder.goalReached = true;
        int startCol = 0;
        int startRow = 0;
        int goalCol = 0;
        int goalRow = 0;

        enemy.setPosition(startCol * gamePanel.tileSize, startRow * gamePanel.tileSize);
        pathFinder.setNode(startCol, startRow, goalCol, goalRow, enemy);

        // Run the pathfinding search
        boolean pathFound = !pathFinder.search();
        assertTrue(pathFound);

    }

}
