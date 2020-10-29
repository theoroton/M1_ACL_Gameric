package com.gameric.mazegame.model;

import com.gameric.mazegame.engine.Cmd;
import com.gameric.mazegame.engine.Game;

public class JeuLabyrinthe implements Game {
	
	public JeuLabyrinthe() {
	}

	@Override
	public void evolve(Cmd userCmd) {
		System.out.println(userCmd);	
	}

	@Override
	public boolean isFinished() {
		return false;
	}

}
