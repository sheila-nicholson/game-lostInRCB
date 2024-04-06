import com.game.Characters.Enemy;
import com.game.Characters.Hero;
import com.game.CollisionChecker;
import com.game.GamePanel.GamePanel;
import com.game.Items.APlusPaper;
import com.game.Items.*;
import com.game.Key.Direction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class CollisionCheckerTest {

    private CollisionChecker collisionChecker;
    private GamePanel gamePanel;
    //private Item[] items;
    private String difficulty = "easy";
    private Hero hero;
    private Enemy enemy;


    @BeforeEach
    void setUp() {
        this.gamePanel = new GamePanel();
        this.collisionChecker = gamePanel.collisionChecker;
        gamePanel.setupGame(difficulty);
        hero = gamePanel.getHero();
        enemy = gamePanel.getEnemy();

    }

    @AfterEach
    void reset(){
        gamePanel.closeGamePanel();
    }

    @Test
    public void itemPlacementAllowed(){

        APlusPaper testItem = new APlusPaper(gamePanel);
        testItem.setPosition(1, 18);
        APlusPaper testItem2 = new APlusPaper(gamePanel);
        testItem.setPosition(50, 50);
        Item[] itemArr = {testItem2};
        itemArr[0] = null;
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


    //tests for collisions between hero and enemy
    @Test
    public void testCollisionWhenHeroOnTopOfEnemy(){

        hero.setPosition(gamePanel.tileSize , gamePanel.tileSize);
        enemy.setPosition(gamePanel.tileSize, enemy.getMovementSpeed()+gamePanel.tileSize);
        enemy.setCurrentDirection(Direction.UP);
        enemy.setAction();

        assertTrue(collisionChecker.checkCharacter(enemy,hero) != 999);

    }

    @Test
    public void testCollisionWhenHeroBelowOfEnemy(){

        hero.setPosition(gamePanel.tileSize , gamePanel.tileSize+enemy.getMovementSpeed());
        enemy.setPosition(gamePanel.tileSize , gamePanel.tileSize);
        enemy.setCurrentDirection(Direction.DOWN);
        enemy.setAction();

        assertTrue(collisionChecker.checkCharacter(enemy,hero) != 999);

    }

    @Test
    public void testCollisionWhenHeroLeftOfEnemy(){


        hero.setPosition(gamePanel.tileSize , gamePanel.tileSize);
        enemy.setPosition(gamePanel.tileSize+ enemy.getMovementSpeed() , gamePanel.tileSize);
        enemy.setCurrentDirection(Direction.LEFT);
        enemy.setAction();


        assertTrue(collisionChecker.checkCharacter(enemy,hero) != 999);

    }

    @Test
    public void testCollisionWhenHeroRightOfEnemy(){

        enemy.setCurrentDirection(Direction.RIGHT);
        hero.setPosition(gamePanel.tileSize + enemy.getMovementSpeed(), gamePanel.tileSize);
        enemy.setPosition(gamePanel.tileSize , gamePanel.tileSize);
        enemy.setAction();

        assertTrue(collisionChecker.checkCharacter(enemy,hero) != 999);

        enemy.checkCollision();
    }



}
