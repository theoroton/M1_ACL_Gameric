package com.gameric.mazegame.start;

import com.gameric.mazegame.engine.GameEngineText;
import com.gameric.mazegame.model.JeuLabyrinthe;

/**
 * Lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		//Création du jeu
		JeuLabyrinthe game = new JeuLabyrinthe();

		//Lancement du moteur graphique
		GameEngineText engine = new GameEngineText(game);
		engine.run();
	}

}
