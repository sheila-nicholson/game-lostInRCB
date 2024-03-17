package com.game.Tile;

import com.game.GamePanel.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class TileManager {
    private GamePanel gp;
    private Tile[] tile;
    private int mapTileNum[][];
    boolean drawPath = true;
    private String mapDifficulty;

    public int[][] getMapTileNum() {
        return mapTileNum;
    }

    public Tile[] getTile(){
        return tile;
    }

    public TileManager(GamePanel gp, String diff){
        this.mapDifficulty = diff;
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreeRow];
        getTileImage();
        loadMap();
    }
    public void getTileImage(){
        try{
            tile[0] = new GoodTile(true, false);
            tile[0].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/light_orange.png")));
            tile[0].setTileType("floor");

            tile[1] = new GoodTile(true, false);
            tile[1].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/green.png")));
            tile[1].setTileType("start");

            tile[2] = new GoodTile(false, false);
            tile[2].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/dark_brown.png")));
            tile[2].setTileType("inner wall");
            //tile[2].collision = true;

            tile[3] = new GoodTile(false, false);
            tile[3].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/orange_grad.png")));
            tile[3].setTileType("outer wall");
            //tile[0].collision = true;

            tile[4] = new GoodTile(false, true);
            tile[4].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/red_end.png")));
            //tile[4].levelEnd = true;
            tile[4].setTileType("end");

            tile[5] = new MysteriousSmokeTile();
            tile[5].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/light_orange.png")));
            tile[5].setTileType("smoke");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setSpriteChange(int tileType, String filename){
        try{
            tile[tileType].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/"+filename+".png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
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
            else if (this.mapDifficulty == "Infinite"){
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

            Random rand = new Random();
            int floorTileToBeSmoke = rand.nextInt(numFloorTiles - 5 + 1) + 5;
            numFloorTiles = 0;
            for (int i = 0; i < mapTileNum.length; i++) {
                for (int j = 0; j < mapTileNum[i].length ; j++) {
                    if (mapTileNum[i][j] == 0){
                        if (numFloorTiles == floorTileToBeSmoke){
                            mapTileNum[i][j] = 5;
                            System.out.println(i);
                            System.out.println(j);
                            return;
                        }
                        numFloorTiles++;
                    }
                }
            }

        }catch(Exception e){
        }
    }
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

}
