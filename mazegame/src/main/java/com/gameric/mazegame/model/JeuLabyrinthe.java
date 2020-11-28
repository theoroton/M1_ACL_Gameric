package com.gameric.mazegame.model;

import com.gameric.mazegame.engine.Cmd;
import com.gameric.mazegame.engine.Game;
import com.gameric.mazegame.model.labyrinthe.CaseSortie;
import com.gameric.mazegame.model.labyrinthe.Labyrinthe;
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
	private Etat etat;
	
	private String classe;
	
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
		etat = Etat.Debut;
	}
	
	/**
	 * Méthode qui permet de sélectionner la classe choisie par le joueur
	 * @param classe : classe choisie
	 */
	public void choixClasse(String c) {
		classe = c;
	}
	
	/**
	 * Méthode qui permet de lancer le jeu
	 */
	public void lancerJeu() {
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
		}
		
		niveau = 1;
		labyrinthe = new Labyrinthe(personnage, "niveaux/niveau" + niveau + ".txt");
	}

	/**
	 * Méthode qui fait évoluer le jeu en fonction de
	 * la commande
	 */
	public void evolve(Cmd userCmd) {
		
		//Si le jeu est en pause
		if (enPause()) {
			//Commande PAUSE
			if (userCmd == Cmd.PAUSE) {
				//reprend le cours du jeu
				reprendre();
			}
		
		//Si le jeu est en cours
		} else if (enCours()){
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
			//Commande ATTACK
			case ATTACK:
				//le personnage attaque
				personnage.attaquer();
				break;
			//Commande PAUSE	
			case PAUSE:
				//met le jeu en pause
				pause();
				break;
			//Commande RESET
			case RESET:
				//remet à zéro le jeu
				reset();
				break;
			}
		}
	}

	/**
	 * Méthode qui met en pause le jeu.
	 */
	private void pause() {
		//on met le jeu en pause
		etat = Etat.Pause;
		//on arrête les timers des monstres
		labyrinthe.arreterTimers();
	}
	
	/**
	 * Méthode qui permet de reprendre le jeu quand il est en pause.
	 */
	private void reprendre() {
		//on reprend les timers des monstres
		labyrinthe.reprendreTimers();
		//on remet le jeu en cours
		etat = Etat.EnCours;	
	}
	
	/**
	 * Méthode qui permet de relancer le jeu.
	 */
	private void reset() {
		//on arrête les timers des monstres
		labyrinthe.arreterTimers();
		//on relance le jeu
		lancerJeu();
	}

	/**
	 * Méthode qui renvoi si le jeu est fini ou non
	 */
	public boolean isFinished() {
		boolean res = false;
		
		//Si le personnage est sur la case de sortie
		if (personnage.getPosition().getClass() == CaseSortie.class) {
			labyrinthe.arreterTimers();
			//Si c'est le dernier niveau, alors on a gagné
			if (niveau == NIVEAU_MAX) {
				res = true;
			//Sinon au passe au niveau suivant
			} else {
				niveauSuivant();
			}
			
		//Si le personnage est mort, alors on a perdu
		} else if (personnage.estMort()) {
			labyrinthe.arreterTimers();
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
	 * Méthode getter de l'attribut etat
	 * @return etat du jeu
	 */
	public Etat getEtat() {
		return etat;
	}

	/**
	 * Méthode setter de l'état du jeu
	 * @param etat : nouvel état du jeu
	 */
	public void setEtat(Etat etat) {
		this.etat = etat;
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
	
	/**
	 * Méthode qui retourne true si le jeu n'est pas encore lancé.
	 * @return true si le jeu est dans l'état Debut.
	 */
	public boolean debut() {
		return etat == Etat.Debut;
	}
	
	/**
	 * Méthode qui retourne true si le jeu est en cours.
	 * @return true si le jeu est dans l'état EnCours.
	 */
	public boolean enCours() {
		return etat == Etat.EnCours;
	}
	
	/**
	 * Méthode qui retourne true si le jeu est en pause.
	 * @return true si le jeu est dans l'état Pause.
	 */
	public boolean enPause() {
		return etat == Etat.Pause;
	}
}
