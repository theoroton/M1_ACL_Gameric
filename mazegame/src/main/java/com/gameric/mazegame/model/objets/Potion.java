package com.gameric.mazegame.model.objets;

import com.gameric.mazegame.model.personnage.Personnage;

/**
 * 
 * @author Maeva Touchet
 *
 */
 
public class Potion extends Objet{
	//Attribut
	int soins;
	//Constructeur
	public Potion(String nom, int soins){
		super(nom, 50);
		this.soins = soins;
	}
	//Méthodes
	public void effetObjet(Personnage p){
		super.effetObjet(p);
		p.setPointsVie(p.getPointsVie() + soins);
	}
}
