package Model;

import javax.print.DocFlavor;
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

        switch (fillWith){

            case "FilmTitels" :
                ResultSet filmTitels = sqlConnection.executeSql("" +
                        "SELECT Content.Titel\n" +
                        "FROM Content\n" +
                        "INNER JOIN Film\n" +
                        "ON Film.ContentID = Content.ContentID\n");

                ArrayList<String> filmTitelsArray = new ArrayList<>();

                while (filmTitels.next()) {
                    filmTitelsArray.add(filmTitels.getString(1));
                }
                jComboBox = new JComboBox<>(filmTitelsArray.toArray());
                break;
        }
        return  jComboBox;
    }
}
