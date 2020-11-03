package com.gameric.mazegame.model;

import com.gameric.mazegame.engine.Cmd;

/**
 * 
 * @author Anna Sushko
 * Stratégie de deplacement aléatoire
 *
 */

public class Patrouille implements StrategieDeplacement{
	//Monstre m;
	//Labyrinthe l;
	String direction;
	//Case newPosition;
	//et il faut récupérer une case du labyrinthe plutôt que de changer le x et le y
	
	public boolean checkBordures(int x, int y, Labyrinthe l) {
		boolean res = false;
		if ((x >= 0) && (x <= l.getLargeur()-1) && (y >= 0) && (y <= l.getHauteur()-1)){
			res = true;
		}
		return res;
	}
	
	@Override
	public void deplacer(Monstre monstre) {
		Personnage p = monstre.getLabyrinthe().getPersonnage_laby();
		String[] choix = {"UP", "RIGHT", "DOWN", "LEFT"};
		direction = choix[(int)(4 * Math.random())];
		int x = monstre.getPos_x();
		int y = monstre.getPos_y();
		switch (direction) {
			//Commande UP
			case "UP":
				//le monstre se déplace de 1 vers le haut (0,1)
				y--;
				break;
			//Commande DOWN
			case "DOWN":
				//le monstre se déplace de 1 vers le bas (0,-1)
				y++;
				break;
			//Commande LEFT
			case "LEFT":
				//le monstre se déplace de 1 vers la gauche (-1,0)
				x--;
				break;
			//Commande RIGHT
			case "RIGHT":
				//le monstre se déplace de 1 vers la droite (1,0)
				x++;
				break;
		}
		
		if (checkBordures(x,y,monstre.getLabyrinthe())) {
			if(!(monstre.getLabyrinthe().getCase(x,y).getClass() == Mur.class)) {
				monstre.setPosition(x, y);
				if(monstre.getLabyrinthe().estCaseOccupee(x, y) && monstre.getLabyrinthe().getCase(x,y) == p.getPosition()) {
					p.setPointsVie(p.getPointsVie() - monstre.getDegats());
					if(p.getPointsVie() < 0) {
						System.out.println("Joueur etait tue");
					}
				}
			}
		}
	}
}
