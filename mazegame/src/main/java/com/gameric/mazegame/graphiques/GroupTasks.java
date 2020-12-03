package com.gameric.mazegame.graphiques;

import java.awt.Graphics2D;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.gameric.mazegame.model.Const;
import com.gameric.mazegame.model.labyrinthe.CasePiegee;
import com.gameric.mazegame.model.labyrinthe.CaseTeleportation;
import com.gameric.mazegame.model.monstres.Monstre;

public class GroupTasks extends JPanel implements ActionListener{
	Timer animationTimer;
	Timer pauses;
	private int animationDelay;
	int currImg;
	int tmp;
	boolean b;
	
    public GroupTasks() {}
    
    public int startAnimation(Graphics2D crayon, int i, int j, ImageObserver ob, Class c, ImageIcon images[], int totalImages, int currentImage) {
    	currImg = currentImage;
    	if (animationTimer == null) {
    		currImg = 0;
			ActionListener taskPerformer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (images[currImg].getImageLoadStatus() == MediaTracker.COMPLETE) {
						crayon.drawImage(images[currImg].getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, ob);
		    			tmp = (currImg + 1) % totalImages;
	    			  }
				}
			};
			
			if(c == CasePiegee.class) animationDelay = 600;
			if (c == CaseTeleportation.class) animationDelay = 0;
			animationTimer = new Timer(animationDelay, taskPerformer);
			animationTimer.start();
		} else if (!animationTimer.isRunning()) {
			animationTimer.restart();
		}
	    
    	return tmp;
	}
    
    public void startAnimationMonstre(Graphics2D crayon, int x, int y, int w, int h, ImageObserver ob, Animation anim, Monstre m) {
    	
    	currImg = 0;
    	BufferedImage images[] = anim.getAnimImages();
    	//crayon.drawImage(images[currImg], x, y, w, h, ob);
    	//crayon.drawImage(anim.getSprite(), x, y, w, h, ob);
    	if (animationTimer == null) {
			ActionListener taskPerformer1 = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					//System.out.println("Here2 "+anim.getSizeFrames());
					
		    		System.out.println("MonsterDirection-- "+m.getDirection());
		    		//crayon.drawImage(images[currImg], x, y, w, h, ob);
		    		//animationTimer.stop();
		    		//animationTimer = null;
					
					for(int c = 0; c < anim.getSizeFrames(); c++) {
						System.out.println("CurrImg-- "+currImg);
						switch(m.getDirection()) {
							case "UP":
								crayon.drawImage(images[currImg], x, y+c*Const.TAILLE_CASE/anim.getSizeFrames(), w, h, ob);
								break;
							case "DOWN":
								crayon.drawImage(images[currImg], x, y-c*Const.TAILLE_CASE/anim.getSizeFrames(), w, h, ob);
								break;
							case "LEFT":
								crayon.drawImage(images[currImg], x-c*Const.TAILLE_CASE/anim.getSizeFrames(), y, w, h, ob);
								break;
							case "RIGHT":
								crayon.drawImage(images[currImg], x+c*Const.TAILLE_CASE/anim.getSizeFrames(), y, w, h, ob);
								break;
							default:
								crayon.drawImage(images[currImg], x, y, w, h, ob);
								break;
						}
						currImg++;
						//animationTimer.stop();
						
						System.out.println("+++++++Bef");
						
						/*try {
							animationTimer.wait(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
						//animationTimer.setDelay(10);
						//waitForTwoSeconds();
						//animationTimer.setDelay(8000);
						System.out.println("+++++++Aft");
						crayon.dispose();
					}
					
					animationTimer.stop();
		    		animationTimer = null;
				}
			};
			animationTimer = new Timer(0, taskPerformer1);
			animationTimer.start();
		}
	}
        
    public void stopAnimation() {
    	animationTimer.stop();
	}
    public void restartAnimation() {
    	animationTimer.restart();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
