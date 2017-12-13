package Repositories;

import Objects.Account;
import applicationlogic.SqlConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountRepository {
    private SqlConnection sqlConnection;

    public AccountRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Account> readAll() {
        ArrayList<Account> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM ACCOUNT");
            while(rs.next()) {
                lijst.add(new Account(rs.getInt("Abonneenr"), rs.getString("Naam"), rs.getString("Straat"), rs.getString("Postcode"), rs.getString("Huisnummer"), rs.getString("woonPlaats")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Account read(int id) {
        Account account = null;
        try
        {
            String sqlQuery = "SELECT * FROM STUDENTS WHERE Id=" + id;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            account = new Account(rs.getInt("Abonneenummer"), rs.getString("Naam"), rs.getString("Straat"), rs.getString("Postcode"), rs.getString("Huisnummer"), rs.getString("Plaats"));
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
