package com.game.Utilities;

import com.game.Characters.Character;
import com.game.Characters.Enemy;
import com.game.GamePanel.MainGamePanel;
import com.game.Items.Item;
import com.game.Characters.Hero;

/**
 * Handles collision detection for various game elements.
 * <p>
 * This class is responsible for determining collisions between the player character, enemies, items,
 * and environmental obstacles within the game. It checks for interactions that can affect movement,
 * trigger item pickups, initiate combat, or any other game mechanics related to physical interactions
 * in the game world.
 */
public class CollisionChecker {

    MainGamePanel gamePanel;

    /**
     * Constructs a CollisionChecker associated with a specific game panel.
     *
     * @param gamepanel The game panel where the game elements are rendered and interacted with.
     */
    public CollisionChecker(MainGamePanel gamepanel) {
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

    public boolean isCharacterIntersecting(Item position){

        Hero hero = gamePanel.getHero();
        Enemy enemy = gamePanel.getEnemy();

        hero.solidArea.x = hero.getXPosition() + hero.solidArea.x;
        hero.solidArea.y = hero.getYPosition() + hero.solidArea.y;
        enemy.solidArea.x = enemy.getXPosition() + enemy.solidArea.x;
        enemy.solidArea.y = enemy.getYPosition() + enemy.solidArea.y;
        position.solidArea.x = position.getXPosition() + position.solidArea.x;
        position.solidArea.y = position.getYPosition() + position.solidArea.y;

        if (position.solidArea.intersects(hero.solidArea))
            return true;

        else if (position.solidArea.intersects(enemy.solidArea))
            return true;

        hero.solidArea.x = hero.solidAreaDefaultX;
        hero.solidArea.y = hero.solidAreaDefaultY;
        enemy.solidArea.x = enemy.solidAreaDefaultX;
        enemy.solidArea.y = enemy.solidAreaDefaultY;
        position.solidArea.x = position.solidAreaDefaultX;
        position.solidArea.y = position.solidAreaDefaultY;

        return false;
    }

    public boolean isTileOccupied(Item[] item, Position newItem) {

        Boolean tileOccupied = false;

        for (Item value : item) {
            if (value == null) continue;
            if (value.getXPosition() == newItem.getXPosition()) {
                if (value.getYPosition() == newItem.getYPosition()) {
                    tileOccupied = true;
                }
            }
        }
        return tileOccupied;

    }


    public int checkInteract(Character hero, Character enemy){

        if (hero.solidArea.intersects(enemy.solidArea)) {
            hero.collisionOn = true;
            return 1;
        }
        return 999;
    }

    /**
     * Checks for collisions between the hero and enemy.
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
                    index = checkInteract(hero,enemy);

                    break;
                case DOWN:
                    hero.solidArea.y += hero.movementSpeed;
                    index = checkInteract(hero,enemy);

                    break;
                case LEFT:
                    hero.solidArea.x -= hero.movementSpeed;
                    index = checkInteract(hero,enemy);

                    break;
                case RIGHT:
                    hero.solidArea.x += hero.movementSpeed;
                    index = checkInteract(hero,enemy);

                    break;
            }
            hero.solidArea.x = hero.solidAreaDefaultX;
            hero.solidArea.y = hero.solidAreaDefaultY;
            enemy.solidArea.x = enemy.solidAreaDefaultX;
            enemy.solidArea.y = enemy.solidAreaDefaultY;
        }

    return index;
}
}


