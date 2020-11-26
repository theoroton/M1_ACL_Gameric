package com.gameric.mazegame.model.personnage;

/**
 *
 * @author Maeva Touchet
 *
 */
public abstract class Personnage{

	//Attributs

	int pointsVie;			//Points de vie courants du personnage
	int vieMax;				//Points de vie max du personnage
	int degats;				//Dégats courants du personnage
	int degatsDefaut;		 //Dégats par défaut du personnage
	int portee;				//Portée de l'attaque du personnage
	Case position;			//Position du personnage
	Labyrinthe labyrinthe;

	char direction;		//direction dans laquelle le personnage regarde
	public static final char N = "Nord";	//Serviront à changer la direction du Personnage
	public static final char E = "Est";
	public static final char S = "Sud";
	public static final char O = "Ouest";

	//Constructeurs
	public Personnage(){
		direction = E;
		System.out.println("Le personnage regard vers: " + direction);
	};

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

	public boolean estMort() {
		return pointsVie <= 0;
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
	 * Récupère le monstre à la position (x,y)
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
	 * Attaque un monstre à portée (sans direction d'attaque dans cette version)
	 **/
	public void attaquer(){
		int distance = 0;
		//On teste chaque case
		for(int i=0; i<labyrinthe.getHauteur(); i++){
			for(int j=0; j<labyrinthe.getLargeur() ; j++){
				Case c = labyrinthe.getCase(i,j);
				distance = Math.abs(position.getPx() - c.getPx() + position.getPy() - c.getPy());
				//Si la case est à portée
				if(distance <= portee){
					//Si la case est vide ou un mur(fantômes)
					if(c.getClass().getSuperclass() == CaseVide.class
							|| c.getClass().getSuperclass() == Mur.class){
						//S'il y a un monstre dessus
						if(testMonstre(c.getPx(), c.getPy())){
							//On récupère le monstre
							Monstre m = getMonstre(c.getPx(), c.getPy());
							//On lui fait des dégats
							m.setPointsVie(m.getPointsVie() - this.degats);
						}
					}
				}
			}
		}
	}

	//Setters
	public void setPosition(int x, int y) {
		position = labyrinthe.getCase(x, y);
	}

	public void setLabyrinthe(Labyrinthe labyrinthe) {
		this.labyrinthe = labyrinthe;
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


	public int getPointsVie() {
		return pointsVie;
	}

	public int getDegats() {
		return degats;
	}
}