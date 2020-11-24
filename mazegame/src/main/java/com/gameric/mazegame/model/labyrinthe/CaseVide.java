package com.gameric.mazegame.model.labyrinthe;

/**
 * 
 * @author Théo Roton
 * Classe CaseVide
 */
public class CaseVide extends Case {

	/**
	 * Constructeur de la classe CaseVide
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 */
	public CaseVide(int x, int y) {
		super(x, y);
		occupee = false;
	}

}
