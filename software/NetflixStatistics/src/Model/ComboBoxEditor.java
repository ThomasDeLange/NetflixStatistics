package Model;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComboBoxEditor {

    private JComboBox jComboBox;
    private SqlConnection sqlConnection;

    public ComboBoxEditor(SqlConnection sqlConnection) {
        this.jComboBox = jComboBox;
        this.sqlConnection = sqlConnection;
    }

    public JComboBox fillCombobox(JComboBox jComboBox, String fillWith) throws SQLException {

        switch (fillWith) {

            case "FilmTitels":
                ResultSet filmTitels = sqlConnection.executeSql("" +
                        "SELECT DISTINCT Content.Titel\n" +
                        "FROM Content\n" +
                        "INNER JOIN Film\n" +
                        "ON Film.ContentID = Content.ContentID\n");

                ArrayList<String> filmTitelsArray = new ArrayList<>();

                while (filmTitels.next()) {
                    filmTitelsArray.add(filmTitels.getString(1));
                }

//                for (int i = 0; i < filmTitelsArray.size(); i++) {
//                    if (filmTitelsArray.get(i).contains("'")) {
//                        filmTitelsArray.set(i, filmTitelsArray.get(i).replace("'", "''"));
//                    }
//                }


                jComboBox = new JComboBox<>(filmTitelsArray.toArray());

                break;

            case "SerieTitels":
                ResultSet serieTitels = sqlConnection.executeSql("" +
                        "SELECT DISTINCT Content.Titel\n" +
                        "FROM Content\n" +
                        "INNER JOIN Serie\n" +
                        "ON Serie.ContentID = Content.ContentID");

                ArrayList<String> serieTitelsArray = new ArrayList<>();

                while (serieTitels.next()) {
                    serieTitelsArray.add(serieTitels.getString(1));
                }
                jComboBox = new JComboBox<>(serieTitelsArray.toArray());

                break;


            case "AccountNRs":
                ResultSet accountNRs = sqlConnection.executeSql("" +
                        "SELECT DISTINCT Account.AccountNR\n" +
                        "FROM Account");

                ArrayList<String> accountsNRsArray = new ArrayList<>();


                while (accountNRs.next()) {
                    accountsNRsArray.add(accountNRs.getString(1));
                }
                jComboBox = new JComboBox<>(accountsNRsArray.toArray());

                break;
        }
        return jComboBox;
    }
}

