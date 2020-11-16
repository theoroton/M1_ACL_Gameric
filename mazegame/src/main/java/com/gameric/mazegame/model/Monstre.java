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
	private int pointsVie = 10;
	/**
	 * La nombre des degats du monstre
	 */
	private int degats = 2;
	/**
	 * La vitesse de déplacement du monstre
	 */
	//private int vitesse = 200;
	/**
	 * La distance de l'attaque du monstre
	 */
	//private int portee = 1;
	/**
	 * La direction de déplacement du monstre
	 */
	//private String direction;
	/**
	 * Est-ce que le monstre a la possibilite de traverser les murs ou non
	 */
	//private boolean traverserMur = false;
	/**
	 * La distance sur laquelle le monstre peux voir le Personnage
	 */
	//private int vision = 3;
	/**
	 * La position du monstre
	 */
	private Case position;
	/**
	 * La strategie de deplacement
	 */
	private StrategieDeplacement strategie = new DetectionJoueur();
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
	 * Méthode getter de l'attribut vitesse
	 * @return La vitesse de déplacement du monstre
	 */
	/*public int getVitesse() {
		return vitesse;
	}
	/**
	 * Méthode setter de l'attribut vitesse
	 * @param vitesse
	 */
	/*public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}*/
	/**
	 * Méthode getter de l'attribut portee
	 * @return La distance de l'attaque du monstre
	 */
	/*public int getPortee() {
		return portee;
	}*/
	/**
	 * Méthode setter de l'attribut portee
	 * @param portee
	 */
	/*public void setPortee(int portee) {
		this.portee = portee;
	}*/
	/**
	 * Méthode getter de l'attribut direction
	 * @return La direction de déplacement du monstre
	 */
	/*public String getDirection() {
		return direction;
	}*/
	/**
	 * Méthode setter de l'attribut direction
	 * @param direction
	 */
	/*public void setDirection(String direction) {
		this.direction = direction;
	}*/
	/**
	 * Méthode qui retourne true si le Monstre peut traverser la mur
	 * @return
	 */
	/*public boolean isTraverserMur() {
		return traverserMur;
	}*/
	/**
	 * Méthode setter de l'attribut boolean traverserMur
	 * @param traverserMur
	 */
	/*public void setTraverserMur(boolean traverserMur) {
		this.traverserMur = traverserMur;
	}*/
	/**
	 * Méthode getter de l'attribut vision
	 * @return La distance sur laquelle le monstre voit le Personnage
	 */
	/*public int getVision() {
		return vision;
	}*/
	/**
	 * Méthode setter de l'attribut vision
	 * @param vision
	 */
	/*public void setVision(int vision) {
		this.vision = vision;
	}*/
	
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
		if(this.getPosition().getHeuristic(labyrinthe.getPersonnage_laby().getPosition()) != 1)
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
	
	//public abstract void attaquer(Personnage p);
}
