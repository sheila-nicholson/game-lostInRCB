package com.game;

import com.game.Character.Character;
import com.game.Character.Enemy;
import com.game.GamePanel.GamePanel;
import com.game.Items.Item;
import com.game.Key.Direction;
import com.game.Character.Hero;

import java.awt.*;

public class CollisionChecker {

    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamepanel) {
        this.gamePanel = gamepanel;

    }

    public void checkTile(Position position){
        int entityLeftWorldX = position.getXPosition() + position.solidArea.x - 47;
        int entityRightWorldX = position.getXPosition() + position.solidArea.x + position.solidArea.width - 47;
        int entityTopWorldY = position.getYPosition() + position.solidArea.y - 47;
        int entityBottomWorldY = position.getYPosition() + position.solidArea.y + position.solidArea.height - 47;

        int entityLeftCol = entityLeftWorldX/gamePanel.tileSize;
        int entityRightCol = entityRightWorldX/gamePanel.tileSize;
        int entityTopRow = entityTopWorldY/gamePanel.tileSize;
        int entityBottomRow = entityBottomWorldY/gamePanel.tileSize;

        int tileNum1, tileNum2;

        switch (position.currentDirection){
            case UP:
                entityTopRow = (entityTopWorldY - position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true){
                    position.collisionOn = true;
                }
                if (gamePanel.tileM.tile[tileNum1].levelEnd == true || gamePanel.tileM.tile[tileNum2].levelEnd == true){
                    position.reachedEndOn = true;
                }
                break;
            case DOWN:
                entityBottomRow = (entityBottomWorldY + position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true){
                    position.collisionOn = true;
                }
                if (gamePanel.tileM.tile[tileNum1].levelEnd == true || gamePanel.tileM.tile[tileNum2].levelEnd == true){
                    position.reachedEndOn = true;
                }
                break;
            case LEFT:
                entityLeftCol = (entityLeftWorldX - position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true){
                    position.collisionOn = true;
                }
                if (gamePanel.tileM.tile[tileNum1].levelEnd == true || gamePanel.tileM.tile[tileNum2].levelEnd == true){
                    position.reachedEndOn = true;
                }
                break;
            case RIGHT:
                entityRightCol = (entityRightWorldX + position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true){
                    position.collisionOn = true;
                }
                if (gamePanel.tileM.tile[tileNum1].levelEnd == true || gamePanel.tileM.tile[tileNum2].levelEnd == true){
                    position.reachedEndOn = true;
                }
                break;
        }
    }

    public int checkItem(Position position, boolean hero) {
        int index = 999;
        Item[] item = gamePanel.getItem();
        
        if(position.currentDirection == null)
            return index;

        for(int i = 0; i < item.length; i++) {
           if(item[i] != null) {

               // calculate the solid area of the hero:
               position.solidArea.x = position.getXPosition() + position.solidArea.x;
               position.solidArea.y = position.getYPosition() + position.solidArea.y;

                // calculate the solid area of the item:
               item[i].solidArea.x = item[i].getXPosition() + item[i].solidArea.x;
               item[i].solidArea.y = item[i].getYPosition() + item[i].solidArea.y;

               switch(position.currentDirection) {

                   case UP:
                       position.solidArea.y -= position.movementSpeed;

                       if(position.solidArea.intersects(item[i].solidArea)) {
                           if(item[i].collision) {
                               position.collisionOn = true;
                               gamePanel.ui.showMessage("DIAMONDS FOUND WOOHOO! -> UP"); // temporary
                           }
                           if(hero)
                               index = i;
                       }
                       break;
                   case DOWN:
                       position.solidArea.y += position.movementSpeed;

                       if(position.solidArea.intersects(item[i].solidArea)) {
                           if(item[i].collision) {
                               position.collisionOn = true;
                               gamePanel.ui.showMessage("DIAMONDS FOUND WOOHOO! -> DOWN"); // temporary
                           }
                           if(hero)
                               index = i;
                       }
                       break;
                   case LEFT:
                       position.solidArea.x -= position.movementSpeed;

                       if(position.solidArea.intersects(item[i].solidArea)) {
                           if(item[i].collision) {
                               position.collisionOn = true;
                               gamePanel.ui.showMessage("DIAMONDS FOUND WOOHOO! -> LEFT"); // temporary
                           }
                           if(hero)
                              index = i;
                       }
                       break;
                   case RIGHT:
                       position.solidArea.x += position.movementSpeed;

                       if(position.solidArea.intersects(item[i].solidArea)) {
                           if(item[i].collision) {
                               position.collisionOn = true;
                               gamePanel.ui.showMessage("DIAMONDS FOUND WOOHOO! -> RIGHT"); // temporary
                           }
                           if(hero)

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

    // Check if there is a collision between hero and item
    public boolean isHeroIntersecting(Item position) {
        Boolean intersect = false;
        Hero hero = gamePanel.getHero();

        hero.solidArea.x = hero.getXPosition() + hero.solidArea.x;
        hero.solidArea.y = hero.getYPosition() + hero.solidArea.y;

        position.solidArea.x = position.getXPosition() + position.solidArea.x;
        position.solidArea.y = position.getYPosition() + position.solidArea.y;

        if(position.solidArea.intersects(hero.solidArea)) {
            intersect = true;
            return intersect;
        }

        hero.solidArea.x = hero.solidAreaDefaultX;
        hero.solidArea.y = hero.solidAreaDefaultY;

        position.solidArea.x = position.solidAreaDefaultX;
        position.solidArea.y = position.solidAreaDefaultY;

        return intersect;
    }

    // Check if there is a collision between hero and enemy when hero is moved via vortex
    public boolean isEnemyIntersecting() {
        Boolean intersect = false;
        Enemy enemy = gamePanel.getEnemy();
        Hero hero = gamePanel.getHero();

        hero.solidArea.x = hero.getXPosition() + hero.solidArea.x;
        hero.solidArea.y = hero.getYPosition() + hero.solidArea.y;

        enemy.solidArea.x = enemy.getXPosition() + enemy.solidArea.x;
        enemy.solidArea.y = enemy.getYPosition() + enemy.solidArea.y;

        if(hero.solidArea.intersects(enemy.solidArea)) {
            intersect = true;
        }

        hero.solidArea.x = hero.solidAreaDefaultX;
        hero.solidArea.y = hero.solidAreaDefaultY;

        enemy.solidArea.x = enemy.solidAreaDefaultX;
        enemy.solidArea.y = enemy.solidAreaDefaultY;

        return intersect;
    }

    //check hero and enemy collision
    public int checkEnemy(Position position, boolean hero){
        Enemy enemy = gamePanel.getEnemy();

        if(position.currentDirection == null)
            return 0;

        if(enemy!= null) {

                // calculate the solid area of the hero:
                position.solidArea.x = position.getXPosition() + position.solidArea.x;
                position.solidArea.y = position.getYPosition() + position.solidArea.y;


                // calculate the solid area of the item:
                enemy.solidArea.x = enemy.getXPosition() + enemy.solidArea.x;
                enemy.solidArea.y = enemy.getYPosition() + enemy.solidArea.y;

                switch(position.currentDirection) {

                    case UP:
                        position.solidArea.y -= position.movementSpeed;
                        if(position.solidArea.intersects(enemy.solidArea)) {
                                position.collisionOn = true;
                        }
                        break;
                    case DOWN:
                        position.solidArea.y += position.movementSpeed;
                        if(position.solidArea.intersects(enemy.solidArea)) {
                                position.collisionOn = true;
                        }
                        break;
                    case LEFT:
                        position.solidArea.x -= position.movementSpeed;
                        if(position.solidArea.intersects(enemy.solidArea)) {
                                position.collisionOn = true;
                        }
                        break;
                    case RIGHT:
                        position.solidArea.x += position.movementSpeed;
                        if(position.solidArea.intersects(enemy.solidArea)) {
                                position.collisionOn = true;
                        }
                        break;
                }
                position.solidArea.x = position.solidAreaDefaultX;
                position.solidArea.y = position.solidAreaDefaultY;

                enemy.solidArea.x = enemy.solidAreaDefaultX;
                enemy.solidArea.y = enemy.solidAreaDefaultY;
            }
        return 0;
        }
}


