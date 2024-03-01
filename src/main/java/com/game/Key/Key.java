package com.game.Key;

public class Key {
    private boolean pressed = false;

    public Key(){}

    public boolean getPressed(){return this.pressed;}

    public void toggle(boolean pressed){
        if(pressed != this.pressed)  this.pressed = pressed;
    }

}
