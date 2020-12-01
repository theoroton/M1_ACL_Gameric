package com.gameric.mazegame.graphiques;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.*;

import com.gameric.mazegame.engine.GamePainter;
import com.gameric.mazegame.graphiques.GroupTasks;
import com.gameric.mazegame.model.Const;
import com.gameric.mazegame.model.JeuLabyrinthe;
import com.gameric.mazegame.model.labyrinthe.Case;
import com.gameric.mazegame.model.labyrinthe.CaseApparition;
import com.gameric.mazegame.model.labyrinthe.CaseSortie;
import com.gameric.mazegame.model.labyrinthe.CaseEntree;
import com.gameric.mazegame.model.labyrinthe.CaseVide;
import com.gameric.mazegame.model.labyrinthe.CaseObjet;
import com.gameric.mazegame.model.labyrinthe.CasePiegee;
import com.gameric.mazegame.model.labyrinthe.CaseTeleportation;
import com.gameric.mazegame.model.labyrinthe.Labyrinthe;
import com.gameric.mazegame.model.labyrinthe.Mur;
import com.gameric.mazegame.model.monstres.Monstre;
import com.gameric.mazegame.model.monstres.Squelette;
import com.gameric.mazegame.model.monstres.Zombie;
import com.gameric.mazegame.model.personnage.Personnage;

/**
 * 
 * @author Théo Roton
 * Afficheur graphique du jeu
 */
public class DessinLabyrinthe extends JPanel implements GamePainter {
	
	/**
	 * Largeur du dessin du labyrinthe
	 */
	private static int WIDTH;
	/**
	 * Hauteur du dessin du labyrinthe
	 */
	private static int HEIGHT;
	
	/**
	 * Jeu à afficher
	 */
	private JeuLabyrinthe jeu;
	
	private final static String IMAGE_NAME = "piege";
	protected ImageIcon images[]; // array of images
	private int totalImages = 9; // number of images
	private int totalImagesTep = 8;
	private int currentImage = 0; // current image index
	private int currentImageTep = 0;
	protected int degree = 0;
	protected ImageIcon telepEff[];
	
	private int tmp;
	private boolean active = true;
	
	private GroupTasks animationTimer = new GroupTasks();
	private GroupTasks animationTimerTep = new GroupTasks();
	
	/**
	 * Constructeur de l'afficheur
	 * @param j : jeu à afficher
	 */
	public DessinLabyrinthe(JeuLabyrinthe j) {
		jeu = j;
		WIDTH = (j.getLabyrinthe().getLargeur())*Const.TAILLE_CASE;
		HEIGHT = (j.getLabyrinthe().getHauteur())*Const.TAILLE_CASE;
		
		images = new ImageIcon[totalImages];
		telepEff = new ImageIcon[totalImagesTep];
		
		// load 9 images
		for ( int count = 0; count < images.length; count++ )
			images[count] = new ImageIcon(getClass().getResource("/images/textures/piege/" + IMAGE_NAME + count + ".jpg"));
		
		for ( int count = 0; count < telepEff.length; count++ )
			telepEff[count] = new ImageIcon(getClass().getResource("/images/textures/effects/telepEffect" + count + ".png"));
		
	}

