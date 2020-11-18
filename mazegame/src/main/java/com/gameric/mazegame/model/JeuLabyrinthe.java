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
	 * Niveau max du jeu
	 */
	private final static int NIVEAU_MAX = 3;
	/**
	 * Niveau courant du jeu
	 */
	private int niveau;
	
	/**
	 * Constructeur du jeu
	 * On initialise un labyrinthe et le personnage du joueur
	 */
	public JeuLabyrinthe() {
		personnage = new Personnage();
		niveau = 1;
		labyrinthe = new Labyrinthe(personnage, "niveaux/niveau" + niveau + ".txt");
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
		
		//Si le personnage est sur la case de sortie
		if (personnage.getPosition().getClass() == CaseSortie.class) {
			//Si c'est le dernier niveau, alors on a gagné
			if (niveau == NIVEAU_MAX) {
				res = true;
			//Sinon au passe au niveau suivant
			} else {
				niveauSuivant();
			}
			
		//Si le personnage est mort, alors on a perdu
		} else if (personnage.estMort()) {
			res = true;
		}	
		
		return res;
	}

	/**
	 * Méthode qui permet de passer au niveau suivant du jeu.
	 */
	private void niveauSuivant() {
		niveau++;
		labyrinthe = new Labyrinthe(personnage, "niveaux/niveau" + niveau + ".txt");	
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
	 * Méthode getter de l'attribut niveau
	 * @return niveau courant du jeu
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * Méthode setter de l'attribut niveau.
	 * La méthode place aussi le jeu au niveau souhaité.
	 * @param n : niveau du labyrinthe
	 */
	public void setNiveau(int n) {
		niveau = n;
		labyrinthe = new Labyrinthe(personnage, "niveaux/niveau" + niveau + ".txt");
	}	
	
}
