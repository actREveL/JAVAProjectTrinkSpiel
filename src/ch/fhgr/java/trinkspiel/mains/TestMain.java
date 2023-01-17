package ch.fhgr.java.trinkspiel.mains;

import ch.fhgr.java.trinkspiel.logik.Frage;
import ch.fhgr.java.trinkspiel.logik.SpielAblaufController;


// wurde verwendet um Datenbank zu testen - AKTUELL NICHT EINGESETZT

public class TestMain {

	public static void main(String[] args) {
		
		SpielAblaufController controller = new SpielAblaufController();
		controller.init();
		
		while (controller.nochFragenUebrig()) {
			Frage frage = controller.getRandomFrage();
			System.out.println(frage);
		}
		
	}

}
