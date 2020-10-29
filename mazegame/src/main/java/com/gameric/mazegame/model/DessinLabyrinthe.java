package com.gameric.mazegame.model;

import java.awt.image.BufferedImage;

import com.gameric.mazegame.engine.GamePainter;

public class DessinLabyrinthe implements GamePainter {
	
	protected static final int WIDTH = 100;
	protected static final int HEIGHT = 100;

	@Override
	public void draw(BufferedImage image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

}
