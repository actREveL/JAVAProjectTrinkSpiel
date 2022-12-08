package ch.fhgr.java.trinkspiel.mains;

import ch.fhgr.java.trinkspiel.logik.FrageInitialisator;
import ch.fhgr.java.trinkspiel.logik.FrageSammlung;

public class TestMain {

	public static void main(String[] args) {
		
		FrageInitialisator initiate = new FrageInitialisator();
		initiate.initaliseTestQuestions();
		initiate.printQuestions();
		
        System.out.println("ok");
	}

}
