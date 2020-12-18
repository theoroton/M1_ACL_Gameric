package com.gameric.mazegame.model.personnage;

import java.awt.image.BufferedImage;

import com.gameric.mazegame.graphiques.Animation;
import com.gameric.mazegame.graphiques.Sprite;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Mage extends Personnage{
	//Constructeur
	public Mage(){
		super();
		pointsVie = vieMax = 10;
		degats = 10;
		portee = 3;
		
		attaqueUp = new BufferedImage[7];
		attaqueDown = new BufferedImage[7];
		attaqueLeft = new BufferedImage[7];
		attaqueRight = new BufferedImage[7];

		for (int i = 0; i < 7; i++) {
			attaqueUp[i] = new Sprite().getSprite(i, 0, this.getClass());
			attaqueDown[i] = new Sprite().getSprite(i, 2, this.getClass());
			attaqueLeft[i] = new Sprite().getSprite(i, 1, this.getClass());
			attaqueRight[i] = new Sprite().getSprite(i, 3, this.getClass());
		}

		attaqueU = new Animation(attaqueUp, 10);
		attaqueD = new Animation(attaqueDown, 10);
		attaqueL = new Animation(attaqueLeft, 10);
		attaqueR= new Animation(attaqueRight, 10);
	}
	//Méthodes
	/**
	 * Capacité spéciale, déclenchée lorsqu'on attaque un monstre
	 * Pour le mage, plus 2 points de vie (soin) à chaque monstre tué
	 */
	protected void capaciteSpe(){
		setPointsVie(pointsVie + 2);
	}
}
