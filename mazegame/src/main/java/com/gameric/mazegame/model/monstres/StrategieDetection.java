package com.gameric.mazegame.model.monstres;

import java.util.Collections;
import java.util.LinkedList;

import com.gameric.mazegame.model.labyrinthe.Case;
import com.gameric.mazegame.model.labyrinthe.Labyrinthe;
import com.gameric.mazegame.model.labyrinthe.Mur;
import com.gameric.mazegame.model.personnage.Personnage;
/**
 * 
 * @author Anna Sushko
 * Stratégie de deplacement lors de la détection de Joueur
 *
 */

public class StrategieDetection implements StrategieDeplacement {
	private int persDernX;
	private int persDernY;
	private AStarTraversator traverse;
	private LinkedList<Case> caseListChemin;
	private Labyrinthe l;
	private Case cheminBut;
	private Personnage p;
	private Monstre m;
	
	/**
	 * Méthode qui gère le deplacement intelligent d'un monstre
	 */
	@Override
	public void deplacer(Monstre monstre) {
		m = monstre;
		l = monstre.getLabyrinthe();
		p = l.getPersonnage_laby();
		
		String[] choix = {"UP", "RIGHT", "DOWN", "LEFT"};
		if(getpersDernX() != p.getPos_x() || getpersDernY() != p.getPos_y()) {
			setCaseListChemin(new LinkedList<Case>());
			setpersDernX(p.getPos_x());
			setpersDernY(p.getPos_y());
			setTraverse(new AStarTraversator(l.getCase(p.getPos_x(),p.getPos_y())));
			getTraverse().traverse(l, m, l.getCase(m.getPos_x(),m.getPos_y()));
			// Si l'algorithme de recherche a trouvé le joueur, alors ajout de chemin à linked list
			if(getTraverse().estButTrouve()) {
				setCheminBut(getTraverse().getCheminBut());
				while (getCheminBut() != null){
					getCaseListChemin().add(getCheminBut());
					setCheminBut(getCheminBut().getParent());
				}
				//Révérer la collection de chemins à l'emplacement du joueur et supprimer la case du Monstre de la liste
				Collections.reverse(getCaseListChemin());
				getCaseListChemin().removeFirst();
			}
		}
		
		// Si le chemin a été trouvé, alors le deplacement du Monstre vers le joueur
		if(getTraverse().estButTrouve()) {
			Case nextChemin = getCaseListChemin().poll();
			boolean trouveNextChemin = false;
			/*
			 * Continuer la boucle, jusqu'a ce que le bon chemin sera trouver
			 * Si le bon chemin est trouvé, alors break de l'iteration courant
			 */
			while (nextChemin != null && !trouveNextChemin && m.getPosition().getHeuristic(p.getPosition()) > m.getPortee()){
				//le monstre se déplace de 1 vers la gauche (-1,0)
				if(nextChemin.getPx() == (m.getPos_x() - 1)){
					if (estBonDeplacement(m.getPos_x() - 1, m.getPos_y())){
						action(m.getPos_x() - 1, m.getPos_y());
						trouveNextChemin = true;
						break;
					}
				}
				//le monstre se déplace de 1 vers la droite (1,0)
				if(nextChemin.getPx() == (m.getPos_x() + 1)){
					if (estBonDeplacement(m.getPos_x() + 1, m.getPos_y())){
						action(m.getPos_x() + 1, m.getPos_y());
						trouveNextChemin = true;
						break;
					}
				}
				//le monstre se déplace de 1 vers le haut (0,1)
				if(nextChemin.getPy() == (m.getPos_y() - 1)){
					if (estBonDeplacement(m.getPos_x(), m.getPos_y() - 1)){
						action(m.getPos_x(), m.getPos_y() - 1);
						trouveNextChemin = true;
						break;
					}
				}
				//le monstre se déplace de 1 vers le bas (0,-1)
				if(nextChemin.getPy() == (m.getPos_y() + 1)){
					if (estBonDeplacement(m.getPos_x(), m.getPos_y() + 1)){
						action(m.getPos_x(), m.getPos_y() + 1);
						trouveNextChemin = true;
						break;
					}
				}
				//Il y a la possibilité que le monstre sera coincé en labyrinthe, donc verification de ce cas
				if(!trouveNextChemin){
					checkMove(choix[(int)(4 * Math.random())]);
				}
				//Si le jeu est déjà fini, alors le mouvement s'arrete et break de la boucle
				if(m.getPointsVie() <= 0 || p.estMort()){
					break;
				}
			}
		}
		if(m.getPosition().getHeuristic(p.getPosition()) <= m.getPortee()) {
			m.setPeutDonnerDegats(true);
			m.donnerDegats();
		} else {
			m.setPeutDonnerDegats(false);
		}
	}
	
