/*
 * Character.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */

package com.game.Character;

import com.game.Key.Direction;
import com.game.Position;
import javafx.animation.Animation;

import java.security.DigestException;

public abstract class Character extends Position {

    protected boolean up = false;
    protected boolean down = false;
    protected boolean left = false;
    protected boolean right = false;
    protected boolean fallen = false; //for vortex effect
    protected boolean collision = false; //enemy with playper

    protected Direction currentDirection;
    protected Animation currentAnimation;

    protected int movementSpeed;

    protected abstract void setDefaultPosition();
    public abstract void update();
    public abstract void draw();
    public abstract void getImage();

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



}
