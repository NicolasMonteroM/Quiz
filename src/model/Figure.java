package model;

import processing.core.PApplet;

public abstract class Figure {

	public int x;
	public int y;
	public int size;
	public int dir;
	public PApplet app;
	public int figureColour;
	public boolean state;

	public Figure(int size, int x, int y, int dir, PApplet app) {

		this.y = y;
		this.x = x;
		this.size = size;
		this.state = true;
		this.dir = (int) app.random(-1, 1);
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

			app.fill(153, 72, 254);
			break;

		case 1:

			app.fill(107, 221, 83);
			break;

		case 2:

			app.fill(252, 139, 37);
			break;

		case 3:

			app.fill(255, 199, 46);
			break;

		case 4:
			app.fill(0, 180, 253);
			break;

		case 5:

			app.fill(229, 45, 59);
			break;
		}

	}

	public void moveFigure(boolean state) {

		this.y += dir;

		if (!this.state) {

			dir = 0;

		} else {

			if (this.y < 0 - this.size && dir == -1) {

				setY(app.height);

			}

			if (this.y > app.height + this.size && dir == +1) {

				setY(0 - this.size);

			}

		}

	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
