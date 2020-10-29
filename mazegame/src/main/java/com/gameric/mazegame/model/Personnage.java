package com.gameric.mazegame.model;

public class Personnage{
	
	//Attributs
	
	//Points de vie du personnage
	int pointsVie = 100;
	//Dégats du personnage
	int degats = 10;		
	int pos_x;
	int pos_y;
	

	
	//Constructeur
	public Personnage(){
		pos_x = pos_y = 1;
	}
	
	public Personnage(int x, int y){
		if((x > 0) && (x < 1000))	pos_x = x;
		else 						pos_x = 1;
		if((y > 0) && (y < 1000))	pos_y = y;
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
	int deplacer( int dx, int dy){
		int new_x = pos_x + dx;
		int new_y = pos_y + dy;
		
		if( (new_x > 0) && (new_x < 1000) ){
			if( (new_y > 0) && (new_y < 1000) ){
				pos_x = new_x;
				pos_y = new_y;
				return 1;
			}
		}
		else{
			System.out.println("ERREUR DEPLACEMENT\n");
		}
		return 0;
	}
	
	void getPosition(){
		System.out.println("(" + pos_x + "," +  pos_y + ")\n");
	}
}



