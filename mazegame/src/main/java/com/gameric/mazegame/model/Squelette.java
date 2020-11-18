package com.gameric.mazegame.model;

/**
 * 
 * @author Anna Sushko
 * Sous-classe du Monstre qui a une portee != 1
 *
 */

public class Squelette extends Monstre {

	static final int VIE_MAX = 10;
	
	/**
	 * Constructeur de la classe Squelette
	 * @param x
	 * @param y
	 * @param l
	 */
	public Squelette(int x, int y, Labyrinthe l) {
		super(x, y, l);
		portee = 3;
		vision = 5;
		degats = 1;
		traverserMur = false;
		pointsVie = VIE_MAX;
	}
}
