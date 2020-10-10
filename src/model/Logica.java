package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	PApplet app;
	public ArrayList<Figure> figures;
	private String[] info;
	
	Square s;
	Circle c;

	public Logica(PApplet app) {

		figures = new ArrayList<Figure>();
		info = app.loadStrings("data/figuresData.txt");
		firstFigures();

	}

	public void firstFigures() {

		for (int i = 0; i < info.length; i++) {

			String[] buildingInfo = info[i].split(" ");
			
			if (buildingInfo[0].equals("Cuadrado")) {
				
				int size = Integer.parseInt(buildingInfo[1]);
				int x = Integer.parseInt(buildingInfo[2]);
				int y = Integer.parseInt(buildingInfo[3]);
				int dir = Integer.parseInt(buildingInfo[4]);
				
				Square s = new Square(size, x, y, dir, app);
				figures.add(s);
				
			} else if (buildingInfo[0].equals("Circulo")) {
				
				int size = Integer.parseInt(buildingInfo[1]);
				int x = Integer.parseInt(buildingInfo[2]);
				int y = Integer.parseInt(buildingInfo[3]);
				int dir = Integer.parseInt(buildingInfo[4]);
				
				Circle c = new Circle(size, x, y, dir, app);
				figures.add(c);
			}
		}

	}

	public void drawLogica(PApplet app) {
		
		for (int i = 0; i < figures.size(); i++) {
			figures.get(i).drawFigure();
			}

	}

	public void interactions(PApplet app) {

	}

}
