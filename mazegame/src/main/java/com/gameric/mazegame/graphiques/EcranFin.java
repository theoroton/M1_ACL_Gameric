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
public class EcranFin extends JPanel {

	/**
	 * CardLayout auquel est ajouté ce JPanel
	 */
	private CardLayoutJeu clParent;
	
	/**
	 * Jeu
	 */
	private JeuLabyrinthe jeu;
	
	/**
	 * Constructeur de l'écran de fin
	 * @param c : CardLayout père
	 * @param j : Jeu à afficher
	 */
	public EcranFin(CardLayoutJeu c, JeuLabyrinthe j) {
		clParent = c;
		jeu = j;
		setPreferredSize(new java.awt.Dimension(544, 604));
		
		//Création des labels de message de fin
		JLabel labelFin = new javax.swing.JLabel();
        JLabel labelFinPetit = new javax.swing.JLabel();
        labelFin.setFont(new java.awt.Font("Gadugi", 1, 36));
        labelFin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFin.setPreferredSize(new java.awt.Dimension(200, 48));
        labelFinPetit.setFont(new java.awt.Font("Gabriola", 0, 24));
        labelFinPetit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFinPetit.setPreferredSize(new java.awt.Dimension(200, 42));
        
        //Si le jeu est gagné, on affiche victoire
        if (j.estGagne()) {
        	labelFin.setForeground(new java.awt.Color(0, 153, 51));
        	labelFinPetit.setForeground(new java.awt.Color(0, 153, 51));
            labelFin.setText("Victoire");
            labelFinPetit.setText("Vous avez atteint la sortie");
         
        //Si le jeu est perdu, on affiche défaite
        } else if (j.estPerdu()) {
        	labelFin.setForeground(new java.awt.Color(204, 0, 0));
        	labelFinPetit.setForeground(new java.awt.Color(204, 0, 0));
            labelFin.setText("Défaite");
            labelFinPetit.setText("Vous êtes mort");
        }


        //Création du bouton pour recommencer le jeu
        JButton recommencer = new javax.swing.JButton();
        recommencer.setFont(new java.awt.Font("Tahoma", 0, 18));
        recommencer.setText("Recommencer");
        recommencer.setPreferredSize(new java.awt.Dimension(160, 40));
        //Action du bouton recommencer
        recommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On remet à zéro le jeu
            	clParent.recommencerJeu();
            }
        });


        //Création du bouton pour quitter le jeu
        JButton quitter = new javax.swing.JButton();
        quitter.setFont(new java.awt.Font("Tahoma", 0, 18));
        quitter.setText("Quitter");
        quitter.setPreferredSize(new java.awt.Dimension(160, 40));
        //Action du bouton quitter
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //On indique que le jeu est dans l'état fin
               jeu.setEtat(Etat.Fin);
            }
        });

        
        //Création du bouton pour aller au menu
        JButton menu = new javax.swing.JButton();
        menu.setFont(new java.awt.Font("Tahoma", 0, 18));
        menu.setText("Menu principal");
        menu.setPreferredSize(new java.awt.Dimension(160, 40));
        //Action du bouton menu
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jeu = new JeuLabyrinthe();
            	clParent.afficherMenu();
            }
        });

        //Placement des éléments
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelFinPetit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recommencer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(192, 192, 192)))));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFinPetit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(recommencer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)));
	}
}
