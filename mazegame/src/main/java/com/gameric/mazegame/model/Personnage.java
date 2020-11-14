package com.gameric.mazegame.model;

/**
 * 
 * @author Maeva Touchet
 *
 */
public class Personnage{
	
	//Attributs
	
	int pointsVie = 20;	//Points de vie du personnage
	int degats = 10;		//Dégats du personnage	
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
							position = new_position;
							
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
		position = labyrinthe.getCase(x, y);
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
			this.pointsVie = pointsVie;	
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
			position.ramasserObjet();
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
	}
	/**
	 * Trouve le monstre à portée (recherche sens horaire) et le renvoie
	 **/
	private Monstre trouverCible(){
		int x,y;
		x = position.getPx() - i;
		y = position.getPy() + i;
		if(testMonstre(x,y))	return getMonstre(x,y);
		
		x = position.getPx();
		y = position.getPy() + i;
		if(testMonstre(x,y))	return getMonstre(x,y);
			
		x = position.getPx() + i;
		y = position.getPy() + i;
		if(testMonstre(x,y))	return getMonstre(x,y);
			
		x = position.getPx() - i;
		y = position.getPy();
		if(testMonstre(x,y))	return getMonstre(x,y);
			
		x = position.getPx() + i;
		y = position.getPy();
		if(testMonstre(x,y))	return getMonstre(x,y);
			
		x = position.getPx() - i;
		y = position.getPy() - i;
		if(testMonstre(x,y))	return getMonstre(x,y);
			
		x = position.getPx();
		y = position.getPy() - i;
		if(testMonstre(x,y))	return getMonstre(x,y);
			
		x = position.getPx() + i;
		y = position.getPy() - i;
		if(testMonstre(x,y))	return getMonstre(x,y);
	}
	
	/**
	 * Retourne 1 s'il y a un monstre à portée
	 * Retourne 0 sinon
	 **/
	private boolean detecterCible(){
		boolean present = false;
		if(testMonstre(position.getPx() - i, position.getPy() + i))	return present = true;
		if(testMonstre(position.getPx()    , position.getPy() + i))	return present = true;
		if(testMonstre(position.getPx() + i, position.getPy() + i))	return present = true;
		if(testMonstre(position.getPx() - i, position.getPy()    ))	return present = true;
		if(testMonstre(position.getPx() + i, position.getPy()    ))	return present = true;
		if(testMonstre(position.getPx() - i, position.getPy() - i))	return present = true;
		if(testMonstre(position.getPx()    , position.getPy() - i))	return present = true;
		if(testMonstre(position.getPx() + i, position.getPy() - i))	return present = true;
		return present;
	}
	
	public void attaquer(){
		if(detecterCible()){
			Monstre m = trouverCible();
			m.setPointsVie(m.getPointsVie() - this.degats);
		}
	}
}
