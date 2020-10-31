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
	 * Tableau des cases du labyrinthe
	 */
	private Case[][] cases;
	
	/**
	 * Position x de l'entrée
	 */
	private int xEntree;
	/**
	 * Position y de l'entrée
	 */
	private int yEntree;
	/**
	 * Position x de l'entrée
	 */
	private int xSortie;
	/**
	 * Position y de l'entrée
	 */
	private int ySortie;
	
	/**
	 * Personnage joueur du labyrinthe
	 */
	private Personnage personnage_laby;
	
	/**
	 * Constructeur d'un labyrinthe par défaut
	 */
	public Labyrinthe(Personnage p) {
		largeur = 10;
		hauteur = 10;
		personnage_laby = p;
		
		//Génération du labyrinthe par défaut
		genererLabyrintheDefaut();
	}
	
	/**
	 * Constructeur d'un labyrinthe par défaut en précisant sa taille
	 * @param l : largeur du labyrinthe
	 * @param h : hauteur du labyrinthe
	 */
	public Labyrinthe(int l, int h, Personnage p) {
		largeur = l;
		hauteur = h;
		personnage_laby = p;
		
		//Génération du labyrinthe par défaut
		genererLabyrintheDefaut();
	}
	
	/**
	 * Méthode qui permet de générer le labyrinthe par défaut
	 */
	private void genererLabyrintheDefaut() {
		//Tableau des cases du labyrinthe
		cases = new Case[hauteur][largeur];
		//Initialisation entrée et sortie
		xEntree = 0;
		yEntree = 1;
		xSortie = largeur-1;
		ySortie = hauteur-2;
		
		//Pour chaque case du tableau
		for (int i=0; i<hauteur; i++) {
			for (int j=0; j<largeur; j++) {
				//Si cette case est au extrémités, alors c'est un mur
				if (i==0 || i==hauteur-1 || j==0 || j==largeur-1) {
					cases[i][j] = new Mur(j,i);
				//Sinon c'est une case vide
				} else {
					cases[i][j] = new CaseVide(j,i);
				}
			}
		}
		
		//Ajout de l'entrée et de la sortie
		cases[yEntree][xEntree] = new CaseEntree(xEntree,yEntree);
		cases[ySortie][xSortie] = new CaseSortie(xSortie,ySortie);
	}

	/**
	 * Méthode getter de l'attribut cases
	 * @return tableau des cases du labyrinthe
	 */
	public Case[][] getCases() {
		return cases;
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
	
	/**
	 * Méthode getter de l'attribut personnage_laby
	 * @return le personnage joueur du labyrinthe
	 */
	public Personnage getPersonnage_laby() {
		return personnage_laby;
	}

	/**
	 * Méthode qui retourne la case à la position (x,y) dans le labyrinthe 
	 * @param x : position x de la case
	 * @param y : position y de la case
	 * @return Case correspondant à la position
	 */
	public Case getCase(int x, int y) {
		return cases[y][x];
	}
	
}
