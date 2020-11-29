package com.gameric.mazegame.model.monstres;

import com.gameric.mazegame.model.labyrinthe.Labyrinthe;

/**
 * 
 * @author Anna Sushko
 * Sous-classe du Monstre qui peut traverser les murs
 *
 */

public class Fantome extends Monstre {
	
	static final int VIE_MAX = 20;
	
	/**
	 * Constructeur de la classe Fantome
	 * @param x
	 * @param y
	 * @param l
	 */
	public Fantome(int x, int y, Labyrinthe l) {
		super(x, y, l, 200);
		portee = 1;
		vision = 3;
		degats = 2;
		traverserMur = true;
		pointsVie = VIE_MAX;
	}
}
