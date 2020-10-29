package com.gameric.mazegame.model;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Personnage{
	
	//Attributs
	
	//Points de vie du personnage
	int pointsVie = 100;
	//Dégats du personnage
	int degats = 10;		
	int pos_x;
	int pos_y;
	
	private Labyrinthe labyrinthe;
	
	//Constructeur
	public Personnage(Labyrinthe l){
		labyrinthe = l;
		pos_x = pos_y = 1;
	}
	
	public Personnage(Labyrinthe l, int x, int y){
		labyrinthe = l;
		if((x > 0) && (x < labyrinthe.getLargeur()))	pos_x = x;
		else 						pos_x = 1;
		if((y > 0) && (y < labyrinthe.getHauteur()))	pos_y = y;
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
	void deplacer(int dx, int dy){
		boolean valide = true;
		int new_x = pos_x + dx;
		int new_y = pos_y + dy;
		
		if((new_x > 0) && (new_x < labyrinthe.getLargeur())){
			if( (new_y > 0) && (new_y < labyrinthe.getHauteur()) ){
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
	
	String getPosition(){
		return "(" + pos_x + "," +  pos_y + ")";
	}
}



