package controller;

import model.Logica;
import processing.core.PApplet;

public class Controller {

	Logica logica;
	PApplet app;
	
	public Controller(PApplet app) {
		
		this.app = app;
		logica = new Logica(app);
	}
	
	public void drawController() {
		
		logica.drawLogica(app);
		
	}
	
	public void mouseController(){
		
		logica.interactions(app);
		
	}

}
