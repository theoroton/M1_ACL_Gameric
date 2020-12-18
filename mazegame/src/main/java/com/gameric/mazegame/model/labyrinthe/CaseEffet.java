package com.gameric.mazegame.model.labyrinthe;

import com.gameric.mazegame.model.personnage.Personnage;

/**
 * 
 * @author Théo Roton
 * Classe abstraite CaseEffet
 */
public abstract class CaseEffet extends CaseVide {

	/**
	 * Score de la case
	 */
	private int score;
	
	/**
	 * Constructeur de la classe CaseEffet
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 * @param s : score de la case
	 */
	public CaseEffet(int x, int y, int s) {
		super(x, y);
		score = s;
	}
	
	/**
	 * Méthode qui effectue l'effet de la case
	 * @param p : Personnage sur lequel effectuer l'effet
	 */
	public void faireEffet(Personnage p) {
		p.setScoreTotal(p.getScoreTotal() + score);
	};

}
