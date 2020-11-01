package com.gameric.mazegame.start;

import com.gameric.mazegame.engine.GameEngineGraphical;
import com.gameric.mazegame.model.ControleurLabyrinthe;
import com.gameric.mazegame.model.DessinLabyrinthe;
import com.gameric.mazegame.model.JeuLabyrinthe;

/**
 * Lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		//Création du jeu
		JeuLabyrinthe jeu = new JeuLabyrinthe();
		DessinLabyrinthe dessin = new DessinLabyrinthe(jeu);
		ControleurLabyrinthe controleur = new ControleurLabyrinthe();

		//Lancement du moteur graphique
		GameEngineGraphical engine = new GameEngineGraphical(jeu, dessin, controleur);
		engine.run();
	}

}
