package com.gameric.mazegame.graphiques;

import java.awt.Graphics2D;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.gameric.mazegame.model.Const;
import com.gameric.mazegame.model.labyrinthe.CasePiegee;
import com.gameric.mazegame.model.labyrinthe.CaseTeleportation;
import com.gameric.mazegame.model.monstres.Monstre;


public class Animation extends JPanel implements ActionListener {

    private int frameCount;                 // Counts ticks for change
                    // frame delay 1-12 (You will have to play around with this)
    private int currentFrame;               // animations current frame
    private int animationDirection;         // animation direction (i.e counting forward or backward)
    private int totalFrames;                // total amount of frames for your animation

    private boolean stopped;                // has animations stopped

    private List<Frame> frames = new ArrayList<Frame>();    // Arraylist of frames 
    
    Timer animationTimer;
    BufferedImage images[];
    private int animDelay; 
    int currImg;
    protected ImageIcon images2[];
    

    public Animation(BufferedImage[] frames, int animationDelay) {
    	//this.frames = frames;
    	this.animDelay = animationDelay;
    	//this.images = frames;
    	
    	this.images = frames;
		
    	//startAnimation();
        
        //this.animationDelay = animationDelay;
        //this.stopped = true;

        for (int i = 0; i < frames.length; i++) {
            addFrame(frames[i], animationDelay);
        }
/*
        this.frameCount = 0;
        this.animationDelay = animationDelay;
        this.currentFrame = 0;
        this.animationDirection = 1;*/
        this.totalFrames = this.frames.size();
        
        this.stopped = true;
        this.frameCount = 0;
        this.currentFrame = 0;
        this.animationDirection = 1;

    }
    public int getSizeFrames() {
    	return totalFrames;
    }
    public void startAnimation(Graphics2D crayon, int x, int y, int w, int h, ImageObserver ob, Monstre m) {
    	System.out.println("Img length "+images.length);
    	for(int c = 0; c < images.length; c++) {
    		System.out.println("Here2 "+c);
    		//crayon.drawImage(images[currImg], x, y, w, h, ob);
    		//currImg = (currImg + 1) % images.length;
    		switch(m.getDirection()) {
				case "UP":
					crayon.drawImage(images[currImg], x, y+c*Const.TAILLE_CASE/3, w, h, ob);
					break;
				case "DOWN":
					crayon.drawImage(images[currImg], x, y-c*Const.TAILLE_CASE/3, w, h, ob);
					break;
				case "LEFT":
					crayon.drawImage(images[currImg], x-c*Const.TAILLE_CASE/3, y, w, h, ob);
					break;
				case "RIGHT":
					crayon.drawImage(images[currImg], x+c*Const.TAILLE_CASE/3, y, w, h, ob);
					break;
				default:
					//m.setAnimation(images[currImg]);
					crayon.drawImage(images[currImg], x, y, w, h, ob);
					break;
    		}
    		crayon.dispose();
    		currImg++;
    	}
    	currImg = 0;
    }
    
    public BufferedImage[] getAnimImages() {
    	return images;
    }
    
    public BufferedImage getSprite() {
        return frames.get(currentFrame).getFrame();
    }
    public void setCurSprite (int num) {
    	this.currentFrame = num;
    }
    
    public void stopAnimation() {
    	animationTimer.stop();
	}
    
    private void addFrame(BufferedImage frame, int duration) {
        if (duration <= 0) {
            System.err.println("Invalid duration: " + duration);
            throw new RuntimeException("Invalid duration: " + duration);
        }

        frames.add(new Frame(frame, duration));
        currentFrame = 0;
    }

    public void start() {
        if (!stopped) {
            return;
        }

        if (frames.size() == 0) {
            return;
        }

        stopped = false;
    }

    public void stop() {
        if (frames.size() == 0) {
            return;
        }

        stopped = true;
    }

    public void restart() {
        if (frames.size() == 0) {
            return;
        }

        stopped = false;
        currentFrame = 0;
    }

    public void reset() {
        this.stopped = true;
        this.frameCount = 0;
        this.currentFrame = 0;
    }

    public void update() {
        if (!stopped) {
            frameCount++;

            if (frameCount > animDelay) {
                frameCount = 0;
                currentFrame += animationDirection;

                if (currentFrame > totalFrames - 1) {
                    currentFrame = 0;
                }
                else if (currentFrame < 0) {
                    currentFrame = totalFrames - 1;
                }
            }
        }

    }
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}