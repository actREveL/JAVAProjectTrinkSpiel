package ch.fhgr.java.trinkspiel.logik;

public class DbConfiguration {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL_BASE = "jdbc:mysql://";
	public static final String IP = "10.0.251.88";
	public static final int PORT = 3306;
	public static final String DBNAME = "trinkspiel";
	public static final String USER = "trinkspiel";
	public static final String PASSWORT = "trinkspiel";
	
	public static String buildURL() {
		return DbConfiguration.URL_BASE + DbConfiguration.IP + ":" + 
				DbConfiguration.PORT + "/" + DbConfiguration.DBNAME;
}
}
