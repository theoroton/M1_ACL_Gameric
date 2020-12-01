package com.gameric.mazegame.graphiques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Théo Roton
 * Classe de l'écran des commandes
 */
public class EcranCommandes extends JPanel {
	
	/**
	 * CardLayout auquel est ajouté ce JPanel
	 */
	private CardLayoutJeu clParent;
	
	/**
	 * Constructeur de l'écran des commandes
	 * @param c : CardLayout père
	 */
	public EcranCommandes(CardLayoutJeu c) {
		clParent = c;
		setPreferredSize(new java.awt.Dimension(544, 604));
		
		//Création du labeldes commandes
		JLabel commandes = new javax.swing.JLabel();
        commandes.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        commandes.setText(commandesTexte());

        //Création du bouton pour lancer le jeu.
        JButton lancerJeu = new javax.swing.JButton();
        lancerJeu.setFont(new java.awt.Font("Tahoma", 0, 18));
        lancerJeu.setText("Lancer le jeu");
        lancerJeu.setPreferredSize(new java.awt.Dimension(140, 40));
        //Ajout de l'action qui permet de lancer le jeu au bouton
        lancerJeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On lance le jeu
            	clParent.lancerJeu();
            }
        });

        //Création du label des commandes
        JLabel labelCommandes = new javax.swing.JLabel();
        labelCommandes.setFont(new java.awt.Font("Gabriola", 1, 28));
        labelCommandes.setText("Commandes");
        labelCommandes.setPreferredSize(new java.awt.Dimension(120, 50));

        //Placement des éléments
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lancerJeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(labelCommandes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(commandes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE)));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelCommandes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(commandes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(lancerJeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)));
	}
	
	/**
	 * Méthode qui permet de récupérer les commandes du jeu d'un fichier texte
	 * @return String avec les commandes du jeu
	 */
	private String commandesTexte() {
		String commandes = "", ligne;
		
		//Récupération du fichier
		InputStream in = getClass().getResourceAsStream("/texte/commandes.txt");	
		BufferedReader fichLab = new BufferedReader(new InputStreamReader(in));
		
		//Création de la chaîne
		try {
			while ((ligne = fichLab.readLine()) != null) {
				commandes += ligne + "<br>";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//On ajoute des balises html pour un meilleur affichage
		commandes = "<html><div>" + commandes + "</div></html>";
		
		return commandes;

	}

}
