import com.game.Character.Enemy;
import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnemyMovement {

    private Enemy enemy;
    private GamePanel gamePanel;

    @BeforeEach
    public void setUp() {
        gamePanel = new GamePanel();
        enemy = new Enemy(4,gamePanel);
        // Initialize the game character and game panel as needed
    }

//    @Test
//    public void testSearchPathMoveUp() {
//        // Setup the character and goal positions to move upwards
//        enemy.setPosition(100, 100); // Example starting position
////        gamePanel.setTileSize(32); // Set the tile size for the game panel
//
//        // Assume setting a solid area and the goal position
////        enemy.setSolidArea(new Rectangle(0, 0, 32, 32));
//        int goalCol = 2; // Goal column
//        int goalRow = 1; // Goal row, higher row should move character up
//
//        // Call the method to test
//        enemy.searchPath(goalCol, goalRow);
//
//        // Check if the character's direction is set to up
//        assertEquals(Direction.UP, enemy.getCurrentDirection());
//    }


    @Test
    public void testEnemyPathfindingToGoal() {
        // Set starting and goal positions for the test
        int startCol = 1;
        int startRow = 1;
        int goalCol = 3;
        int goalRow = 3;

        // Configure the enemy's initial position and pathfinding
        enemy.setPosition(startCol * gamePanel.originalTileSize, startRow * gamePanel.originalTileSize);
        pathFinder.setNode(startCol, startRow, goalCol, goalRow, enemy);

        // Run the pathfinding search
        boolean pathFound = pathFinder.search();
        assertTrue("Path should be found", pathFound);

        // Optionally, test the movement step by step if necessary
        enemy.moveAlongPath(pathFinder.getPathList()); // Implement moveAlongPath method based on your game logic

        // Verify enemy reaches the goal
        assertEquals("Enemy should reach goal column", goalCol, enemy.getXPosition() / mockGamePanel.tileSize);
        assertEquals("Enemy should reach goal row", goalRow, enemy.getYPosition() / mockGamePanel.tileSize);
    }

    // Additional tests can be added for different scenarios, like testing for obstacles, corner cases, etc.

}

}
