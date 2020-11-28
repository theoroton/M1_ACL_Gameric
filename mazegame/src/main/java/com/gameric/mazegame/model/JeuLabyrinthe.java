package com.gameric.mazegame.model;

import com.gameric.mazegame.engine.Cmd;
import com.gameric.mazegame.engine.Game;
import com.gameric.mazegame.model.labyrinthe.CaseSortie;
import com.gameric.mazegame.model.labyrinthe.Labyrinthe;
import com.gameric.mazegame.model.monstres.Monstre;
import com.gameric.mazegame.model.personnage.Archer;
import com.gameric.mazegame.model.personnage.Epeiste;
import com.gameric.mazegame.model.personnage.Mage;
import com.gameric.mazegame.model.personnage.Personnage;

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
		enCours = false;
		niveau = 1;
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
			personnage.setDirection('N');
			personnage.deplacer(0, -1);
			break;
		//Commande DOWN
		case DOWN:
			//le personnage se déplace de 1 vers le bas (0,-1)
			personnage.setDirection('S');
			personnage.deplacer(0, 1);
			break;
		//Commande LEFT
		case LEFT:
			//le personnage se déplace de 1 vers la gauche (-1,0)
			personnage.setDirection('O');
			personnage.deplacer(-1, 0);
			break;
		//Commande RIGHT
		case RIGHT:
			//le personnage se déplace de 1 vers la droite (1,0)
			personnage.setDirection('E');
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
	
	/**
	 * Méthode getter de l'attribut niveau
	 * @return niveau courant du jeu
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * Méthode setter de l'attribut niveau. 
	 * La méthode place aussi le jeu au niveau souhaité (si il existe).
	 * @param n : niveau du labyrinthe
	 */
	public void setNiveau(int n) {
		//Si le niveau est compris entre 1 et le niveau max, on met le jeu au niveau n
		if (1 <= n && n <= NIVEAU_MAX) {
			niveau = n;
		//Sinon on le met au premier niveau
		} else {
			niveau = 1;
		}		
		labyrinthe = new Labyrinthe(personnage, "niveaux/niveau" + niveau + ".txt");
	}	
	
}
