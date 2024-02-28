/*
 * Character.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */

package com.game.Character;

import com.game.Position;

public abstract class Character extends Position {

    //still need a type
//    private characterSprite;

    protected int movementSpeed;
    protected abstract void setDefaultPosition();
    protected Character(int speed){
            this.setDefaultPosition();
            this.movementSpeed = speed;
    }

    private void setMovementSpeed(int speed){
        this.movementSpeed = speed;
    }

    public void moveCharacter() {
        // move along array per game tick
        return;
    }

    public void displayCharacter() {
        // should be visible at all times XOR in vortex teleport animation (quick milliseconds?)
        return;
    }

}
