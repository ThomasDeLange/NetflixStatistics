package Clicklistener;


import applicationlogic.SqlConnection;
import applicationlogic.TaskExecutor;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/*
ClickListener
1. Ontvangt als er een actie is gebeurd(ComboBox, TextFied, Button)
2. Ontvangt een taskID
3. Stuurt de taskId naar TaskExecutor
4. Verwijderd de inhoud van een tabel
5. Ontvangt avn TaskExecutor het resultaat van de uitgevoerde querry
6. Voegt de gekregen ResultSet toe aan de tabel


 */

public class ClickListener implements ActionListener {
    private JTextArea object;
    private TaskExecutor taskExecutor;
    private TableEditor tableEditor;
    private DefaultTableModel tableModel;
    private String taskId;

    public ClickListener(JTable resultTable, JComboBox input, SqlConnection sqlConnection, DefaultTableModel tableModel, String taskID){
        this.object = object;
        this.taskExecutor = taskExecutor;
        this.tableModel = tableModel;
        this.taskId = taskID;
        tableEditor = new TableEditor(tableModel, resultTable);
        taskExecutor = new TaskExecutor(sqlConnection, tableModel, resultTable, input);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        tableEditor.emptyTable();
        ResultSet resultSet = taskExecutor.runTask(taskId);
        tableEditor.fillTable(resultSet);

    }
}
