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
	Labyrinthe l;
	Personnage p;
	Case newPosition;
	
	public boolean checkBordures(Case position) {
		int x = position.getPx();
		int y = position.getPy();
		if(x > 0 && y > 0 && x < l.getLargeur() && y < l.getHauteur()) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void deplacer(Monstre monstre) {
		String[] choix = {"UP", "RIGHT", "DOWN", "LEFT"};
        m.setDirection(choix[(int)(4 * Math.random())]);
		switch (m.getDirection()) {
			//Commande UP
			case "UP":
				//le monstre se déplace de 1 vers le haut (0,1)
				newPosition.setPx(0);
				newPosition.setPy(1);
				break;
			//Commande DOWN
			case "DOWN":
				//le monstre se déplace de 1 vers le bas (0,-1)
				newPosition.setPx(0);
				newPosition.setPy(-1);
				break;
			//Commande LEFT
			case "LEFT":
				//le monstre se déplace de 1 vers la gauche (-1,0)
				newPosition.setPx(-1);
				newPosition.setPy(0);
				break;
			//Commande RIGHT
			case "RIGHT":
				//le monstre se déplace de 1 vers la droite (1,0)
				newPosition.setPx(1);
				newPosition.setPy(0);
				break;
		}
		
		if(l.getCase(newPosition.getPx(),newPosition.getPy()).getClass() == Mur.class || !checkBordures(newPosition) 
				|| newPosition.getPx() != p.getPos_x() && newPosition.getPy() != p.getPos_y()) {
			System.out.println("Erreur Patrouille Monstre");
		} else {
			m.setPosition(newPosition.getPx(), newPosition.getPy());
		}
	}
}