	/**
	 * Méthode qui verifie si le Monstre peut deplacer à la case prochaine
	 * @param x
	 * @param y
	 * @return true si le Monstre peut deplacer à la case prochaine, sinon false
	 */
	private boolean estBonDeplacement(int x, int y){
		boolean res = false;

		if(!p.estMort() && verifierBordures(x, y, m.getLabyrinthe()) && (m.getLabyrinthe().getCase(x,y).getClass() != Mur.class || m.peutTraverserMur())) {
			res = true;
		}
		return res;
	}
	/**
	 * Méthode qui verifie si la case current n'est pas sur le bord du labyrinthe
	 * @param x
	 * @param y
	 * @param l
	 * @return true si la case current n'est pas sur le bord du labyrinthe, sinon false
	 */
	public boolean verifierBordures(int x, int y, Labyrinthe l) {
		boolean res = false;
		if ((x >= 0) && (x <= l.getLargeur()-1) && (y >= 0) && (y <= l.getHauteur()-1)){
			res = true;
		}
		return res;
	}
	/**
	 * Méthode qui gère le déplacement et la collision du Monstre avec Personnage
	 * @param x
	 * @param y
	 */
	public void action(int x, int y) {
		if(!(m.getLabyrinthe().estCaseOccupee(x, y))) {
			m.setPosition(x, y);
		}
	}
	/**
	 * Méthode qui deplace le monstre vers la direction specifique
	 * @param direction
	 */
	private void checkMove(String direction){
		if(m.getPointsVie() <= 0) return;
		int x = m.getPos_x();
		int y = m.getPos_y();
		// Moving the enemy object to a new position in the maze
		m.setDirection(direction);
		switch(direction){
			//Commande UP
			case "UP":
				//le monstre se déplace de 1 vers le haut (0,1)
				y--;
				break;
			//Commande DOWN
			case "DOWN":
				//le monstre se déplace de 1 vers le bas (0,-1)
				y++;
				break;
			//Commande LEFT
			case "LEFT":
				//le monstre se déplace de 1 vers la gauche (-1,0)
				x--;
				break;
			//Commande RIGHT
			case "RIGHT":
				//le monstre se déplace de 1 vers la droite (1,0)
				x++;
				break;
		}
		
		if(estBonDeplacement(x,y)){
			action(x,y);
		}
	}
	
	/**
	 * Méthode getter de dernier X position de joueur
	 * @return
	 */
	public int getpersDernX() {
		return persDernX;
	}
	/**
	 * Méthode setter de dernier X position de joueur
	 * @param persDernX
	 * @return dernier X position de joueur
	 */
	public int setpersDernX(int persDernX) {
		return this.persDernX = persDernX;
	}
	/**
	 * Méthode getter de dernier Y position de joueur
	 * @return
	 */
	public int getpersDernY() {
		return persDernY;
	}
	/**
	 * Méthode setter de dernier X position de joueur
	 * @param persDernY
	 * @return dernier Y position de joueur
	 */
	public int setpersDernY(int persDernY) {
		return this.persDernY = persDernY;
	}
	/**
	 * Méthode getter de la linked list des cases du chemin
	 * @return linked list des cases du chemin
	 */
	public LinkedList<Case> getCaseListChemin() {
		return caseListChemin;
	}
	/**
	 * Méthode setter de la linked list de chemin
	 * @param caseListChemin
	 */
	public void setCaseListChemin(LinkedList<Case> caseListChemin) {
		this.caseListChemin = caseListChemin;
	}
	/**
	 * Méthode getter du chemin construit par A* algorithm
	 * @return chemin construit par A* algorithm
	 */
	public AStarTraversator getTraverse() {
		return traverse;
	}
	/**
	 * Méthode setter du chemin construit par A* algorithm
	 * @param traverse
	 */
	public void setTraverse(AStarTraversator traverse) {
		this.traverse = traverse;
	}
	/**
	 * Méthode getter de la case du chemin vers le but
	 * @return la case du chemin vers le but
	 */
	public Case getCheminBut() {
		return cheminBut;
	}
	/**
	 * Méthode setter de la case au chemin vers le but
	 * @param cheminBut
	 */
	public void setCheminBut(Case cheminBut) {
		this.cheminBut = cheminBut;
	}
}
