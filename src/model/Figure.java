package model;

import processing.core.PApplet;

public abstract class Figure {

	public int x;
	public int y;
	public int size;
	public int dir;
	public PApplet app;
	public int figureColour;

	public Figure(int size, int x, int y, int dir, PApplet app) {

		this.y = y;
		this.x = x;
		this.size = size;
		this.dir = dir;
		this.setApp(app);
		this.figureColour = (int) app.random(0, 6);

	}

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public float getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public void draw() {

	}

	public void colourSelection() {

		switch (figureColour) {

		case 0:

			app.fill(150, 150, 150);
			break;

		case 1:

			app.fill(200, 200, 200);
			break;

		case 2:

			app.fill(100, 100, 100);
			break;

		case 3:

			app.fill(75, 75, 75);
			break;

		case 4:
			app.fill(60, 60, 60);
			break;

		case 5:

			app.fill(220, 220, 220);
			break;
		}

	}

	public void moveFigure() {

		this.y += dir;

		if (this.y < 0 - this.size && dir == -1) {

			setY(app.height);

		}

		if (this.y > app.height + this.size && dir == +1) {

			setY(0 - this.size);

		}

	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
