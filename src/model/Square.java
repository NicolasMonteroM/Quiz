package model;

import processing.core.PApplet;

public class Square extends Figure{

	public Square(int size, float x, float y,  int dir, PApplet app) {
		
		super(size, x, y, dir, app);
		
	}
	
	@Override
	public void drawFigure() {
		
	//	this.app.rect(this.x, this.y, this.size, this.size);
		
	}
	
	@Override
	public void moveFigure(float dir){
		
		
	}

}
