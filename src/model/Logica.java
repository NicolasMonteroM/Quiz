package model;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PConstants;

public class Logica {

	PApplet app;
	public ArrayList<Figure> figures;
	private String[] info;

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

		// –––––––– creating  figures from array ––––––––
		
		for (int i = 0; i < info.length; i++) {

			String[] buildingInfo = info[i].split(" ");

			int size = Integer.parseInt(buildingInfo[1]);
			int x = Integer.parseInt(buildingInfo[2]);
			int y = Integer.parseInt(buildingInfo[3]);
			int dir = Integer.parseInt(buildingInfo[4]);

			if (buildingInfo[0].equals("Cuadrado")) {

				f = new Square(size, x, y, dir, app);

			}

			if (buildingInfo[0].equals("Circulo")) {

				f = new Circle(size, x, y, dir, app);

			}

			figures.add(f);
			f.setDir(dir);
		}
	}

	public void draw() {

		for (Figure f : figures) {

			f.colourSelection();
			f.draw();

		}

		collision();
	}

	public void collision() {

		for (int i = 0; i < figures.size(); i++) {
			for (int j = 0; j < figures.size(); j++) {

				// –––––––– calculating the distance between figures ––––––––
				
				float scope = (figures.get(i).getSize() - figures.get(j).getSize() + 15);

				if (PApplet.dist(figures.get(i).getX(), figures.get(i).getY(), figures.get(j).getX(),
						figures.get(j).getY()) < scope) {

					// –––––––– changing directions ––––––––

					figures.get(i).setDir((int) (figures.get(i).getDir() * -1));
					figures.get(j).setDir((int) (figures.get(j).getDir() * -1));

				}
			}
		}
	}

	public void interactions() {

		if (app.mouseButton == PConstants.RIGHT) {

			// –––––––– random direction selector ––––––––

			int dir = 0;
			int randomDir = (int) Math.floor(Math.random() * 2);

			switch (randomDir) {

			case 0:

				dir = 1;

				break;

			case 1:

				dir = -1;

				break;

			}

			// random variable that throws the figures' type
			
			int type = (int) app.random(0, 2);

			// random variable that throws the figures' size number
			
			int z = ((int) app.random(30, 80));
			
			// random variables that throws the figures' position
			
			int x = (int) app.random(40, 560);
			int y = (int) app.random(40, 560);

			switch (type) {

			case 0:

				f = new Square(z, x, y, dir, app);
				break;
			case 1:

				f = new Circle(z, x, y, dir, app);
				break;

			}

			figures.add(f);
		}

		// stopping when clicking on figures
		
		for (Figure f : figures) {

			if (PApplet.dist(app.mouseX, app.mouseY, f.getX(), f.getY()) < f.getSize()) {

				f.setDir(0);

			}
		}
	}
}
