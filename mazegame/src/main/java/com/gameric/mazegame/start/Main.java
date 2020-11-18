package com.gameric.mazegame.start;

import com.gameric.mazegame.engine.GameEngineGraphical;
import com.gameric.mazegame.model.ControleurLabyrinthe;
import com.gameric.mazegame.model.JeuLabyrinthe;

/**
 * Lancement du jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		//Création du jeu
		JeuLabyrinthe jeu = new JeuLabyrinthe();
		ControleurLabyrinthe controleur = new ControleurLabyrinthe();

		//Création du moteur de jeu
		GameEngineGraphical engine = new GameEngineGraphical(jeu, controleur);
		//Lancement du moteur
		engine.run();
	}

}
