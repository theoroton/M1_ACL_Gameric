package com.gameric.mazegame.model;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Archer extends Personnage{
	//Constructeur
	public Archer(int x, int y){
		super(x,y);
		pointsVie = vieMax = 20;
		degats = 5;
		portee = 5;
	}
	//Méthodes

}
