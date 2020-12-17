package com.gameric.mazegame.model.personnage;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Archer extends Personnage{
	//Attributs
	int compteur; //Compte le nombre de monstre tués pour la capaciteSpe
	//Constructeur
	public Archer(){
		super();
		pointsVie = vieMax = 20;
		degats = 5;
		portee = 5;
		compteur = 0;

		for (int i = 0; i < 9; i++ ) {
			walkingDown[i] = new Sprite().getSprite(i, 10, this.getClass());
			walkingLeft[i] = new Sprite().getSprite(i, 9, this.getClass());
			walkingRight[i] = new Sprite().getSprite(i, 11, this.getClass());
			walkingUp[i] = new Sprite().getSprite(i, 8, this.getClass());
		}
		stand[0] = new Sprite().getSprite(0, 2, this.getClass());

		for (int i = 0; i < 12; i++) {
			attaqueUp[i] = new Sprite().getSprite(i, 16, this.getClass());
			attaqueDown[i] = new Sprite().getSprite(i, 18, this.getClass());
			attaqueLeft[i] = new Sprite().getSprite(i, 17, this.getClass());
			attaqueRight[i] = new Sprite().getSprite(i, 19, this.getClass());
		}

		walkingU = new Animation(walkingUp, 10);
		walkingD = new Animation(walkingDown, 10);
		walkingL = new Animation(walkingLeft, 10);
		walkingR = new Animation(walkingRight, 10);
		standing = new Animation(stand, 10);

		attaqueU = new Animation(attaqueUp, 10);
		attaqueD = new Animation(attaqueDown, 10);
		attaqueL = new Animation(attaqueLeft, 10);
		attaqueR= new Animation(attaqueRight, 10);
	}
	//Méthodes
	/**
	 * Capacité spéciale, déclenchée lorsqu'on attaque un monstre
	 * Pour l'archer, plus un de portée toutes les 3 monstres tués
	 */
	protected void capaciteSpe(){
		compteur = compteur + 1;
		if(compteur == 3) {
			setPortee(portee + 1);
			compteur = 0;
		}
	}
}
