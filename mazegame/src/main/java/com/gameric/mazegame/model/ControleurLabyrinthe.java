package com.gameric.mazegame.model;

import java.awt.event.KeyEvent;

import com.gameric.mazegame.engine.Cmd;
import com.gameric.mazegame.engine.GameController;

/**
 * 
 * @author Théo Roton
 * Contrôleur du jeu. Type KeyListener
 */
public class ControleurLabyrinthe implements GameController {
	
	/**
	 * Commande du jeu en cours
	 */
	private Cmd commandeEnCours;
	
	/**
	 * Constructeur du contrôleur.
	 * Par défaut il n'y a pas de commande.
	 */
	public ControleurLabyrinthe() {
		this.commandeEnCours = Cmd.IDLE;
	}
	
	/**
	 * Ne fait rien
	 */
	public void keyTyped(KeyEvent e) {}

	/**
	 * Met à jour la commande du jeu quand le joueur presse une touche
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		//Flèche gauche
		case 37:
			this.commandeEnCours = Cmd.LEFT;
			break;
		//Flèche droite
		case 39:
			this.commandeEnCours = Cmd.RIGHT;
			break;
		//Flèche du haut
		case 38:
			this.commandeEnCours = Cmd.UP;
			break;
		//Flèche du bas
		case 40:
			this.commandeEnCours = Cmd.DOWN;
			break;
		//E
		case 69:
			this.commandeEnCours = Cmd.PICKUP;
			break;
		//A
		case 65:
			this.commandeEnCours = Cmd.ATTACK;
			break;
		//P
		case 80:
			this.commandeEnCours = Cmd.PAUSE;
			break;
		//R
		case 82:
			this.commandeEnCours = Cmd.RESET;
			break;
		}
	}

	/**
	 * Met à jour la commande du jeu quand le joueur relâche une touche
	 */
	public void keyReleased(KeyEvent e) {
		this.commandeEnCours = Cmd.IDLE;	
	}

	/**
	 * Retourne la commande en cours du jeu
	 * @return commande faite par le joueur
	 */
	public Cmd getCommand() {
		return commandeEnCours;
	}

}
