package com.gameric.mazegame.model.personnage;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Archer extends Personnage{
	//Attributs
	int compteur; //Compte le nombre de monstre tués pour la capaciteSpe
	//Constructeur
	public Archer(){
		super();
		pointsVie = vieMax = 20;
		degats = 5;
		portee = 5;
	}
	//Méthodes
	/**
	 * Capacité spéciale, déclenchée lorsqu'on attaque un monstre
	 * Pour l'archer, plus un de portée tous les 3 monstres tués
	 */
	public void capaciteSpe(){
		if(compteur == 3) {
			setPortee(portee + 1);
			compteur = 0;
		}
	}
}
