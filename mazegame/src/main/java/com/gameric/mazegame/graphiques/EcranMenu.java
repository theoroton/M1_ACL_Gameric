package com.gameric.mazegame.graphiques;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EcranMenu extends JPanel {

	/**
	 * CardLayout auquel est ajouté ce JPanel
	 */
	private CardLayoutJeu clParent;
	
	/**
	 * Constructeur de l'écran du menu
	 * @param c : CardLayout père
	 */
	public EcranMenu(CardLayoutJeu c) {
		clParent = c;
		setPreferredSize(new java.awt.Dimension(320, 360));
		
		//Création du bouton pour jouer au jeu
		JButton jouer = new javax.swing.JButton();
        jouer.setText("Jouer");
        jouer.setPreferredSize(new java.awt.Dimension(100, 30));
        //Action du bouton jouer
        jouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On affiche le choix de classe
                clParent.afficherChoixClasse();
            }
        });
        

        //Création du bouton pour afficher le but et les commandes du jeu
        JButton but = new javax.swing.JButton();
        but.setText("But du jeu");
        but.setPreferredSize(new java.awt.Dimension(100, 30));
        //Action du bouton règles
        but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On affiche l'écran des règles
                clParent.afficherRegles();
            }
        });
        

        //Placement des éléments
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE)));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(jouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)));
	}
}
