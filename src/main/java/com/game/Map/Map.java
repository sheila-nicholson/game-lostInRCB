/*
 * Map.java
 * 
 * Class Description: Controls aspects of items, walls and tiles, along with the game itself during runtime.
 *
 * Authors: [put your names here] + Brendan ???
 * Last modified on: March 6, 2024 1:27 AM
 */


package com.game.Map;

import com.game.Characters.Enemy;
import com.game.Characters.Hero;
import com.game.Items.Wall;
import com.game.Tile.Tile;

import java.util.ArrayList;

public class Map {
    private ArrayList<Tile>[][] tileGrid = new ArrayList[50][50];
    private ArrayList<Wall> Walls = new ArrayList<Wall>();
    private Hero Player;
    private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

    Map(ArrayList<Tile>[][] tileGrid){
        this.tileGrid = tileGrid;
    }

    // loadMap public - Map
}
