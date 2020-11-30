package com.gameric.mazegame.model;

/**
 * 
 * @author Théo Roton
 * Enumération des états du jeu
 */
public enum Etat {
	//Etat quand le jeu est dans le menu principal ou le choix de classe.
	Debut,
	
	//Etat quand le jeu est en cours.
	EnCours,
	
	//Etat quand le jeu est en pause.
	Pause,
	
	//Etat quand le jeu est gagné.
	Gagne,
	
	//Etat quand le jeu est perdu.
	Perdu,
	
	//Etat quand le jeu est fermé.
	Fin
}