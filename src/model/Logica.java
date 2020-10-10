package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	PApplet app;
	public ArrayList<Figure> figures;
	private String[] info;

	Square s;
	Circle c;

	Figure f;

	boolean movementState = true;

	public Logica(PApplet app) {

		this.app = app;
		figures = new ArrayList<Figure>();
		info = app.loadStrings("data/figuresData.txt");
		firstFigures();

		// System.out.println(figures);

	}

	public void firstFigures() {

		for (int i = 0; i < info.length; i++) {

			String[] buildingInfo = info[i].split(" ");

			if (buildingInfo[0].equals("Cuadrado")) {

				int size = Integer.parseInt(buildingInfo[1]);
				int x = Integer.parseInt(buildingInfo[2]);
				int y = Integer.parseInt(buildingInfo[3]);
				int dir = Integer.parseInt(buildingInfo[4]);

				/*
				 * System.out.println(size); System.out.println(x); System.out.println(y);
				 * System.out.println(dir);
				 */

				f = new Square(size, x, y, dir, app);
				figures.add(f);
				f.setDir(dir);

			} else if (buildingInfo[0].equals("Circulo")) {

				int size = Integer.parseInt(buildingInfo[1]);
				int x = Integer.parseInt(buildingInfo[2]);
				int y = Integer.parseInt(buildingInfo[3]);
				int dir = Integer.parseInt(buildingInfo[4]);

				/*
				 * System.out.println(size); System.out.println(x); System.out.println(y);
				 * System.out.println(dir);
				 */

				f = new Circle(size, x, y, dir, app);
				figures.add(f);
				f.setDir(dir);

			}
		}

	}

	public void draw() {

		for (Figure f : figures) {

			f.colourSelection();
			f.draw();
			//f.moveFigure();
		}

	}

	public void collition() {

		for (Figure f : figures) {

			for (Figure s : figures) {

				if (app.dist(s.getX(), s.getY(), f.getX(), f.getY()) < f.getSize() + 20) {

					f.setDir((int) (f.getDir()*-1));
					s.setDir((int) (f.getDir()*-1));

				}

			}
		}

	}

	public void interactions() {

		for (Figure f : figures) {

			if (app.dist(app.mouseX, app.mouseY, f.getX(), f.getY()) < f.getSize() + 20) {

				f.setDir(0);

			}

		}
		
		int type = (int) app.random(0, 2);

		//random variable that throws the figures' size number
		int z = ((int)app.random(5,60));
		
		switch(type) {
		
		  case 0:
			  
			  f = new Square((int)app.random(30, 80), (int)app.random(40, 560), (int)app.random(40, 560), 1, app);
			  break;

		  case 1:
			  
			  f = new Circle((int)app.random(30, 80), (int)app.random(40, 560), (int)app.random(40, 560), 1, app);
			  break;
			  
		}
		
		figures.add(f);

	}

}
