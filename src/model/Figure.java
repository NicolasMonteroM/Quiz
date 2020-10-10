package model;

import processing.core.PApplet;

public abstract class Figure {

	public float x;
	public float y;
	public float size;
	public float dir;
	public PApplet app;
	
	public Figure(int size, float x, float y,  int dir, PApplet app) {
		
		this.y = y;
		this.x = x;
		this.size = size;
		this.dir = dir;
		this.setApp(app);
		
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public float getDir() {
		return dir;
	}

	public void setDir(float dir) {
		this.dir = dir;
	}

	public void drawFigure(){
		
		
	}
	
	public void moveFigure(float dir){
		
		//this.y += dir;
			
	}
	

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
