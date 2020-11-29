package com.gameric.mazegame.engine;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.gameric.mazegame.graphiques.CardLayoutJeu;

/**
 * @author Théo Roton
 * Interface graphique du jeu
 */
public class GraphicalInterface  {

	/**
	 * JFrame d'affichage
	 */
	private JFrame fenetre;
	/**
	 * JPanel contenant le CardLayout pour l'affichage
	 */
	private JPanel panel;
	
	/**
	 * Constructeur de l'interface graphique
	 * @param cl
	 */
	public GraphicalInterface(CardLayoutJeu cl){
		fenetre = new JFrame();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Création du JPanel englobant
		this.panel = cl;
		
		//Ajout du JPanel à la fenêtre
		fenetre.setContentPane(this.panel);
		
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.getContentPane().setFocusable(true);
		fenetre.getContentPane().requestFocus();
	}
	
	/**
	 * Mise à jour des dessins
	 */
	public void paint() {
		fenetre.pack();
		((CardLayoutJeu) panel).update();
	}
	
	/**
	 * Méthode qui permet de ferme la fenêtre de jeu
	 */
	public void fin() {
		fenetre.dispose();
	}
}
