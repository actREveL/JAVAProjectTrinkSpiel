package ch.fhgr.java.trinkspiel.logik;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Frage {

	private String fragetext;
	//private String antwortvariante_0;
	//private String antwortvariante_1;
	private ArrayList<String> antwortvarianten;
	private int richtigeAntwort;
	
	
	public Frage(String frage, ArrayList<String> antwortmöglichkeiten, int richtigeAntwort) {
		super();
		this.fragetext = frage;
		//this.antwortvarianten.add(antwortvariante_0);
		//this.antwortvarianten.add(antwortvariante_1);
		this.antwortvarianten = antwortmöglichkeiten;
		this.richtigeAntwort = richtigeAntwort;
	}
	
	
	
	public void setFrage(String frage) {
		this.fragetext = frage;
	}
	
	public void setAntwortvarianten (ArrayList<String> antwortmöglichkeiten) {
		this.antwortvarianten = antwortmöglichkeiten;
	}
	
	public void setRichtigeAntwort (int richtigeAntwort) {
		this.richtigeAntwort = richtigeAntwort;
	}
	
	public String getFrage() {
		return fragetext;
	}
	
	public ArrayList<String> getAntwortvarianten() {
		return antwortvarianten;
	}
	
	public int getRichtigeAntwort() {
		return richtigeAntwort;
	}
	
	
	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append(fragetext + "\n");
		
		Iterator <String> st = antwortvarianten.iterator();
		while (st.hasNext()) {
			String a = st.next();
			sb.append(" - ");
			sb.append(a);
			sb.append("\n");
		} 
		
		sb.append("  richtige Antwort: " + this.richtigeAntwort);
		
		return(sb.toString());
	}

}
