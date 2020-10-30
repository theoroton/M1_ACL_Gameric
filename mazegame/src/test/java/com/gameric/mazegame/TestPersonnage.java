package com.gameric.mazegame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gameric.mazegame.model.Labyrinthe;
import com.gameric.mazegame.model.Personnage;

public class TestPersonnage {
	
	/**
	 * Test du positionnement du personnage dans
	 * un labyrinthe par défaut.
	 */
	@Test
	public void testPositionnementPersonnage() {
		//Création du labyrinthe
		Labyrinthe l = new Labyrinthe(5,5);
		
		//Positionnement par défaut
		Personnage p1 = new Personnage();	
		//Position attendue (1,1)
		assertEquals("La position en X n'est pas celle attendue", 1, p1.getPos_x());
		assertEquals("La position en Y n'est pas celle attendue", 1, p1.getPos_y());	
		
		//Positionnement à un point dans le labyrinthe
		Personnage p2 = new Personnage(3,2);	
		//Position attendue (3,2)
		assertEquals("La position en X n'est pas celle attendue", 3, p2.getPos_x());
		assertEquals("La position en Y n'est pas celle attendue", 2, p2.getPos_y());	
		
		//Positionnement à un point hors du labyrinthe
		Personnage p3 = new Personnage(6,6);	
		//Position attendue (1,1)
		assertEquals("La position en X n'est pas celle attendue", 1, p3.getPos_x());
		assertEquals("La position en Y n'est pas celle attendue", 1, p3.getPos_y());	
	}
	
	/**
	 * Test du déplacement du personnage.
	 * Test où les déplacements sont dans le labyrinthe.
	 */
	@Test
	public void testDeplacementPersonnage1() {
		//Création du labyrinthe
		Labyrinthe l = new Labyrinthe(5,5);
		//Création du personnage
		Personnage p = new Personnage(2,2);
		
		//Déplacement vers le haut
		p.deplacer(0, 1);
		//Position attendue (2,3)
		assertEquals("La position en X n'est pas celle attendue", 2, p.getPos_x());
		assertEquals("La position en Y n'est pas celle attendue", 3, p.getPos_y());
		
		//Déplacement vers le bas
		p.deplacer(0, -1);
		//Position attendue (2,2)
		assertEquals("La position en X n'est pas celle attendue", 2, p.getPos_x());
		assertEquals("La position en Y n'est pas celle attendue", 2, p.getPos_y());
		
		//Déplacement vers la gauche
		p.deplacer(-1, 0);
		//Position attendue (1,2)
		assertEquals("La position en X n'est pas celle attendue", 1, p.getPos_x());
		assertEquals("La position en Y n'est pas celle attendue", 2, p.getPos_y());
		
		//Déplacement vers la droite
		p.deplacer(1, 0);
		//Position attendue (2,2)
		assertEquals("La position en X n'est pas celle attendue", 2, p.getPos_x());
		assertEquals("La position en Y n'est pas celle attendue", 2, p.getPos_y());
	}
	
	/**
	 * Test du déplacement du personnage.
	 * Test où les déplacements sont à la limite du labyrinthe.
	 */
	@Test
	public void testDeplacementPersonnage2() {
		//Création du labyrinthe
		Labyrinthe l = new Labyrinthe(5,5);
		
		
		
		//Création du personnage (coin en bas à gauche)
		Personnage p1 = new Personnage(1,1);
		
		//Déplacement vers le bas
		p1.deplacer(0, -1);
		//Position attendue (1,1)
		assertEquals("La position en X ne devrait pas avoir changer", 1, p1.getPos_x());
		assertEquals("La position en Y ne devrait pas avoir changer", 1, p1.getPos_y());
		
		//Déplacement vers la gauche
		p1.deplacer(-1, 0);
		//Position attendue (1,1)
		assertEquals("La position en X ne devrait pas avoir changer", 1, p1.getPos_x());
		assertEquals("La position en Y ne devrait pas avoir changer", 1, p1.getPos_y());


		
		//Création du personnage (coin en haut à droite)
		Personnage p2 = new Personnage(4,4);
		
		//Déplacement vers le haut
		p2.deplacer(0, 1);
		//Position attendue (4,4)
		assertEquals("La position en X ne devrait pas avoir changer", 4, p2.getPos_x());
		assertEquals("La position en Y ne devrait pas avoir changer", 4, p2.getPos_y());
		
		//Déplacement vers la droite
		p2.deplacer(1, 0);
		//Position attendue (4,4)
		assertEquals("La position en X ne devrait pas avoir changer", 4, p2.getPos_x());
		assertEquals("La position en Y ne devrait pas avoir changer", 4, p2.getPos_y());
	}
}
