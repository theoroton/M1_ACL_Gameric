package com.gameric.mazegame.model;

/**
 * 
 * @author Maeva Touchet
 *
 */
 
public class Potion extends Objet{
	//Attribut
	int soins;
	//Constructeur
	public Objet(String nom, int soins){
		this.nom = nom;
		this.soins = soins;
	}
	//Méthodes
	public void effetObjet(Personnage p){
		p.setPointsVie(p.getPointsVie + soins);
	}
}
