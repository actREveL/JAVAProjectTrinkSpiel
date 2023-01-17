package ch.fhgr.java.trinkspiel.logik;

import java.util.Iterator;
import java.sql.*;

public class FrageInitialisator {
	public void initaliseTestQuestions() { 
		try {
		
			// 1 - Register driver
			Class.forName(DbConfiguration.DRIVER);
			
			// 2 - Get connection
			Connection con = DriverManager.getConnection(
					DbConfiguration.buildURL(), DbConfiguration.USER, DbConfiguration.PASSWORT);
			
			// 3
			Statement stmt = con.createStatement(); 
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM FragenDatenbank");
			while(rs.next()) {
				Frage frage = new Frage(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				fragen.addFrage(frage); // Frage von der DB in einem loop dargestellt
			}
			
			// 5
			con.close();
			
			} 
		catch(Exception e) {
			System.out.println(e);
			}
		}	
	
	
	private FrageSammlung fragen = new FrageSammlung();
	
		
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
