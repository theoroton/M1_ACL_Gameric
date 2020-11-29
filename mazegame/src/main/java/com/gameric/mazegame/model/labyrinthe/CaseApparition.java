package com.gameric.mazegame.model.labyrinthe;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.gameric.mazegame.model.monstres.Fantome;
import com.gameric.mazegame.model.monstres.Monstre;
import com.gameric.mazegame.model.monstres.Squelette;
import com.gameric.mazegame.model.monstres.Zombie;
import com.gameric.mazegame.model.personnage.Personnage;

/**
 * 
 * @author Théo Roton
 * Classe CaseApparition
 */
public class CaseApparition extends CaseEffet {

	/**
	 * Attribut booléen qui indique si l'effet à déjà était déclenché
	 */
	private boolean declenche;
	
	/**
	 * Constructeur de la classe CaseApparition
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 */
	public CaseApparition(int x, int y) {
		super(x, y);
		declenche = false;
	}

	/**
	 * Méthode qui effectue l'effet de la case :
	 * 	- L'effet de la case apparition va créer un monstre et
	 * le positionner sur une case vide et non occupée aléatoire du labyrinthe.
	 * @param p : Personnage sur lequel effectuer l'effet.
	 */
	public void faireEffet(Personnage p) {
		//Si l'effet n'a pas encore était déclenché
		if (!declenche) {
			
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
			
			//On crée un nouveau monstre aléatoire
			int choix = (int) (Math.random() * (3 - 0));
			Monstre m = null;
			switch(choix) {
			case 0:
				m = new Fantome(x,y,l);
				break;
			case 1:
				m = new Zombie(x,y,l);
				break;
			case 2:
				m = new Squelette(x,y,l);
				break;
			}		
			//On ajoute le monstre à la liste des monstres du labyrinthe
			l.ajouterMonstre(m);
			//On indique que l'effet a était déclenché
			declenche = true;
		}			
	}

	/**
	 * Méthode getter de l'attribut declenche
	 * @return si l'effet à déjà était déclenché
	 */
	public boolean isDeclenche() {
		return declenche;
	}

}
