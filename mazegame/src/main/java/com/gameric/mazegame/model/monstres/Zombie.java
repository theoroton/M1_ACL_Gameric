package com.gameric.mazegame.model.monstres;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.gameric.mazegame.graphiques.Animation;
import com.gameric.mazegame.graphiques.Sprite;
import com.gameric.mazegame.model.labyrinthe.Labyrinthe;

/**
 * 
 * @author Anna Sushko
 * Sous-classe du Monstre qui deplace que aleatoirement
 *
 */

public class Zombie extends Monstre {
	
	static final int VIE_MAX = 30;
	
	/**
	 * Constructeur de la classe Zombie
	 * @param x
	 * @param y
	 * @param l
	 */
	public Zombie(int x, int y, Labyrinthe l) {
		super(x, y, l, 500);
		portee = 1;
		vision = 3;
		degats = 5;
		traverserMur = false;
		pointsVie = VIE_MAX;
		
		int count = 4;
		
		walkingDown = new BufferedImage[count];
		walkingLeft = new BufferedImage[count];
		walkingRight = new BufferedImage[count];
		walkingUp = new BufferedImage[count];
		standing = new BufferedImage[1];
		
		for (int i = 0; i < count; i++ ) {
			walkingDown[i] = new Sprite().getSprite(i, 0, this.getClass());//, new Sprite().getSprite(3, 0, this.getClass())};
			walkingLeft[i] = new Sprite().getSprite(i, 1, this.getClass());//, new Sprite().getSprite(3, 0, this.getClass())};
			walkingRight[i] = new Sprite().getSprite(i, 2, this.getClass());//, new Sprite().getSprite(3, 0, this.getClass())};
			walkingUp[i] = new Sprite().getSprite(i, 3, this.getClass());//, new Sprite().getSprite(3, 0, this.getClass())};
		}
		standing[0] = new Sprite().getSprite(0, 0, this.getClass());
		

		
		walkUp = new Animation(walkingUp, 10);
		walkDown = new Animation(walkingDown, 10);
		walkLeft = new Animation(walkingLeft, 10);
		walkRight = new Animation(walkingRight, 10);
		stand = new Animation(standing, 10);
	}

}
