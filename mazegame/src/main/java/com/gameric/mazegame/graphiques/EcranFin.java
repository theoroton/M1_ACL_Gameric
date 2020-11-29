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
	 * Constructeur de l'écran de fin
	 * @param c : CardLayout père
	 * @param j : jeu
	 */
	public EcranFin(CardLayoutJeu c, JeuLabyrinthe j) {
		clParent = c;
		setPreferredSize(new java.awt.Dimension(320, 360));
		
		//Création des labels de message de fin
		JLabel labelFin = new javax.swing.JLabel();
        JLabel labelFinPetit = new javax.swing.JLabel();
        labelFin.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N    
        labelFin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFinPetit.setFont(new java.awt.Font("Gabriola", 0, 20)); // NOI18N    
        labelFinPetit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
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
        recommencer.setText("Recommencer");
        recommencer.setPreferredSize(new java.awt.Dimension(120, 30));
        //Action du bouton recommencer
        recommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On remet à zéro le jeu
            	clParent.recommencerJeu();
            }
        });


        //Création du bouton pour quitter le jeu
        JButton quitter = new javax.swing.JButton();
        quitter.setText("Quitter");
        quitter.setPreferredSize(new java.awt.Dimension(120, 30));
        //Action du bouton quitter
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //On indique que le jeu est dans l'état fin
               j.setEtat(Etat.Fin);
            }
        });

        //Placement des éléments
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(labelFin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(labelFinPetit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recommencer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelFin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFinPetit)
                .addGap(70, 70, 70)
                .addComponent(recommencer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE)));
	}
}
