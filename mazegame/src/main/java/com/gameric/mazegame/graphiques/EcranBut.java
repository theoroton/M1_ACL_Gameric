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
		
		//Création jscrollpane interne
		JScrollPane jScrollPane = new javax.swing.JScrollPane();
		
		//Création jpanel interne
        JPanel jpanel = new javax.swing.JPanel();
        jpanel.setPreferredSize(new java.awt.Dimension(266, 700));
        
        //Création du label But
        JLabel but = new javax.swing.JLabel();
        but.setFont(new java.awt.Font("Gill Sans MT", 0, 16));
        but.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        but.setText(butTexte()); 
        but.setMaximumSize(new java.awt.Dimension(266, 1000));
        but.setPreferredSize(new java.awt.Dimension(266, 14));
        
        //Création du label des cases à effet
        JLabel labelCases = new javax.swing.JLabel();
        labelCases.setFont(new java.awt.Font("Gill Sans MT", 1, 16));
        labelCases.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCases.setText("Cases à effets :");
        labelCases.setPreferredSize(new java.awt.Dimension(100, 20));
        
        //Création de l'image de la case piégée et de son label
        JLabel imageCP1 = new javax.swing.JLabel();
        JLabel labelCP1 = new javax.swing.JLabel();
        imageCP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/textures/piege4.jpg")));
        imageCP1.setPreferredSize(new java.awt.Dimension(64, 64));
        labelCP1.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        labelCP1.setText("<html><div style='text-align: justify;'><b>Case piégée :</b><br>Inflige des dégâts au personnage quand il passe dessus.</div></html>");
        
        //Création de l'image de la case apparition et de son label
        JLabel imageCP2 = new javax.swing.JLabel();
        JLabel labelCP2 = new javax.swing.JLabel();
        imageCP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/textures/spawner.jpg")));
        imageCP2.setPreferredSize(new java.awt.Dimension(64, 64));
        labelCP2.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        labelCP2.setText("<html><div style='text-align: justify;'><b>Case spawner :</b><br>Fait apparaître un monstre dans le labyrinthe quand le personnage passe dessus.</div></html>");

        
        //Création de l'image de la case téléportation et de son label
        JLabel imageCP3 = new javax.swing.JLabel();
        JLabel labelCP3 = new javax.swing.JLabel();
        imageCP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/textures/teleporter.png")));
        imageCP3.setPreferredSize(new java.awt.Dimension(64, 64));
        labelCP3.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        labelCP3.setText("<html><div style='text-align: justify;'><b>Case téléportation :</b><br>Téléporte le personnage à une position aléatoire dans le labyrinthe.</div></html> ");
        
        //Création du label des objets
        JLabel labelObjets = new javax.swing.JLabel();
        labelObjets.setFont(new java.awt.Font("Gill Sans MT", 1, 16)); // NOI18N
        labelObjets.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelObjets.setText("Objets :");
        labelObjets.setPreferredSize(new java.awt.Dimension(100, 20));
        
        //Création de l'image de l'arme
        JLabel imageO1 = new javax.swing.JLabel();
        JLabel labelO1 = new javax.swing.JLabel();
        imageO1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/textures/epee.png")));
        imageO1.setPreferredSize(new java.awt.Dimension(64, 64));
        labelO1.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        labelO1.setText("<html><div style='text-align: justify;'><b>Arme :</b><br>Augmente les dégâts du personnage.</div></html>");
        
        //Création de l'image de la potion
        JLabel imageO2 = new javax.swing.JLabel();
        JLabel labelO2 = new javax.swing.JLabel();
        imageO2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/textures/potion.png")));
        imageO2.setPreferredSize(new java.awt.Dimension(64, 64));
        labelO2.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        labelO2.setText("<html><div style='text-align: justify;'><b>Potion :</b><br>Rend des points de vie au personnage.</div></html>");
        
        //Création de l'image de l'objet mystère
        JLabel imageO3 = new javax.swing.JLabel();
        JLabel labelO3 = new javax.swing.JLabel();
        imageO3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/textures/box.jpg")));
        imageO3.setPreferredSize(new java.awt.Dimension(64, 64));
        labelO3.setFont(new java.awt.Font("Tahoma", 0, 11)); 
        labelO3.setText("<html><div style='text-align: justify;'><b>Objet mystère :</b><br>Modifie une statistique (dégâts, portée, vie, vie maximale) aléatoire positivement ou négativement du personnage.</div></html>");

        //Création du bouton retour
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


        //Placement des éléments
	    javax.swing.GroupLayout jpanel2Layout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanel2Layout);
        jpanel2Layout.setHorizontalGroup(
            jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel2Layout.createSequentialGroup()
                        .addComponent(imageCP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageCP2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jpanel2Layout.createSequentialGroup()
                        .addComponent(imageO1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelO1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imageO2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelO2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jpanel2Layout.createSequentialGroup()
                .addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel2Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(labelCases, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel2Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(imageCP3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCP3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel2Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(labelObjets, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(imageO3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelO3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(but, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        jpanel2Layout.setVerticalGroup(
            jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(but, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelCases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCP2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageCP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageCP2)
                    .addComponent(labelCP1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageCP3)
                    .addComponent(labelCP3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(labelObjets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelO1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageO1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageO2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelO2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageO3)
                    .addComponent(labelO3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(202, 202, 202)));

        jScrollPane.setViewportView(jpanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane)
                .addContainerGap()));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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