package com.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UtilityTool {
    public BufferedImage scaleImage(BufferedImage image, int w, int h){

        BufferedImage Image = new BufferedImage(w,h,image.getType());
        Graphics2D i2 = Image.createGraphics();
        i2.drawImage(image, 0,0,w,h,null);
        i2.dispose();

        return Image;
    }

}
