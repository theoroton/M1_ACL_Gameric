package com.gameric.mazegame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gameric.mazegame.model.Arme;
import com.gameric.mazegame.model.CaseEntree;
import com.gameric.mazegame.model.CaseObjet;
import com.gameric.mazegame.model.CasePiegee;
import com.gameric.mazegame.model.CaseSortie;
import com.gameric.mazegame.model.CaseVide;
import com.gameric.mazegame.model.JeuLabyrinthe;
import com.gameric.mazegame.model.Labyrinthe;
import com.gameric.mazegame.model.Personnage;
import com.gameric.mazegame.model.Potion;

/**
 * Classe des tests sur le labyrinthe
 * @author Théo Roton
 *
 */
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
		
		//Test de la taille du labyrinthe (attendue : 12 * 10)
		assertEquals("La largeur du labyrinthe n'est pas celle attendue", 12, labyrinthe.getLargeur());
		assertEquals("La hauteur du labyrinthe n'est pas celle attendue", 10, labyrinthe.getHauteur());
		
		//Test de la position de la case d'entrée (attendue : (0,1))
		assertEquals("La position X de la case entrée n'est pas celle attendue", 0, labyrinthe.getxEntree());
		assertEquals("La position Y de la case entrée n'est pas celle attendue", 1, labyrinthe.getyEntree());
		//Test du type de la case à la position de l'entrée 
		assertEquals("La case à la position de l'entrée n'est pas un objet de type 'CaseEntree'", CaseEntree.class, labyrinthe.getCase(0, 1).getClass());

		//Test de la position de la case de sortie (attendue : (11,6))
		assertEquals("La position X de la case sortie n'est pas celle attendue", 11, labyrinthe.getxSortie());
		assertEquals("La position Y de la case sortie n'est pas celle attendue", 8, labyrinthe.getySortie());
		//Test du type de la case à la position de la sortie
		assertEquals("La case à la position de la sortie n'est pas un objet de type 'CaseSortie'", CaseSortie.class, labyrinthe.getCase(11, 8).getClass());
		
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
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test.txt");	
		
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
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test_monstres.txt");	
		
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
	public void testEstCaseOccupee01() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test.txt");	
		
		//Test si la case du joueur est occupée (attendu : true)
		assertEquals("La case devrait être occupée", true, labyrinthe.estCaseOccupee(0, 5));
		//Test si la case en position (1,6) est occupée (attendu : false)
		assertEquals("La case devrait être libre", false, labyrinthe.estCaseOccupee(1, 6));
	}
	
	
	/**
	 * Test de la méthode estCaseOccupee
	 */
	@Test
	public void testEstCaseOccupee02() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test_monstres.txt");	
		
		//Test si la case du joueur est occupée (attendu : true)
		assertEquals("La case devrait être occupée", true, labyrinthe.estCaseOccupee(0, 5));
		//Test si la case en position (1,6) est occupée (attendu : false)
		assertEquals("La case devrait être libre", false, labyrinthe.estCaseOccupee(1, 6));
		//Test si la case du premier monstre est occupée (attendu : true)
		assertEquals("La case devrait être occupée", true, labyrinthe.estCaseOccupee(7, 5));
	}
	
	
	/**
	 * Test de la création des cases piégées.
	 */
	@Test
	public void testCasesPiegees() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test_cases_effets.txt");
		
		//Test si la case en position (7,3) est une case piégée (attendu : true)
		assertEquals("La case devrait être piégée", CasePiegee.class, labyrinthe.getCase(7, 2).getClass());
		//Test si la case en position (6,10) est une case piégée (attendu : true)
		assertEquals("La case devrait être piégée", CasePiegee.class, labyrinthe.getCase(6, 10).getClass());
		//Test si la case en position (4,4) n'est pas une case piégée (attendu : false)
		assertEquals("La case ne devrait pas être piégée", CaseVide.class, labyrinthe.getCase(4, 4).getClass());		
	}
	
	
	/**
	 * Test de la création des cases objets.
	 */
	@Test
	public void testCasesObjets() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test_cases_effets.txt");
		
		//Test si la case en position (9,5) est une case objet (attendu : true)
		assertEquals("La case devrait être une case objet", CaseObjet.class, labyrinthe.getCase(9, 5).getClass());
		//Test si la case en position (4,9) est une case objet (attendu : true)
		assertEquals("La case devrait être une case objet", CaseObjet.class, labyrinthe.getCase(4, 9).getClass());
		//Test si la case en position (3,6) n'est  pas une case objet (attendu : false)
		assertEquals("La case ne devrait pas être une case objet", CaseVide.class, labyrinthe.getCase(3, 6).getClass());	
	}
	
	/**
	 * Test des objets sur les cases objets.
	 */
	@Test
	public void testObjetsCasesObjets() {
		//Création du personnage
		Personnage personnage = new Personnage();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test_cases_effets.txt");
		
		//Test si la case en position (9,5) possède bien une arme (attendu : true)
		assertEquals("L'objet de cette case devrait être une arme", Arme.class, ((CaseObjet) labyrinthe.getCase(9, 5)).getObjet().getClass());
		//Test si la case en position (4,9) possède bien une potion (attendu : true)
		assertEquals("L'objet de cette case devrait être une potion", Potion.class, ((CaseObjet) labyrinthe.getCase(4, 9)).getObjet().getClass());
	}
	
	/**
	 * Test du passage au niveau suivant du jeu.
	 * On test le passage du jeu du niveau 1 au niveau 2.
	 */
	@Test
	public void testNiveauSuivant01() {
		//Création du jeu
		JeuLabyrinthe jeu = new JeuLabyrinthe();
		
		//Test si le niveau est bien de 1
		assertEquals("Le niveau courant devrait être 1", 1, jeu.getNiveau());
		
		//Placement du personnage devant la sortie
		jeu.getPersonnage().setPosition(14, 13);
		//Déplacement sur la sortie
		jeu.getPersonnage().deplacer(1, 0);
		
		//On regarde si le jeu est fini
		assertTrue("Le jeu ne devrait pas être encore fini", !jeu.isFinished());	
		//Test si le niveau est bien de 2
		assertEquals("Le niveau courant devrait être 2", 2, jeu.getNiveau());
	}
	
	/**
	 * Test du passage au niveau suivant du jeu si on est au dernier niveau.
	 * On test le passage du jeu au niveau 3.
	 */
	@Test
	public void testNiveauSuivant02() {
		//Création du jeu
		JeuLabyrinthe jeu = new JeuLabyrinthe();
		//On met le jeu au niveau 3
		jeu.setNiveau(3);
		
		//Test si le niveau est bien de 3
		assertEquals("Le niveau courant devrait être 3", 3, jeu.getNiveau());
		
		//Placement du personnage devant la sortie
		jeu.getPersonnage().setPosition(1, 13);
		//Déplacement sur la sortie
		jeu.getPersonnage().deplacer(-1, 0);
		
		//On regarde si le jeu est fini
		assertTrue("Le jeu devrait être fini", jeu.isFinished());	
		//Test si le niveau est toujours de 3 car on a fini
		assertEquals("Le niveau courant devrait être 3", 3, jeu.getNiveau());
	}
}
