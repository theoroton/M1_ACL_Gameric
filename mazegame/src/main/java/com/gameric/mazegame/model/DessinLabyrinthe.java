package com.gameric.mazegame.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.gameric.mazegame.engine.GamePainter;

/**
 * 
 * @author Théo Roton
 * Afficheur graphique du jeu
 */
public class DessinLabyrinthe implements GamePainter {
	
	/**
	 * Largeur du dessin du labyrinthe
	 */
	protected static int WIDTH;
	/**
	 * Hauteur du dessin du labyrinthe
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
	public DessinLabyrinthe(JeuLabyrinthe j) {
		jeu = j;
		WIDTH = (j.getLabyrinthe().getLargeur())*Const.TAILLE_CASE;
		HEIGHT = (j.getLabyrinthe().getHauteur())*Const.TAILLE_CASE;
	}

	/**
	 * Méthode qui dessine l'image du labyrinthe du jeu
	 */
	public void draw(BufferedImage image) {
		//On récupère le personnage du jeu
		Personnage personnage = jeu.getPersonnage();
		//On récupère le labyrinthe du jeu
		Labyrinthe labyrinthe = jeu.getLabyrinthe();
		
		Graphics2D crayon = (Graphics2D) image.getGraphics();
		
		int hauteur = labyrinthe.getHauteur();
		int largeur = labyrinthe.getLargeur();
		//On dessine cases qui doivent être affichées
		for (int i=0; i<hauteur; i++) {
			for (int j=0; j<largeur; j++) {
				//On dessine en noir les murs
				if ((labyrinthe.getCase(j,i)).getClass() == Mur.class) {
					crayon.setColor(Color.BLACK);
					crayon.fillRect(j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE);
					
				//On dessigne en orange les cases objets
				} else if ((labyrinthe.getCase(j,i)).getClass() == CaseObjet.class) {
					crayon.setColor(new Color(255, 153, 0));
					crayon.fillRect(j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE);
				
				//On dessigne en rose les cases piégées
				} else if ((labyrinthe.getCase(j,i)).getClass() == CasePiegee.class) {
					crayon.setColor(new Color(255, 153, 153));
					crayon.fillRect(j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE);
				}
			}
		}
		
		//On dessine le personnage en bleu
		if (!personnage.estMort()) {
			crayon.setColor(Color.BLUE);
			crayon.fillOval(personnage.getPos_x()*Const.TAILLE_CASE + Const.TAILLE_PLACEPERSO, 
							personnage.getPos_y()*Const.TAILLE_CASE + Const.TAILLE_PLACEPERSO, 
							Const.TAILLE_PERSO, Const.TAILLE_PERSO);
		}
		
		//On dessine les monstres
		crayon.setColor(Color.RED);
		for (Monstre m : labyrinthe.getMonstres()) {
			crayon.fillOval(m.getPosition().getPx()*Const.TAILLE_CASE + Const.TAILLE_PLACEPERSO, 
							m.getPosition().getPy()*Const.TAILLE_CASE + Const.TAILLE_PLACEPERSO, 
							Const.TAILLE_PERSO, Const.TAILLE_PERSO);
		}

		//Si le jeu est fini et que le personnage est mort, alors on écrit un message de défaite
		if (personnage.estMort()) {	
			crayon.setColor(Color.LIGHT_GRAY);
			crayon.fillRect(WIDTH/6, HEIGHT/6, 2*WIDTH/3, HEIGHT/4+20);
			crayon.setColor(Color.RED);
			dessinerChaineCentree(crayon, "DEFAITE", new Rectangle(WIDTH/6, HEIGHT/6, 2*WIDTH/3, HEIGHT/4), new Font(" TimesRoman ",Font.BOLD,16));
			dessinerChaineCentree(crayon, "Vous êtes mort", new Rectangle(WIDTH/6, HEIGHT/6+20, 2*WIDTH/3, HEIGHT/4), new Font(" TimesRoman ",Font.BOLD,12));
			
		//Si le jeu est fini et que le personnage n'est pas mort, alors on écrit un message de victoire
		} else if (jeu.isFinished()) {
			crayon.setColor(Color.LIGHT_GRAY);
			crayon.fillRect(WIDTH/6, HEIGHT/6, 2*WIDTH/3, HEIGHT/4+20);
			crayon.setColor(Color.GREEN);
			dessinerChaineCentree(crayon, "Victoire", new Rectangle(WIDTH/6, HEIGHT/6, 2*WIDTH/3, HEIGHT/4), new Font(" TimesRoman ",Font.BOLD,16));
			dessinerChaineCentree(crayon, "Vous avez atteint la sortie", new Rectangle(WIDTH/6, HEIGHT/6+20, 2*WIDTH/3, HEIGHT/4), new Font(" TimesRoman ",Font.BOLD,12));
		}
		
	}
	
	/**
	 * Méthode qui permet de dessiner une chaîne centrée dans un rectangle
	 * @param g : graphics à utiliser
	 * @param s : chaîne à écrire
	 * @param r : rectangle dans lequel centrer la chaîne
	 * @param f : police à utiliser
	 */
	public void dessinerChaineCentree(Graphics g, String s, Rectangle r, Font f) {
	    FontMetrics metrics = g.getFontMetrics(f);
	    //Position x de la chaîne
	    int x = r.x + (r.width - metrics.stringWidth(s)) / 2;
	    //Position y de la chaîne
	    int y = r.y + ((r.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    g.setFont(f);
	    g.drawString(s, x, y);
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
