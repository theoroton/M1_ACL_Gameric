package com.gameric.mazegame.model.monstres;

import com.gameric.mazegame.model.labyrinthe.Labyrinthe;

/**
 * 
 * @author Anna Sushko
 * Sous-classe du Monstre qui deplace que aleatoirement
 *
 */

public class Zombie extends Monstre {
	
	static final int VIE_MAX = 30;
	
	/**
	 * Constructeur de la classe Zombie
	 * @param x
	 * @param y
	 * @param l
	 */
	public Zombie(int x, int y, Labyrinthe l) {
		super(x, y, l);
		portee = 1;
		vision = 3;
		degats = 5;
		traverserMur = false;
		pointsVie = VIE_MAX;
	}

}
