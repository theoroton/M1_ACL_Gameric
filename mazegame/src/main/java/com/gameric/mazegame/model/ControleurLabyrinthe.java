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
		switch (e.getKeyChar()) {
		case 'q':
		case 'Q':
			this.commandeEnCours = Cmd.LEFT;
			break;
		case 'd':
		case 'D':
			this.commandeEnCours = Cmd.RIGHT;
			break;
		case 'z':
		case 'Z':
			this.commandeEnCours = Cmd.UP;
			break;
		case 's':
		case 'S':
			this.commandeEnCours = Cmd.DOWN;
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
