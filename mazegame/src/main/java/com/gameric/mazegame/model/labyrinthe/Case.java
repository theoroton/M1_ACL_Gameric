package com.gameric.mazegame.model.labyrinthe;

import java.util.ArrayList;
import java.util.List;

import com.gameric.mazegame.model.monstres.Monstre;
/**
 * 
 * @author Théo Roton
 * Classe abstraite Case
 */
public abstract class Case {

	/**
	 * Position en x de la case
	 */
	private int px;
	/**
	 * Position en y de la case
	 */
	private int py;
	
	/**
	 * Booléen qui indique si la case est occupée ou non.
	 */
	protected boolean occupee;
	
	/**
	 * Parent de la case
	 */
	private Case parent;
	/**
	 * Distance entre la case et le but
	 */
	private int distance;
	
	/**
	 * Constructeur de la classe Case
	 * @param x : position en x de la case
	 * @param y : position en y de la case
	 */
	public Case(int x, int y) {
		px = x;
		py = y;
	}

	/**
	 * Méthode getter de l'attribut px
	 * @return position en x de la case
	 */
	public int getPx() {
		return px;
	}

	/**
	 * Méthode getter de l'attribut py
	 * @return position en y de la case
	 */
	public int getPy() {
		return py;
	}

	/**
	 * Méthode setter de l'attribut px
	 * @param px : nouvelle position X de la case
	 */
	public void setPx(int px) {
		this.px = px;
	}

	/**
	 * Méthode setter de l'attribut py
	 * @param py : nouvelle position Y de la case
	 */
	public void setPy(int py) {
		this.py = py;
	}

	/**
	 * Méthode getter de parent de la case
	 * @return le parent de la case
	 */
	public Case getParent() {
		return parent;
	}
	
	/**Méthode setter de parent de la case
	 * @param parent
	 */
	
	public void setParent(Case parent) {
		this.parent = parent;
	}
	
	/**
	 * Méthode getter de coût du chemin
	 * @return le coût du chemin
	 */
	public int getCoutChemin() {
		return distance;
	}

	/**
	 * Méthode setter de coût du chemin
	 * @param distance
	 */
	public void setCoutChemin(int distance) {
		this.distance = distance;
	}
	
	/**
	 * Méthode getter de l'attribut occupee
	 * @return true si la case est occupée
	 */
	public boolean isOccupee() {
		return occupee;
	}

	/**
	 * Méthode setter de l'attribut occupee
	 * @param occupee : parametre qui met à jour la position de la case
	 */
	public void setOccupee(boolean occupee) {
		this.occupee = occupee;
	}

	/**
	 * Méthode qui calcule une estimation du coût minimum d'un case au but
	 * @param but
	 * @return coût minimum d'un case au but
	 */
	public int getHeuristic(Case but){
		double px1 = this.px;
		double py1 = this.py;
		double px2 = but.getPx();
		double py2 = but.getPy();
		double result = Math.sqrt(Math.pow((px2 - px1), 2) + Math.pow((py2 - py1), 2));
		if(result - (int)result != 0) result = (int)result + 1;
		return (int) result;
	}
	
	/**
	 * Méthode qui construit un tableau des enfants pour un case
	 * @param l
	 * @return un tableau des enfants
	 */
	public Case[] children(Labyrinthe l, Monstre m){		
		List<Case> children = new ArrayList<Case>();
		if (px > 0 && !l.estCaseOccupee(px-1, py) && (l.getCase(px-1, py).getClass() != Mur.class || m.peutTraverserMur())) 
			children.add(l.getCase(px-1, py));
		if (px < l.getHauteur() - 1 && !l.estCaseOccupee(px+1, py) && (l.getCase(px+1, py).getClass() != Mur.class || m.peutTraverserMur()))
			children.add(l.getCase(px+1, py));
		if (py > 0 && !l.estCaseOccupee(px, py-1) && (l.getCase(px, py-1).getClass() != Mur.class || m.peutTraverserMur()))
			children.add(l.getCase(px, py-1));
		if (py < l.getLargeur() - 1 && !l.estCaseOccupee(px, py+1) && (l.getCase(px, py+1).getClass() != Mur.class || m.peutTraverserMur()))
			children.add(l.getCase(px, py+1));
		
		return (Case[]) children.toArray(new Case[children.size()]);
	}
}
