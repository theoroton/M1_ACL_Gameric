package com.gameric.mazegame.model.monstres;

import com.gameric.mazegame.model.labyrinthe.Labyrinthe;

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
		super(x, y, l, 400);
		portee = 3;
		vision = 5;
		degats = 3;
		traverserMur = false;
		pointsVie = VIE_MAX;
	}
}
