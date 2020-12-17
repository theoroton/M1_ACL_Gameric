package com.gameric.mazegame.model.personnage;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Epeiste extends Personnage{
	//Constructeur
	public Epeiste(){
		super();
		pointsVie = vieMax = 30;
		degats = 10;
		portee = 1;

		for (int i = 0; i < 9; i++ ) {
			walkingDown[i] = new Sprite().getSprite(i, 10, this.getClass());
			walkingLeft[i] = new Sprite().getSprite(i, 9, this.getClass());
			walkingRight[i] = new Sprite().getSprite(i, 11, this.getClass());
			walkingUp[i] = new Sprite().getSprite(i, 8, this.getClass());
		}
		stand[0] = new Sprite().getSprite(0, 2, this.getClass());

		for (int i = 0; i < 12; i++) {
			attaqueUp[i] = new Sprite().getSprite(i, 22, this.getClass());
			attaqueDown[i] = new Sprite().getSprite(i, 24, this.getClass());
			attaqueLeft[i] = new Sprite().getSprite(i, 23, this.getClass());
			attaqueRight[i] = new Sprite().getSprite(i, 25, this.getClass());
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
	 * Pour l'épéiste, augmentation de 2 dégâts pour chaque monstre tué
	 */
	protected void capaciteSpe(){
		setDegats(degats + 2);
	}
}
