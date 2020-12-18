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
	boolean gameChanged = false;
	
    public GroupTasks() {}
    
    public int startAnimation(Graphics2D crayon, int i, int j, ImageObserver ob, Class c, ImageIcon images[], int totalImages, int currentImage) {
    	currImg = currentImage;
    	if (animationTimer == null) {
    		currImg = 0;
			ActionListener taskPerformer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (images[currImg].getImageLoadStatus() == MediaTracker.COMPLETE && gameChanged == false) {
						crayon.drawImage(images[currImg].getImage(), j*Const.TAILLE_CASE, i*Const.TAILLE_CASE, Const.TAILLE_CASE, Const.TAILLE_CASE, ob);
		    			tmp = (currImg + 1) % totalImages;
	    			  } else {
	    				  gameChanged =false;
	    				  crayon.dispose();
	    			  }
				}
			};
			
			if(c == CasePiegee.class) animationDelay = 600;
			if (c == CaseTeleportation.class) animationDelay = 0;
			animationTimer = new Timer(animationDelay, taskPerformer);
			animationTimer.start();
		} else if (!animationTimer.isRunning() && !gameChanged) {
			animationTimer.restart();
		}
	    
    	return tmp;
	}
    public void setGameChanged(boolean b) {
    	this.gameChanged = b;
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