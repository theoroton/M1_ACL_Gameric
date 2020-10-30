package com.gameric.mazegame.model;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Personnage{
	
	//Attributs
	
	//Points de vie du personnage
	//int pointsVie = 100;
	//Dégats du personnage
	//int degats = 10;		
	int pos_x;
	int pos_y;
	
	//Constructeur
	public Personnage(){
		pos_x = pos_y = 1;
	}
	
	public Personnage(int x, int y){
		if((x > 0) && (x < Labyrinthe.getLargeur()))	pos_x = x;
		else 						pos_x = 1;
		if((y > 0) && (y < Labyrinthe.getHauteur()))	pos_y = y;
		else 						pos_y = 1;
	}
	
	
	
	//Méthodes
	
	/**
	 * Gère le déplacement du personnage, via les coefficients dx et dy
	 * @param dx : déplacement en x
	 * @param dy : déplacement en y
	 * @return Retourne 1 si le déplacement est possible et que la position a été mise à jour,
	 * 0 sinon.
	 */
	public void deplacer(int dx, int dy){
		boolean valide = true;
		int new_x = pos_x + dx;
		int new_y = pos_y + dy;
		
		if((new_x > 0) && (new_x < Labyrinthe.getLargeur())){
			if( (new_y > 0) && (new_y < Labyrinthe.getHauteur()) ){
				pos_x = new_x;
				pos_y = new_y;
			} else {
				valide = false;
			}
		} else{
			valide = false;
		}
		
		if (!valide) {
			System.out.println("ERREUR DEPLACEMENT");
		}
	}
	
	public String getPosition(){
		return "(" + pos_x + "," +  pos_y + ")";
	}

	public int getPos_x() {
		return pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}
	
}



