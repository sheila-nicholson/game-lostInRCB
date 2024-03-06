/*
 * Wall.java
 * 
 * Class Description: Describes wall objects such as the boundaries of the map.
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:25 AM
 */

package com.game.Items;

import com.game.Position;

import java.awt.*;

public class Wall extends Position {

    private int wallLength = 1; // temporary value
    private Image wallSprite;

    Wall(int param_X, int param_y){

        setPosition(param_X,param_y);

    }
}
