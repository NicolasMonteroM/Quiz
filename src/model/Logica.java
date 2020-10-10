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

	public Logica(PApplet app) {

		this.app = app;
		figures = new ArrayList<Figure>();
		info = app.loadStrings("data/figuresData.txt");
		firstFigures();
		
		System.out.println(figures);

	}

	public void firstFigures() {

		for (int i = 0; i < info.length; i++) {

			String[] buildingInfo = info[i].split(" ");
			
			if (buildingInfo[0].equals("Cuadrado")) {
				
				int size = Integer.parseInt(buildingInfo[1]);
				int x = Integer.parseInt(buildingInfo[2]);
				int y = Integer.parseInt(buildingInfo[3]);
				int dir = Integer.parseInt(buildingInfo[4]);
				
			/*	System.out.println(size);
				System.out.println(x);
				System.out.println(y);
				System.out.println(dir);*/
				
				
				f = new Square(size, x, y, dir, app);
				figures.add(f);
				f.setDir(dir);
				
			} else if (buildingInfo[0].equals("Circulo")) {
				
				int size = Integer.parseInt(buildingInfo[1]);
				int x = Integer.parseInt(buildingInfo[2]);
				int y = Integer.parseInt(buildingInfo[3]);
				int dir = Integer.parseInt(buildingInfo[4]);
				
				/*	System.out.println(size);
				System.out.println(x);
				System.out.println(y);
				System.out.println(dir);*/
				
				f = new Circle(size, x, y, dir, app);
				figures.add(f);
				f.setDir(dir);
				
			}
		}

	}

	public void draw(PApplet app) {
		
		for (Figure f : figures) {
			
			f.colourSelection();
			f.draw();
			f.moveFigure();
		}

	}

	public void interactions(PApplet app) {

	}

}
