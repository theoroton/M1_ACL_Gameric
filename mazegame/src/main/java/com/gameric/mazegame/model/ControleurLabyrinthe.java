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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cmd getCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}
