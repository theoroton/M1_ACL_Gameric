package com.gameric.mazegame.engine;

import com.gameric.mazegame.graphiques.CardLayoutJeu;
import com.gameric.mazegame.model.ControleurLabyrinthe;
import com.gameric.mazegame.model.JeuLabyrinthe;

/**
 * 
 * @author Théo Roton
 * Moteur du jeu
 */
public class GameEngineGraphical {

	//Jeu 
	private JeuLabyrinthe jeu;

	//Controleur du jeu
	private ControleurLabyrinthe controleur;
	
	//CardLayout pour l'affichage
	private CardLayoutJeu cardLayout;

	//Interface graphique du jeu
	private GraphicalInterface gui;

	/**
	 * Constructeur du moteur du jeu
	 * @param j : jeu
	 * @param c : controleur du jeu
	 */
	public GameEngineGraphical(JeuLabyrinthe j, ControleurLabyrinthe c) {
		this.jeu = j;
		this.controleur = c;
		//Création du CardLayout
		this.cardLayout = new CardLayoutJeu(jeu, controleur);
		//Création de l'interface graphique
		this.gui = new GraphicalInterface(this.cardLayout);
	}

	/**
	 * Méthode qui lance le moteur de jeu
	 * @throws InterruptedException
	 */
	public void run() throws InterruptedException {
		//Tant que le jeu n'est pas lancé, on attends.
		while (jeu.debut()) { Thread.sleep(100); }
		
		//Tant que le jeu n'est pas fermé
		while (!this.jeu.enFin()) {
			
			//Une fois que le jeu est lancé, on exécute la boucle du jeu
			while (!this.jeu.isFinished()) {
				//Récupère la commande de l'utilisateur
				Cmd c = this.controleur.getCommand();
				//Fait evoluer le jeu
				this.jeu.evolve(c);
				//Met à jour l'affichage du jeu
				this.gui.paint();
				//Met en attente
				Thread.sleep(100);
			}
			
			//Si on gagne ou on perd, on affiche la fin
			cardLayout.afficherFin();
			
			//Tant qu'on est sur l'écran de fin
			while (this.jeu.estGagne() || this.jeu.estPerdu()) {
				Thread.sleep(100);
			}
		}
		
		//Si on choisit de quitter le jeu, on ferme la fenêtre
		gui.fin();
	}

}
