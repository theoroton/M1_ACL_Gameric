package com.gameric.mazegame.graphiques;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.gameric.mazegame.model.ControleurLabyrinthe;
import com.gameric.mazegame.model.Etat;
import com.gameric.mazegame.model.JeuLabyrinthe;

/**
 * 
 * @author Théo Roton
 * Classe CardLayoutJeu
 */
public class CardLayoutJeu extends JPanel {

	/**
	 * Ecran du menu principal
	 */
	private EcranMenu menu;
	/**
	 * Ecran des règles du jeu
	 */
	private EcranRegle regle;
	/**
	 * Ecran du choix de classe
	 */
	private EcranClasse choixClasse;
	/**
	 * Ecran du jeu
	 */
	private EcranJeu ecranJeu;
	/**
	 * Ecran de fin du jeu
	 */
	private EcranFin ecranFin;
	
	/**
	 * Layout qui permettra d'ajouter les écrans
	 */
	private CardLayout cl = new CardLayout();
	
	/**
	 * Jeu à afficher
	 */
	private JeuLabyrinthe jeu;
	/**
	 * Controleur à ajouter
	 */
	private ControleurLabyrinthe controleur;
	
	/**
	 * Constructeur du CardLayout
	 * @param j : jeu à afficher 
	 * @param c : controleur à ajouter
	 */
	public CardLayoutJeu(JeuLabyrinthe j, ControleurLabyrinthe c) {
		jeu = j;
		controleur = c;
		
		//Ajout du layout
		setLayout(cl);
		
		//Création de l'écran du choix de classe
		choixClasse = new EcranClasse(this);

		//Ajout du controleur
		addKeyListener(controleur);
		//Ajout de l'écran du choix de classe au layout
		add(choixClasse, "choixClasse");
		
	}
	
	/**
	 * Méthode qui permet de mettre à jour l'affichage
	 */
	public void update() {
		ecranJeu.update();
	}

	/**
	 * Méthode getter du CardLayout
	 * @return le CardLayout
	 */
	public CardLayout getCl() {
		return cl;
	}

	/**
	 * Méthode qui permet de créer l'écran de jeu et de lancer le jeu
	 * @param classe : classe choisis par le joueur sur l'écran de
	 * sélection des classes.
	 */
	public void creerJeu(String classe) {
		//On indique la classe choisis au jeu
		jeu.choixClasse(classe);
		//Lancement le jeu
		jeu.lancerJeu();
		
		//On crée l'écran du jeu
		ecranJeu = new EcranJeu(jeu);
		//On ajoute l'écran du jeu
		add(ecranJeu, "ecranJeu");
		//On affiche l'écran du jeu
		cl.show(this, "ecranJeu");
		//On indique que le jeu est en cours
		jeu.setEtat(Etat.EnCours);
	}
	
	/**
	 * Méthode qui permet d'afficher la fin du jeu
	 */
	public void afficherFin() {
		//On crée l'écran de fin
		ecranFin = new EcranFin(this, jeu);
		//On ajoute l'écrand de fin
		add(ecranFin, "ecranFin");
		//On affiche l'écran de fin
		cl.show(this, "ecranFin");
	}
	
	/**
	 * Méthode qui permet de relancer le jeu quand on appuie sur recommencer sur l'écran de fin
	 */
	public void recommencerJeu() {
		//Remet à zéro le jeu
		jeu.reset();
		//Affiche l'écran du jeu
		cl.show(this, "ecranJeu");
		//Met l'état du jeu en cours
		jeu.setEtat(Etat.EnCours);
	}
	
	
	
}
