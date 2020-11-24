package com.gameric.mazegame.model.labyrinthe;

import com.gameric.mazegame.model.objets.Objet;
import com.gameric.mazegame.model.personnage.Personnage;

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
	private Objet objet;
	
	/**
	 * Constructeur de la classe CaseObjet
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 * @param o : objet lié à la case
	 */
	public CaseObjet(int x, int y, Objet o) {
		super(x, y);
		ramasse = false;
		objet = o;
	}
	
	/**
	 * Méthode qui permet de ramasser l'objet sur la case et d'effectuer son
	 * effet
	 * @param p : Personnage qui ramasse l'objet
	 */
	public void ramasserObjet(Personnage p) {
		if (!ramasse) {
			objet.effetObjet(p);
			ramasse = true;
		} 	
	}

	/**
	 * Méthode getter de l'attribut objet
	 * @return objet sur cette case
	 */
	public Objet getObjet() {
		return objet;
	}

	/**
	 * Méthode getter de l'attribut ramasse
	 * @return true si l'objet a était ramassé
	 */
	public boolean isRamasse() {
		return ramasse;
	}
	
}
