package com.gameric.mazegame.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gameric.mazegame.engine.GamePainter;

/**
 * 
 * @author Théo Roton
 * Afficheur graphique du jeu
 */
public class DessinLabyrinthe implements GamePainter {
	
	/**
	 * Largeur du dessin
	 */
	protected static int WIDTH;
	/**
	 * Hauteur du dessin
	 */
	protected static int HEIGHT;
	
	/**
	 * Taille d'une case
	 */
	private final static int TAILLE_CASE = 10;
	
	/**
	 * Jeu à afficher
	 */
	private JeuLabyrinthe jeu;
	
	/**
	 * Constructeur de l'afficheur
	 * @param j : jeu à afficher
	 */
	public DessinLabyrinthe(JeuLabyrinthe j) {
		jeu = j;
		WIDTH = (Labyrinthe.getLargeur()+1)*TAILLE_CASE;
		HEIGHT = (Labyrinthe.getHauteur()+1)*TAILLE_CASE;
	}

	/**
	 * Méthode qui dessine l'image du jeu
	 */
	public void draw(BufferedImage image) {
		Personnage personnage = jeu.getPersonnage();
		
		Graphics2D crayon = (Graphics2D) image.getGraphics();
		crayon.setColor(Color.BLUE);
		crayon.fillOval(personnage.getPos_x()*TAILLE_CASE, personnage.getPos_y()*TAILLE_CASE, 10, 10);
	}

	/**
	 * Getter de la largeur du dessin
	 * @return largeur du dessin
	 */
	public int getWidth() {
		return WIDTH;
	}

	/**
	 * Getter de la hauteur du dessin
	 * @return hauteur du dessin
	 */
	public int getHeight() {
		return HEIGHT;
	}

}
