package com.gameric.mazegame.model;

import com.gameric.mazegame.engine.Cmd;
import com.gameric.mazegame.engine.Game;

/**
 * 
 * @author Théo Roton
 * Classe du jeu labyrinthe
 */
public class JeuLabyrinthe implements Game {
	
	/**
	 * Labyrinthe du jeu
	 */
	private Labyrinthe labyrinthe;
	/**
	 * Personnage joueur du jeu
	 */
	private Personnage personnage;
	
	/**
	 * Attribut qui permet d'indiquer si le jeu est en cours;
	 */
	private boolean enCours;
	
	/**
	 * Constructeur du jeu
	 * On initialise un labyrinthe et le personnage du joueur
	 */
	public JeuLabyrinthe() {
		enCours = false;
	}
	
	/**
	 * Méthode qui permet de sélectionner la classe choisie par le joueur
	 * @param classe : classe choisie
	 */
	public void choixClasse(String classe) {
		switch (classe) {
		//Si le joueur a choisi Archer
		case "archer":
			personnage = new Archer();
			break;
		//Si le joueur a choisi Mage
		case "mage":
			personnage = new Mage();
			break;
		//Si le joueur a choisi Epeiste
		case "epeiste":
			personnage = new Epeiste();
			break;
		//Si la classe n'est pas reconnue, on crée un épeiste pour le personnage
		default:
			personnage = new Epeiste();
			break;
		}
	}
	
	/**
	 * Méthode qui permet de lancer le jeu
	 */
	public void lancerJeu() {
		labyrinthe = new Labyrinthe(personnage, "niveau1.txt");
	}

	/**
	 * Méthode qui fait évoluer le jeu en fonction de
	 * la commande
	 */
	public void evolve(Cmd userCmd) {
		//Switch sur la commande de l'utilisateur
		switch (userCmd) {
		//Commande UP
		case UP:
			//le personnage se déplace de 1 vers le haut (0,1)
			personnage.deplacer(0, -1);
			break;
		//Commande DOWN
		case DOWN:
			//le personnage se déplace de 1 vers le bas (0,-1)
			personnage.deplacer(0, 1);
			break;
		//Commande LEFT
		case LEFT:
			//le personnage se déplace de 1 vers la gauche (-1,0)
			personnage.deplacer(-1, 0);
			break;
		//Commande RIGHT
		case RIGHT:
			//le personnage se déplace de 1 vers la droite (1,0)
			personnage.deplacer(1, 0);
			break;
		//Commande PICKUP
		case PICKUP:
			//le personnage essaie de ramasser un objet
			personnage.ramasserObjet();
			break;
		case ATTACK:
			//le personnage attaque
			personnage.attaquer();
			break;
		}

		for (Monstre m : labyrinthe.getMonstres()) {
			m.deplacerMonstre();
		}
	}

	/**
	 * Méthode qui renvoi si le jeu est fini ou non
	 */
	public boolean isFinished() {
		boolean res = false;
		
		//Si le personnage est sur la case de sortie, alors on a gagné
		if (personnage.getPosition().getClass() == CaseSortie.class) {
			res = true;
		//Si le personnage est mort, alors on a perdu
		} else if (personnage.estMort()) {
			res = true;
		}	
		
		return res;
	}

	/**
	 * Méthode getter de l'attribut labyrinthe
	 * @return labyrinthe du jeu
	 */
	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}

	/**
	 * Méthode getter de l'attribut personnage
	 * @return personnage du jeu
	 */
	public Personnage getPersonnage() {
		return personnage;
	}
	
	/**
	 * Méthode getter de l'attribut enCours
	 * @return true si le jeu est en cours
	 */
	public boolean isEnCours() {
		return enCours;
	}

	/**
	 * Méthode setter de l'attribut enCours
	 * @param b : booléen qui permet de changer l'état du jeu.
	 */
	public void setEnCours(boolean b) {
		this.enCours = b;
	}

}
