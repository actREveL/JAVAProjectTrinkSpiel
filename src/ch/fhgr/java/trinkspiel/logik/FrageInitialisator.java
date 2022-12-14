package ch.fhgr.java.trinkspiel.logik;

import java.util.ArrayList;
import java.util.Iterator;

public class FrageInitialisator {
//	public void initaliseTestQuestions() {
//	try {
//		Class.forName(DbConfiguration.DRIVER);
//		Connection con = DriverManager.getConnection(
//				DbConfiguration.buildURL(), DbConfiguration.USER, DbConfiguration.PASSWORT);
//		
//		Statement stmt = con.createStatement();
		
//		stmt.executeUpdate("create table testtable(id INTEGER not NULL AUTO_INCREMENT, name VARCHAR(255), PRIMARY KEY (id));");
//		System.out.println("Testtabelle kreieren");
//		String sql = "INSERT INTO testtable(name) VALUES ('Puce')";
//		stmt.executeUpdate(sql);
//		sql = "INSERT INTO testtable(name) VALUES ('Lana')";
//		stmt.executeUpdate(sql);
		
//		System.out.println("Inhalte der Tabelle lesen");
//		ResultSet rs = stmt.executeQuery("SELECT * FROM Fragentrinkspiel");
//		while(rs.next()) {
//			System.out.println(rs.getString(2) + " : " + rs.getString(1));
//			ArrayList<String> antworten = new ArrayList<String>();
//			antworten.add(rs.getString(1));
//			Frage frage = new Frage(rs.getString(2), antworten, rs.getInt(3));
//			fragen.addFrage(frage); //wie kann man die frage von der DB in einem loop darstellen?
//		}
//		
//		con.close();
//		}catch(Exception e) {
//		System.out.println(e);
//	}
//	}	
//}
	
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
		Iterator <Frage> it = fragen.getFragen().iterator();
		while (it.hasNext()) {
			Frage f = it.next();
			System.out.println(f);
		}
	}
	public FrageSammlung getFragen() {
		return fragen;
	}
	public void setFragen(FrageSammlung fragen) {
		this.fragen = fragen;
	}
	}
