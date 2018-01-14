package Repositories;

import Objects.Account;
import applicationlogic.SqlConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountRepository {
    private SqlConnection sqlConnection;

    public AccountRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;    }

    public ArrayList<Account> readAll() {
        ArrayList<Account> lijst = new ArrayList<>();
        try {
            ResultSet resultSet = sqlConnection.executeSql("SELECT * FROM ACCOUNT");
            while(resultSet.next()) {
                lijst.add(new Account(
                        resultSet.getInt("AbonneeNR"),
                        resultSet.getString("Naam"),
                        resultSet.getString("Straat"),
                        resultSet.getString("Postcode"),
                        resultSet.getString("Huisnummer"),
                        resultSet.getString("woonPlaats")));
            }
        }
        catch(Exception e) {
            System.out.println(e + "Geen database connectie");
        }
        return lijst;
    }

    public Account read(int abonneeNR) {
        Account account = null;
        try
        {
            String sqlQuery = "SELECT * FROM Account WHERE AbonneeNR=" + abonneeNR;
            ResultSet resultSet = sqlConnection.executeSql(sqlQuery);
            resultSet.next();
            account = new Account(resultSet.getInt(
                    "AbonneeNR"),
                    resultSet.getString("Naam"),
                    resultSet.getString("Straat"),
                    resultSet.getString("Postcode"),
                    resultSet.getString("Huisnummer"),
                    resultSet.getString("WoonPlaats"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return account;
    }

    public boolean create(Account account) {
        try
        {
            String sqlQuery = "INSERT INTO ACCOUNT VALUES (" + account.getAbonneenummer() + ", '" + account.getNaam() + "', '" + account.getStraat() + "', '" + account.getPostcode() + "', '" + account.getHuisnummer() + "', '" + account.getPlaats();
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Account account) {
        if(account==null) return false;
        return delete(account.getAbonneenummer());
    }

    public boolean delete(int id) {
        try
        {
            String sqlQuery = "DELETE ACCOUNT WHERE Id=" + id;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}