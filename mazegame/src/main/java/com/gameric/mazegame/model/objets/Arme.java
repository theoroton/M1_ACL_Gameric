package com.gameric.mazegame.model.objets;

import com.gameric.mazegame.model.personnage.Personnage;

/**
 * 
 * @author Maeva Touchet
 *
 */
 
public class Arme extends Objet{
	//Attribut
	int degats;
	//Constructeur
	public Arme(String nom, int degats){
		super(nom, 50);
		this.degats = degats;
	}
	//Méthodes
	public void effetObjet(Personnage p){
		super.effetObjet(p);
		p.setDegats(p.getDegats() + degats);
	}
}
