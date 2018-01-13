package Clicklistener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TableEditor {

    private ResultSet resultSet;
    private DefaultTableModel tableModel;
    private JTable resultTable;

    public TableEditor(DefaultTableModel tableModel, JTable resultTable) {
        this.resultSet = resultSet;
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
        } catch(SQLException e1) {
            e1.printStackTrace();
        }
    }
    public void emptyTable(){
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
    }
}


