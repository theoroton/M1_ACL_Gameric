package com.gameric.mazegame.graphiques;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.gameric.mazegame.model.Const;
import com.gameric.mazegame.model.Etat;
import com.gameric.mazegame.model.JeuLabyrinthe;

public class EcranMenu extends JPanel implements MouseListener {

	/**
	 * CardLayout auquel est ajouté ce JPanel
	 */
	private CardLayoutJeu clParent;
	
	/**
	 * Constructeur de l'écran du menu
	 * @param c : CardLayout père
	 */
	public EcranMenu(CardLayoutJeu c, JeuLabyrinthe j) {
		clParent = c;
		setPreferredSize(new java.awt.Dimension(544, 604));
		addMouseListener(this);
		
		//Création du bouton pour jouer au jeu
		JButton jouer = new javax.swing.JButton();
		jouer.setFont(new java.awt.Font("Tahoma", 0, 18));
        jouer.setText("Jouer");
        jouer.setPreferredSize(new java.awt.Dimension(140, 40));
        //Action du bouton jouer
        jouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On affiche le choix de classe
                clParent.afficherChoixClasse();
            }
        });
        

        //Création du bouton pour afficher le but et les commandes du jeu
        JButton but = new javax.swing.JButton();
        but.setFont(new java.awt.Font("Tahoma", 0, 18));
        but.setText("But du jeu");
        but.setPreferredSize(new java.awt.Dimension(140, 40));
        //Action du bouton but
        but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On affiche l'écran des règles
                clParent.afficherBut();
            }
        });
        
        JButton quitter = new javax.swing.JButton();
        quitter.setFont(new java.awt.Font("Tahoma", 0, 18));
        quitter.setText("Quitter");
        quitter.setPreferredSize(new java.awt.Dimension(140, 40));
        //Action du bouton quitter
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//On ferme le jeu
            	j.setEtat(Etat.Fin);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(204, Short.MAX_VALUE)));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(jouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)));
	}
	
	public void paintComponent(Graphics g) {
		ImageIcon m = new ImageIcon(getClass().getResource("/images/textures/menu/menuPrincip.png"));
		g.drawImage(m.getImage(), 
				0, 0, 544, 604, this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e);	
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
