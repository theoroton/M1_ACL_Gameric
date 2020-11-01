package com.gameric.mazegame.model;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Personnage{
	
	//Attributs
	
	int pointsVie = 100;	//Points de vie du personnage
	int degats = 10;		//Dégats du personnage	
	Case position;			//Position du personnage
	
	//Constructeurs
	public Personnage(){					//Sans argument
		position = new Case(1,1);
	}
	
	public Personnage(int x, int y){		//Via deux entiers x et y
		int pos_x, pos_y;
		
		if((x > 0) && (x < Labyrinthe.getLargeur()-1))	pos_x = x;
		else 						pos_x = 1;
		if((y > 0) && (y < Labyrinthe.getHauteur()-1))	pos_y = y;
		else 						pos_y = 1;
		
		position = new Case(pos_x,pos_y);
	}
	
	public Personnage(Case pos) {			//Via une Case
		position = new Case(pos);
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
		boolean valide = false;
		int new_x = position.getPx() + dx;
		int new_y = position.getPy() + dy;
		
		if((new_x > 0) && (new_x < Labyrinthe.getLargeur()-1)){
			if( (new_y > 0) && (new_y < Labyrinthe.getHauteur()-1) ){
				Case new_position = Labyrinthe.getCase(new_x,new_y);
				if(new_position != null) {
					//Ajouter la méthode pour tester si une case est vide et libre
					position = new_position;
					valide = true;
				}
			}
		}
		
		if (!valide) {
			System.out.println("ERREUR DEPLACEMENT");
		}
	}
	
	//Getters
	public String getStringPosition(){
		return "(" + position.getPx() + "," +  position.getPy() + ")";
	}
	
	public Case getPosition() {
		return position;
	}

	public int getPos_x() {
		return position.getPx();
	}

	public int getPos_y() {
		return position.getPy();
	}
	
}



