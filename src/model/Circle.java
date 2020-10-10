package model;

import processing.core.PApplet;

public class Circle extends Figure{
	
	public Circle(int size, int x, int y,  int dir, PApplet app) {
		
		super(size, x, y, dir, app);
		
	}
	
	@Override
	public void draw() {
		
		app.noStroke();
		super.app.ellipse(this.x, this.y, this.size, this.size);
		
		moveFigure();
	}
	
}
