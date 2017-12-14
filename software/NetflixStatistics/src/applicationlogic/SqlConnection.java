package applicationlogic;

import java.sql.*;
/*
SQL connection

Zet de connectie op
Disconnect met de database

Voert sql uit met en zonder restultaat

*/
public class SqlConnection {

    private Connection connection = null;

    public boolean connectDatabase(String connectionUrl) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(connectionUrl);
            System.out.println("connected to database");
        }
        catch(Exception e)
        {
            System.out.println(e);
            connection=null;
            return false;
        }
        return true;
    }

    public void disconnectDatabase() {
        if (connection != null) {
            try {
                connection.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
            connection=null;
        }
    }
    //Voert sql die gegeven opvraagd
    public ResultSet executeSql(String sqlQuery) {
        ResultSet resultSet = null;
        try
        {
            Statement statement = this.connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return resultSet;
    }
    //voert sql uit die toevoegd of detete
    public boolean executeSqlNoResult(String sqlQuery) {
        try
        {
            Statement statement = this.connection.createStatement();
            return statement.execute(sqlQuery);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
}
