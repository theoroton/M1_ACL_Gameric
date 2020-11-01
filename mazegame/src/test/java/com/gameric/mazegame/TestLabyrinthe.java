package com.gameric.mazegame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gameric.mazegame.model.CaseEntree;
import com.gameric.mazegame.model.CaseSortie;
import com.gameric.mazegame.model.Labyrinthe;
import com.gameric.mazegame.model.Personnage;

public class TestLabyrinthe {

	/**
	 * Test de la création d'un labyrinthe par défaut.
	 * On test :
	 * - la taille du labyrinthe
	 * - la position de la case d'entrée
	 * - la position de la case de sortie
	 */
	@Test
	public void testLabyrintheDefault() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage);	
		
		//Test de la taille du labyrinthe (attendue : 10 * 10)
		assertEquals("La largeur du labyrinthe n'est pas celle attendue", 10, Labyrinthe.getLargeur());
		assertEquals("La hauteur du labyrinthe n'est pas celle attendue", 10, Labyrinthe.getHauteur());
		
		//Test de la position de la case d'entrée (attendue : (0,1))
		assertEquals("La position X de la case entrée n'est pas celle attendue", 0, labyrinthe.getxEntree());
		assertEquals("La position Y de la case entrée n'est pas celle attendue", 1, labyrinthe.getyEntree());
		//Test du type de la case à la position de l'entrée
		assertEquals("La case à la position de l'entrée n'est pas un objet de type 'CaseEntree'", CaseEntree.class, labyrinthe.getCase(0, 1).getClass());

		//Test de la position de la case de sortie (attendue : (9,8))
		assertEquals("La position X de la case sortie n'est pas celle attendue", 9, labyrinthe.getxSortie());
		assertEquals("La position Y de la case sortie n'est pas celle attendue", 8, labyrinthe.getySortie());
		//Test du type de la case à la position de la sortie
		assertEquals("La case à la position de la sortie n'est pas un objet de type 'CaseSortie'", CaseSortie.class, labyrinthe.getCase(9, 8).getClass());
	}
	
	/**
	 * Test de la création d'un labyrinthe par défaut auquel on spécifie sa taille.
	 * On test :
	 * - la taille du labyrinthe
	 * - la position de la case d'entrée
	 * - la position de la case de sortie
	 */
	@Test
	public void testLabyrintheDefaultTaille() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(12,8,personnage);	
		
		//Test de la taille du labyrinthe (attendue : 12 * 8)
		assertEquals("La largeur du labyrinthe n'est pas celle attendue", 12, Labyrinthe.getLargeur());
		assertEquals("La hauteur du labyrinthe n'est pas celle attendue", 8, Labyrinthe.getHauteur());
		
		//Test de la position de la case d'entrée (attendue : (0,1))
		assertEquals("La position X de la case entrée n'est pas celle attendue", 0, labyrinthe.getxEntree());
		assertEquals("La position Y de la case entrée n'est pas celle attendue", 1, labyrinthe.getyEntree());
		//Test du type de la case à la position de l'entrée 
		assertEquals("La case à la position de l'entrée n'est pas un objet de type 'CaseEntree'", CaseEntree.class, labyrinthe.getCase(0, 1).getClass());

		//Test de la position de la case de sortie (attendue : (11,6))
		assertEquals("La position X de la case sortie n'est pas celle attendue", 11, labyrinthe.getxSortie());
		assertEquals("La position Y de la case sortie n'est pas celle attendue", 6, labyrinthe.getySortie());
		//Test du type de la case à la position de la sortie
		assertEquals("La case à la position de la sortie n'est pas un objet de type 'CaseSortie'", CaseSortie.class, labyrinthe.getCase(11, 6).getClass());
	}
	
	/**
	 * Test de la création d'un labyrinthe en lisant le fichier "test.txt".
	 * On test :
	 * - la taille du labyrinthe
	 * - la position de la case d'entrée
	 * - la position de la case de sortie
	 */
	@Test
	public void testLabyrintheFichierTest() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"test.txt");	
		
		//Test de la taille du labyrinthe (attendue : 12 * 12)
		assertEquals("La largeur du labyrinthe n'est pas celle attendue", 12, Labyrinthe.getLargeur());
		assertEquals("La hauteur du labyrinthe n'est pas celle attendue", 12, Labyrinthe.getHauteur());
		
		//Test de la position de la case d'entrée (attendue : (0,6))
		assertEquals("La position X de la case entrée n'est pas celle attendue", 0, labyrinthe.getxEntree());
		assertEquals("La position Y de la case entrée n'est pas celle attendue", 5, labyrinthe.getyEntree());
		//Test du type de la case à la position de l'entrée 
		assertEquals("La case à la position de l'entrée n'est pas un objet de type 'CaseEntree'", CaseEntree.class, labyrinthe.getCase(0, 5).getClass());

		//Test de la position de la case de sortie (attendue : (11,2))
		assertEquals("La position X de la case sortie n'est pas celle attendue", 11, labyrinthe.getxSortie());
		assertEquals("La position Y de la case sortie n'est pas celle attendue", 2, labyrinthe.getySortie());
		//Test du type de la case à la position de la sortie
		assertEquals("La case à la position de la sortie n'est pas un objet de type 'CaseSortie'", CaseSortie.class, labyrinthe.getCase(11, 2).getClass());
	}
}
