package com.gameric.mazegame.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	private static Case[][] cases;
	
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
	 * Liste des monstres du labyrinthe
	 */
	private List<Monstre> monstres;
	
	/**
	 * Constructeur d'un labyrinthe par défaut
	 * @param p : personnage joueur du labyrinthe
	 */
	public Labyrinthe(Personnage p) {
		largeur = 10;
		hauteur = 10;
		personnage_laby = p;
		monstres = new ArrayList<Monstre>();
		
		//Génération du labyrinthe par défaut
		genererLabyrintheDefaut();
	}
	
	/**
	 * Constructeur d'un labyrinthe par défaut en précisant sa taille
	 * @param l : largeur du labyrinthe
	 * @param h : hauteur du labyrinthe
	 * @param p : personnage joueur du labyrinthe
	 */
	public Labyrinthe(int l, int h, Personnage p) {
		largeur = l;
		hauteur = h;
		personnage_laby = p;
		monstres = new ArrayList<Monstre>();
		
		//Génération du labyrinthe par défaut
		genererLabyrintheDefaut();
	}
	
	/**
	 * Constructeur d'un labyrinthe à partir d'un fichier
	 * @param p : personnage joueur du labyrinthe
	 * @param fichier : fichier qui va permettre de construire le labyrinthe
	 */
	public Labyrinthe(Personnage p, String fichier) {
		largeur = 12;
		hauteur = 12;
		personnage_laby = p;
		monstres = new ArrayList<Monstre>();
		
		//Génération du labyrinthe à partir du fichier donné
		genererLabyrinthe(fichier);
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
		
		//Placement du personnage dans le labyrinthe
		placerPersonnage();
	}
	
	/**
	 * Méthode qui permet de générer le labyrinthe à partir d'un fichier
	 * @param fichier : fichier de génération du labyrinthe
	 */
	private void genererLabyrinthe(String fichier) {
		//Tableau des cases du labyrinthe
		cases = new Case[hauteur][largeur];
		
		try {
			//Récupération du fichier
			BufferedReader fichLab = new BufferedReader(new FileReader("./src/main/ressources/"+fichier));
			String ligne;
			Case cas = null;
			//Position en x
			int i = 0;
			//Position en y
			int j = 0;
			
			//Pour chaque ligne du fichier
			while ((ligne = fichLab.readLine()) != null && j < hauteur) {
				//On découpe la ligne courante en un tableau de caractères
				char[] caracts = ligne.toCharArray();
				i = 0;
				
				//Pour chaque caractère
				while (i < largeur) {
					char c = caracts[i];
					//Si le caractère est un X, on crée un Mur à cette position
					if (c == 'X') {
						cas = new Mur(i,j);
					//Si le caractère est un E, on crée une CaseEntree à cette position
					} else if (c == 'E') {
						cas = new CaseEntree(i, j);
						xEntree = i;
						yEntree = j;
					//Si le caractère est un S, on crée une CaseSortie à cette position
					} else if (c == 'S') {
						cas = new CaseSortie(i,j);
						xSortie = i;
						ySortie = j;				
					//Sinon on crée une CaseVide à cette position
					} else {
						cas = new CaseVide(i, j);
					}
					 
					//On ajoute la case créer au tableau des cases
					cases[j][i] = cas;
					
					//Si le caractère est un M, on ajoute un monstre au labyrinthe à cette position
					if (c == 'M') {
						ajouterMonstre(i,j);
					}
					
					//On augmente de 1 le x
					i++;
				}
				//On augmente de 1 le y
				j++;
			}
			placerPersonnage();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé");
		} catch (IOException e) {
			System.out.println("Erreur de flux");
		}
	}

	/**
	 * Méthode qui permet de placer le personnage dans le labyrinthe à
	 * la position de la case d'entrée
	 */
	private void placerPersonnage() {
		personnage_laby.setPosition(xEntree, yEntree);	
	}

	/**
	 * Méthode qui permet de créer et placer un monstre
	 * @param x : position en X du monstre
	 * @param y : position en Y du monstre
	 */
	private void ajouterMonstre(int x, int y) {
		//Création du monstre à la position donnée
		Monstre m = new Monstre(x,y);
		//Ajout du monstre à la liste des monstres du labyrinthe
		monstres.add(m);
	}
	
	/**
	 * Méthode qui permet d'indiquer si une case vide est occupée
	 * @param x : position X de la case
	 * @param y : position Y de la case
	 * @return true si la case est occupée, false sinon
	 */
	public boolean estCaseOccupee(int x, int y) {
		boolean res = false;
		
		if (personnage_laby.getPosition() == cases[y][x]) {
			res = true;
		} else {
			for (Monstre m : monstres) {
				if (m.getPosition() == cases[y][x]) {
					res = true;
					break;
				}
			}
		}
		
		return res;
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
	public static Case getCase(int x, int y) {
		return cases[y][x];
	}

	/**
	 * Méthode getter de l'attribut xEntree
	 * @return position en X de l'entrée
	 */
	public int getxEntree() {
		return xEntree;
	}

	/**
	 * Méthode getter de l'attribut yEntree
	 * @return position en Y de l'entrée
	 */
	public int getyEntree() {
		return yEntree;
	}

	/**
	 * Méthode getter de l'attribut xSortie
	 * @return position en X de la sortie
	 */
	public int getxSortie() {
		return xSortie;
	}

	/**
	 * Méthode getter de l'attribut ySortie
	 * @return position en Y de la sortie
	 */
	public int getySortie() {
		return ySortie;
	}

	/**
	 * Méthode getter de l'attribut monstres
	 * @return monstres du labyrinthe
	 */
	public List<Monstre> getMonstres() {
		return monstres;
	}
	
}
