package com.gameric.mazegame.model.monstres;

import java.awt.image.BufferedImage;

import com.gameric.mazegame.graphiques.Animation;
import com.gameric.mazegame.graphiques.Sprite;
import com.gameric.mazegame.model.labyrinthe.Labyrinthe;

/**
 * 
 * @author Anna Sushko
 * Sous-classe du Monstre qui a une portee != 1
 *
 */

public class Squelette extends Monstre {

	public static final int VIE_MAX = 10;
	
	/**
	 * Constructeur de la classe Squelette
	 * @param x
	 * @param y
	 * @param l
	 */
	public Squelette(int x, int y, Labyrinthe l) {
		super(x, y, l, 400);
		portee = 3;
		vision = 5;
		degats = 3;
		traverserMur = false;
		pointsVie = VIE_MAX;
		
		int count = 13;
		
		walkingDown = new BufferedImage[9];
		walkingLeft = new BufferedImage[9];
		walkingRight = new BufferedImage[9];
		walkingUp = new BufferedImage[9];
		standing = new BufferedImage[1];
		
		attaqueDown = new BufferedImage[count];
		attaqueLeft = new BufferedImage[count];
		attaqueRight = new BufferedImage[count];
		attaqueUp = new BufferedImage[count];
		
		for (int i = 0; i < count; i++ ) {
			
			if(i < 9) {
				walkingDown[i] = new Sprite().getSprite(i, 10, this.getClass());//, new Sprite().getSprite(3, 0, this.getClass())};
				walkingLeft[i] = new Sprite().getSprite(i, 9, this.getClass());//, new Sprite().getSprite(3, 0, this.getClass())};
				walkingRight[i] = new Sprite().getSprite(i, 11, this.getClass());//, new Sprite().getSprite(3, 0, this.getClass())};
				walkingUp[i] = new Sprite().getSprite(i, 8, this.getClass());//, new Sprite().getSprite(3, 0, this.getClass())};
			}
			
			attaqueDown[i] = new Sprite().getSprite(i, 18, this.getClass());
			attaqueLeft[i] = new Sprite().getSprite(i, 17, this.getClass());
			attaqueRight[i] = new Sprite().getSprite(i, 19, this.getClass());
			attaqueUp[i] = new Sprite().getSprite(i, 16, this.getClass());
		}
		standing[0] = new Sprite().getSprite(10, 0, this.getClass());

		
		walkUp = new Animation(walkingUp, 10);
		walkDown = new Animation(walkingDown, 10);
		walkLeft = new Animation(walkingLeft, 10);
		walkRight = new Animation(walkingRight, 10);
		stand = new Animation(standing, 10);
		
		attaqUp = new Animation(attaqueUp, 10);
		attaqDown = new Animation(attaqueDown, 10);
		attaqLeft = new Animation(attaqueLeft, 10);
		attaqRight = new Animation(attaqueRight, 10);
	}
}
