package com.gameric.mazegame.start;

import com.gameric.mazegame.engine.GameEngineGraphical;
import com.gameric.mazegame.model.PacmanController;
import com.gameric.mazegame.model.PacmanGame;
import com.gameric.mazegame.model.PacmanPainter;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		PacmanPainter painter = new PacmanPainter();
		PacmanController controller = new PacmanController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}
