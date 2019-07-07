package main;

public class SoftwareInfo {
	
	// DATABASE
		private final static String DB_HOST = "localhost";
		private final static String DB_PORT = "3306";
		private static final String DB_NAME = "superburguer";
		
		public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
		public static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
		public static final String DB_USERNAME = "root";
		public static final String DB_PASSWORD = null;
		public static final String DB_CHARSET = "utf8";

}
