package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
SQL connection

connectDatabase():
1. Probeert een verbinding te maken met de database aan de hand van een connection string die meegegeven wordt

disconnectDatabase()
1. Kan de verbinding weer sluiten met de database

executeSql():
1. Ontvangt een sql querry
2. Voert de querry uit op de database
3. Returned een resultset

Voert sql uit met en zonder restultaat

*/
public class SqlConnection {


    private Connection connection = null;

    public boolean connectDatabase(String connectionUrl) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(connectionUrl);
            System.out.println("connected to database");
        } catch (Exception e) {
            System.out.println(e);
            connection = null;
            return false;
        }
        return true;
    }

    public void disconnectDatabase() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            connection = null;
        }
    }

    //Voert sql die gegevens opvraagd
    public ResultSet executeSql(String sqlQuery) {
        ResultSet resultSet = null;
        try {
            Statement statement = this.connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }


}
