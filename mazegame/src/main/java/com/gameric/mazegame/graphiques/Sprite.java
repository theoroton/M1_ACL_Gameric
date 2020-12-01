package com.gameric.mazegame.graphiques;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.gameric.mazegame.model.monstres.Zombie;

public class Sprite {

    private BufferedImage spriteSheet;
    private final int TILE_SIZE = 32;
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
        	//if(c == Zombie.class)
        		spriteSheet = loadSprite("zombie");
        }
        System.out.println("Size " + xGrid +" " +yGrid);
        return spriteSheet.getSubimage(xGrid * spriteSheet.getWidth()/4, yGrid * spriteSheet.getHeight()/4, spriteSheet.getWidth()/4, spriteSheet.getHeight()/4);
    }

}