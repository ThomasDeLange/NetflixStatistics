package net.viralpatel.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	private static String JDBC_CONNECTION_URL = "jdbc:sqlserver://thomasserver.database.windows.net:1433;database=NetflixStatistics;user=Thomas@thomasserver;password={admin123!};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

	
	public static void main(String[] args) {
		try {

			CSVLoader loader = new CSVLoader(getCon());
			loader.loadCSV("/Users/thomas/Downloads/Load_CSV_Database_Java_example/Aflevering tabel.csv", "Aflevering", true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection getCon() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(JDBC_CONNECTION_URL);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
