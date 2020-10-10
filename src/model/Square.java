package model;

import processing.core.PApplet;
import processing.core.PConstants;

public class Square extends Figure{

	public Square(int size, int x, int y,  int dir, PApplet app) {
		
		super(size, x, y, dir, app);
		
	}
	
	@Override
	public void draw() {
		
		app.rectMode(PConstants.CENTER);
		app.stroke(200);
		super.app.rect(super.x, super.y, super.size, super.size);
		
		moveFigure();
		
	}

}
