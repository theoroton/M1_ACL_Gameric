package com.gameric.mazegame.model;

import java.awt.Font;

/**
 * 
 * @author Théo
 * Classe contenant les constantes du jeu
 *
 */
public class Const {
	
	/**
	 * Taille d'une case
	 */
	public final static int TAILLE_CASE = 20;
	
	/**
	 * Taille de placement du personnage
	 */
	public final static int TAILLE_PLACEPERSO = TAILLE_CASE/8;
	
	/**
	 * Taille du personnage
	 */
	public final static int TAILLE_PERSO = (3*TAILLE_CASE)/4;
	
	/**
	 * Largeur de la barre de vie
	 */
	public final static int WIDTH_BARREPV = 70;
	
	/**
	 * Hauteur de la barre de vie
	 */
	public final static int HEIGHT_BARREPV = 24;
	
	/**
	 * Police pour le message de fin du jeu
	 */
	public final static Font FONT_FIN_JEU_1 = new Font(" TimesRoman ", Font.BOLD, 16);
	
	/**
	 * Police pour le message de fin du jeu
	 */
	public final static Font FONT_FIN_JEU_2 = new Font(" TimesRoman ", Font.BOLD, 12);
	
	/**
	 * Police pour écrire un objet sur une case objet
	 */
	public final static Font FONT_OBJET = new Font(" TimesRoman ",Font.BOLD,8);

}
