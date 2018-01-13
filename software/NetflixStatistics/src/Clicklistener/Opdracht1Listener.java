package Clicklistener;

import applicationlogic.SqlConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/*

Opdracht1Listener

Als er op de bijbehorende knop wordt gedrukt wordt actionPerformed()
Regelt het afsluiten van het programma
Zet de connectie op van de database
 */

public class Opdracht1Listener implements ActionListener {

    private JTable resultTable;
    private SqlConnection sqlConnection;
    private JTextArea input;
    private DefaultTableModel tableModel;

    public Opdracht1Listener(JTable resultTable, JTextArea input, SqlConnection sqlConnection, DefaultTableModel tableModel) {
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
                                                                "WHERE Content.Titel =" + "'" + input.getText() + "'" + "\n" +
                                                                "GROUP BY Bekeken.AfleveringID, Aflevering.Titel");
        try {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnnNumber = rsmd.getColumnCount();
            while(resultSet.next()){
                Object[] objects = new Object[columnnNumber];

                for(int i=0; i<columnnNumber; i++){
                    objects[i]=resultSet.getObject(i+1);
                }
                tableModel.addRow(objects);
            }
            resultTable.setModel(tableModel);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
