package com.gameric.mazegame.model.labyrinthe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.gameric.mazegame.model.monstres.Fantome;
import com.gameric.mazegame.model.monstres.Monstre;
import com.gameric.mazegame.model.monstres.Squelette;
import com.gameric.mazegame.model.monstres.Zombie;
import com.gameric.mazegame.model.objets.Arme;
import com.gameric.mazegame.model.objets.ObjetMystere;
import com.gameric.mazegame.model.objets.Potion;
import com.gameric.mazegame.model.personnage.Personnage;


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
	
	private boolean niveauChange;
	
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
		p.setLabyrinthe(this);
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
		if (l < 10) { largeur = 10; } else { largeur = l; }
		if (h < 10) { hauteur = 10; } else { hauteur = h; }
		personnage_laby = p;
		p.setLabyrinthe(this);
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
		personnage_laby = p;
		p.setLabyrinthe(this);
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

		try {	
			//On teste si le fichier est bien construit
			testerFichier(fichier);
			
			//Récupération du fichier
			InputStream in = getClass().getResourceAsStream("/"+fichier);	
			BufferedReader fichLab = new BufferedReader(new InputStreamReader(in));	

			//Tableau des cases du labyrinthe
			cases = new Case[hauteur][largeur];
			Case cas = null;
			String ligne;
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
					//Si le caractère est un P, on crée une CasePiegee à cette position
					} else if (c == 'P') {
						cas = new CasePiegee(i, j);
					//Si le caractère est un T, on crée une CaseTeleportation à cette position
					} else if (c == 'T') {
						cas = new CaseTeleportation(i, j);
					//Si le caractère est un A, on crée une CaseApparition à cette position
					} else if (c == 'A') {
						cas = new CaseApparition(i, j);
					//Si le caractère est un p, on crée une CaseObjet avec une potion à cette position
					} else if (c == 'p') {
						cas = new CaseObjet(i, j, new Potion("Potion", 5));
					//Si le caractère est un a, on crée une CaseObjet avec une arme à cette positon
					} else if (c == 'a') {
						cas = new CaseObjet(i, j, new Arme("Arme", 2));
					//Si le caractère est un ?, on crée une CaseObjet avec un objet mystère dessus
					} else if (c == '?') {
						cas = new CaseObjet(i, j, new ObjetMystere());
					//Sinon on crée une CaseVide à cette position
					} else {
						cas = new CaseVide(i, j);
					}
					 
					//On ajoute la case créer au tableau des cases
					cases[j][i] = cas;
					
					//Si le caractère est un s, on ajoute un squelette au labyrinthe à cette position
					if (c == 's') {
						ajouterMonstre(new Squelette(i,j,this));
					//Si le caractère est un z, on ajoute un zombie au labyrinthe à cette position
					} else if (c == 'z') {
						ajouterMonstre(new Zombie(i,j,this));
					//Si le caractère est un f, on ajoute un fantôme au labyrinthe à cette position
					} else if (c == 'f') {
						ajouterMonstre(new Fantome(i,j,this));
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
			e.printStackTrace();
		//Si on obtient l'exception de taille du fichier, on crée un labyrinthe par défaut à la place
		} catch (TailleFichierException e) {
			e.printStackTrace();
			System.out.println("Création d'un labyrinthe par défaut");
			largeur = 10;
			hauteur = 10;
			//Génération par défaut
			genererLabyrintheDefaut();
		}
	}

	/**
	 * Méthode qui teste si le fichier donnée en entré est bien construit.
	 * Pour qu'un fichier soit bien construit, il faut que chaque ligne du fichier
	 * soit de la même taille.
	 * @param fichier : fichier à tester
	 * @throws IOException
	 * @throws TailleFichierException : exception qui indique que le fichier est mal formé
	 */
	private void testerFichier(String fichier) throws IOException, TailleFichierException {
		//Récupération du fichier
		InputStream in = getClass().getResourceAsStream("/"+fichier);	
		BufferedReader fichLab = new BufferedReader(new InputStreamReader(in));	
		
		//On récupére la première ligne
		String ligne = fichLab.readLine();
		//On initie le nb de lignes et de colonnes. (on utilise la taille de la première ligne pour comparer)
		int nbLignes = 1, nbColonnes = ligne.length();
		//Pour chaque ligne du fichier
		while ((ligne = fichLab.readLine()) != null) {
			//On augmente le nombre de ligne de 1
			nbLignes++;
			//Si la taille de la ligne courante est différente de la première, on renvoi une exception
			if (ligne.length() != nbColonnes) {
				throw new TailleFichierException("Il y a des lignes de tailles différentes dans le fichier");
			}
		}
		
		//On initie la largeur et la hauteur avec les valeurs que l'on a trouvé
		largeur = nbColonnes;
		hauteur = nbLignes;
	}

	/**
	 * Méthode qui permet de placer le personnage dans le labyrinthe à
	 * la position de la case d'entrée
	 */
	private void placerPersonnage() {
		personnage_laby.setPosition(xEntree, yEntree);	
	}

	/**
	 * Méthode qui ajoute un monstre au labyrinthe
	 * @param m : monstre à ajouter
	 */
	public void ajouterMonstre(Monstre m) {
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
		
		//On regarde si les coordonnées données sont correctes
		if (x >= 0 && x < largeur) {
			if (y >= 0 && y < hauteur) {
				
				//On regarde si la case est occupée
				if (cases[y][x].isOccupee()) {
					res = true;
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
	
	/**
	 * Méthode qui permet d'enlever un monstre de la liste des
	 * monstres du labyrinthe.
	 * @param m : Monstre à enlever
	 */
	public void enleverMonstre(Monstre m) {
		m.getPosition().setOccupee(false);
		m.getTimer().stop();
		monstres.remove(m);
	}
	
	/**
	 * Méthode qui permet d'arrêter les timers de tous les
	 * monstres du labyrinthe.
	 */
	public void arreterTimers() {
		for (Monstre m : monstres) {
			m.getTimer().stop();
		}
	}
	
	/**
	 * Méthode qui permet de relancer les timers de tous les 
	 * monstres du labyrinthe.
	 */
	public void reprendreTimers() {
		for (Monstre m : monstres) {
			m.setTimer();
		}
	}
	public void setNiveauChange(boolean n) {
		this.niveauChange = n;
	}
	public boolean getNiveauChange() {
		return niveauChange;
	}
	
}
