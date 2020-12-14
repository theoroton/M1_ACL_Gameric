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
<<<<<<< HEAD
	private void capaciteSpe(){
=======
	public void capaciteSpe(){
>>>>>>> e3f72ac1948be1b92683a9f41287798bdd46944a
		setPointsVie(pointsVie + 2);
	}
}
