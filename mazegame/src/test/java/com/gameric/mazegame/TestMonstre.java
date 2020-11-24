package com.gameric.mazegame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gameric.mazegame.model.labyrinthe.Labyrinthe;
import com.gameric.mazegame.model.labyrinthe.Mur;
import com.gameric.mazegame.model.monstres.Fantome;
import com.gameric.mazegame.model.monstres.Monstre;
import com.gameric.mazegame.model.monstres.Squelette;
import com.gameric.mazegame.model.monstres.Zombie;
import com.gameric.mazegame.model.personnage.Epeiste;
import com.gameric.mazegame.model.personnage.Personnage;

/**
 * Classe des tests sur le Monstre
 * @author Anna Sushko
 *
 */

public class TestMonstre {
	/**
	 * Test de la comportement du Fantome dans le jeu
	 * On test :
	 * - la nombre des points de vie du monstre avant et apres l'attaque du personnage
	 * - la nombre des points de vie du personnage avant et apres l'attaque du monstre
	 * - si le personnage est ou pas dans le champ du vision du monstre
	 * - si le personnage peut aller sur les cases du class Mur
	 * - si le personnage peut ou pas attaque le personnage à un certaine distance
	 */
	@Test
	public void testMonstreFantome() {
		
		//Création du personnage
		Personnage personnage = new Epeiste();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test.txt");
		personnage.setPosition(3, 5);
		//Création du monstre fantome
		Monstre monstre = new Fantome(10, 5, labyrinthe);
		//Debut du jeu pour le Fantome
		assertEquals("Le monstre ne devrait pas encore avoir perdu de points de vie", 20, monstre.getPointsVie());
		//Personnage n'est pas dans le champ de vision du monstre
		assertEquals("Le monstre ne voit pas le personnage", false, monstre.verifPersEnZone());
		monstre.setPosition(6, 5);
		//Personnage est dans le champ de vision du monstre
		assertEquals("Le monstre voit le personnage", true, monstre.verifPersEnZone());
		//Monstre a le droit d'aller sur les cases Mur
		assertEquals("Le monstre peut aller sur les cases du class Mur", true, monstre.peutTraverserMur());
		monstre.deplacerMonstre();
		//Monstre peut être sur la case Mur
		assertEquals("Le monstre s'est deplacé sur la case du class Mur", true, labyrinthe.getCase(monstre.getPos_x(),monstre.getPos_y()).getClass() == Mur.class);
		//Monstre peut pas attaquer le personnage a la distance > de la portee
		assertEquals("Le monstre peut pas faire le degats a personnage", 30, personnage.getPointsVie());
		monstre.setPosition(4, 5);
		monstre.deplacerMonstre();
		//Fantom a la portee 1 donc peut attaquer de la position (4, 5)
		assertEquals("Le monstre devrait faire le degats de 2 a personnage ", 28, personnage.getPointsVie());
		//personnage.attaquer();
		//assertEquals("Le monstre devrait avoir perdu 10 points de vie", 10, monstre.getPointsVie());
		
	}
	
	/**
	 * Test de la comportement du Zombie dans le jeu
	 * On test :
	 * - la nombre des points de vie du monstre avant et apres l'attaque du personnage
	 * - la nombre des points de vie du personnage avant et apres l'attaque du monstre
	 * - si le personnage est ou pas dans le champ du vision du monstre
	 * - si le personnage peut aller sur les cases du class Mur
	 * - si le personnage peut ou pas attaque le personnage à un certaine distance
	 */
	@Test
	public void testMonstreZombie() {
		
		//Création du personnage
		Personnage personnage = new Epeiste();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test.txt");
		personnage.setPosition(0, 5);
		//Création du monstre zombie
		Monstre monstre = new Zombie(4, 5, labyrinthe);
		//Debut du jeu pour le Zombie
		assertEquals("Le monstre ne devrait pas encore avoir perdu de points de vie", 30, monstre.getPointsVie());
		//Monstre n'a pas le droit d'aller sur les cases Mur
		assertEquals("Le monstre ne peut pas aller sur les cases du class Mur", false, monstre.peutTraverserMur());
		//Personnage n'est pas dans le champ de vision du monstre
		assertEquals("Le monstre ne voit pas le personnage", false, monstre.verifPersEnZone());
		monstre.deplacerMonstre();
		//Monstre peut pas attaquer le personnage a la distance > de la portee
		assertEquals("Le monstre peut pas faire le degats a personnage", 30, personnage.getPointsVie());
		monstre.setPosition(1, 5);
		//Personnage est dans le champ de vision du monstre
		assertEquals("Le monstre voit le personnage", true, monstre.verifPersEnZone());
		monstre.deplacerMonstre();
		//Zombie a la portee 1 donc peut attaquer de la position (1, 5)
		assertEquals("Le monstre devrait faire le degats de 5 a personnage", 25, personnage.getPointsVie());
		//personnage.attaquer();
		//assertEquals("Le monstre devrait avoir perdu 10 points de vie", 20, monstre.getPointsVie());
		
	}
	
	/**
	 * Test de la comportement du Squelette dans le jeu
	 * On test :
	 * - la nombre des points de vie du monstre avant et apres l'attaque du personnage
	 * - la nombre des points de vie du personnage avant et apres l'attaque du monstre
	 * - si le personnage est ou pas dans le champ du vision du monstre
	 * - si le personnage peut aller sur les cases du class Mur
	 * - si le personnage peut ou pas attaque le personnage à un certaine distance
	 */
	@Test
	public void testMonstreSquelette() {
		
		//Création du personnage
		Personnage personnage = new Epeiste();
		//Création du labyrinthe
		Labyrinthe labyrinthe = new Labyrinthe(personnage,"tests/test.txt");
		personnage.setPosition(0, 5);
		//Création du monstre squelette
		Monstre monstre = new Squelette(3, 2, labyrinthe);
		//Debut du jeu pour le Squelette
		assertEquals("Le monstre ne devrait pas encore avoir perdu de points de vie", 10, monstre.getPointsVie());
		//Monstre n'a pas le droit d'aller sur les cases Mur
		assertEquals("Le monstre ne peut pas aller sur les cases du class Mur", false, monstre.peutTraverserMur());
		//Personnage n'est pas dans le champ de vision du monstre
		assertEquals("Le monstre ne voit pas le personnage", false, monstre.verifPersEnZone());
		monstre.setPosition(3, 3);
		//Personnage est dans le champ de vision du monstre
		assertEquals("Le monstre voit le personnage", true, monstre.verifPersEnZone());
		monstre.deplacerMonstre();
		//Monstre ne peut pas attaquer le personnage a la distance > de la portee
		assertEquals("Le monstre ne peut pas faire le degats a personnage", 30, personnage.getPointsVie());
		monstre.deplacerMonstre();
		//squelette a la portee 3 donc peut attaquer
		assertEquals("Le monstre devrait faire le degats de 4 a personnage", 26, personnage.getPointsVie());
		//personnage.attaquer();
		//assertEquals("Le monstre devrait avoir perdu 10 points de vie", 0, monstre.getPointsVie());
		
		
	}
}
