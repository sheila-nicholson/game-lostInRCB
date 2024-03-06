package com.game.Key;

import com.game.GamePanel.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyHandler implements KeyListener{//not finished

    //adaptor
    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();

    public KeyHandler(GamePanel gp){
        gp.addKeyListener(this);
    }

    void update(KeyEvent e, boolean pressed){
        int k = e.getKeyCode();
        if(k == KeyEvent.VK_A) left.toggle(pressed);
        if(k == KeyEvent.VK_D) right.toggle(pressed);
        if(k == KeyEvent.VK_W) up.toggle(pressed);
        if(k == KeyEvent.VK_S) down.toggle(pressed);
    }

    public boolean getPressed(Direction d){
        switch(d){
            case UP:
                return up.getPressed();
            case DOWN:
                return down.getPressed();
            case LEFT:
                return left.getPressed();
            case RIGHT:
                return right.getPressed();
            default:
                return false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) { update(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) { update(e, false);
    }
}
