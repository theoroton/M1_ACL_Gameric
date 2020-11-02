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
	private final static int TAILLE_CASE = 20;
	
	/**
	 * Taille de placement du personnage
	 */
	private final static int TAILLE_PLACEPERSO = TAILLE_CASE/8;
	
	/**
	 * Taille du personnage
	 */
	private final static int TAILLE_PERSO = (3*TAILLE_CASE)/4;
	
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
		WIDTH = (Labyrinthe.getLargeur())*TAILLE_CASE;
		HEIGHT = (Labyrinthe.getHauteur())*TAILLE_CASE;
	}

	/**
	 * Méthode qui dessine l'image du jeu
	 */
	public void draw(BufferedImage image) {
		//On récupère le personnage du jeu
		Personnage personnage = jeu.getPersonnage();
		//On récupère le labyrinthe du jeu
		Labyrinthe labyrinthe = jeu.getLabyrinthe();
		
		Graphics2D crayon = (Graphics2D) image.getGraphics();
		//On dessine le personnage en bleu
		crayon.setColor(Color.BLUE);
		crayon.fillOval(personnage.getPos_x()*TAILLE_CASE + TAILLE_PLACEPERSO, 
						personnage.getPos_y()*TAILLE_CASE + TAILLE_PLACEPERSO, 
						TAILLE_PERSO, TAILLE_PERSO);
		
		int hauteur = Labyrinthe.getHauteur();
		int largeur = Labyrinthe.getLargeur();
		//On dessine les murs du jeu en noir
		crayon.setColor(Color.BLACK);
		for (int i=0; i<hauteur; i++) {
			for (int j=0; j<largeur; j++) {
				if ((labyrinthe.getCase(j,i)).getClass() == Mur.class) {
					crayon.fillRect(j*TAILLE_CASE, i*TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
				}
			}
		}
		
		crayon.setColor(Color.RED);
		for (Monstre m : labyrinthe.getMonstres()) {
			crayon.fillOval(m.getPosition().getPx()*TAILLE_CASE + TAILLE_PLACEPERSO, 
							m.getPosition().getPy()*TAILLE_CASE + TAILLE_PLACEPERSO, 
							TAILLE_PERSO, TAILLE_PERSO);
		}
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
