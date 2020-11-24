package com.gameric.mazegame.model.labyrinthe;

import com.gameric.mazegame.model.personnage.Personnage;

/**
 * 
 * @author Théo Roton
 * Classe abstraite CaseEffet
 */
public abstract class CaseEffet extends CaseVide {

	/**
	 * Constructeur de la classe CaseEffet
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 */
	public CaseEffet(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Méthode qui effectue l'effet de la case
	 * @param p : Personnage sur lequel effectuer l'effet
	 */
	public abstract void faireEffet(Personnage p);

}
