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
	 * - la position du personnage
	 */
	@Test
	public void testLabyrintheDefault() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage);	
		
		//Test de la taille du labyrinthe (attendue : 10 * 10)
		assertEquals("La largeur du labyrinthe n'est pas celle attendue", 10, labyrinthe.getLargeur());
		assertEquals("La hauteur du labyrinthe n'est pas celle attendue", 10, labyrinthe.getHauteur());
		
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
		
		//Test de la position du personnage (attendue : (0,1))
		assertEquals("La position X du personnage n'est pas celle attendue", 0, personnage.getPos_x());
		assertEquals("La position Y du personnage n'est pas celle attendue", 1, personnage.getPos_y());
	}
	
	/**
	 * Test de la création d'un labyrinthe par défaut auquel on spécifie sa taille.
	 * On test :
	 * - la taille du labyrinthe
	 * - la position de la case d'entrée
	 * - la position de la case de sortie
	 * - la position du personnage
	 */
	@Test
	public void testLabyrintheDefaultTaille() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(12,8,personnage);	
		
		//Test de la taille du labyrinthe (attendue : 12 * 8)
		assertEquals("La largeur du labyrinthe n'est pas celle attendue", 12, labyrinthe.getLargeur());
		assertEquals("La hauteur du labyrinthe n'est pas celle attendue", 8, labyrinthe.getHauteur());
		
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
		
		//Test de la position du personnage (attendue : (0,1))
		assertEquals("La position X du personnage n'est pas celle attendue", 0, personnage.getPos_x());
		assertEquals("La position Y du personnage n'est pas celle attendue", 1, personnage.getPos_y());
	}
	
	/**
	 * Test de la création d'un labyrinthe en lisant le fichier "test.txt".
	 * On test :
	 * - la taille du labyrinthe
	 * - la position de la case d'entrée
	 * - la position de la case de sortie
	 * - la position du personnage
	 * - le nombre de monstres
	 */
	@Test
	public void testLabyrintheFichierTest() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"test.txt");	
		
		//Test de la taille du labyrinthe (attendue : 12 * 12)
		assertEquals("La largeur du labyrinthe n'est pas celle attendue", 12, labyrinthe.getLargeur());
		assertEquals("La hauteur du labyrinthe n'est pas celle attendue", 12, labyrinthe.getHauteur());
		
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
		
		//Test de la position du personnage (attendue : (0,5))
		assertEquals("La position X du personnage n'est pas celle attendue", 0, personnage.getPos_x());
		assertEquals("La position Y du personnage n'est pas celle attendue", 5, personnage.getPos_y());
		
		//Test du nombre de monstres (attendu : 0)
		assertEquals("Le nombre de monstre n'est pas celui attendu", 0, labyrinthe.getMonstres().size());
	}
	
	/**
	 * Test de la création d'un labyrinthe en lisant le fichier "test_monstres.txt".
	 * On test :
	 * - la taille du labyrinthe
	 * - la position de la case d'entrée
	 * - la position de la case de sortie
	 * - la position du personnage
	 * - le nombre de monstres et leurs positions
	 */
	@Test
	public void testLabyrintheFichierTestMonstre() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"test_monstres.txt");	
		
		//Test de la taille du labyrinthe (attendue : 12 * 12)
		assertEquals("La largeur du labyrinthe n'est pas celle attendue", 12, labyrinthe.getLargeur());
		assertEquals("La hauteur du labyrinthe n'est pas celle attendue", 12, labyrinthe.getHauteur());
		
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
		
		//Test de la position du personnage (attendue : (0,5))
		assertEquals("La position X du personnage n'est pas celle attendue", 0, personnage.getPos_x());
		assertEquals("La position Y du personnage n'est pas celle attendue", 5, personnage.getPos_y());
		
		//Test du nombre de monstres (attendu : 2)
		assertEquals("Le nombre de monstre n'est pas celui attendu", 2, labyrinthe.getMonstres().size());
		//Test de la position du premier monstre (attendue : (7,5))
		assertEquals("La position X du premier monstre n'est pas celle attendue", 7, labyrinthe.getMonstres().get(0).getPos_x());
		assertEquals("La position Y du premier monstre n'est pas celle attendue", 5, labyrinthe.getMonstres().get(0).getPos_y());
		//Test de la position du deuxième monstre (attendue : (7,10))
		assertEquals("La position X du premier monstre n'est pas celle attendue", 7, labyrinthe.getMonstres().get(1).getPos_x());
		assertEquals("La position Y du premier monstre n'est pas celle attendue", 10, labyrinthe.getMonstres().get(1).getPos_y());
	}
	
	/**
	 * Test de la méthode estCaseOccupee
	 */
	@Test
	public void testEstCaseOccupee() {
		//Création du personnage
		Personnage personnage1 = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe1 = new Labyrinthe(personnage1,"test.txt");	
		
		//Test si la case du joueur est occupée (attendu : true)
		assertEquals("La case devrait être occupée", true, labyrinthe1.estCaseOccupee(0, 5));
		//Test si la case en position (1,6) est occupée (attendu : false)
		assertEquals("La case devrait être libre", false, labyrinthe1.estCaseOccupee(1, 6));
		
		//Création du personnage
		Personnage personnage2 = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe2 = new Labyrinthe(personnage2,"test_monstres.txt");	
		
		//Test si la case du joueur est occupée (attendu : true)
		assertEquals("La case devrait être occupée", true, labyrinthe2.estCaseOccupee(0, 5));
		//Test si la case en position (1,6) est occupée (attendu : false)
		assertEquals("La case devrait être libre", false, labyrinthe2.estCaseOccupee(1, 6));
		//Test si la case du premier monstre est occupée (attendu : true)
		assertEquals("La case devrait être occupée", true, labyrinthe2.estCaseOccupee(7, 5));
	}
}
