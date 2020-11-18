package com.gameric.mazegame.model;

/**
 * 
 * @author Anna Sushko
 * Classe du monstre
 *
 */

public class Monstre {
	
	/**
	 * La nombre des points de la vie du monstre
	 */
	protected int pointsVie = 10;
	/**
	 * La nombre des degats du monstre
	 */
	private int degats = 2;
	/**
	 * La distance de l'attaque du monstre
	 */
	protected int portee = 1;
	/**
	 * Est-ce que le monstre a la possibilite de traverser les murs ou non
	 */
	private boolean traverserMur = false;
	/**
	 * La distance sur laquelle le monstre peux voir le Personnage
	 */
	private int vision = 1;
	/**
	 * La position du monstre
	 */
	private Case position;
	/**
	 * La strategie de deplacement
	 */
	private StrategieDeplacement strategie = new StrategieDetection();
	/**
	 * Le labyrinthe où se trouve le monstre
	 */
	private Labyrinthe labyrinthe;
	/**
	 * Constructeur du monstre
	 */
	public Monstre(int x, int y, Labyrinthe l) {
		labyrinthe = l;
		position = labyrinthe.getCase(x,y); 
	}
	/**
	 * Méthode getter de l'attribut pointsVie
	 * @return La nombre actuel des points de la vie du monstre
	 */
	public int getPointsVie() {
		return pointsVie;
	}
	/** 
	 * Méthode setter de l'attribut pointsVie
	 * @param pointsVie
	 */
	public void setPointsVie(int pointsVie) {
		this.pointsVie = pointsVie;
	}
	/**
	 * Méthode getter de l'attribut degats
	 * @return La nombre des degats du monstre
	 */
	public int getDegats() {
		return degats;
	}
	/**
	 * Méthode setter de l'attribut degats
	 * @param degats
	 */
	public void setDegats(int degats) {
		this.degats = degats;
	}
	/**
	 * Méthode getter de l'attribut portee
	 * @return La distance de l'attaque du monstre
	 */
	public int getPortee() {
		return portee;
	}
	/**
	 * Méthode setter de l'attribut portee
	 * @param portee
	 */
	public void setPortee(int portee) {
		this.portee = portee;
	}
	/**
	 * Méthode qui retourne true si le Monstre peut traverser la mur
	 * @return
	 */
	public boolean peutTraverserMur() {
		return traverserMur;
	}
	/**
	 * Méthode setter de l'attribut boolean traverserMur
	 * @param traverserMur
	 */
	public void setTraverserMur(boolean traverserMur) {
		this.traverserMur = traverserMur;
	}
	/**
	 * Méthode getter de l'attribut vision
	 * @return La distance sur laquelle le monstre voit le Personnage
	 */
	public int getVision() {
		return vision;
	}
	/**
	 * Méthode setter de l'attribut vision
	 * @param vision
	 */
	public void setVision(int vision) {
		this.vision = vision;
	}
	
