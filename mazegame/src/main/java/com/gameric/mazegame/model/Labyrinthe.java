package com.gameric.mazegame.model;

/**
 * 
 * @author Théo Roton
 * Classe Labyrinthe
 */
public class Labyrinthe {
	
	/**
	 * Largeur du labyrinthe
	 */
	private int largeur;
	/**
	 * Hauteur du labyrinthe
	 */
	private int hauteur;
	
	/**
	 * Constructeur d'un labyrinthe par défaut
	 */
	public Labyrinthe() {
		largeur = 10;
		hauteur = 8;
	}

	/**
	 * Méthode getter de l'attribut largeur
	 * @return largeur du labyrinthe
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * Méthode getter de l'attribut hauteur
	 * @return hauteur du labyrinthe
	 */
	public int getHauteur() {
		return hauteur;
	}
	
}
