package com.gameric.mazegame.graphiques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class EcranBut extends JPanel{
	
	/**
	 * CardLayout auquel est ajouté ce JPanel
	 */
	private CardLayoutJeu clParent;
	
	/**
	 * Constructeur de l'écran des règles
	 * @param c : CardLayout père
	 */
	public EcranBut(CardLayoutJeu c) {
		clParent = c;
		setPreferredSize(new java.awt.Dimension(544, 604));
		
		JScrollPane jScrollPane = new javax.swing.JScrollPane();
        JPanel jpanel = new javax.swing.JPanel();
        jpanel.setPreferredSize(new java.awt.Dimension(266, 420));
       

        //Construction label du but du jeu
        JLabel but = new javax.swing.JLabel();
        but.setFont(new java.awt.Font("Gill Sans MT", 0, 16));
        but.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        but.setText(butTexte());
        but.setMaximumSize(new java.awt.Dimension(266, 1000));
        but.setPreferredSize(new java.awt.Dimension(266, 14));
        
        //Construction label des commandes
        JLabel commandes = new javax.swing.JLabel();
        commandes.setFont(new java.awt.Font("Gill Sans MT", 0, 16));
        commandes.setText(commandesTexte());
        
        //Création du bouton pour retourner au menu
        JButton retour = new javax.swing.JButton();
        retour.setFont(new java.awt.Font("Tahoma", 0, 18));
        retour.setText("Retour");
        retour.setPreferredSize(new java.awt.Dimension(140, 40));
        //Action du bouton pour afficher le menu principal
        retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On affiche le menu principal
                clParent.afficherMenu();
            }
        });
        
        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(commandes))
                .addContainerGap()));
        
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(but, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(commandes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jScrollPane.setViewportView(jpanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(212, Short.MAX_VALUE)
                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane)
                .addContainerGap()));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)));
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
			ligne = fichLab.readLine();
			commandes += ligne + "<br>";
			while ((ligne = fichLab.readLine()) != null) {
				if (!ligne.equals("")) {
					commandes += "&nbsp; - " + ligne + "<br>";
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//On ajoute des balises html pour un meilleur affichage
		commandes = "<html><div>" + commandes + "</div></html>";
		
		return commandes;

	}

}