	/**
	 * Méthode getter de l'attribut position
	 * @return
	 */
	public Case getPosition() {
		return position;
	}
	/**
	 * Méthode setter de l'attribut position
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y) {
		position = labyrinthe.getCase(x, y);
	}
	/**
	 * Méthode qui gère le déplacement de monstre
	 */
	public void deplacerMonstre() {
		if(verifPersEnZone() && this.getClass() != Zombie.class) {
			if(checkLineBresenham(this.getPos_x(), this.getPos_y(), labyrinthe.getPersonnage_laby().getPos_x(),labyrinthe.getPersonnage_laby().getPos_y()) ||
					this.peutTraverserMur()) {
				strategie = new StrategieDetection();
			}else {
				strategie = new StrategiePatrouille();
			}
		} else {
			strategie = new StrategiePatrouille();
		}
		strategie.deplacer(this);
	}
	/**
	 * Méthode getter de valeur X en attribut position
	 * @return valeur X de position du monstre
	 */
	public int getPos_x() {
		return position.getPx();
	}
	/**
	 * Méthode getter de valeur Y en attribut position
	 * @return valeur Y de position du monstre
	 */
	public int getPos_y() {
		return position.getPy();
	}
	/**
	 * Récupération de labyrinthe où se trouve le monstre 
	 * @return l'objet labyrinthe
	 */
	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}
	/**
	 * Méthode qui verifie si le Personnage est dans la zone de la vision du Monstre
	 * @return true si le Personnage est dans la zone de la vision du Monstre, sinon false
	 */
	public boolean verifPersEnZone() {
		int x1, y1, x2, y2, x3, y3, x4, y4;
		for(int k=1; k <= this.getVision(); k++) {
			for(int i = 0; i < k; i++) {
				//x,y
				x1 = this.getPos_x()+k-i;
				y1 = this.getPos_y()+i;
				//-x,-y
				x2 = this.getPos_x()-k+i;
				y2 = this.getPos_y()-i;
				//-x,y
				x3 = this.getPos_x()-i;
				y3 = this.getPos_y()+k-i;
				//x,-y
				x4 = this.getPos_x()+i;
				y4 = this.getPos_y()-k+i;
				if(memeCasePM(x1,y1) || memeCasePM(x3,y3) || memeCasePM(x2,y2) || memeCasePM(x4,y4))
					return true;
			}
		}
		return false;
	}
	/**
	 * Méthode qui verifie si le Personnage et le Monstre sont sur la meme case
	 * @param x
	 * @param y
	 * @return true si le Personnage et le Monstre sont sur la meme case, sinon false
	 */
	private boolean memeCasePM(int x, int y) {
		return x == labyrinthe.getPersonnage_laby().getPos_x() && y ==labyrinthe.getPersonnage_laby().getPos_y();
	}
	/**
	 * Méthode qui utilise l'algorithme de Bresenham pour verifie s'il y a
	 * un obstacle sur le chemin entre le Personnage et le Monstre
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 * @return true s'il y a pas des obstacles, sinon false
	 */
	public boolean checkLineBresenham(int x0, int y0, int x1, int y1) {
		boolean swapXY = fastAbs( y1 - y0 ) > fastAbs( x1 - x0 );
		int tmp;
		if ( swapXY ) {
			// swap x and y
			tmp = x0; x0 = y0; y0 = tmp; // swap x0 and y0
			tmp = x1; x1 = y1; y1 = tmp; // swap x1 and y1
		}

		if ( x0 > x1 ) {
			// verifier x0 < x1
			tmp = x0; x0 = x1; x1 = tmp; // swap x0 and x1
			tmp = y0; y0 = y1; y1 = tmp; // swap y0 and y1
		}

		int deltax = x1 - x0;
		float deltay = fastFloor( fastAbs( y1 - y0 ) );
		float error = fastFloor( deltax / 2 );
		int y = y0;
		int ystep = y0 < y1 ? 1 : -1; 

		if( swapXY )
			// Y / X
			for ( int x = x0; x < x1+1; x++ ) {
				if( !rayonPasse(y,x) )
				return false;

				error -= deltay;
				if ( error < 0 ) {
					y = y + ystep;
					error = error + deltax;
				}
			}
		else
			// X / Y
			for (int x = x0; x < x1+1; x++ ) {
				if( !rayonPasse(x,y) )
				return false;

				error -= deltay;
				if ( error < 0 ) {
					y = y + ystep;
					error = error + deltax;
				}
			}
		return true;
	}
	/**
	 * Méthode qui calcule la valeur absolue entière (abs) sans branchement
	 * @param v
	 * @return la valuer absolue entière
	 */
	private static int fastAbs(int v) {
		return (v ^ (v >> 31)) - (v >> 31);
	}

	/**
	 * Méthode qui supprime la partie fractionnaire d'un nombre
	 * @param v
	 * @return un nombre sans la partie fractionnaire
	 */
	private static float fastFloor(float v) {
		return truncateSafely(v);
	}
	/**
	 * Méthode qui supprime la partie fractionnaire pour les nombres négatifs et positifs.
	 * @param value
	 * @return le nombre sans la partie fractionnaire
	 */
	private static float truncateSafely(float value) {
        if (value < 0) {
            return (float) Math.ceil(value); // pour les nombres négatifs
        } else {
            return (float) Math.floor(value); // pour les nombres positifs
        }
    }
	/**
	 * Méthode qui verifie si la case est un Mur ou non
	 * @param x
	 * @param y
	 * @return true si la case n'est pas un Mur, sinon false
	 */
	private boolean rayonPasse(int x, int y) {
		return labyrinthe.getCase(x, y).getClass() != Mur.class;
	}
	
	/**
	 * Méthode qui donne le degats du Monstre à Personnage 
	 */
	public void donnerDegats() {
		this.getLabyrinthe().getPersonnage_laby().setPointsVie(this.getLabyrinthe().getPersonnage_laby().getPointsVie() - this.getDegats());
	}
}
