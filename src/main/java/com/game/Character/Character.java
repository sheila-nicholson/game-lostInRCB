/*
 * Character.java
 * 
 * Class Description: Main attributes of all characters in the game.
 *                    Will be present through all iterations of the game in the
 *                    map (not the main menu).
 *
 * Authors: [put your names here]
 * Last modified on: March 5 10:47 AM
 */

package com.game.Character;

import com.game.Key.Direction;
import com.game.Position;
import javafx.animation.Animation;

import java.awt.*;
import java.security.DigestException;

public abstract class Character extends Position {

    protected boolean up, down, left, right, fallen, collision;
    up = down = left = right = fallen = collision = false;
    // fallen -> vortex effect, false -> enemy with character

    protected Direction currentDirection;
    protected Animation currentAnimation;

    protected int movementSpeed;

    protected abstract void setDefaultPosition();
    public abstract void update();
    public abstract void draw(Graphics2D g2);
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

/*  public void setAnimation(Key direction) { <- is this moveCharacter in the UML?
    
    //not finished
    }

    public void displayCharacter(){
        if (collision) {
              then change the animation
        } else if (left) {
           then change the animation
        } else if (right) {
            }
          .....
    }

    public void moveCharacter() { See above at setAnimationKey???

    }
*/
}
