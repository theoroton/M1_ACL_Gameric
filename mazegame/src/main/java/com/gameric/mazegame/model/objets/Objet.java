package com.gameric.mazegame.model.objets;

import com.gameric.mazegame.model.personnage.Personnage;

/**
 * 
 * @author Maeva Touchet
 *
 */
 
public abstract class Objet{
	//Attribut
	String nom;
	private int score;
	
	//Constructeur
	public Objet(String nom, int s) {
		this.nom = nom;
		this.score = s;
	};
	//Méthodes
	public void effetObjet(Personnage p) {
		p.setScoreTotal(p.getScoreTotal() + score);
	};
	
	public String getNom() {
		return nom;
	}
	
}
