package com.gameric.mazegame.model;

import java.awt.event.KeyEvent;

import com.gameric.mazegame.engine.Cmd;
import com.gameric.mazegame.engine.GameController;

public class ControleurLabyrinthe implements GameController {
	
	private Cmd commandeEnCours;
	
	public ControleurLabyrinthe() {
		this.commandeEnCours = Cmd.IDLE;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		this.commandeEnCours = Cmd.IDLE;	
	}

	@Override
	public Cmd getCommand() {
		return commandeEnCours;
	}

}
