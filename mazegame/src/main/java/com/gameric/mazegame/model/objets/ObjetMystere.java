package com.gameric.mazegame.model.objets;

import java.util.Random;

import com.gameric.mazegame.model.personnage.Personnage;

public class ObjetMystere extends Objet {

	public ObjetMystere() {
		super("?");
	}

	@Override
	public void effetObjet(Personnage p) {
		int rand = (int) (Math.random() * (9 - 1));
		
		switch (rand) {
		case 1:
			p.setVieMax(p.getVieMax() - 4);
			break;
		case 2:
			p.setVieMax(p.getVieMax() + 4);
			break;
		case 3:
			p.setPointsVie(p.getPointsVie() - 6);
			break;
		case 4:
			p.setPointsVie(p.getPointsVie() + 6);
			break;
		case 5:
			p.setDegats(p.getDegats() - 3);
			break;
		case 6:
			p.setDegats(p.getDegats() + 3);
			break;
		case 7:
			if (p.getPortee() > 1) {
				p.setPortee(p.getPortee() - 1);
			}
			break;
		case 8:
			p.setPortee(p.getPortee() + 1);
			break;
		}
	}

}
