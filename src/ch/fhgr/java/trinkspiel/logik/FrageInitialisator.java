package ch.fhgr.java.trinkspiel.logik;

import java.util.ArrayList;
import java.util.Iterator;
import java.sql.*;

public class FrageInitialisator {
	public void initaliseTestQuestions() {
		try {
		
			// 1 - Register driver
			Class.forName(DbConfiguration.DRIVER);
			
			// 2 - Get connection
			// First parameter: localhost is when db is local. Otherwise give IP,
			// Connection con= DriverManager.getConnection(
			//                       "jdbc:mysql://localhost:3306/trinkspiel",  
			//                       "trinkspiel", "trinkspiel");
			Connection con = DriverManager.getConnection(
					DbConfiguration.buildURL(), DbConfiguration.USER, DbConfiguration.PASSWORT);
			
			// 3
			Statement stmt = con.createStatement(); 
			
			// 4 (Tabelle kreieren und einfügen - bruchemer ned!)
			/*System.out.println("Testtabelle kreieren");
			
			stmt.executeUpdate(
				"create table testtable(id INTEGER not NULL AUTO_INCREMENT, " 
				+ "name VARCHAR(255), PRIMARY KEY (id));");
			
			System.out.println("Inhalte in Tabelle einfügen...");
			String sql = "INSERT INTO testtable(name) VALUES ('Puce')";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO testtable(name) VALUES ('Lana')";
			stmt.executeUpdate(sql);
			
			*/ 
			/* System.out.println("Test prepared statetement");
	         PreparedStatement stmt1 = con.prepareStatement("insert into testtable(name) values(?)");  
	         //stmt1.setInt(1, 101); //1 specifies the first parameter in the query  
	         stmt1.setString(1, "Marie");  
	           
	         int i= stmt1.executeUpdate();  
	         System.out.println(i+" records inserted");  

	         stmt1.setString(1, "Phil");  
	         stmt1.executeUpdate();   
			
			System.out.println("Inhalte der Tabelle lesen...");*/
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Fragentrinkspiel");
			while(rs.next()) {
				//System.out.println(rs.getString(2) + " : " + rs.getString(1));
				ArrayList<String> antworten = new ArrayList<String>();
				antworten.add(rs.getString(1));
				Frage frage = new Frage(rs.getString(2), antworten, rs.getInt(3));
				fragen.addFrage(frage); //wie kann man die frage von der DB in einem loop darstellen?
		}
			
			// 5
			con.close();
			
			} catch(Exception e) {
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
