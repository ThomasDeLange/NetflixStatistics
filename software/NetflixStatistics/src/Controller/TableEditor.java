package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/*
TableEditor - 2 Methodes
Constructor:
1. Krijgt een tableModel en een JTable

fillTable()
1. Krijgt een resultset en een Jtable mee
2. Leest uit hoeveel colommen er in de resultset zitten
3. Vult de tabel met de resultset
4. Laat de table weten dat deze is geupdate

emptyTable()
1. Haalt de table die met het aanmaken van de TableEditor is aangemaakt op
2. Leegt de table
3. Laat de table weten dat deze is geupdate
 */

public class TableEditor {

    private DefaultTableModel tableModel;
    private JTable resultTable;

    public TableEditor(DefaultTableModel tableModel, JTable resultTable) {
        this.tableModel = tableModel;
        this.resultTable = resultTable;
    }

    public void fillTable(ResultSet resultSet) {
        try {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnnNumber = rsmd.getColumnCount();

            while (resultSet.next()) {
                Object[] objects = new Object[columnnNumber];

                for (int i = 0; i < columnnNumber; i++) {
                    objects[i] = resultSet.getObject(i + 1);
                }
                tableModel.addRow(objects);
            }
            resultTable.setModel(tableModel);
            tableModel.fireTableDataChanged();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void emptyTable() {
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
    }
}


