package ch.fhgr.java.trinkspiel.logik;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SpielAblaufController {
	
	// arbeiten hier mit Klasse Sammlung
	private FrageSammlung fragen;
	
	private ArrayList <Boolean> redundanz = new ArrayList <Boolean> ();
	
	private int counter;
	
	// Constructor
	public SpielAblaufController() {
		FrageInitialisator fi = new FrageInitialisator();
		fi.initaliseTestQuestions();
		this.fragen = fi.getFragen();	
				
	}
	
	public void init () {
		this.counter = fragen.getAnzahlFragen();
		redundanz.clear();
		for (int i = 0; i < counter; i++) {
			redundanz.add(false);
		}
	}
	
	public boolean nochFragenUebrig () {
		return counter > 0;
	}
	
	public Frage getRandomFrage() {
		Random r = new Random();
		int index = (int) r.nextInt(counter);
		int i;
		for (i = 0; i < fragen.getAnzahlFragen(); i++) {
			if (redundanz.get(i) == false) {
				index --;
			}
			
			if (index == -1) {
				redundanz.set(i, true);
				break;
			}
		}
		counter --;
		return fragen.selectQuestion(i);
	}
	
	
}