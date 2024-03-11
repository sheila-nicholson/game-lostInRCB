package com.game;

import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;

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
            case Direction.UP:
                entityTopRow = (entityTopWorldY - position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true){
                    position.collisionOn = true;
                }
                break;
            case DOWN:
                entityBottomRow = (entityBottomWorldY + position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true){
                    position.collisionOn = true;
                }
                break;
            case LEFT:
                entityLeftCol = (entityLeftWorldX - position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true){
                    position.collisionOn = true;
                }
                break;
            case RIGHT:
                entityRightCol = (entityRightWorldX + position.movementSpeed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true){
                    position.collisionOn = true;
                }
                break;
        }
    }

    public int checkObject(Position position, boolean hero) {
        int index = 999;

        if(position.currentDirection == null)
            return index;

        for(int i = 0; i < gamePanel.item.length; i++) {
           if(gamePanel.item[i] != null) {

               // calculate the solid area of the hero:
               position.solidArea.x = position.getXPosition() + position.solidArea.x;
               position.solidArea.y = position.getYPosition() + position.solidArea.y;

                // calculate the solid area of the item:
               gamePanel.item[i].solidArea.x = gamePanel.item[i].getXPosition() + gamePanel.item[i].solidArea.x;
               gamePanel.item[i].solidArea.y = gamePanel.item[i].getYPosition() + gamePanel.item[i].solidArea.y;

               switch(position.currentDirection) {

                   case UP:
                       position.solidArea.y -= position.movementSpeed;
                       if(position.solidArea.intersects(gamePanel.item[i].solidArea)) {
                           if(gamePanel.item[i].collision == true)
                               position.collisionOn = true;
                           if(hero == true)
                               index = i;
                       }
                       break;
                   case DOWN:
                       position.solidArea.y += position.movementSpeed;
                       if(position.solidArea.intersects(gamePanel.item[i].solidArea)) {
                           if(gamePanel.item[i].collision == true)
                               position.collisionOn = true;
                           if(hero == true)
                               index = i;
                       }
                       break;
                   case LEFT:
                       position.solidArea.x -= position.movementSpeed;
                       if(position.solidArea.intersects(gamePanel.item[i].solidArea)) {
                           if(gamePanel.item[i].collision == true)
                               position.collisionOn = true;
                           if(hero == true)
                               index = i;
                       }
                       break;
                   case RIGHT:
                       position.solidArea.x += position.movementSpeed;
                       if(position.solidArea.intersects(gamePanel.item[i].solidArea)) {
                           if(gamePanel.item[i].collision == true)
                               position.collisionOn = true;
                           if(hero == true)
                               index = i;
                       }
                       break;
               }
               position.solidArea.x = position.solidAreaDefaultX;
               position.solidArea.y = position.solidAreaDefaultY;

               gamePanel.item[i].solidArea.x = gamePanel.item[i].solidAreaDefaultX;
               gamePanel.item[i].solidArea.y = gamePanel.item[i].solidAreaDefaultY;
           }
        }
    return index;
    }



}
