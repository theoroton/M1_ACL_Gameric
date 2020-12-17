package com.gameric.mazegame.graphiques;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import com.gameric.mazegame.model.JeuLabyrinthe;

/**
 * 
 * @author Théo Roton
 * Classe de l'écran de victoire
 */
public class EcranVictoire extends EcranFin {
	
	/**
	 * Images nécessaires pour l'affichage de la victoire
	 */
	private ImageIcon imageVictoire = new ImageIcon(getClass().getResource("/images/textures/ecrans/victoire/victoire.png"));
	private ImageIcon imageRejouer = new ImageIcon(getClass().getResource("/images/textures/ecrans/victoire/rejouer.png"));
	private ImageIcon imageMenu = new ImageIcon(getClass().getResource("/images/textures/ecrans/victoire/menu.png"));
	private ImageIcon imageQuitter = new ImageIcon(getClass().getResource("/images/textures/ecrans/victoire/quitter.png"));
	
	/**
	 * Constructeur de l'écran de victoire
	 * @param c : CardLayout père
	 * @param j : Jeu à afficher
	 */
	public EcranVictoire(CardLayoutJeu c, JeuLabyrinthe j) {
		super(c, j);
		
		//Couleur du score
		score.setForeground(new java.awt.Color(241, 162, 15));
		
        //Listener pour changer l'image du bouton quand on le survole
        rejouer.addMouseListener(new MouseListener() {      	
        	public void mouseClicked(MouseEvent e) {}
        	public void mousePressed(MouseEvent e) {}
        	public void mouseReleased(MouseEvent e) {}
        	
        	//Ajoute une image au bouton
        	public void mouseEntered(MouseEvent e) {
        		rejouer.setIcon(imageRejouer);	
        		rejouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}

        	//Enlève l'image du bouton
        	public void mouseExited(MouseEvent e) {
        		rejouer.setIcon(null);      		
        	}
		});
        
             
        //Listener pour changer l'image du bouton quand on le survole
        menu.addMouseListener(new MouseListener() {      	
        	public void mouseClicked(MouseEvent e) {}
        	public void mousePressed(MouseEvent e) {}
        	public void mouseReleased(MouseEvent e) {}
        	
        	//Ajoute une image au bouton
        	public void mouseEntered(MouseEvent e) {
        		menu.setIcon(imageMenu);	
        		menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}

        	//Enlève l'image du bouton
        	public void mouseExited(MouseEvent e) {
        		menu.setIcon(null);      		
        	}
		});
        

        
        //Listener pour changer l'image du bouton quand on le survole
        quitter.addMouseListener(new MouseListener() {      	
        	public void mouseClicked(MouseEvent e) {}
        	public void mousePressed(MouseEvent e) {}
        	public void mouseReleased(MouseEvent e) {}
        	
        	//Ajoute une image au bouton
        	public void mouseEntered(MouseEvent e) {
        		quitter.setIcon(imageQuitter);	
        		quitter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}

        	//Enlève l'image du bouton
        	public void mouseExited(MouseEvent e) {
        		quitter.setIcon(null);      		
        	}
		});
		
        //Placement des éléments     
        score.setBounds(172, 106, 200, 30);
        rejouer.setBounds(161, 210, 223, 58);
        menu.setBounds(160, 297, 223, 58);
        quitter.setBounds(160, 386, 223, 58);   
        
        //Ajout des éléments au jpanel    
        add(score);
        add(rejouer);
        add(menu);
        add(quitter);
	}
	
	/**
	 * Méthode paintComponent qui affiche l'image de victoire.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(imageVictoire.getImage(), 0, 0, this);	
	}

}
