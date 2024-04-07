package com.game.Tile;

import com.game.GamePanel.MainGamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Manages and renders tiles for the game environment based on map configurations.
 * <p>
 * This class is responsible for loading tile images, setting up the game map based on predefined
 * configurations, and dynamically adjusting map elements such as introducing mysterious smoke tiles.
 * It supports rendering the entire tile set to the game panel and changing tile sprites dynamically
 * to reflect different game states or effects.
 */
public class TileManager {
    private MainGamePanel gp;
    private Tile[] tile;
    private int mapTileNum[][];
    boolean drawPath = true;
    private String mapDifficulty;

    /**
     * Constructs a TileManager with specified game panel and difficulty setting.
     * <p>
     * Initializes tile images and loads the map configuration based on the specified difficulty.
     *
     * @param gp The game panel to which the tiles will be rendered.
     * @param diff The difficulty setting of the game, affecting map layout and tile types.
     */
    public TileManager(MainGamePanel gp, String diff){
        this.mapDifficulty = diff;
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreeRow];
        getTileImage();
        loadMap();
    }

    /**
     * Loads and assigns images to the tile types used in the game.
     * <p>
     * Initializes the tile array with different types of tiles, setting their images, steppability,
     * and special properties like ending a level or activating effects like mysterious smoke.
     */
    public void getTileImage(){
        try{
            tile[0] = new GoodTile(true, false);
            tile[0].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/Wood Floor.png")));
            tile[0].setTileType("floor");

            tile[1] = new GoodTile(false, false);
            tile[1].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/start_door.png")));
            tile[1].setTileType("start");

            tile[2] = new GoodTile(false, false);
            tile[2].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/locker.png")));
            tile[2].setTileType("inner wall");
            //tile[2].collision = true;

            tile[3] = new GoodTile(false, false);
            tile[3].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/bricks.png")));
            tile[3].setTileType("outer wall");
            //tile[0].collision = true;

            tile[4] = new GoodTile(false, true);
            tile[4].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/end_door.png")));
            //tile[4].levelEnd = true;
            tile[4].setTileType("end");

            tile[5] = new MysteriousSmokeTile();
            tile[5].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/Wood Floor.png")));
            tile[5].setTileType("smoke");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Dynamically changes the sprite of a specified tile type.
     * <p>
     * Allows for dynamic visual changes in the game environment, such as activating
     * effects or altering the appearance of tiles based on game events.
     *
     * @param tileType The index of the tile type to change.
     * @param filename The new image file to set as the sprite for the tile type.
     */
    public void setSpriteChange(int tileType, String filename){
        try{
            tile[tileType].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/"+filename+".png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads the map configuration from a file based on the current difficulty setting.
     * <p>
     * Reads a map layout file, assigning tile numbers to the map matrix to configure the
     * game environment. It also introduces dynamic elements like mysterious smoke tiles
     * based on random or predetermined conditions.
     */
    public void loadMap(){
        try{
            InputStream is;
            if (this.mapDifficulty == "Easy"){
                is = getClass().getResourceAsStream("/Maps/map01.txt");
            }
            else if (this.mapDifficulty == "Medium") {
                is = getClass().getResourceAsStream("/Maps/map02.txt");
            }
            else if (this.mapDifficulty == "Hard"){
                is = getClass().getResourceAsStream("/Maps/map03.txt");
            }
            else{
                is = getClass().getResourceAsStream("/Maps/map01.txt");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            int numFloorTiles = 0;
            while(col < gp.maxScreenCol && row < gp.maxScreeRow){
                String line = br.readLine();
                while(col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    if (num == 0){
                        numFloorTiles++;
                    }
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

            //randomly placing a smoke tile
            Random rand = new Random();
            int floorTileToBeSmoke = rand.nextInt(numFloorTiles - 5 + 1) + 5;
            numFloorTiles = 0;
            for (int i = 0; i < mapTileNum.length; i++) {
                for (int j = 0; j < mapTileNum[i].length ; j++) {
                    if (mapTileNum[i][j] == 0){
                        if (numFloorTiles == floorTileToBeSmoke){
                            mapTileNum[i][j] = 5;
                            return;
                        }
                        numFloorTiles++;
                    }
                }
            }
        }catch(Exception e){
        }
    }

    /**
     * Renders the tiles to the game panel.
     * <p>
     * Draws the tile set to the screen based on the current map configuration, handling
     * the positioning and rendering of each tile according to its location in the map matrix.
     *
     * @param g2 The Graphics2D object used for drawing.
     */
    public void draw(Graphics2D g2){
/*        g2.drawImage(tile[0].getTileSprite(),0,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].getTileSprite(),48,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].getTileSprite(),96,0,gp.tileSize,gp.tileSize,null);*/
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreeRow){
            int tileNum = mapTileNum[col][row];
            g2.drawImage(tile[tileNum].getTileSprite(),x,y,gp.tileSize,gp.tileSize,null);
            col++;
            x += gp.tileSize;
            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
        //for testing
//        if(drawPath){
//            g2.setColor(new Color(255,0,0,70));
//
//            for(int i = 0; i < gp.pathFinder.pathList.size(); i++){
//                int worldX = gp.pathFinder.pathList.get(i).col * gp.tileSize;
//                int worldY = gp.pathFinder.pathList.get(i).row * gp.tileSize;
//
//            }
//        }
    }

    public String getMapDifficulty(){return mapDifficulty;}

    public int[][] getMapTileNum() {
        return mapTileNum;
    }

    public Tile[] getTile(){
        return tile;
    }

}
