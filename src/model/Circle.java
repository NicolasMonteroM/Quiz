package model;

import processing.core.PApplet;

public class Circle extends Figure{
	
	public Circle(int size, float x, float y,  int dir, PApplet app) {
		
		super(size, x, y, dir, app);
		
	}
	
	@Override
	public void drawFigure() {
		
	//	getApp().ellipse(this.x, this.y, this.size, this.size);
		
	}
	
	@Override
	public void moveFigure(float dir){
		
		
	}
	
}
