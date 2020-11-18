package com.gameric.mazegame.graphiques;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.gameric.mazegame.engine.DrawingPanel;
import com.gameric.mazegame.model.JeuLabyrinthe;

/**
 * 
 * @author Théo Roton
 * Classe de l'écran du jeu
 */
public class EcranJeu extends JPanel {

	/**
	 * DrawingPanel du jeu
	 */
	private DrawingPanel partieJeu;
	/**
	 * DrawingPanel des infos
	 */
	private DrawingPanel partieInfos;
	
	/**
	 * Constructeur de l'écran du jeu
	 * @param j : Jeu à afficher
	 */
	public EcranJeu(JeuLabyrinthe j) {
		//Layout de l'écran du jeu
		setLayout(new BorderLayout());
		
		//On crée la partie du labyrinthe
		partieJeu = new DrawingPanel(new DessinLabyrinthe(j));
		//On crée la partie des infos
		partieInfos = new DrawingPanel(new InfosLabyrinthe(j));
		
		//Ajout au JPanel
		add(partieJeu, BorderLayout.NORTH);
		add(partieInfos, BorderLayout.SOUTH);
	}
	
	/**
	 * Méthode qui permet de rafraichir les dessins
	 */
	public void update() {
		partieJeu.drawGame();
		partieInfos.drawGame();
	}
}
