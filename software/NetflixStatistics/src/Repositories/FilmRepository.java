package Repositories;

import Objects.Account;
import Objects.Film;
import applicationlogic.SqlConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class FilmRepository {

    private SqlConnection sqlConnection;

    public FilmRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public String longestFilmUnder16() {
        String returnString = new String();
        try
        {String sqlQuery = "SELECT MAX(Tijdsduur), MAX(Leeftijd), MAX(Titel) \n" +
                    "FROM Film INNER JOIN Content\n" +
                    "ON Content.ContentID=Film.ContentID\n" +
                    "WHERE Leeftijd < 16\n";
            ResultSet resultSet = sqlConnection.executeSql(sqlQuery);
            while (resultSet.next()) {
                String em = resultSet.getString("(No column name), (No column name), (No column name)");
                returnString = em.replace("\n", ",");

            }


        }
        catch(Exception e) {
            System.out.println(e);
        }
        return returnString;
    }
}
