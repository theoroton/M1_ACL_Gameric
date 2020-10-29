package com.gameric.mazegame.engine;

public class GameEngineText {

	private Game game;
	private GameController gameController;
	
	public GameEngineText(Game game, GameController gameController) {
		this.game = game;
		this.gameController = gameController;
	}
	
	public void run() throws InterruptedException {
		
		while (!this.game.isFinished()) {
			Cmd c = this.gameController.getCommand();
			Thread.sleep(100);
		}
	}
}
