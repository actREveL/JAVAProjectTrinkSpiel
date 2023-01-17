package ch.fhgr.java.trinkspiel.logik;

public class Frage {

	private String fragetext;
	private String antwort0;
	private String antwort1;
	private int richtigeAntwort;
	
	
	public Frage(String frage, String antwort0, String antwort1, int richtigeAntwort) {
		super();
		this.fragetext = frage;
		this.antwort0 = antwort0;
		this.antwort1 = antwort1;
		this.richtigeAntwort = richtigeAntwort;
	}
	
	// Methoden werden gesetzt für Fragen
	public String getFragetext() {
		return fragetext;
	}

	public void setFragetext(String fragetext) {
		this.fragetext = fragetext;
	}

	public String getAntwort0() {
		return antwort0;
	}

	public void setAntwort0(String antwort0) {
		this.antwort0 = antwort0;
	}

	public String getAntwort1() {
		return antwort1;
	}

	public void setAntwort1(String antwort1) {
		this.antwort1 = antwort1;
	}

	public void setFrage(String frage) {
		this.fragetext = frage;
	}
	
	public void setRichtigeAntwort (int richtigeAntwort) {
		this.richtigeAntwort = richtigeAntwort;
	}
	
	public String getFrage() {
		return fragetext;
	}
	
	public int getRichtigeAntwort() {
		return richtigeAntwort;
	}

}
