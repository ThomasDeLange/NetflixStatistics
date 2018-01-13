package Clicklistener;

import applicationlogic.SqlConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


/*

Opdracht1Listener

Als er op de bijbehorende knop wordt gedrukt wordt actionPerformed()
Regelt het afsluiten van het programma
Zet de connectie op van de database
 */

public class  Opdracht1Listener implements ActionListener {

    private JTable resultTable;
    private SqlConnection sqlConnection;
    private Object input;
    private DefaultTableModel tableModel;
    private TableEditor tableEditor;

    public Opdracht1Listener(JTable resultTable, Object input, SqlConnection sqlConnection, DefaultTableModel tableModel) {
        this.resultTable = resultTable;
        this.input = input;
        this.sqlConnection = sqlConnection;
        this.tableModel = tableModel;
        tableEditor = new TableEditor(tableModel, resultTable);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        tableEditor.emptyTable();

        ResultSet resultSet = sqlConnection.executeSql("SELECT Bekeken.AfleveringID, Aflevering.Titel, AVG(Bekeken.ProcentGezien) as gemiddeldBekekenPercentage\n" +
                                                                "FROM Bekeken\n" +
                                                                "INNER JOIN Aflevering\n" +
                                                                "ON Aflevering.AfleveringID = Bekeken.AfleveringID\n" +
                                                                "INNER JOIN Content\n" +
                                                                "ON Content.ContentID = Aflevering.ContentID\n" +
                                                                "WHERE Content.Titel =" + "'" + input + "'" + "\n" +
                                                                "GROUP BY Bekeken.AfleveringID, Aflevering.Titel");

        tableEditor.fillTable(resultSet);
    }
}
