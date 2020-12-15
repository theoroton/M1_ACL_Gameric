package com.gameric.mazegame.engine;

import java.io.IOException;

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
		
		afficherCommandes();
		
		//Tant que le jeu n'est pas fermé
		while (!this.jeu.enFin()) {
			
			//Tant que le jeu n'est pas lancé, on attends.
			while (this.jeu.debut()) { 
				Thread.sleep(100); 
			}
			
			//Une fois que le jeu est lancé, on exécute la boucle du jeu
			while (this.jeu.enCours() && !this.jeu.isFinished()) {
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
			if (jeu.estGagne() || this.jeu.estPerdu()) {
				cardLayout.afficherFin();
			}
			
			//Tant qu'on est sur l'écran de fin
			while (this.jeu.estGagne() || this.jeu.estPerdu()) {
				Thread.sleep(100);
			}
		}
		
		//Si on choisit de quitter le jeu, on ferme la fenêtre
		gui.fin();
		System.exit(0);
	}

	/**
	 * Méthode qui permet d'afficher les commandes du jeu dans la console
	 */
	private void afficherCommandes() {
		System.out.println("Commandes du jeu :");
		System.out.println("- Fleche du haut : deplacement vers le haut");
		System.out.println("- Fleche du bas : deplacement vers le bas");
		System.out.println("- Fleche droite : deplacement vers la droite");
		System.out.println("- Fleche gauche : deplacement vers la gauche");
		System.out.println("- A : attaquer");
		System.out.println("- E : ramasser");
		System.out.println("- P : mettre en pause");
		System.out.println("- R : recommencer le jeu");
	}

}
