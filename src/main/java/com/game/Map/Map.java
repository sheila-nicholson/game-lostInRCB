package com.game.Map;

import com.game.Character.Enemy;
import com.game.Character.Hero;
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
}
