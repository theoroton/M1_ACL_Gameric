package com.gameric.mazegame.model;

/**
 * 
 * @author Maeva Touchet
 *
 */
 
public class Arme extends Objet{
	//Attribut
	int degats;
	//Constructeur
	public Objet(String nom, int degats){
		this.nom = nom;
		this.degats = degats;
	}
	//Méthodes
	public void effetObjet(Personnage p){
		p.updateAtk(degats);
	}
}
