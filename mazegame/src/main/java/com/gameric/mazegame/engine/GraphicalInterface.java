package com.gameric.mazegame.engine;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author Théo Roton
 * Interface graphique du jeu
 */
public class GraphicalInterface  {

	
	private JPanel panel;
	/**
	 * Le panel du jeu à afficher
	 */
	private DrawingPanel panelJeu;
	/**
	 * Le panel des infos à afficher
	 */
	private DrawingPanel panelInfos;
	
	/**
	 * Construction de l'interface graphique: JFrame avec panel pour le jeu
	 * 
	 * @param gamePainter l'afficheur du jeu a utiliser dans le moteur
	 * @param gamePainter l'afficheur des infos du jeu a utiliser dans le moteur
	 * @param gameController le controleur à utiliser dans le moteur
	 * 
	 */
	public GraphicalInterface(GamePainter gamePainter, GamePainter infoPainter, GameController gameController){
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Création du JPanel englobant
		this.panel = new JPanel(new BorderLayout());
		//JPanel du jeu
		this.panelJeu = new DrawingPanel(gamePainter);
		//JPanel des infos du jeu
		this.panelInfos = new DrawingPanel(infoPainter);
		
		panel.add(panelJeu, BorderLayout.NORTH);
		panel.add(panelInfos, BorderLayout.SOUTH);
		f.setContentPane(this.panel);
		
		//Attacher le controleur au JPanel englobant
		this.panel.addKeyListener(gameController);	
		
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
	}
	
	/**
	 * Mise à jour des dessins
	 */
	public void paint() {
		this.panelJeu.drawGame();
		this.panelInfos.drawGame();
	}
	
}
