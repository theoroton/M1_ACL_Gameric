package com.gameric.mazegame.model;

/**
 * 
 * @author Théo Roton
 * Classe abstraite Case
 */
public abstract class Case {

	/**
	 * Position en x de la case
	 */
	private int px;
	/**
	 * Position en y de la case
	 */
	private int py;
	
	/**
	 * Constructeur de la classe Case
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 */
	public Case(int x, int y) {
		px = x;
		py = y;
	}

	/**
	 * Méthode getter de l'attribut px
	 * @return position en x de la case
	 */
	public int getPx() {
		return px;
	}

	/**
	 * Méthode getter de l'attribut py
	 * @return position en y de la case
	 */
	public int getPy() {
		return py;
	}
}