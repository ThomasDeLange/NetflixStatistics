package Model;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
ComboBoxEditor

Consturctor:
1. Ontvangt een JComboBox en een string met informatie wat in de combo box gestopt moet worden

fillCombobox():
1. Switched met welke gegevens de combobox gevuld moet worden
2. Als de fillWith overeenkomt met een case wordt de resultset opgehaald met de gegevens die in de combobox moeten
3. De resultSet waarde voor waarde omgezet naar een array
4. De methode returned dezefde combobox maar dan gevuld met de goede data
 */


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

