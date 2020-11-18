package com.gameric.mazegame.graphiques;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * @author Théo Roton
 * Classe de l'écran du choix de classe
 */
public class EcranClasse extends JPanel {
	
	/**
	 * CardLayout auquel est ajouté ce JPanel
	 */
	private CardLayoutJeu clParent;
	/**
	 * Groupe de bouttons regroupant les JRadioButton
	 */
	private ButtonGroup bgroup;
	/**
	 * JPanel regroupant les JRadioButton
	 */
	private JPanel radioPanel;
	/**
	 * Bouton qui permet de lancer le jeu
	 */
	private JButton lancerJeu;
	
	/**
	 * Constructeur de l'écran du choix de classe
	 * @param c : CardLayout père
	 */
	public EcranClasse(CardLayoutJeu c) {
		//Layout de l'écran
		setLayout(new BorderLayout());
		
		clParent = c;
		
		//Construction des boutons représentant chaque classe
		JRadioButton archer = new JRadioButton("Archer");
		archer.setActionCommand("archer");
		JRadioButton mage = new JRadioButton("Mage");
		mage.setActionCommand("mage");
		JRadioButton epeiste = new JRadioButton("Epeiste");
		epeiste.setActionCommand("epeiste");

		//Construction du groupe de boutons
	    bgroup = new ButtonGroup();
	    //Ajout des boutons
	    bgroup.add(archer);
	    bgroup.add(mage);
	    bgroup.add(epeiste);
	  
	    //JPanel contenant les boutons en colonne
	    radioPanel = new JPanel();
	    radioPanel.setLayout(new GridLayout(3, 1));
	    radioPanel.add(archer);
	    radioPanel.add(mage);
	    radioPanel.add(epeiste);
	    
	    //Ajout d'actions aux boutons de choix
	    archer.addActionListener(new ActionBoutton());
	    mage.addActionListener(new ActionBoutton());
	    epeiste.addActionListener(new ActionBoutton());
	    
	    //Construction du bouton pour lancer le jeu
		lancerJeu = new JButton("Lancer");
		//Ajout de l'action qui permet de lancer le jeu au bouton
		lancerJeu.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				//On appelle la méthode créer jeu du CardLayout parent
				clParent.creerJeu(bgroup.getSelection().getActionCommand()); 
			}
		});
		//De base le bouton pour lancer le jeu est désactivé
		//Pour l'activer il faut au moins sélectionner un bouton dans le groupe de boutons
		lancerJeu.setEnabled(false);
		
		//Ajout du JPanel des boutons
		add(radioPanel, BorderLayout.NORTH);
		//Ajout du bouton pour lancer le jeu
		add(lancerJeu, BorderLayout.SOUTH);
	}
	
	/**
	 * 
	 * @author Théo Roton
	 * Classe Action Button
	 * Cette classe définit l'action faite par les JRadioButton
	 */
	class ActionBoutton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lancerJeu.setEnabled(true);	
		}	
	}

}
