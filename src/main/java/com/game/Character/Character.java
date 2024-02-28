/*
 * Character.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */

package com.game.Character;

import com.game.Key.Key;
import com.game.Position;
import javafx.animation.Animation;

public abstract class Character extends Position {

    protected boolean up = false;
    protected boolean down = false;
    protected boolean left = false;
    protected boolean right = false;
    protected boolean fallen = false; //for vortex effect
    protected boolean collision = false; //enemy with playper


    protected Key currentDirection;
    protected Animation currentAnimation;

    protected int movementSpeed;

    protected abstract void setDefaultPosition();
    protected Character(int speed){
            this.setDefaultPosition();
            this.movementSpeed = speed;
    }

    private void setMovementSpeed(int speed){
        this.movementSpeed = speed;
    }

    public void setFallen(boolean f){
        this.fallen = f;
    }

//    public void setAnimation(Key direction){ //not finished
//    }
//
//    public void displayCharacter(){
//        if(collision){
//              then change the animation
//        }else if (left){
//           //then change the animation
//        }
//          .....
//    }

    /**
     *  need thread and handler to restrict it only move one time in a tick
     *  will update later
     *  */
    public void moveCharacter() {
        if(up){
            this.currentDirection = Key.UP;
            this.moveUp();

        }else if(down){
            this.currentDirection = Key.DOWN;
            this.moveDown();

        }else if(right){
            this.currentDirection = Key.RIGHT;
            this.moveRight();

        }else if(left){
            this.currentDirection = Key.LEFT;
            this.moveLeft();
        }
    }

    public void update(){
//        this.displayCharacter();

    }


}
