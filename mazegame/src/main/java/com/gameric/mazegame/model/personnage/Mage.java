package com.gameric.mazegame.model.personnage;

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

		for (int i = 0; i < 12; i++) {
			attaqueUp[i] = new Sprite().getSprite(i, 16, this.getClass());
			attaqueDown[i] = new Sprite().getSprite(i, 18, this.getClass());
			attaqueLeft[i] = new Sprite().getSprite(i, 17, this.getClass());
			attaqueRight[i] = new Sprite().getSprite(i, 19, this.getClass());
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
