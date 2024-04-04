import com.game.Character.Enemy;
import com.game.Character.EnemyMovement.PathFinder;
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

        gamePanel.getEnemy().setPosition(startCol * gamePanel.tileSize, startRow * gamePanel.tileSize);

        pathFinder.setNode(startCol, startRow, goalCol, goalRow, enemy);

       // Run the pathfinding search
        boolean pathFound = pathFinder.search();
        assertTrue(pathFound, "Path should be found");

    }


    @Test
    public void testEnemySearchToGoalWithLongDistance() {

        //the map index limit is Row:18,Col:28
        int startCol = 1;
        int startRow = 1;
        int goalCol = 25;
        int goalRow = 16;

        gamePanel.getEnemy().setPosition(startCol * gamePanel.tileSize, startRow * gamePanel.tileSize);
        pathFinder.setNode(startCol, startRow, goalCol, goalRow, enemy);
        boolean pathFound = pathFinder.search();
        assertTrue(pathFound, "Path should be found");

    }


    @Test
    public void testSearchWithCollsion() {
        // Setup your test grid and nodes in gamePanel and pathFinder
        int startCol = 1;
        int startRow = 1;
        int goalCol = 27;
        int goalRow = 16;

        gamePanel.getEnemy().setPosition(startCol * gamePanel.tileSize, startRow * gamePanel.tileSize);
        pathFinder.setNode(startCol, startRow, goalCol, goalRow, enemy);

        // Run the pathfinding search
        boolean pathFound = pathFinder.search();
        assertTrue(pathFound, "Path should be found");

    }
    }
