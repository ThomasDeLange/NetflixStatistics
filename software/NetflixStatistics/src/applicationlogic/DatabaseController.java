package applicationlogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseController {
    private String connectionUrl = "jdbc:sqlserver://thomasserver.database.windows.net:1433;database=NetflixStatistics;user=Thomas@thomasserver;password={admin123!};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public DatabaseController(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }

    public ArrayList<String> getStrings(String SQL, String collumnName){
        ArrayList<String> output = new ArrayList<>();
        try {
            rs = stmt.executeQuery(SQL);
            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
            while (rs.next()) {
                output.add(rs.getString(collumnName));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return output;
    }

    public ArrayList<Integer> getInts(String SQL, String collumnName){
        ArrayList<Integer> output = new ArrayList<>();
        try {
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);
            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
            while (rs.next()) {
                output.add(rs.getInt(collumnName));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return output;
    }

    public void close(){
        if (rs != null) try { rs.close(); } catch(Exception e) {}
        if (stmt != null) try { stmt.close(); } catch(Exception e) {}
        if (con != null) try { con.close(); } catch(Exception e) {}
        System.out.println("database closed");
    }
}