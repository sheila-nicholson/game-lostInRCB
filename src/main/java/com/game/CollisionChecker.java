package com.game;

import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;

public class CollisionChecker {

    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamepanel) {
        this.gamePanel = gamepanel;

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
