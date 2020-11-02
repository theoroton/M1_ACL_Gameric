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
	//private int vitesse = 1;
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
	private Case position;
	
	private static StrategieDeplacement strategie;
	
	/**
	 * Méthode getter de l'attribut pointsVie
	 * @return La nombre actuel des points de la vie du monstre
	 */
	public int getPointsVie() {
		return pointsVie;
	}
	/**
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
	 * @param degats
	 */
	public void setDegats(int degats) {
		this.degats = degats;
	}
	/**
	 * Méthode getter de l'attribut vitesse
	 * @return La vitesse de déplacement du monstre
	 */
	public int getVitesse() {
		return vitesse;
	}
	/**
	 * @param vitesse
	 */
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	/**
	 * Méthode getter de l'attribut portee
	 * @return La distance de l'attaque du monstre
	 */
	public int getPortee() {
		return portee;
	}
	/**
	 * @param portee
	 */
	public void setPortee(int portee) {
		this.portee = portee;
	}
	/**
	 * Méthode getter de l'attribut direction
	 * @return La direction de déplacement du monstre
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * @return
	 */
	public boolean isTraverserMur() {
		return traverserMur;
	}
	/**
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
	 * @param vision
	 */
	public void setVision(int vision) {
		this.vision = vision;
	}
	
	public Case getPosition() {
		return position;
	}
	
	public void setPosition(int x, int y) {
		this.position.setPx(x);
		this.position.setPy(y);
	}
	/**
	 * Méthode qui gère le déplacement de monstre
	 */
	public void deplacerMonstre(StrategieDeplacement strategie) {
		strategie.deplacer();
	}

	//pour v2
	//public abstract void attaquer(Personnage p);
}
