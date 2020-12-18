package com.gameric.mazegame.graphiques;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.swing.ImageIcon;
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
	 * Images nécessaires pour l'affichage des commandes
	 */
	private ImageIcon imageCommandes = new ImageIcon(getClass().getResource("/images/textures/ecrans/commandes/commandes.png"));
	private ImageIcon imageJouer = new ImageIcon(getClass().getResource("/images/textures/ecrans/commandes/jouer.png"));
	
	/**
	 * Constructeur de l'écran des commandes
	 * @param c : CardLayout père
	 */
	public EcranCommandes(CardLayoutJeu c) {
		clParent = c;
		setPreferredSize(new java.awt.Dimension(544, 604));
		setLayout(null);
		
        //Création du label du titre es commandes
        JLabel labelTitre = new javax.swing.JLabel();
        labelTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitre.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24));
        labelTitre.setText("Commandes");
		
		//Création du label des commandes
		JLabel labelCommandes = new javax.swing.JLabel();
        labelCommandes.setFont(new java.awt.Font("Lucida Calligraphy", 0, 16));
        labelCommandes.setText(commandesTexte());

        //Création du bouton pour lancer le jeu.
        JButton jouer = new javax.swing.JButton();
        //On cache le bouton
        jouer.setOpaque(false);
        jouer.setContentAreaFilled(false);
        jouer.setBorderPainted(false);
        
        //Ajout de l'action qui permet de lancer le jeu au bouton
        jouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On lance le jeu
            	clParent.lancerJeu();
            }
        });
        
     
        //Listener pour changer l'image du bouton quand on le survole
        jouer.addMouseListener(new MouseListener() {      	
        	public void mouseClicked(MouseEvent e) {}
        	public void mousePressed(MouseEvent e) {}
        	public void mouseReleased(MouseEvent e) {}
        	
        	//Ajoute une image au bouton
        	public void mouseEntered(MouseEvent e) {
        		jouer.setIcon(imageJouer);	
        		jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}

        	//Enlève l'image du bouton
        	public void mouseExited(MouseEvent e) {
        		jouer.setIcon(null);      		
        	}
		});

            
        //Placement des éléments
        labelTitre.setBounds(172, 40, 200, 50);
        labelCommandes.setBounds(122, 150, 300, 240);
        jouer.setBounds(177, 545, 194, 51);
        
        //Ajout des éléments au jpanel
        add(labelTitre);
        add(labelCommandes);
        add(jouer);
	}
	
	/**
	 * Méthode qui permet de récupérer les commandes du jeu d'un fichier texte
	 * @return String avec les commandes du jeu
	 */
	private String commandesTexte() {
		String commandes = "", ligne;
		
		//Récupération du fichier
		InputStream in = getClass().getResourceAsStream("/texte/commandes.txt");	
		BufferedReader fichLab = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
		
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

	
	/**
	 * Méthode paintComponent qui affiche l'image des commandes.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(imageCommandes.getImage(), 0, 0, this);	
	}

}
