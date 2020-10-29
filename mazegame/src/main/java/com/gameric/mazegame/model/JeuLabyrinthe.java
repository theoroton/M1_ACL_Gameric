package com.gameric.mazegame.model;

import com.gameric.mazegame.engine.Cmd;
import com.gameric.mazegame.engine.Game;

public class JeuLabyrinthe implements Game {
	
	private Labyrinthe labyrinthe;
	
	public JeuLabyrinthe() {
		labyrinthe = new Labyrinthe();
	}

	@Override
	public void evolve(Cmd userCmd) {	
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}	

}
