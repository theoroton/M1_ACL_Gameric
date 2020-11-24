package com.gameric.mazegame.model.personnage;

import com.gameric.mazegame.model.labyrinthe.Case;
import com.gameric.mazegame.model.labyrinthe.CaseEffet;
import com.gameric.mazegame.model.labyrinthe.CaseObjet;
import com.gameric.mazegame.model.labyrinthe.Labyrinthe;
import com.gameric.mazegame.model.labyrinthe.Mur;
import com.gameric.mazegame.model.monstres.Monstre;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Personnage{
	
	//Attributs
	
	int pointsVie = 30;	//Points de vie courants du personnage
	int vieMax = 30; 	//Points de vie max du personnage
	int degats  = 10;		//Dégats du personnage	
	int portee = 1;		//Portée de l'attaque du personnage
	Case position;			//Position du personnage
	Labyrinthe labyrinthe;
	
	//Constructeurs
	public Personnage(){
	}

	public Personnage(int x, int y){		//Via deux entiers x et y
		int pos_x, pos_y;
		
		if((x > 0) && (x < labyrinthe.getLargeur()-1))	pos_x = x;
		else 						pos_x = 1;
		if((y > 0) && (y < labyrinthe.getHauteur()-1))	pos_y = y;
		else 						pos_y = 1;
		
		position = labyrinthe.getCase(x,y);
		System.out.println(position);
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
		int new_x = position.getPx() + dx;
		int new_y = position.getPy() + dy;
		
		if((new_x >= 0) && (new_x < labyrinthe.getLargeur())){			//Vérification: 0 < x < largeur
			if( (new_y >= 0) && (new_y < labyrinthe.getHauteur()) ){	//Vérification: 0 < y < hauteur
				Case new_position = labyrinthe.getCase(new_x,new_y);
				if(new_position != null) {								//Vérification: Case existante

					if(new_position.getClass() != Mur.class){	
						//Vérification: CaseVide
						if(!labyrinthe.estCaseOccupee(new_x,new_y)){	//Vérification: Case non occupée
							position.setOccupee(false);
							position = new_position;
							position.setOccupee(true);
							
							//Si la case sur lequel le personnage se déplace est une case à effet
							if (new_position.getClass().getSuperclass() == CaseEffet.class) {
								//On exécute l'effet de la case
								((CaseEffet) new_position).faireEffet(this);
							}
						}
						else {											//S'il y a collision
							for(Monstre m: labyrinthe.getMonstres()) {			//On boucle sur les monstres
								if(m.getPos_x() == new_x) {						//On cherche celui se trouvant sur la case ou on veut aller
									if(m.getPos_y() == new_y) {
										setPointsVie(pointsVie - m.getDegats());	//On ajuste les points de vie (personnage se prend les dégâts du monstre)
									}
								}
							}									//Le personnage ne va pas sur la case car elle est occupée par le monstre
						}
					}
				}
			}
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
	
	public void setPosition(int x, int y) {
		if (position != null) {
			position.setOccupee(false);
		}
		position = labyrinthe.getCase(x, y);
		position.setOccupee(true);
	}

	public void setLabyrinthe(Labyrinthe labyrinthe) {
		this.labyrinthe = labyrinthe;
	}

	public int getPointsVie() {
		return pointsVie;
	}

	public void setPointsVie(int pointsVie) {
		if (pointsVie < 0) {
			this.pointsVie = 0;
		} else {
			if(pointsVie > vieMax){
				this.pointsVie = vieMax;
			}
			else{
				this.pointsVie = pointsVie;	
			}
		}	
	}
	
	public void setDegats(int degats){
		this.degats = degats;
	}

	public boolean estMort() {
		return pointsVie <= 0;
	}

	public int getDegats() {
		return degats;
	}
	
	public void ramasserObjet(){
		if( position.getClass() == CaseObjet.class ){
			((CaseObjet) position).ramasserObjet(this);
		}
	}
	/**
	 * Teste si un monstre est présent sur la case (x,y)
	 **/
	private boolean testMonstre(int x, int y){
		boolean present = false;
		for(Monstre m: labyrinthe.getMonstres()) {			//On boucle sur les monstres
				if(m.getPos_x() == x) {						//On cherche celui se trouvant sur la case
					if(m.getPos_y() == y) {
						present = true;
					}
				}
			}
		return present;
	}
	
	/**
	 * Retourne le monstre à la position donnée
	 **/
	private Monstre getMonstre(int x, int y){
		for(Monstre m: labyrinthe.getMonstres()) {			//On boucle sur les monstres
				if(m.getPos_x() == x) {						//On cherche celui se trouvant sur la case
					if(m.getPos_y() == y) {
						return m;
					}
				}
			}
		return null;
	}
	/**
	 * Trouve le monstre à portée (recherche sens horaire) et le renvoie
	 **/
	private Monstre trouverCible(){
		int x,y;
		
		x = position.getPx();
		y = position.getPy() + 1;
		if(testMonstre(x,y))	return getMonstre(x,y);
			
		x = position.getPx() - 1;
		y = position.getPy();
		if(testMonstre(x,y))	return getMonstre(x,y);
			
		x = position.getPx() + 1;
		y = position.getPy();
		if(testMonstre(x,y))	return getMonstre(x,y);
			
		x = position.getPx();
		y = position.getPy() - 1;
		if(testMonstre(x,y))	return getMonstre(x,y);
		
		return null;

	}
	
	/**
	 * Retourne 1 s'il y a un monstre à portée
	 * Retourne 0 sinon
	 **/
	private boolean detecterCible(){
		boolean present = false;
		if(testMonstre(position.getPx()    , position.getPy() + 1))	return present = true;
		if(testMonstre(position.getPx() - 1, position.getPy()    ))	return present = true;
		if(testMonstre(position.getPx() + 1, position.getPy()    ))	return present = true;
		if(testMonstre(position.getPx()    , position.getPy() - 1))	return present = true;
		return present;
	}
	
	public void attaquer(){
		if(detecterCible()){
			Monstre m = trouverCible();
			m.setPointsVie(m.getPointsVie() - this.degats);
			if (m.getPointsVie() <= 0) {
				labyrinthe.enleverMonstre(m);
			}
		}
	}
}
