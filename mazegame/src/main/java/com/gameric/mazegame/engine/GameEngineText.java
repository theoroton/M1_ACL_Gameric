package com.gameric.mazegame.engine;

import java.util.Scanner;

public class GameEngineText {

	private Game game;
	
	public GameEngineText(Game game) {
		this.game = game;
	}
	
	public void run() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
				
		while (!this.game.isFinished()) {
			System.out.println("Ecrire Commande (Q/D/Z/S/W) :");
			
			char scan = scanner.next().charAt(0);
			Cmd c = Cmd.IDLE;
			
			switch (scan) {
			case 'q':
			case 'Q':
				c = Cmd.LEFT;
				break;
			case 'd':
			case 'D':
				c = Cmd.RIGHT;
				break;
			case 's':
			case 'S':
				c = Cmd.DOWN;
				break;
			case 'z':
			case 'Z':
				c = Cmd.LEFT;
				break;
			}
						
			this.game.evolve(c);
			Thread.sleep(100);
		}
	}
}
