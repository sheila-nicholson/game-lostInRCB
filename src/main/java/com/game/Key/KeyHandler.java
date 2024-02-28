package com.game.Key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *  will update later
 *
 **/
public class KeyHandler implements KeyListener{//not finished

    public static ArrayList<Key> keysList = new ArrayList<Key>();

    public void toggle(KeyEvent e, boolean pressed){

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }
}
