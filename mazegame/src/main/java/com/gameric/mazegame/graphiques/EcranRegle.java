package com.gameric.mazegame.graphiques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class EcranRegle extends JPanel{
	
	/**
	 * CardLayout auquel est ajouté ce JPanel
	 */
	private CardLayoutJeu clParent;
	
	/**
	 * Constructeur de l'écran des règles
	 * @param c : CardLayout père
	 */
	public EcranRegle(CardLayoutJeu c) {
		clParent = c;
		setPreferredSize(new java.awt.Dimension(320, 360));
		
		JScrollPane jScrollPane = new javax.swing.JScrollPane();
        JPanel jpanel = new javax.swing.JPanel();
        jpanel.setPreferredSize(new java.awt.Dimension(266, 420));
       

        //Construction label du but du jeu
        JLabel but = new javax.swing.JLabel();
        but.setFont(new java.awt.Font("Gill Sans MT", 0, 12));
        but.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        but.setText(butTexte());
        but.setMaximumSize(new java.awt.Dimension(266, 1000));
        but.setPreferredSize(new java.awt.Dimension(266, 14));
        
        //Construction label des commandes
        JLabel commandes = new javax.swing.JLabel();
        commandes.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        commandes.setText(commandesTexte());
        
        //Création du bouton pour retourner au menu
        JButton retour = new javax.swing.JButton();
        retour.setText("Retour");
        retour.setPreferredSize(new java.awt.Dimension(80, 25));
        //Action du bouton pour afficher le menu principal
        retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On affiche le menu principal
                clParent.afficherMenu();
            }
        });
        
        //Placement des éléments
        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(commandes)
                    .addComponent(but, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(but, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(commandes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        jScrollPane.setViewportView(jpanel);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)));
	}

	
	/**
	 * Méthode qui permet de récupérer le but du jeu d'un fichier texte
	 * @return String avec le but du jeu
	 */
	private String butTexte() {
		String but = "", ligne;
		
		//Récupération du fichier
		InputStream in = getClass().getResourceAsStream("/texte/but.txt");	
		BufferedReader fichLab = new BufferedReader(new InputStreamReader(in));
		
		//Création de la chaîne
		try {
			while ((ligne = fichLab.readLine()) != null) {
				but += "&nbsp;&nbsp;&nbsp;" + ligne + "<br>";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//On ajoute des balises html pour un meilleur affichage
		but = "<html><div style='text-align: justify;'>" + but + "</div></html>";
		
		return but;
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
