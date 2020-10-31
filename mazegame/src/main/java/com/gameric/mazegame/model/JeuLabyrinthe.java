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
	 * Constructeur du jeu
	 * On initialise un labyrinthe et le personnage du joueur
	 */
	public JeuLabyrinthe() {
		labyrinthe = new Labyrinthe(5, 5);
		personnage = new Personnage();
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
			personnage.deplacer(0, 1);
			break;
		//Commande DOWN
		case DOWN:
			//le personnage se déplace de 1 vers le bas (0,-1)
			personnage.deplacer(0, -1);
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
		}

		//Affichage de la position du personnage après une commande
		System.out.println("Personnage " + personnage.getPosition());
	}

	/**
	 * Méthode qui renvoi si le jeu est fini ou non
	 */
	public boolean isFinished() {
		return false;
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

}
