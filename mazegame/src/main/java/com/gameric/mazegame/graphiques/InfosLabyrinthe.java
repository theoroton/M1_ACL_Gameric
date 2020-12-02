package com.gameric.mazegame.graphiques;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gameric.mazegame.engine.GamePainter;
import com.gameric.mazegame.model.Const;
import com.gameric.mazegame.model.JeuLabyrinthe;
import com.gameric.mazegame.model.personnage.Personnage;

public class InfosLabyrinthe implements GamePainter {

	/**
	 * Largeur du dessin des infos
	 */
	protected static int WIDTH;
	/**
	 * Hauteur du dessin des infos
	 */
	protected static int HEIGHT;
	
	/**
	 * Jeu à afficher
	 */
	private JeuLabyrinthe jeu;
	
	/**
	 * Constructeur de l'afficheur
	 * @param j : jeu à afficher
	 */
	public InfosLabyrinthe(JeuLabyrinthe j) {
		jeu = j;
		WIDTH = (j.getLabyrinthe().getLargeur())*Const.TAILLE_CASE;
		HEIGHT = 60;
	}

	/**
	 * Méthode qui dessine l'image des infos du jeu
	 */
	public void draw(BufferedImage image) {
		Personnage personnage = jeu.getPersonnage();
		Graphics2D crayon = (Graphics2D) image.getGraphics();
		
		//Arrière plan des informations
		crayon.setColor(Color.LIGHT_GRAY);
		crayon.fillRect(0, 0, WIDTH, HEIGHT);
		
		//On dessine les points de vie du joueur
		crayon.setColor(Color.BLACK);
		crayon.drawRect(9, 19, Const.WIDTH_BARREPV+1, Const.HEIGHT_BARREPV+1);
		
		int pvPerso = personnage.getPointsVie();
		int pvMax = personnage.getVieMax();
		double pv = (double) pvPerso/ (double) pvMax;
		crayon.setColor(new Color(0, 153, 0));
		crayon.fillRect(10, 20, (int) (pv*Const.WIDTH_BARREPV), Const.HEIGHT_BARREPV);
		if (personnage.getPointsVie() <= pvMax/5) {
			crayon.setColor(new Color(204, 0, 0));
		}
		crayon.drawString("PV : " + pvPerso + "/" + pvMax, 10, HEIGHT/4);
		
		//On dessine les points d'attaque du joueur
		crayon.setColor(Color.BLACK);
		crayon.drawString("Attaque : " + personnage.getDegats(), 2*WIDTH/5, HEIGHT/3);
		crayon.drawString("Portée : " + personnage.getPortee(), 2*WIDTH/5, 2*HEIGHT/3);
		
		//On dessine le niveau courant du joueur
		crayon.drawString("Niveau : " + jeu.getNiveau(), 4*WIDTH/5, HEIGHT/2);
		
		//Si le jeu est en pause.
		if (jeu.enPause()) {
			crayon.setColor(Const.COULEUR_PAUSE);
			crayon.fillRect(0, 0, WIDTH, HEIGHT);
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
