package com.gameric.mazegame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gameric.mazegame.model.JeuLabyrinthe;
import com.gameric.mazegame.model.labyrinthe.CaseApparition;
import com.gameric.mazegame.model.labyrinthe.Labyrinthe;
import com.gameric.mazegame.model.personnage.Archer;
import com.gameric.mazegame.model.personnage.Epeiste;
import com.gameric.mazegame.model.personnage.Personnage;

/**
 * Classe des tests sur le personnage
 * @author Théo Roton
 *
 */
public class TestPersonnage {

	/**
	 * Test du passage sur une case piégée.
	 * On teste les points de vie du personnage avant 
	 * et après le passage.
	 */
	@Test
	public void testCasePiegee01() {
		//Création du personnage
		Personnage personnage = new Epeiste();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test_cases_effets.txt");
		//Positionnement du personnage à côté d'une case piégée
		personnage.setPosition(6, 2);
		
		//On teste si le personnage a 30 points de vie au début
		assertEquals("Le personnage ne devrait pas encore avoir perdu de points de vie", 30, personnage.getPointsVie());
		
		//Déplacement du personnage sur la case piégée
		personnage.deplacer(1, 0);
		
		//On teste si le personnage a subi des dégâts et a 26 points de vie
		assertEquals("Le personnage devrait avoir perdu 4 points de vie", 26, personnage.getPointsVie());
	}
	
	
	/**
	 * Test du passage 2 fois sur la même case piégée.
	 * On teste les points de vie du personnage avant, au milieu et
	 * après les 2 passages.
	 */
	@Test
	public void testCasePiegee02() {
		//Création du personnage
		Personnage personnage = new Epeiste();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test_cases_effets.txt");
		//Positionnement du personnage à côté d'une case piégée
		personnage.setPosition(6, 2);
		
		//On teste si le personnage a 30 points de vie au début
		assertEquals("Le personnage ne devrait pas encore avoir perdu de points de vie", 30, personnage.getPointsVie());
		
		//Déplacement du personnage sur la case piégée
		personnage.deplacer(1, 0);
		//Déplacement du personnage sur la case à droite
		personnage.deplacer(1, 0);
		
		//On teste si le personnage a subi des dégâts et a 26 points de vie
		assertEquals("Le personnage devrait avoir perdu 4 points de vie", 26, personnage.getPointsVie());
		
		//Déplacement du personnage sur la case piégée
		personnage.deplacer(-1, 0);
		//Déplacement du personnage sur la case à gauche
		personnage.deplacer(-1, 0);
		
		//On teste si le personnage a subi des dégâts et a 22 points de vie
		assertEquals("Le personnage devrait avoir encore perdu 4 points de vie", 22, personnage.getPointsVie());
	}
	
	
	/**
	 * Test du passage sur la case piégée.
	 * On teste si le personnage meurt en passant sur la case
	 * piégée s'il lui reste moins de points de vie que les
	 * dégâts du piège.
	 */
	@Test
	public void testCasePiegee03() {
		//Création du personnage
		Personnage personnage = new Epeiste();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test_cases_effets.txt");
		//Positionnement du personnage à côté d'une case piégée
		personnage.setPosition(6, 2);
		//On met les points de vie du personnage à 2
		personnage.setPointsVie(2);
		
		//On teste si le personnage a bien 2 points de vie
		assertEquals("Le personnage devrait avoir 2 points de vie", 2, personnage.getPointsVie());
		//On teste si le personnage est vivant
		assertEquals("Le personnage ne devrait pas être mort", false, personnage.estMort());
		
		//Déplacement du personnage sur la case piégée
		personnage.deplacer(1, 0);
		
		//On teste si le personnage a subi des dégâts et n'a plus de points de vie
		assertEquals("Le personnage devrait ne plus avoir de points de vie", 0, personnage.getPointsVie());
		//On teste si le personnage est mort
		assertEquals("Le personnage devrait être mort", true, personnage.estMort());
	}
	
	
	/**
	 * Test du choix de la classe pour une classe existante
	 */
	@Test
	public void testChoixClasse01() {
		//Création du jeu
		JeuLabyrinthe jeu = new JeuLabyrinthe();
		//Choix de la classe
		jeu.choixClasse("archer");
		//Lancement du jeu
		jeu.lancerJeu();
		
		//La classe du joueur devrait être : Archer
		assertEquals("La classe du joueur devrait être un archer", Archer.class, jeu.getPersonnage().getClass());
	}
	
	
	/**
	 * Test du choix de la classe pour une classe inexistante
	 */
	@Test
	public void testChoixClasse02() {
		//Création du jeu
		JeuLabyrinthe jeu = new JeuLabyrinthe();
		//Choix de la classe
		jeu.choixClasse("barbare");
		//Lancement du jeu
		jeu.lancerJeu();
		
		//La classe du joueur devrait être la classe par défaut : Epeiste
		assertEquals("La classe du joueur devrait être un épeiste", Epeiste.class, jeu.getPersonnage().getClass());
	}
	
	
	/**
	 * Test du passage sur la case téléportation.
	 * On teste si le personnage ne se situe pas sur la case
	 * de téléportation après être passé sur la case de téléportation
	 */
	@Test
	public void testCaseTeleportation() {
		//Création du personnage
		Personnage personnage = new Epeiste();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test_cases_effets.txt");
		//Positionnement du personnage à côté d'une case téléportation
		personnage.setPosition(3, 3);
		
		//Test de la position du personnage (attendue : (3,3))
		assertEquals("La position X du personnage n'est pas celle attendue", 3, personnage.getPos_x());
		assertEquals("La position Y du personnage n'est pas celle attendue", 3, personnage.getPos_y());
		
		//Déplacement du personnage sur la case piégée
		personnage.deplacer(1, 0);
		
		//Test de la position du personnage (différente de : (4,3))
		assertTrue("La position ne devrait pas être celle de la case de téléportation", (personnage.getPos_x() != 4) && (personnage.getPos_y() != 3));
	}
	
	
	/**
	 * Test du passage sur la case apparition.
	 * On teste si il y a un monstre de plus dans le labyrinthe
	 * après que le joueur passe sur la case apparition et si
	 * la case n'est plus active après le passage.
	 */
	@Test
	public void testCaseApparition() {
		//Création du personnage
		Personnage personnage = new Epeiste();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test_cases_effets.txt");
		//Positionnement du personnage à côté d'une case apparition
		personnage.setPosition(6, 7);
		
		//Test si la case n'a pas encore était déclenchée
		assertTrue("La case devrait être active", !((CaseApparition) labyrinthe.getCase(7, 7)).isDeclenche());
		//Test du nombre de monstre avant le passage (attendu : 0)
		assertEquals("Le nombre de monstre n'est pas celui attendu", 0, labyrinthe.getMonstres().size());
		
		//Déplacement du personnage sur la case piégée
		personnage.deplacer(1, 0);
		
		//Test si la case a était déclenchée
		assertTrue("La case ne devrait plus être active", ((CaseApparition) labyrinthe.getCase(7, 7)).isDeclenche());
		//Test du nombre de monstre après le passage (attendu : 1)
		assertEquals("Le nombre de monstre n'est pas celui attendu", 1, labyrinthe.getMonstres().size());
	}
}
