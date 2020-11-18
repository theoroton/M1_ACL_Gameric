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
	 * JPanel contenant le CardLayout pour l'affichage
	 */
	private JPanel panel;
	
	/**
	 * Constructeur de l'interface graphique
	 * @param cl
	 */
	public GraphicalInterface(CardLayoutJeu cl){
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Création du JPanel englobant
		this.panel = cl;
		
		//Ajout du JPanel à la fenêtre
		f.setContentPane(this.panel);
		
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
	}
	
	/**
	 * Mise à jour des dessins
	 */
	public void paint() {
		((CardLayoutJeu) panel).update();
	}
	
}
