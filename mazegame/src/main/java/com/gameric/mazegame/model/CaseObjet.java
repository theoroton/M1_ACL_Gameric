package com.gameric.mazegame.model;

/**
 * 
 * @author Théo Roton
 * Classe CaseObjet
 */
public class CaseObjet extends CaseVide {

	/**
	 * Booléen qui indique si l'objet à déjà était ramasser
	 */
	private boolean ramasse;
	
	/**
	 * Objet lié à la case
	 */
	//private Objet objet;
	
	/**
	 * Constructeur de la classe CaseObjet
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 */
	public CaseObjet(int x, int y) {
		super(x, y);
		ramasse = false;
	}
	
	/**
	 * Méthode qui permet de ramasser l'objet sur la case et d'effectuer son
	 * effet
	 * @param p : Personnage qui ramasse l'objet
	 */
	public void ramasserObjet(Personnage p) {
		if (!ramasse) {
			//objet.effetObjet(p);
			ramasse = true;
		} 	
	}

}
