package com.game;

import com.game.Character.Character;
import com.game.Character.Enemy;
import com.game.GamePanel.GamePanel;
import com.game.Items.Item;
import com.game.Key.Direction;

public class CollisionChecker {

    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamepanel) {
        this.gamePanel = gamepanel;

    }
    public int checkObject(Position position, boolean hero) {
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
                           if(item[i].collision)
                               position.collisionOn = true;
                           if(hero)
                               index = i;
                       }
                       break;
                   case DOWN:
                       position.solidArea.y += position.movementSpeed;
                       if(position.solidArea.intersects(item[i].solidArea)) {
                           if(item[i].collision)
                               position.collisionOn = true;
                           if(hero)
                               index = i;
                       }
                       break;
                   case LEFT:
                       position.solidArea.x -= position.movementSpeed;
                       if(position.solidArea.intersects(item[i].solidArea)) {
                           if(item[i].collision)
                               position.collisionOn = true;
                           if(hero)
                               index = i;
                       }
                       break;
                   case RIGHT:
                       position.solidArea.x += position.movementSpeed;
                       if(position.solidArea.intersects(item[i].solidArea)) {
                           if(item[i].collision)
                               position.collisionOn = true;
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

