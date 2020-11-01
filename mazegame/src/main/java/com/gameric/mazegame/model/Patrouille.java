package com.gameric.mazegame.model;

import com.gameric.mazegame.engine.Cmd;

/**
 * 
 * @author Anna Sushko
 * Stratégie de deplacement aléatoire
 *
 */

public class Patrouille implements StrategieDeplacement{
	Monstre m;
	public void deplacer() {
		String[] choix = {"UP", "RIGHT", "DOWN", "LEFT"};
        m.setDirection(choix[(int)(4 * Math.random())]);
		switch (m.getDirection()) {
			//Commande UP
			case "UP":
				//le monstre se déplace de 1 vers le haut (0,1)
				m.setPosition(0, 1);
				break;
			//Commande DOWN
			case "DOWN":
				//le monstre se déplace de 1 vers le bas (0,-1)
				m.setPosition(0, -1);
				break;
			//Commande LEFT
			case "LEFT":
				//le monstre se déplace de 1 vers la gauche (-1,0)
				m.setPosition(-1, 0);
				break;
			//Commande RIGHT
			case "RIGHT":
				//le monstre se déplace de 1 vers la droite (1,0)
				m.setPosition(1, 0);
				break;
		}
	}
}
