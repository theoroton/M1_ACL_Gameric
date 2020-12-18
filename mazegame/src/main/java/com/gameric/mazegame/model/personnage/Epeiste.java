package com.gameric.mazegame.model.personnage;

import java.awt.image.BufferedImage;

import com.gameric.mazegame.graphiques.Animation;
import com.gameric.mazegame.graphiques.Sprite;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Epeiste extends Personnage{
	//Constructeur
	public Epeiste(){
		super();
		pointsVie = vieMax = 30;
		degats = 6;
		portee = 1;

		attaqueUp = new BufferedImage[9];
		attaqueDown = new BufferedImage[9];
		attaqueLeft = new BufferedImage[9];
		attaqueRight = new BufferedImage[9];

		for (int i = 0; i < 9; i++) {
			attaqueUp[i] = new Sprite().getSprite(i, 21, this.getClass());
			attaqueDown[i] = new Sprite().getSprite(i, 23, this.getClass());
			attaqueLeft[i] = new Sprite().getSprite(i, 22, this.getClass());
			attaqueRight[i] = new Sprite().getSprite(i, 24, this.getClass());
		}

		attaqueU = new Animation(attaqueUp, 10);
		attaqueD = new Animation(attaqueDown, 10);
		attaqueL = new Animation(attaqueLeft, 10);
		attaqueR= new Animation(attaqueRight, 10);
	}
	//Méthodes

	/**
	 * Capacité spéciale, déclenchée lorsqu'on attaque un monstre
	 * Pour l'épéiste, augmentation de 2 dégâts pour chaque monstre tué
	 */
	protected void capaciteSpe(){
		setDegats(degats + 1);
	}
}
