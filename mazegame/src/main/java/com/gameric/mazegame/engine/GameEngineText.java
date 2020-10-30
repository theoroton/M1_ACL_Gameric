package com.gameric.mazegame.engine;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.gameric.mazegame.model.JeuLabyrinthe;

/**
 * 
 * @author Théo Roton
 *
 * Moteur de jeu pour la version textuel
 * On lui donne le jeu à exécuter
 */
public class GameEngineText {

	/**
	 * Jeu à exécuter
	 */
	private Game game;
	
	/**
	 * Constructeur du moteur de jeu
	 * @param game : jeu à exécuter
	 */
	public GameEngineText(Game game) {
		this.game = game;
	}
	
	/**
	 * Méthode run qui lance le moteur de jeu
	 * @throws InterruptedException
	 */
	public void run() throws InterruptedException {
		//Scanner qui lira les commandes du joueur
		Scanner scanner = new Scanner(System.in);
				
		//Boucle du jeu
		while (!this.game.isFinished()) {
			System.out.println("Ecrire Commande (Q/D/Z/S/W) :");
					
			//On récupère le caractère qui correspond à la commande du joueur
			String scan = scanner.next();
			
			//Caractères acceptés
			String[] commandes = new String[] {"q","d","z","s","w","Q","D","Z","S","W"};
			List<String> list = Arrays.asList(commandes);
			
			//Si le caractère ne correspond à aucune commande, on le redemande au joueur
			while (!list.contains(scan)) {
				System.out.println("ERREUR COMMANDE\n");
				System.out.println("Ecrire Commande (Q/D/Z/S/W) :");
				
				//On récupère le caractère qui correspond à la commande du joueur
				scan = scanner.next();
			}
			
			Cmd c = Cmd.IDLE;
				
			//On récupère la commande correspondant au caractère entré
			switch (scan) {
			case "q":
			case "Q":
				c = Cmd.LEFT;
				break;
			case "d":
			case "D":
				c = Cmd.RIGHT;
				break;
			case "s":
			case "S":
				c = Cmd.DOWN;
				break;
			case "z":
			case "Z":
				c = Cmd.UP;
				break;
			}
						
			//Evolution du jeu en fonction de la commande
			this.game.evolve(c);			
			System.out.println("");
			Thread.sleep(100);
		}
	}
}
