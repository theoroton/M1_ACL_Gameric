package com.gameric.mazegame.model;

/**
 * 
 * @author Théo Roton
 * Classe CasePiegee
 */
public class CasePiegee extends CaseEffet {

	/**
	 * Dégats de la case piègée
	 */
	private int degats;
	
	/**
	 * Constructeur de la classe CasePiegee
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 */
	public CasePiegee(int x, int y) {
		super(x, y);
		degats = 4;
	}

	/**
	 * Méthode qui effectue l'effet de la case :
	 * 	- L'effet de la case piègée inflige des dégats
	 * 	au personnage qui l'active
	 * @param p : Personnage sur lequel effectuer l'effet
	 */
	public void faireEffet(Personnage p) {
		p.setPointsVie(p.getPointsVie() - degats);
	}

}
