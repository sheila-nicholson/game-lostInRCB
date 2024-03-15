package com.game.Tile;

import com.game.GamePanel.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreeRow];
        getTileImage();
        loadMap();
    }
    public void getTileImage(){
        try{
            tile[0] = new GoodTile(false, false);
            tile[0].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/orange_grad.png")));
            tile[0].setTileType("outer wall");
            //tile[0].collision = true;

            tile[1] = new GoodTile(true, false);
            tile[1].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/green.png")));
            tile[1].setTileType("start");

            tile[2] = new GoodTile(false, false);
            tile[2].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/dark_brown.png")));
            tile[2].setTileType("inner wall");
            //tile[2].collision = true;

            tile[3] = new GoodTile(true, false);
            tile[3].setTileSprite(ImageIO.read(getClass().getResourceAsStream("/Tiles/light_orange.png")));
            tile[3].setTileType("floor");

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
            InputStream is = getClass().getResourceAsStream("/Maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxScreenCol && row < gp.maxScreeRow){
                String line = br.readLine();
                while(col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
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
    }
}