	/**
	 * Méthode qui dessine l'image du labyrinthe du jeu
	 */
	public void draw(BufferedImage image) {
		//super.draw(image);
		//On récupère le personnage du jeu
		Personnage personnage = jeu.getPersonnage();
		//On récupère le labyrinthe du jeu
		Labyrinthe labyrinthe = jeu.getLabyrinthe();
		
		Graphics2D crayon = (Graphics2D) image.getGraphics();
		//Graphics2D g2d = (Graphics2D) image.create();
		
		int hauteur = labyrinthe.getHauteur();
		int largeur = labyrinthe.getLargeur();
		//On dessine cases qui doivent être affichées
		for (int i=0; i<hauteur; i++) {
			for (int j=0; j<largeur; j++) {
				Case c = labyrinthe.getCase(j,i);
				//On dessine en noir les murs
				if (c.getClass() == Mur.class) {
					if(i>0 && i<hauteur-1 && j>0 && j<largeur-1) {
						crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/block.jpg")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
					} else {
						if(j == 0) {
							if(i == hauteur-1) {
								crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/coinMurGBlack.jpg")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
							} else {
								crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/murGBlack.jpg")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
							}
						} else if(j == largeur-1) {
							if(i == hauteur-1) {
								crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/coinMurDBlack.jpg")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
							} else {
								crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/murDBlack.jpg")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
							}
						} else 
							crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/down.jpg")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
						
					}
					
					//crayon.setColor(Color.BLACK);
					//crayon.fillRect(j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE);
					//crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/wall.png")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
					
				//On dessine en orange les cases objets
				} else if (c.getClass() == CaseObjet.class) {
					//crayon.setColor(new Color(255, 153, 0));
					//crayon.fillRect(j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE);
					crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/"+checkVoisinGetImg(labyrinthe, i, j))).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
					//Si l'objet n'a pas encore était ramassé, on l'affiche sur la case
					if (!((CaseObjet) c).isRamasse()) {
						//crayon.setColor(Color.BLACK);
						//dessinerChaineCentree(crayon, ((CaseObjet) c).getObjet().getNom(), new Rectangle(j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE), Const.FONT_OBJET);
						if(((CaseObjet) c).getObjet().getNom().equals("Potion")) {
							crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/potion.png")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE-Const.TAILLE_CASE/3, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
						} else if(((CaseObjet) c).getObjet().getNom().equals("Arme")) {
							crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/epee.png")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
						}
					}
					
				//On dessigne en rose les cases piégées
				} else if (c.getClass() == CasePiegee.class) {
					//crayon.setColor(new Color(255, 153, 153));
					//crayon.fillRect(j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE);
					crayon.drawImage(images[currentImage].getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
					if(active) {
						tmp = animationTimer.startAnimation(crayon, i, j, this, c.getClass(), images, totalImages, currentImage);
						currentImage = tmp;
					}
										
				} else if (c.getClass() == CaseEntree.class || c.getClass() == CaseSortie.class) {
					crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/porte.jpg")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
				} else if(c.getClass() == CaseVide.class) {
					crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/"+checkVoisinGetImg(labyrinthe, i, j))).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);						
					//On dessine en bleu clair les cases téléporations
				} else if (c.getClass() == CaseTeleportation.class) {
					crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/"+checkVoisinGetImg(labyrinthe, i, j))).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);						
					crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/teleporter.png")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);						
					crayon.drawImage(telepEff[currentImageTep].getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
					if(active) {
						tmp = animationTimerTep.startAnimation(crayon, i, j, this, c.getClass(), telepEff, totalImagesTep, currentImageTep);
						currentImageTep = tmp;
					}
					
					//crayon.setColor(new Color(15, 220, 241));
					//crayon.fillRect(j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE);
								
				//On dessine en violet clair les cases apparitions
				} else if (c.getClass() == CaseApparition.class) {
					crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/"+checkVoisinGetImg(labyrinthe, i, j))).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);
					if(!((CaseApparition) c).isDeclenche()) {
						crayon.drawImage(new ImageIcon(getClass().getResource("/images/textures/spawner.jpg")).getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, this);						

					}
				}
					//crayon.setColor(new Color(160, 103, 248));
					//crayon.fillRect(j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE);
				
			}
		}
		
		//On dessine le personnage en bleu
		if (!personnage.estMort()) {
			crayon.setColor(Color.BLUE);
			crayon.fillOval(personnage.getPos_x()*Const.TAILLE_CASE + Const.TAILLE_PLACEPERSO, 
							personnage.getPos_y()*Const.TAILLE_CASE + Const.TAILLE_PLACEPERSO, 
							Const.TAILLE_PERSO, Const.TAILLE_PERSO);
		}
		
		//On dessine les monstres
		for (Monstre m : labyrinthe.getMonstres()) {
			if (m.getClass() == Zombie.class) {
				//crayon.setColor(Color.GREEN);
				switch(m.getDirection()) {
					case "UP":
						m.setAnimation(m.getAnimationUp());
						break;
					case "DOWN":
						m.setAnimation(m.getAnimationDown());
						break;
					case "LEFT":
						m.setAnimation(m.getAnimationLeft());
						break;
					case "RIGHT":
						m.setAnimation(m.getAnimationRight());
						break;
					default:
						m.setAnimation(m.getAnimationStand());
						break;
						
				}
				crayon.drawImage(m.getAnimation().getSprite(), m.getPosition().getPx()*Const.TAILLE_CASE, m.getPosition().getPy()*Const.TAILLE_CASE-2*Const.TAILLE_CASE/3, Const.TAILLE_CASE, Const.TAILLE_CASE+(Const.TAILLE_CASE/3), this);						
			} else if (m.getClass() == Squelette.class) {
				crayon.setColor(Color.RED);
			} else {
				crayon.setColor(Color.GRAY);
			}
			/*crayon.fillOval(m.getPosition().getPx()*Const.TAILLE_CASE + Const.TAILLE_PLACEPERSO, 
							m.getPosition().getPy()*Const.TAILLE_CASE + Const.TAILLE_PLACEPERSO, 
							Const.TAILLE_PERSO, Const.TAILLE_PERSO);*/
		}

		//Si le jeu est en pause
		if (jeu.enPause()) {
			crayon.setColor(Const.COULEUR_PAUSE);
			crayon.fillRect(0, 0, WIDTH, HEIGHT);
			crayon.setColor(Color.BLACK);
			dessinerChaineCentree(crayon, "Jeu en pause", new Rectangle(WIDTH/6, HEIGHT/6, 2*WIDTH/3, HEIGHT/4), Const.FONT_PAUSE);
			animationTimer.stopAnimation();
			animationTimerTep.stopAnimation();
			active = false;
		} else {
			active = true;
		}
		
	}
	
	private String checkVoisinGetImg(Labyrinthe l, int i, int j) {
		String res = "";
		String name = "";
		if(l.getCase(j, i-1).getClass() == Mur.class) {
			res += "h";
		} 
		if(l.getCase(j, i+1).getClass() == Mur.class) {
			res += "b";
		} 
		if(l.getCase(j-1, i).getClass() == Mur.class) {
			res += "g";
		}
		if(l.getCase(j+1, i).getClass() == Mur.class) {
			res += "d";
		}
		switch(res) {
		case "h" :
			name += "haut1.jpg";
			break;
		case "hb" :
			name += "haut1.jpg";
			break;	
		case "g" :
			name += "gauche.jpg";
			break;
		case "bg" :
			name += "gauche.jpg";
			break;
		case "gd" :
			name += "gaucheD.jpg";
			break;
		case "bgd" :
			name += "gaucheD.jpg";
			break;
		case "d" :
			name += "droite.jpg";
			break;
		case "bd" :
			name += "droite.jpg";
			break;
		case "hg" :
			name += "hautG.jpg";
			break;
		case "hbg" :
			name += "hautG.jpg";
			break;
		case "hd" :
			name += "hautD.jpg";
			break;
		case "hbd" :
			name += "hautD.jpg";
			break;
		case "hgd" :
			name += "coinHGD.jpg";
			break;
		default: 
			name += "center2.jpg";
			break;
		}		
		return name;
	}
	
	/**
	 * Méthode qui permet de dessiner une chaîne centrée dans un rectangle
	 * @param g : graphics à utiliser
	 * @param s : chaîne à écrire
	 * @param r : rectangle dans lequel centrer la chaîne
	 * @param f : police à utiliser
	 */
	public void dessinerChaineCentree(Graphics g, String s, Rectangle r, Font f) {
	    FontMetrics metrics = g.getFontMetrics(f);
	    //Position x de la chaîne
	    int x = r.x + (r.width - metrics.stringWidth(s)) / 2;
	    //Position y de la chaîne
	    int y = r.y + ((r.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    g.setFont(f);
	    g.drawString(s, x, y);
	}

	/**
	 * Getter de la largeur du dessin
	 * @return largeur du dessin
	 */
	public int getWidth() {
		return WIDTH;
	}

	/**
	 * Getter de la hauteur du dessin
	 * @return hauteur du dessin
	 */
	public int getHeight() {
		return HEIGHT;
	}
	
}
