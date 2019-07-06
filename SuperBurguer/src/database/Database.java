package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String SQL_USERNAME = "root";
	private static final String SQL_PASSWORD = "";
	private static final String DATABASE_NAME = "software_advocacia";
	
	private static Connection singletonConnection = null;
	
	public Database() {
		getSingletonConnection();
	}
	
	public static Connection getSingletonConnection(){
		if(singletonConnection==null) {
			try {
				Class.forName(DRIVER);
				singletonConnection = DriverManager.getConnection(URL, SQL_USERNAME, SQL_PASSWORD);
			} catch(Exception ex) {
				System.err.println("Não foi possível iniciar conexão com o banco de dados.\n" + ex.getMessage());
			}
		}
		
		return singletonConnection;
	}

}
