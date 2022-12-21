package ch.fhgr.java.trinkspiel.logik;

public class Frage {

	private String fragetext;
	private String antwort0;
	private String antwort1;
	// private ArrayList<String> antwortvarianten; // how??
	private int richtigeAntwort;
	
	
	public Frage(String frage, String antwort0, String antwort1, int richtigeAntwort) {
		super();
		this.fragetext = frage;
		// this.antwortvarianten.add(antwort0);
		this.antwort0 = antwort0;
		// this.antwortvarianten.add(antwort1);
		this.antwort1 = antwort1;
		// this.antwortvarianten = antwortmöglichkeiten;
		this.richtigeAntwort = richtigeAntwort;
	}
	
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
	/*
	public void setAntwortvarianten (ArrayList<String> antwortmöglichkeiten) {
		this.antwortvarianten = antwortmöglichkeiten;
	}*/
	
	public void setRichtigeAntwort (int richtigeAntwort) {
		this.richtigeAntwort = richtigeAntwort;
	}
	
	public String getFrage() {
		return fragetext;
	}
	/*
	public ArrayList<String> getAntwortvarianten() {
		return antwortvarianten;
	}*/
	
	public int getRichtigeAntwort() {
		return richtigeAntwort;
	}
	
	/*
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
	}*/

}
