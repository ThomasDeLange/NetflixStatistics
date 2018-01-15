package Controller;

import Model.SqlConnection;
import Model.TaskExecutor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
ClickListener
Constructor:
1. 3 verschillende constructors voor als er geen, 1 of 2 inputs zijn
2. Haalt alle informatie op die nodig zijn voor het aanmaken van de TaskExecutor en de TableFiller en het aanpassen van een table

actionPerformed():
1. Ontvangt als er een actie is gebeurd(ComboBox, TextFied, Button)
2. Ontvangt een taskID
3. Stuurt de taskId naar TaskExecutor
4. Verwijderd de inhoud van een tabel
5. Ontvangt avn TaskExecutor het resultaat van de uitgevoerde querry
6. Test of de resultString leeg is en bepaald daarmee of de noData label op visible wordt gezet of niet
7. Voegt de gekregen ResultSet toe aan de tabel

 */

public class ClickListener implements ActionListener {
    private Object input1;
    private Object input2;
    private TaskExecutor taskExecutor;
    private TableEditor tableEditor;
    private String taskId;
    private JLabel noDataLabel;

    //0 input
    public ClickListener(JTable resultTable, SqlConnection sqlConnection, DefaultTableModel tableModel, String taskID, JLabel noDataLabel) {
        this.taskId = taskID;
        this.noDataLabel = noDataLabel;

        tableEditor = new TableEditor(tableModel, resultTable);
        taskExecutor = new TaskExecutor(sqlConnection);
    }

    //1 input
    public ClickListener(Object input, JTable resultTable, SqlConnection sqlConnection, DefaultTableModel tableModel, String taskID, JLabel noDataLabel) {
        this.input1 = input;
        this.taskId = taskID;
        this.noDataLabel = noDataLabel;


        tableEditor = new TableEditor(tableModel, resultTable);
        taskExecutor = new TaskExecutor(sqlConnection, input1);
    }

    //2 input
    public ClickListener(Object input, Object input2, JTable resultTable, SqlConnection sqlConnection, DefaultTableModel tableModel, String taskID, JLabel noDataLabel) {
        this.input1 = input;
        this.input2 = input2;
        this.taskId = taskID;
        this.noDataLabel = noDataLabel;


        tableEditor = new TableEditor(tableModel, resultTable);
        taskExecutor = new TaskExecutor(sqlConnection, input1, input2);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        tableEditor.emptyTable();
        ResultSet resultSet = null;
        resultSet = taskExecutor.runTask(taskId);


        try {
            if (!resultSet.isBeforeFirst()) {
                noDataLabel.setVisible(true);
            } else {
                noDataLabel.setVisible(false);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableEditor.fillTable(resultSet);

    }
}
