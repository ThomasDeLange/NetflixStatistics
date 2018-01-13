package Clicklistener;

import applicationlogic.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Opdracht2Listener implements ActionListener {

    private JTable resultTable;
    private SqlConnection sqlConnection;
    private JTextArea input;
    private DefaultTableModel tableModel;

    public Opdracht2Listener(JTable resultTable, DefaultTableModel tableModel, JTextArea inputSerieTitel, JTextArea inputAccountNR, SqlConnection sqlConnection) {
        this.resultTable = resultTable;
        this.input = input;
        this.sqlConnection = sqlConnection;
        this.tableModel = tableModel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ResultSet resultSet = sqlConnection.executeSql("SELECT Bekeken.AfleveringID, Aflevering.Titel, AVG(Bekeken.ProcentGezien) as gemiddeldBekekenPercentage\n" +
                                                                "FROM Bekeken\n" +
                                                                "INNER JOIN Aflevering\n" +
                                                                "ON Aflevering.AfleveringID = Bekeken.AfleveringID\n" +
                                                                "INNER JOIN Content\n" +
                                                                "ON Content.ContentID = Aflevering.ContentID\n" +
                                                                "INNER JOIN Account\n" +
                                                                "ON Account.AccountNR = Bekeken.AccountNR\t\n" +
                                                                "WHERE\tContent.Titel = 'Sherlock'\n" +
                                                                "\t\tAND\n" +
                                                                "\t\tAccount.AccountNR = '1215426'\n" +
                                                                "GROUP BY Bekeken.AfleveringID, Aflevering.Titel\n");

    }
}
