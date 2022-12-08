package ch.fhgr.java.trinkspiel.logik;

import java.util.ArrayList;

public class FrageInitialisator {
	
	private FrageSammlung fragen = new FrageSammlung();
	
	public void initaliseTestQuestions() {
		ArrayList<String> antworten = new ArrayList<String>();
		antworten.add("Brambrüesch");
		antworten.add("Haldensteiner Calanda");
		Frage frage = new Frage("Wie heisst der Churer Hausberg?", antworten, 0);
		fragen.addFrage(frage);
		
		antworten = new ArrayList<String>();
		antworten.add("BigAir,Schlagerparade");
		antworten.add("Fasnacht, Churer Fest");
		Frage frage1 = new Frage("Welches sind die grössten Events von Chur?", antworten, 0);
		fragen.addFrage(frage1);
		
		antworten = new ArrayList<String>();
		antworten.add("Ja");
		antworten.add("Nein");
		Frage frage2 = new Frage("Stimmt es, dass in Chur eine Polizeistunde herrscht?", antworten, 1);
		fragen.addFrage(frage2);
		
	}
	public void printQuestions() {
		System.out.println(fragen);
	}

}
