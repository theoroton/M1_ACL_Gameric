package com.gameric.mazegame.ai;

import java.util.*;
import com.gameric.mazegame.model.*;

/**
 * 
 * @author Anna Sushko
 * Algorithme A* de recherche d'un chemin de Monstre à un Personnage
 *
 */

public class AStarTraversator {
	private Case but;
	private Case cheminBut;
	private boolean butTrouve;
	
	/**
	 * Constructeur d'AStarTraversator
	 * @param but
	 */
	public AStarTraversator(Case but){
		this.but = but;
	}
	
	/**
	 * Méthode qui construit un chemin de Monstre à un Personnage
	 * @param l
	 * @param case1
	 */
	public void traverse(Labyrinthe l, Case case1){
		for (int i = 0; i < l.getLargeur(); i++){
			for (int j = 0; j < l.getHauteur(); j++){
				l.getCase(i,j).setParent(null);
			}
		}
    	
    	PriorityQueue<Case> open = new PriorityQueue<Case>(20,(Case current, Case next)-> 
    		(current.getCoutChemin() + current.getHeuristic(but)) - (next.getCoutChemin() + next.getHeuristic(but))
    	);
		ArrayList<Case> closed = new ArrayList<Case>();
		open.offer(case1);
		case1.setCoutChemin(0);
		
		while(!open.isEmpty()){
			case1 = open.poll();
			closed.add(case1);
			if(case1.getHeuristic(but) == 1 && (case1.getPx() == but.getPx() || case1.getPy() == but.getPy())) {
				setButTrouve(true);
		        setCheminBut(case1);
				break;
			}
			
			//Traiter les voisins de la case
			Case[] children = case1.children(l);
			for (int i = 0; i < children.length; i++) {
				Case child = children[i];
				int score = case1.getCoutChemin() + 1 + child.getHeuristic(but);
				int existing = child.getCoutChemin() + child.getHeuristic(but);
				if ((open.contains(child) || closed.contains(child)) && existing < score){
					continue;
				}else{
					open.remove(child);
					closed.remove(child);
					child.setParent(case1);
					child.setCoutChemin(case1.getCoutChemin() + 1);
					open.add(child);
				}
			}
		}
	}

	/**
	 * Méthode qui indique si le but était trouvé
	 * @return true si le but était trouvé, sinon false
	 */
	public boolean estButTrouve() {
		return butTrouve;
	}

	/**
	 * Méthode setter de l'état de recherche de but
	 * @param butTrouve
	 */
	public void setButTrouve(boolean butTrouve) {
		this.butTrouve = butTrouve;
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
