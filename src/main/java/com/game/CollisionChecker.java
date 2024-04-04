package com.game;

import com.game.Character.Character;
import com.game.Character.Enemy;
import com.game.GamePanel.GamePanel;
import com.game.Items.Item;
import com.game.Character.Hero;
import com.game.Tile.MysteriousSmokeTile;

/**
 * Handles collision detection for various game elements.
 * <p>
 * This class is responsible for determining collisions between the player character, enemies, items,
 * and environmental obstacles within the game. It checks for interactions that can affect movement,
 * trigger item pickups, initiate combat, or any other game mechanics related to physical interactions
 * in the game world.
 */
public class CollisionChecker {

    GamePanel gamePanel;

    /**
     * Constructs a CollisionChecker associated with a specific game panel.
     *
     * @param gamepanel The game panel where the game elements are rendered and interacted with.
     */
    public CollisionChecker(GamePanel gamepanel) {
        this.gamePanel = gamepanel;
    }

    /**
     * Checks for collisions with tiles based on the current position and movement direction.
     * <p>
     * This method determines if moving in the current direction will result in a collision
     * with a non-steppable tile or trigger a special tile effect like ending the level or
     * activating a mysterious smoke tile.
     *
     * @param position The current position and solid area of the entity being checked.
     */
    public void checkTile(Position position){
        int entityLeftWorldX = position.getXPosition() + position.solidArea.x - 37;
        int entityRightWorldX = position.getXPosition() + position.solidArea.x + position.solidArea.width - 57;

        int entityTopWorldY = position.getYPosition() + position.solidArea.y - 47;
        int entityBottomWorldY = position.getYPosition() + position.solidArea.y + position.solidArea.height - 47;

        int entityLeftCol = entityLeftWorldX / gamePanel.tileSize;
        int entityRightCol = entityRightWorldX / gamePanel.tileSize;
        int entityTopRow = entityTopWorldY / gamePanel.tileSize;
        int entityBottomRow = entityBottomWorldY / gamePanel.tileSize;

        int tileNum1, tileNum2;

        switch (position.currentDirection) {
            case UP:
                entityTopRow = (entityTopWorldY - position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.getMapTileNum()[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileM.getMapTileNum()[entityRightCol][entityTopRow];
                if (!gamePanel.tileM.getTile()[tileNum1].tileSteppable() || !gamePanel.tileM.getTile()[tileNum2].tileSteppable()){
                    position.collisionOn = true;
                }
                if (gamePanel.tileM.getTile()[tileNum1].isLevelEnd()  || gamePanel.tileM.getTile()[tileNum2].isLevelEnd()){
                    position.reachedEndOn = true;
                }
                if(gamePanel.tileM.getTile()[tileNum1].isMysteriousSmokeTile() || gamePanel.tileM.getTile()[tileNum2].isMysteriousSmokeTile()){
                    position.mysteriousSmokeTileOn = true;
                    gamePanel.ui.showMessage("Mysterious smoke tile hit!");

                }
                break;
            case DOWN:
                entityBottomRow = (entityBottomWorldY + position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.getMapTileNum()[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tileM.getMapTileNum()[entityRightCol][entityBottomRow];
                if (!gamePanel.tileM.getTile()[tileNum1].tileSteppable() || !gamePanel.tileM.getTile()[tileNum2].tileSteppable()){
                    position.collisionOn = true;
                }
                if (gamePanel.tileM.getTile()[tileNum1].isLevelEnd() || gamePanel.tileM.getTile()[tileNum2].isLevelEnd()){
                    position.reachedEndOn = true;
                }
                if(gamePanel.tileM.getTile()[tileNum1].isMysteriousSmokeTile() || gamePanel.tileM.getTile()[tileNum2].isMysteriousSmokeTile()){
                    position.mysteriousSmokeTileOn = true;
                }
                break;
            case LEFT:
                entityLeftCol = (entityLeftWorldX - position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.getMapTileNum()[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileM.getMapTileNum()[entityLeftCol][entityBottomRow];
                if (!gamePanel.tileM.getTile()[tileNum1].tileSteppable() || !gamePanel.tileM.getTile()[tileNum2].tileSteppable()){
                    position.collisionOn = true;
                }
                if (gamePanel.tileM.getTile()[tileNum1].isLevelEnd() || gamePanel.tileM.getTile()[tileNum2].isLevelEnd()){
                    position.reachedEndOn = true;
                }
                if(gamePanel.tileM.getTile()[tileNum1].isMysteriousSmokeTile() || gamePanel.tileM.getTile()[tileNum2].isMysteriousSmokeTile()){
                    position.mysteriousSmokeTileOn = true;
                }
                break;
            case RIGHT:

                entityRightCol = (entityRightWorldX + position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.getMapTileNum()[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tileM.getMapTileNum()[entityRightCol][entityBottomRow];
                if (!gamePanel.tileM.getTile()[tileNum1].tileSteppable() || !gamePanel.tileM.getTile()[tileNum2].tileSteppable()){
                    position.collisionOn = true;
                }
                if (gamePanel.tileM.getTile()[tileNum1].isLevelEnd() || gamePanel.tileM.getTile()[tileNum2].isLevelEnd()){

                    position.reachedEndOn = true;
                }
                if(gamePanel.tileM.getTile()[tileNum1].isMysteriousSmokeTile() || gamePanel.tileM.getTile()[tileNum2].isMysteriousSmokeTile()){
                    position.mysteriousSmokeTileOn = true;
                }
                break;
        }
    }

    /**
     * Checks for interactions with items in the game world.
     * <p>
     * Determines if the player or an enemy is colliding with any item on the map, potentially
     * picking it up or triggering its effect depending on the game logic.
     *
     * @param position The position of the entity checking for item interaction.
     * @param hero A boolean indicating if the entity is the hero (true) or not (false).
     * @return The index of the item interacted with, or 999 if no interaction occurred.
     */
    public int checkItem(Position position, boolean hero) {
        int index = 999;
        Item[] item = gamePanel.getItem();

        if (position.currentDirection == null)
            return index;

        for (int i = 0; i < item.length; i++) {
            if (item[i] != null) {

                // calculate the solid area of the hero:
                position.solidArea.x = position.getXPosition() + position.solidArea.x;
                position.solidArea.y = position.getYPosition() + position.solidArea.y;

                // calculate the solid area of the item:
                item[i].solidArea.x = item[i].getXPosition() + item[i].solidArea.x;
                item[i].solidArea.y = item[i].getYPosition() + item[i].solidArea.y;

                switch (position.currentDirection) {

                    case UP:
                        position.solidArea.y -= position.movementSpeed;

                        if (position.solidArea.intersects(item[i].solidArea)) {
                            if (item[i].collision) {
                                position.collisionOn = true;
                                gamePanel.ui.showMessage(item[i].itemType + " item collected!");
                            }
                            if (hero)
                                index = i;
                        }
                        break;
                    case DOWN:
                        position.solidArea.y += position.movementSpeed;

                        if (position.solidArea.intersects(item[i].solidArea)) {
                            if (item[i].collision) {
                                position.collisionOn = true;
                                gamePanel.ui.showMessage(item[i].itemType + " item collected!");
                            }
                            if (hero)
                                index = i;
                        }
                        break;
                    case LEFT:
                        position.solidArea.x -= position.movementSpeed;

                        if (position.solidArea.intersects(item[i].solidArea)) {
                            if (item[i].collision) {
                                position.collisionOn = true;
                                gamePanel.ui.showMessage(item[i].itemType + " item collected!");
                            }
                            if (hero)
                                index = i;
                        }
                        break;
                    case RIGHT:
                        position.solidArea.x += position.movementSpeed;

                        if (position.solidArea.intersects(item[i].solidArea)) {
                            if (item[i].collision) {
                                position.collisionOn = true;
                                gamePanel.ui.showMessage(item[i].itemType + " item collected!");
                            }
                            if (hero)

                                index = i;
                        }
                        break;
                }
                position.solidArea.x = position.solidAreaDefaultX;
                position.solidArea.y = position.solidAreaDefaultY;

                item[i].solidArea.x = item[i].solidAreaDefaultX;
                item[i].solidArea.y = item[i].solidAreaDefaultY;
            }
        }
        return index;
    }

    /**
     * Checks if the hero intersects with any item.
     *
     * @param position The item to check for intersection.
     * @return {@code true} if there is an intersection, {@code false} otherwise.
     */
    public boolean isHeroIntersecting(Item position) {
        boolean intersect = false;
        Hero hero = gamePanel.getHero();

        hero.solidArea.x = hero.getXPosition() + hero.solidArea.x;
        hero.solidArea.y = hero.getYPosition() + hero.solidArea.y;

        position.solidArea.x = position.getXPosition() + position.solidArea.x;
        position.solidArea.y = position.getYPosition() + position.solidArea.y;

        if (position.solidArea.intersects(hero.solidArea)) {
            intersect = true;
            return intersect;
        }

        hero.solidArea.x = hero.solidAreaDefaultX;
        hero.solidArea.y = hero.solidAreaDefaultY;

        position.solidArea.x = position.solidAreaDefaultX;
        position.solidArea.y = position.solidAreaDefaultY;

        return intersect;
    }

    /**
     * Checks for a collision between an enemy and an item, such as a vortex.
     * <p>
     * This method is used to determine if an enemy intersects with a specific item on the map,
     * potentially triggering effects or interactions specific to the item. It's particularly
     * useful in scenarios where items like vortexes can move the hero or enemies across the map,
     * requiring collision checks between enemies and such items.
     *
     * @param item The item with which the enemy's collision is being checked.
     * @return {@code true} if the enemy intersects with the item, {@code false} otherwise.
     */
    public boolean isEnemyIntersecting(Item item) {
        Boolean intersect = false;

        Enemy enemy = gamePanel.getEnemy();

        item.solidArea.x = item.getXPosition() + item.solidArea.x;
        item.solidArea.y = item.getYPosition() + item.solidArea.y;

        enemy.solidArea.x = enemy.getXPosition() + enemy.solidArea.x;
        enemy.solidArea.y = enemy.getYPosition() + enemy.solidArea.y;


        if(item.solidArea.intersects(enemy.solidArea)) {

            intersect = true;
        }

        item.solidArea.x = item.solidAreaDefaultX;
        item.solidArea.y = item.solidAreaDefaultY;

        enemy.solidArea.x = enemy.solidAreaDefaultX;
        enemy.solidArea.y = enemy.solidAreaDefaultY;

        return intersect;
    }

    public boolean isTileOccupied(Item[] item, Position newItem) {

        Boolean tileOccupied = false;

        for(int i = 0; i < item.length; i++) {
            if(item[i] == null) continue;
            if(item[i].getXPosition() == newItem.getXPosition()) {
                if(item[i].getYPosition() == newItem.getYPosition()) {
                    tileOccupied = true;
                }
            }
        }
        return tileOccupied;

    }


    /**
     * Checks for collisions between the hero and enemies.
     * <p>
     * This method is used to detect when the hero comes into contact with an enemy, potentially
     * initiating combat or other interactions.
     *
     * @param hero The hero character to check for collisions.
     * @param enemy The enemy character to check for collisions.
     * @return An index value representing the collision status or identification.
     */
    public int checkCharacter(Character hero, Character enemy) { ///NEED TO CHANGE THE VARIABLE NAME LATER

        int index = 999;
        if (enemy != null) {
            // calculate the solid area of the hero:
            hero.solidArea.x = hero.getXPosition() + hero.solidArea.x;
            hero.solidArea.y = hero.getYPosition() + hero.solidArea.y;

            // calculate the solid area of the enemy:
            enemy.solidArea.x = enemy.getXPosition() + enemy.solidArea.x;
            enemy.solidArea.y = enemy.getYPosition() + enemy.solidArea.y;

            switch (hero.currentDirection) {

                case UP:
                    hero.solidArea.y -= hero.movementSpeed;
                    if (hero.solidArea.intersects(enemy.solidArea)) {
                        hero.collisionOn = true;
                        index = 1;
                    }
                    break;
                case DOWN:
                    hero.solidArea.y += hero.movementSpeed;
                    if (hero.solidArea.intersects(enemy.solidArea)) {
                        hero.collisionOn = true;
                        index = 1;
                    }
                    break;
                case LEFT:
                    hero.solidArea.x -= hero.movementSpeed;
                    if (hero.solidArea.intersects(enemy.solidArea)) {
                        hero.collisionOn = true;
                        index = 1;
                    }
                    break;
                case RIGHT:
                    hero.solidArea.x += hero.movementSpeed;
                    if (hero.solidArea.intersects(enemy.solidArea)) {
                        hero.collisionOn = true;
                        index = 1;
                    }
                    break;
            }
            hero.solidArea.x = hero.solidAreaDefaultX;
            hero.solidArea.y = hero.solidAreaDefaultY;
            enemy.solidArea.x = enemy.solidAreaDefaultX;
            enemy.solidArea.y = enemy.solidAreaDefaultY;
        }

    return index;
}

    /**
     * Checks for collision between a character and the player character.
     * <p>
     * This method is specifically used to detect collisions between any character and the player,
     * which could trigger game events such as combat, dialogue, or other interactions.
     *
     * @param character The character to check for collision with the player.
     * @return {@code true} if there is a collision, {@code false} otherwise.
     */
     public boolean checkPlayer(Character character){
            boolean check = false;
            if(character != null) {

                Hero hero = gamePanel.getHero();

                // calculate the solid area of enemy(temp):
                character.solidArea.x = character.getXPosition() + character.solidArea.x;
                character.solidArea.y = character.getYPosition() + character.solidArea.y;

                // calculate the solid area of hero:
                hero.solidArea.x = hero.getXPosition() + hero.solidArea.x;
                hero.solidArea.y = hero.getYPosition() + hero.solidArea.y;

                    switch(character.currentDirection) {

                        case UP:
                            character.solidArea.y -= character.movementSpeed;
                            if(character.solidArea.intersects(hero.solidArea)) {
                                character.collisionOn = true;
                                check = true;
                            }
                            break;
                        case DOWN:
                            character.solidArea.y += character.movementSpeed;
                            if(character.solidArea.intersects(hero.solidArea)) {
                                character.collisionOn = true;
                                check = true;

                            }
                            break;
                        case LEFT:
                            character.solidArea.x -= character.movementSpeed;
                            if(character.solidArea.intersects(hero.solidArea)) {
                                character.collisionOn = true;
                                check = true;
                            }
                            break;
                        case RIGHT:
                            character.solidArea.x += character.movementSpeed;
                            if(character.solidArea.intersects(hero.solidArea)) {
                                character.collisionOn = true;
                                check = true;
                            }
                            break;
                    }
                    character.solidArea.x = character.solidAreaDefaultX;
                    character.solidArea.y = character.solidAreaDefaultY;
                    hero.solidArea.x = hero.solidAreaDefaultX;
                    hero.solidArea.y = hero.solidAreaDefaultY;
                }
            return check;
    }

}


