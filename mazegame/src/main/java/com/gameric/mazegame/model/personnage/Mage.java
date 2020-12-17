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
	}
	//Méthodes
	/**
	 * Capacité spéciale, déclenchée lorsqu'on attaque un monstre
	 * Pour le mage, plus 2 points de vie (soin) à chaque monstre tué
	 */
	private void capaciteSpe(){
		setPointsVie(pointsVie + 2);
	}
}
