package com.gameric.mazegame.graphiques;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gameric.mazegame.model.Etat;
import com.gameric.mazegame.model.JeuLabyrinthe;

/**
 * 
 * @author Théo Roton
 * Classe de l'écran de fin
 */
public abstract class EcranFin extends JPanel {

	/**
	 * CardLayout auquel est ajouté ce JPanel
	 */
	private CardLayoutJeu clParent;
	
	/**
	 * Jeu
	 */
	private JeuLabyrinthe jeu;
	
	/**
	 * Label du score
	 */
	protected JLabel score;
	
	/**
	 * Bouton pour recommencer le jeu
	 */
	protected JButton rejouer;
	
	/**
	 * Bouton pour retourner au menu
	 */
	protected JButton menu;
	
	/**
	 * Bouton pour quitter le jeu
	 */
	protected JButton quitter;
	
	/**
	 * Constructeur de l'écran de fin
	 * @param c : CardLayout père
	 * @param j : Jeu à afficher
	 */
	public EcranFin(CardLayoutJeu c, JeuLabyrinthe j) {
		clParent = c;
		jeu = j;
		setPreferredSize(new java.awt.Dimension(544, 604));
		setLayout(null);
		
		//Création du label du score
		score = new JLabel();
        score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24));
		score.setText("Score : " + jeu.getPersonnage().getScoreTotal());

        //Création du bouton pour recommencer le jeu
        rejouer = new javax.swing.JButton();
        //On cache le bouton
        rejouer.setOpaque(false);
        rejouer.setContentAreaFilled(false);
        rejouer.setBorderPainted(false);
        
        //Action du bouton recommencer
        rejouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On remet à zéro le jeu
            	clParent.recommencerJeu();
            }
        });
        
        
        //Création du bouton pour aller au menu
        menu = new javax.swing.JButton();
        //On cache le bouton
        menu.setOpaque(false);
        menu.setContentAreaFilled(false);
        menu.setBorderPainted(false);
        
        //Action du bouton menu
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jeu = new JeuLabyrinthe();
            	clParent.afficherMenu();
            }
        });
        

        //Création du bouton pour quitter le jeu
        quitter = new javax.swing.JButton();
        //Création du bouton pour aller au menu
        quitter = new javax.swing.JButton();
        //On cache le bouton
        quitter.setOpaque(false);
        quitter.setContentAreaFilled(false);
        quitter.setBorderPainted(false);
        
        //Action du bouton quitter
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //On indique que le jeu est dans l'état fin
               jeu.setEtat(Etat.Fin);
            }
        });
	}
}
