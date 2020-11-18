package com.gameric.mazegame.model;

/**
 * 
 * @author Anna Sushko
 * Sous-classe du Monstre qui deplace que aleatoirement
 *
 */

public class Zombie extends Monstre {
	
	static final int VIE_MAX = 30;
	
	public Zombie(int x, int y, Labyrinthe l) {
		super(x, y, l);
		setPortee(1);
		setVision(3);
		setDegats(5);
		setTraverserMur(false);
		setPointsVie(VIE_MAX);
	}

}
