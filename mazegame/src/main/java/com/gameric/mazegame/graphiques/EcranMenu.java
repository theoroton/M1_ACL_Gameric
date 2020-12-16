package com.gameric.mazegame.graphiques;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.gameric.mazegame.model.Etat;
import com.gameric.mazegame.model.JeuLabyrinthe;

public class EcranMenu extends JPanel {

	/**
	 * CardLayout auquel est ajouté ce JPanel
	 */
	private CardLayoutJeu clParent;
	

	ImageIcon imageMenu = new ImageIcon(getClass().getResource("/images/textures/ecrans/menu/menu.png"));
	ImageIcon imageJouer = new ImageIcon(getClass().getResource("/images/textures/ecrans/menu/jouer.png"));
	ImageIcon imageRegles = new ImageIcon(getClass().getResource("/images/textures/ecrans/menu/regles.png"));
	ImageIcon imageSortir = new ImageIcon(getClass().getResource("/images/textures/ecrans/menu/sortir.png"));
	
	/**
	 * Constructeur de l'écran du menu
	 * @param c : CardLayout père
	 */
	public EcranMenu(CardLayoutJeu c, JeuLabyrinthe j) {
		clParent = c;
		setPreferredSize(new java.awt.Dimension(544, 604));
		setLayout(null);
		
		//Création du bouton pour jouer au jeu
		JButton jouer = new javax.swing.JButton();
        jouer.setPreferredSize(new java.awt.Dimension(140, 40));
        //On cache le bouton
        jouer.setOpaque(false);
        jouer.setContentAreaFilled(false);
        jouer.setBorderPainted(false);
        
        //Action du bouton jouer
        jouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On affiche le choix de classe
                clParent.afficherChoixClasse();
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

        
        //Création du bouton pour afficher le but et les commandes du jeu
        JButton regles = new javax.swing.JButton();
        regles.setPreferredSize(new java.awt.Dimension(140, 40));
        //On cache le bouton
        regles.setOpaque(false);
        regles.setContentAreaFilled(false);
        regles.setBorderPainted(false);
        
        //Action du bouton but
        regles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On affiche l'écran des règles
                clParent.afficherRegles();
            }
        });
        
        //Listener pour changer l'image du bouton quand on le survole
        regles.addMouseListener(new MouseListener() {      	
        	public void mouseClicked(MouseEvent e) {}
        	public void mousePressed(MouseEvent e) {}
        	public void mouseReleased(MouseEvent e) {}
        	
        	//Ajoute une image au bouton
        	public void mouseEntered(MouseEvent e) {
        		regles.setIcon(imageRegles);	
        		regles.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}

        	//Enlève l'image du bouton
        	public void mouseExited(MouseEvent e) {
        		regles.setIcon(null);      		
        	}
		});
        
        
        //Création du bouton qui permet de quitter le jeu
        JButton sortir = new javax.swing.JButton();
        sortir.setPreferredSize(new java.awt.Dimension(140, 40));
        //On cache le bouton
        sortir.setOpaque(false);
        sortir.setContentAreaFilled(false);
        sortir.setBorderPainted(false);
        
        //Action du bouton quitter
        sortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On ferme le jeu
            	j.setEtat(Etat.Fin);
            }
        });
        
        //Listener pour changer l'image du bouton quand on le survole
        sortir.addMouseListener(new MouseListener() {      	
        	public void mouseClicked(MouseEvent e) {}
        	public void mousePressed(MouseEvent e) {}
        	public void mouseReleased(MouseEvent e) {}
        	
        	//Ajoute une image au bouton
        	public void mouseEntered(MouseEvent e) {
        		sortir.setIcon(imageSortir);	
        		sortir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}

        	//Enlève l'image du bouton
        	public void mouseExited(MouseEvent e) {
        		sortir.setIcon(null);      		
        	}
		});
        
        
        //Placement des éléments
        jouer.setBounds(291, 192, 216, 63);
        regles.setBounds(291, 282, 216, 63);
        sortir.setBounds(291, 375, 216, 63);
        
        //Ajout des éléments au jpanel
        add(jouer);
        add(regles);
        add(sortir);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(imageMenu.getImage(), 0, 0, this);
	}
}
