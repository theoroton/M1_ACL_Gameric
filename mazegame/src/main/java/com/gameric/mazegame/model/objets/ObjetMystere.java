package com.gameric.mazegame.model.objets;

import com.gameric.mazegame.model.personnage.Personnage;

/**
 * 
 * @author Théo Roton
 * Classe ObjetMystere
 */
public class ObjetMystere extends Objet {

	/**
	 * Constructeur de l'objet mystère;
	 * l'objet mystère est représenté par un "?"
	 */
	public ObjetMystere() {
		super("?", 75);
	}

	/**
	 * Méthode qui effectue l'effet de l'objet sur le personnage
	 * quand il le ramasse.
	 * On va modifier positivement ou négativement une statistique
	 * aléatoire du personnage.
	 * @param p : personnage sur lequel l'effectuer l'effet.
	 */
	public void effetObjet(Personnage p) {
		super.effetObjet(p);
		//On prend un entier compris entre 0 et 7
		int rand = (int) (Math.random() * (8 - 0));
		
		//Effet possibles
		switch (rand) {
		//On réduit les pvMax de 4
		case 0:
			p.setVieMax(p.getVieMax() - 4);
			p.setPointsVie(p.getPointsVie() - 4);
			break;
		//On augmente les pvMax de 4
		case 1:
			p.setVieMax(p.getVieMax() + 4);
			p.setPointsVie(p.getPointsVie() + 4);
			break;
		//On réduit les pv de 6
		case 2:
			p.setPointsVie(p.getPointsVie() - 6);
			break;
		//On augmente les points de vie de 6
		case 3:
			p.setPointsVie(p.getPointsVie() + 6);
			break;
		//On réduit les dégâts de 3
		case 4:
			p.setDegats(p.getDegats() - 3);
			break;
		//On augmente les dégâts de 3
		case 5:
			p.setDegats(p.getDegats() + 3);
			break;
		//On réduit la portée de 1 (si elle est supérieure à 1)
		case 6:
			if (p.getPortee() > 1) {
				p.setPortee(p.getPortee() - 1);
			}
			break;
		}
	}

}
