package com.gameric.mazegame.graphiques;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JButton jouer;
	
	/**
	 * JRadioButton de l'epeiste.
	 */
	private JRadioButton epeiste;
	/**
	 * JRadioButton du mage.
	 */
	private JRadioButton mage;
	/**
	 * JRadioButton de l'archer.
	 */
	private JRadioButton archer;
	
	/**
	 * Images nécessaires pour l'affichage du choix de la classe
	 */
	private ImageIcon imageClasses = new ImageIcon(getClass().getResource("/images/textures/ecrans/classes/classes.png"));
	private ImageIcon imageRetour = new ImageIcon(getClass().getResource("/images/textures/ecrans/classes/retour.png"));
	private ImageIcon imageJouer = new ImageIcon(getClass().getResource("/images/textures/ecrans/classes/jouer.png"));
	private ImageIcon imageEpeiste = new ImageIcon(getClass().getResource("/images/textures/ecrans/classes/epeiste.png"));
	private ImageIcon imageEpeisteS = new ImageIcon(getClass().getResource("/images/textures/ecrans/classes/epeisteS.png"));
	private ImageIcon imageMage = new ImageIcon(getClass().getResource("/images/textures/ecrans/classes/mage.png"));
	private ImageIcon imageMageS = new ImageIcon(getClass().getResource("/images/textures/ecrans/classes/mageS.png"));
	private ImageIcon imageArcher = new ImageIcon(getClass().getResource("/images/textures/ecrans/classes/archer.png"));
	private ImageIcon imageArcherS = new ImageIcon(getClass().getResource("/images/textures/ecrans/classes/archerS.png"));
	
	/**
	 * Constructeur de l'écran du choix de classe
	 * @param c : CardLayout père
	 */
	public EcranClasse(CardLayoutJeu c) {
		clParent = c;	
        setPreferredSize(new java.awt.Dimension(544, 604));
        setLayout(null);

		//Construction des boutons représentant chaque classe
		
		//Epeiste
		epeiste = new JRadioButton();
		epeiste.setActionCommand("epeiste");
		//On cache le bouton
		epeiste.setOpaque(false);
		epeiste.setContentAreaFilled(false);
		epeiste.setBorderPainted(false);
		//On ajoute l'image du bouton
		epeiste.setIcon(imageEpeiste);
		
		//Listener pour changer le curseur quand on survole le bouton
		epeiste.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {
	            epeiste.setCursor(new Cursor(Cursor.HAND_CURSOR));		
			}		
		});
		

		//Mage
		mage = new JRadioButton();
		mage.setActionCommand("mage");	
		//On cache le bouton
		mage.setOpaque(false);
		mage.setContentAreaFilled(false);
		mage.setBorderPainted(false);
		//On ajoute l'image du bouton
		mage.setIcon(imageMage);
		
		//Listener pour changer le curseur quand on survole le bouton
		mage.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {
	            mage.setCursor(new Cursor(Cursor.HAND_CURSOR));		
			}		
		});
		
		
		//Archer
		archer = new JRadioButton();
		archer.setActionCommand("archer");
		archer.setOpaque(false);
		archer.setContentAreaFilled(false);
		archer.setBorderPainted(false);
		//On ajoute l'image du bouton
		archer.setIcon(imageArcher);
		
		//Listener pour changer le curseur quand on survole le bouton
		archer.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {
	            archer.setCursor(new Cursor(Cursor.HAND_CURSOR));		
			}		
		});
	
			
		//Construction du groupe de boutons
	    bgroup = new ButtonGroup();
	    //Ajout des boutons
	    bgroup.add(epeiste);
	    bgroup.add(mage);   
	    bgroup.add(archer);
	
	    
	    //Ajout d'actions aux boutons de choix
	    archer.addActionListener(new ActionBoutton());
	    mage.addActionListener(new ActionBoutton());
	    epeiste.addActionListener(new ActionBoutton());
	    
	    	
		//Création du bouton pour retourner au menu
	    JButton retour = new javax.swing.JButton();   
        //On cache le bouton
        retour.setOpaque(false);
        retour.setContentAreaFilled(false);
        retour.setBorderPainted(false);
        
	    //Action du bouton pour afficher le menu principal
	    retour.addActionListener(new java.awt.event.ActionListener() {
    	   public void actionPerformed(java.awt.event.ActionEvent evt) {
    		   //On affiche le menu principal
               clParent.afficherMenu();
    		   //On déselectionne la classe
    		   bgroup.clearSelection();
    		   //On désactive le bouton jouer
    		   jouer.setEnabled(false);
    		   //On remet les images à 0
    		   epeiste.setIcon(imageEpeiste);
    		   mage.setIcon(imageMage);
    		   archer.setIcon(imageArcher);
	        }
        });
	    
        //Listener pour changer l'image du bouton quand on le survole
        retour.addMouseListener(new MouseListener() {      	
        	public void mouseClicked(MouseEvent e) {}
        	public void mousePressed(MouseEvent e) {}
        	public void mouseReleased(MouseEvent e) {}
        	
        	//Ajoute une image au bouton
        	public void mouseEntered(MouseEvent e) {
                retour.setIcon(imageRetour);	
                retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}

        	//Enlève l'image du bouton
        	public void mouseExited(MouseEvent e) {
        		retour.setIcon(null);      		
        	}
		});
	    
	    
	    //Bouton pour lancer le jeu
	    jouer = new javax.swing.JButton();    
        //On cache le bouton
        jouer.setOpaque(false);
        jouer.setContentAreaFilled(false);
        jouer.setBorderPainted(false);
        
		//Ajout de l'action qui permet de lancer le jeu au bouton
		jouer.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				//On appelle la méthode pour chosir la classe du CardLayout parent
				clParent.choisirClasse(bgroup.getSelection().getActionCommand()); 
		  		//On déselectionne la classe
	    		bgroup.clearSelection();
	    		//On désactive le bouton jouer
	    		jouer.setEnabled(false);
	    		//On remet les images à 0
				epeiste.setIcon(imageEpeiste);
				mage.setIcon(imageMage);
				archer.setIcon(imageArcher);
			}
		});
        
        //Listener pour changer l'image du bouton quand on le survole
        jouer.addMouseListener(new MouseListener() {      	
        	public void mouseClicked(MouseEvent e) {}
        	public void mousePressed(MouseEvent e) {}
        	public void mouseReleased(MouseEvent e) {}
        	
        	//Ajoute une image au bouton
        	public void mouseEntered(MouseEvent e) {
                jouer.setIcon(imageJouer);	
                jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}

        	//Enlève l'image du bouton
        	public void mouseExited(MouseEvent e) {
        		jouer.setIcon(null);      		
        	}
		});
		
		//De base le bouton pour lancer le jeu est désactivé
		//Pour l'activer il faut au moins sélectionner un bouton dans le groupe de boutons
		jouer.setEnabled(false);
	    
	    
        //Placement des éléments
        retour.setBounds(12, 17, 71, 43);
        epeiste.setBounds(67, 381, 123, 159);
        mage.setBounds(201, 381, 132, 159);
        archer.setBounds(340, 381, 134, 159);
        jouer.setBounds(184, 550, 165, 46);
        
        //Ajout des éléments au jpanel
        add(retour);
        add(epeiste);
        add(mage);
        add(archer);
        add(jouer);
	}
	
	
	/**
	 * 
	 * @author Théo Roton
	 * Classe Action Button
	 * Cette classe définit l'action faite par les JRadioButton
	 */
	class ActionBoutton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jouer.setEnabled(true);
			//On remet l'image de tous les personnages à 0
			epeiste.setIcon(imageEpeiste);
			mage.setIcon(imageMage);
			archer.setIcon(imageArcher);
			//On met l'image du personnage selectionne
			switch (bgroup.getSelection().getActionCommand()) {
			//Si on selectionne l'epeiste
			case "epeiste" :
				epeiste.setIcon(imageEpeisteS);
				break;
			//Si on selectionne le mage
			case "mage" :
				mage.setIcon(imageMageS);
				break;
			//Si on selectionne l'archer
			case "archer" :
				archer.setIcon(imageArcherS);
				break;
			}
		}	
	}
	
	
	/**
	 * Méthode paintComponent qui affiche l'image du choix des classes.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(imageClasses.getImage(), 0, 0, this);	
	}

}
