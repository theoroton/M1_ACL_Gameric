package com.gameric.mazegame.model.labyrinthe;

import com.gameric.mazegame.model.personnage.Personnage;

/**
 * 
 * @author Théo Roton
 * Classe CaseTeleportation
 */
public class CaseTeleportation extends CaseEffet {

	/**
	 * Constructeur de la classe CaseTeleportation
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 */
	public CaseTeleportation(int x, int y) {
		super(x, y);
	}

	/**
	 * Méthode qui effectue l'effet de la case :
	 * 	- L'effet de la case téléportation va téléporter le personnage
	 * sur une case vide et non occupée aléatoire du labyrinthe.
	 * @param p : Personnage sur lequel effectuer l'effet.
	 */
	public void faireEffet(Personnage p) {
		//Labyrinthe courant du personnage
		Labyrinthe l = p.getLabyrinthe();
		//Booleen qui indique si on a trouvée une case vide et non ocupée.
		boolean trouvee = false;
		int x = l.getxEntree(), y = l.getyEntree();
		
		//Tant qu'on ne trouve pas de case
		while (!trouvee) {
			//On prend des coordonnées aléatoires compris dans les dimensions du labyrinthe.
			x = (int) (Math.random() * (l.getLargeur() - 1));
			y = (int) (Math.random() * (l.getHauteur() - 1));
			
			//Si la case n'est pas un mur
			if (l.getCase(x, y).getClass() != Mur.class) {
				//Si la case n'est pas occupée.
				if (!l.estCaseOccupee(x, y)) {
					//On a trouvée la case sur laquelle on téléporte le personnage.
					trouvee = true;
				}
			}
		}
		
		//On met la position du personnage sur cette case.
		p.setPosition(x, y);
		//Si le personnage atterit sur une case à effet, on déclenche l'effet.
		if (p.getPosition().getClass().getSuperclass() == CaseEffet.class) {
			((CaseEffet) p.getPosition()).faireEffet(p);
		}	
	}

}
