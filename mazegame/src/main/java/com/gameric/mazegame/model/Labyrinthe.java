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
	private static int largeur;
	/**
	 * Hauteur du labyrinthe
	 */
	private static int hauteur;
	
	/**
	 * Constructeur d'un labyrinthe par défaut
	 */
	public Labyrinthe() {
		largeur = 10;
		hauteur = 10;
	}
	
	/**
	 * Constructeur d'un labyrinthe en précisant sa taille
	 * @param l : largeur du labyrinthe
	 * @param h : hauteur du labyrinthe
	 */
	public Labyrinthe(int l, int h) {
		largeur = l;
		hauteur = h;
	}

	/**
	 * Méthode getter de l'attribut largeur
	 * @return largeur du labyrinthe
	 */
	public static int getLargeur() {
		return largeur;
	}

	/**
	 * Méthode getter de l'attribut hauteur
	 * @return hauteur du labyrinthe
	 */
	public static int getHauteur() {
		return hauteur;
	}
	
}
