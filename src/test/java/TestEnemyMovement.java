import com.game.Character.EnemyMovement.Node;
import com.game.Character.EnemyMovement.PathFinder;
import com.game.Character.Hero;
import com.game.Character.Enemy;
import com.game.GamePanel.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.game.Key.Direction;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestEnemyMovement {
    private Enemy enemy;
    private GamePanel gamePanel;
    private Hero hero;
    private PathFinder pathFinder;

//    @BeforeEach
//    void setUp() {
//        gamePanel = mock(GamePanel.class);
//        hero = mock(Hero.class);
//        enemy = new Enemy(2, gamePanel);
//        when(gamePanel.getHero()).thenReturn(hero);
//    }

    @BeforeEach
    void setUp() {
        gamePanel = mock(GamePanel.class);
        hero = mock(Hero.class);
        pathFinder = mock(PathFinder.class);

        // Set up a non-null solidArea for the mocked Hero
        when(hero.solidArea).thenReturn(new Rectangle(0, 0, 32, 32));  // Assuming 32x32 as example dimensions

        when(gamePanel.getHero()).thenReturn(hero);
        when(gamePanel.pathFinder).thenReturn(pathFinder);

        enemy = new Enemy(2, gamePanel);
    }

//    @Test
//    void testAIMovementTowardHero(){
//
//        when(hero.getXPosition()).thenReturn(100);
//        when(hero.getYPosition()).thenReturn(100);
//
//        enemy.setPosition(0, 0);
//
//        enemy.setAction();
//
//        // Test - Verify enemy is moving towards hero
//        Direction expectedDirection = hero.getCurrentDirection();
//        assertEquals(expectedDirection, enemy.getCurrentDirection());
//
//    }

//    @Test
//    void testAIMovementTowardHero() {
//        // Configure the hero's position
//        when(hero.getXPosition()).thenReturn(100);
//        when(hero.getYPosition()).thenReturn(100);
//
//        // Assume that the pathfinder successfully finds a path
//        when(pathFinder.search()).thenReturn(true);
//
//        // Mock the pathFinder to provide a path
//        Node nextNode = new Node(3, 4);  // Simulate a step in the path
//        ArrayList<Node> pathList = new ArrayList<>();
//        pathList.add(nextNode);
//        when(pathFinder.pathList).thenReturn(pathList);
//
//        enemy.onPath = true;  // Force the enemy to follow the pathfinding logic
//
//        // Execute the method under test
//        enemy.setAction();
//
//        // Verify that the enemy's direction is set
//        assertNotNull(enemy.getCurrentDirection()); // Check if the enemy's direction is updated
//    }




}
