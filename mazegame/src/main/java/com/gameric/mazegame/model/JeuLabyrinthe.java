package com.gameric.mazegame.model;

import com.gameric.mazegame.engine.Cmd;
import com.gameric.mazegame.engine.Game;

public class JeuLabyrinthe implements Game {
	
	private Labyrinthe labyrinthe;
	private Personnage personnage;
	
	public JeuLabyrinthe() {
		labyrinthe = new Labyrinthe();
		personnage = new Personnage(labyrinthe);
	}

	public void evolve(Cmd userCmd) {
		switch (userCmd) {
		case UP:
			personnage.deplacer(0, 1);
			break;
		case DOWN:
			personnage.deplacer(0, -1);
			break;
		case LEFT:
			personnage.deplacer(-1, 0);
			break;
		case RIGHT:
			personnage.deplacer(1, 0);
			break;
		}

		System.out.println("Personnage " + personnage.getPosition());
	}

	public boolean isFinished() {
		return false;
	}

	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}

	public Personnage getPersonnage() {
		return personnage;
	}	

}
