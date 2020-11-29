package com.gameric.mazegame.graphiques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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
	private JButton lancerJeu;
	
	/**
	 * Constructeur de l'écran du choix de classe
	 * @param c : CardLayout père
	 */
	public EcranClasse(CardLayoutJeu c) {
		clParent = c;	
        setPreferredSize(new java.awt.Dimension(320, 360));
		
        
		//Construction label du choix de classe
		JLabel labelClasse = new javax.swing.JLabel();
        labelClasse.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        labelClasse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClasse.setText("Choisissez une classe");     

		
		//Construction des boutons représentant chaque classe
		//Archer
		JRadioButton archer = new JRadioButton("Archer");
        archer.setText("Archer");
        archer.setPreferredSize(new java.awt.Dimension(100, 30));
		archer.setActionCommand("archer");
		
		//Mage
		JRadioButton mage = new JRadioButton("Mage");
	    mage.setText("Mage");
	    mage.setPreferredSize(new java.awt.Dimension(100, 30));
		mage.setActionCommand("mage");
		
		//Epeiste
		JRadioButton epeiste = new JRadioButton("Epeiste");
        epeiste.setText("Epeiste");
        epeiste.setPreferredSize(new java.awt.Dimension(100, 30));
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
	    lancerJeu = new javax.swing.JButton();
        lancerJeu.setText("Lancer le jeu");
        lancerJeu.setPreferredSize(new java.awt.Dimension(140, 25));
        
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
        
        
        //Placement des éléments
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(labelClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(epeiste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(archer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lancerJeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelClasse)
                .addGap(30, 30, 30)
                .addComponent(archer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(mage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(epeiste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lancerJeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
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
