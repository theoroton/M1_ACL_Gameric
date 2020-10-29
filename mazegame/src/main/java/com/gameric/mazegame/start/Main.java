package com.gameric.mazegame.start;

import com.gameric.mazegame.engine.GameEngineGraphical;
import com.gameric.mazegame.model.PacmanController;
import com.gameric.mazegame.model.PacmanGame;
import com.gameric.mazegame.model.PacmanPainter;

/**
 * Lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		//Création du jeu
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		//Création de l'afficheur
		PacmanPainter painter = new PacmanPainter();
		//Création du contrôleur
		PacmanController controller = new PacmanController();

		//Lancement du moteur graphique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}
