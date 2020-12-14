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
	}
	//Méthodes

	/**
	 * Capacité spéciale, déclenchée lorsqu'on attaque un monstre
	 * Pour l'épéiste, augmentation de 2 dégâts pour chaque monstre tué
	 */
<<<<<<< HEAD
	private void capaciteSpe(){
=======
	public void capaciteSpe(){
>>>>>>> e3f72ac1948be1b92683a9f41287798bdd46944a
		setDegats(degats + 2);
	}
}
