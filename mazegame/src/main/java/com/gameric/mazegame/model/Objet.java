package com.gameric.mazegame.model;

/**
 * 
 * @author Maeva Touchet
 *
 */
 
public abstract class Objet{
	//Attribut
	String nom;
	//Constructeur
	public Objet(String nom) {
		this.nom = nom;
	};
	//Méthodes
	public abstract void effetObjet(Personnage p);
	
	public String getNom() {
		return nom;
	}
	
}
