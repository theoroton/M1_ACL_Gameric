package com.gameric.mazegame.graphiques;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

    private BufferedImage spriteSheet;
    private int x = 0 , y = 0, w = 0, h = 0;
    //private String fileName = "";

    public BufferedImage loadSprite(String file) {

        BufferedImage sprite = null;
        //ClassLoader classLoader = getClass().getClassLoader();

        try {
            System.out.println("Sprite name " +file);

            sprite = ImageIO.read(getClass().getResource("/images/sprites/" + file + ".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //sprite = (BufferedImage) new ImageIcon(getClass().getResource("/images/sprites/"+file+".png")).getImage();

        return sprite;
    }

    public BufferedImage getSprite(int xGrid, int yGrid, Class c) {

        if (spriteSheet == null) {
            switch(c.getSimpleName()) {
                case "Archer":
                    spriteSheet = loadSprite("archer");
                    w = spriteSheet.getWidth()/12;
                    h = spriteSheet.getHeight()/8;
                    x = xGrid * w;
                    y = yGrid * h;
                    break;
                case "Epeiste":
                    spriteSheet = loadSprite("epeiste");
                    w = spriteSheet.getWidth()/12;
                    h = spriteSheet.getHeight()/8;
                    x = xGrid * w;
                    y = yGrid * h;
                    break;
                case "Mage":
                    spriteSheet = loadSprite("mage");
                    w = spriteSheet.getWidth()/12;
                    h = spriteSheet.getHeight()/8;
                    x = xGrid * w;
                    y = yGrid * h;
                    break;
            }
        }
        //System.out.println("Size " + c.getSimpleName());
        return spriteSheet.getSubimage(x, y, w, h);
    }

}