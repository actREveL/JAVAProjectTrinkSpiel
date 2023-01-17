package ch.fhgr.java.trinkspiel.logik;

import java.util.ArrayList;

public class FrageSammlung {
	
	private ArrayList<Frage> fragen = new ArrayList<Frage>();
	
	public FrageSammlung() {}

	public FrageSammlung(ArrayList<Frage> fragen) {
		this.fragen = fragen;
	}
	
	public ArrayList<Frage> getFragen() {
		return fragen;
	}

	public void setFragen(ArrayList<Frage> fragen) {
		this.fragen = fragen;
	}

	public void addFrage(Frage frage) {
		fragen.add(frage);
	}
	
	public int getAnzahlFragen() {
		return fragen.size();
	}
	
	public Frage selectQuestion(int index) {
		return fragen.get(index);
	}
}
