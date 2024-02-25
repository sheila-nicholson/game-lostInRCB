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
        return;
    }

    public void displayCharacter() {
        return;
    }

}
