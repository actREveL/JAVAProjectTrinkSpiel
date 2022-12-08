package ch.fhgr.java.trinkspiel.logik;

import java.util.ArrayList;
import java.util.Iterator;

public class Frage {
/*String[] questions = {
	"Wie heisst der Churer Hausberg?",
	"Welches sind die grössten Events von Chur?",
	"Stimmt es dass in Chur eine Polizeistunde herrscht?"
	};

String[][] antwortmöglichkeiten = {
	{"Brambrüesch", "Haldensteiner Calanda"},
	{"BigAir,Schlagerparade", "Fasnacht, Churer Fest"},
	{"Ja", "Nein"}
	};

char[] answers = {
	'A',
	'A',
	'B'
	};*/
private String fragetext;
private ArrayList<String> antwortvarianten;
private int richtigeAntwort;


public Frage(String fraget, ArrayList<String> antwortmöglichkeiten, int richtigeAntwort) {
	super();
	this.fragetext = fraget;
	this.antwortvarianten = antwortmöglichkeiten;
	this.richtigeAntwort = richtigeAntwort;
}

public void setFrage(String frage) {
	this.fragetext = frage;
}

public void setAntwortmöglichkeiten (ArrayList<String> antwortmöglichkeiten) {
	this.antwortvarianten = antwortmöglichkeiten;
}

public void setRichtigeAntwort (int richtigeAntwort) {
	this.richtigeAntwort = richtigeAntwort;
}

public String getFrage() {
	return fragetext;
}

public ArrayList<String> getAntwortmöglichkeiten() {
	return antwortvarianten;
}

public int getRichtigeAntwort() {
	return richtigeAntwort;
}


/*
 * Funktion istrichtig public boolean hinzufügen*/
public String toString() { //hierweiter
	StringBuffer sb = new StringBuffer();
	sb.append(fragetext);
	
	return(sb.toString());
}

}
