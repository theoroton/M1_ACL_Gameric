package com.gameric.mazegame.graphiques;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	 * Constructeur de l'écran du choix de classe
	 * @param c : CardLayout père
	 */
	public EcranClasse(CardLayoutJeu c) {
		clParent = c;	
        setPreferredSize(new java.awt.Dimension(544, 604));
		
        
		//Construction label du choix de classe
		JLabel labelClasse = new javax.swing.JLabel();
        labelClasse.setFont(new java.awt.Font("Gabriola", 1, 28));
        labelClasse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClasse.setText("Choisissez une classe");

		
		//Construction des boutons représentant chaque classe
		//Archer
		JRadioButton archer = new JRadioButton("Archer");
        archer.setFont(new java.awt.Font("Tahoma", 0, 14));
        archer.setText("Archer");
        archer.setPreferredSize(new java.awt.Dimension(140, 40));
		archer.setActionCommand("archer");
		
		//Mage
		JRadioButton mage = new JRadioButton("Mage");
        mage.setFont(new java.awt.Font("Tahoma", 0, 14));
        mage.setText("Mage");
        mage.setPreferredSize(new java.awt.Dimension(140, 40));
		mage.setActionCommand("mage");
		
		//Epeiste
		JRadioButton epeiste = new JRadioButton("Epeiste");
        epeiste.setFont(new java.awt.Font("Tahoma", 0, 14));
        epeiste.setText("Epeiste");
        epeiste.setPreferredSize(new java.awt.Dimension(140, 40));
		epeiste.setActionCommand("epeiste");	
	
		//Construction du groupe de boutons
	    bgroup = new ButtonGroup();
	    //Ajout des boutons
	    bgroup.add(archer);
	    bgroup.add(mage);
	    bgroup.add(epeiste);
	    
	    //Ajout d'actions aux boutons de choix
	    archer.addActionListener(new ActionBoutton());
	    mage.addActionListener(new ActionBoutton());
	    epeiste.addActionListener(new ActionBoutton());
	    
	    
	    //Bouton pour lancer le jeu
	    jouer = new javax.swing.JButton();
        jouer.setFont(new java.awt.Font("Tahoma", 0, 18));
        jouer.setText("Jouer");
        jouer.setPreferredSize(new java.awt.Dimension(140, 40));      
		//Ajout de l'action qui permet de lancer le jeu au bouton
		jouer.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				//On appelle la méthode pour chosir la classe du CardLayout parent
				clParent.choisirClasse(bgroup.getSelection().getActionCommand()); 
		  		//On déselectionne la classe
	    		bgroup.clearSelection();
	    		//On désactive le bouton jouer
	    		jouer.setEnabled(false);
			}
		});
		//De base le bouton pour lancer le jeu est désactivé
		//Pour l'activer il faut au moins sélectionner un bouton dans le groupe de boutons
		jouer.setEnabled(false);
		
		//Création du bouton pour retourner au menu
	    JButton retour = new javax.swing.JButton();
	    retour.setFont(new java.awt.Font("Tahoma", 0, 18));
	    retour.setText("Retour");
	    retour.setPreferredSize(new java.awt.Dimension(140, 40));
	    //Action du bouton pour afficher le menu principal
	    retour.addActionListener(new java.awt.event.ActionListener() {
    	   public void actionPerformed(java.awt.event.ActionEvent evt) {
    		   //On affiche le menu principal
               clParent.afficherMenu();
    		   //On déselectionne la classe
    		   bgroup.clearSelection();
    		   //On désactive le bouton jouer
    		   jouer.setEnabled(false);
	        }
        });


        //Placement des éléments
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(epeiste, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(mage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(archer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 152, Short.MAX_VALUE)
                .addComponent(labelClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelClasse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(archer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(mage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(epeiste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)));
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
		}	
	}
	
	public void paintComponent(Graphics g) {
		ImageIcon m = new ImageIcon(getClass().getResource("/images/textures/menu/choixPers.png"));
		g.drawImage(m.getImage(), 
				0, 0, 544, 604, this);
		
		ImageIcon trans = new ImageIcon(getClass().getResource("/images/textures/menu/test.png"));
		g.drawImage(trans.getImage(), 
				63, 367, this);
		
		ImageIcon m2 = new ImageIcon(getClass().getResource("/images/textures/menu/epeiste.png"));
		g.drawImage(m2.getImage(), 
				61, 388, this);
		
		ImageIcon m3 = new ImageIcon(getClass().getResource("/images/textures/menu/mage.png"));
		g.drawImage(m3.getImage(), 
				225, 378, this);
		
		ImageIcon m4 = new ImageIcon(getClass().getResource("/images/textures/menu/archer.png"));
		g.drawImage(m4.getImage(), 
				345, 378, this);
		
	}

}
