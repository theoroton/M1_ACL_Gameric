package com.gameric.mazegame.model.labyrinthe;

/**
 * 
 * @author Théo Roton
 * Classe Mur
 */
public class Mur extends Case {

	/**
	 * Constructeur de la classe Mur
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 */
	public Mur(int x, int y) {
		super(x, y);
		occupee = true;
	}

}
