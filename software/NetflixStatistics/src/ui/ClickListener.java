package ui;


import applicationlogic.SqlConnection;
import applicationlogic.TaskExecutor;
import javafx.concurrent.Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
ClickListener
1. Ontangt als een knop op het scherm is ingedrukt
2. Ontvangt de bijbehorende taskId van de knop
3. Stuurt de taskId naar TaskExecutor
4. Ontvangt avn TaskExecutor het resultaat van de uitgevoerde querry
5. Toont het resultaat op het scherm

 */

public class ClickListener implements ActionListener {
    private JTextArea object;
    private TaskExecutor taskExecutor;

    public ClickListener(JTextArea object, TaskExecutor taskExecutor){
        this.object = object;
        this.taskExecutor = taskExecutor;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String task = event.getActionCommand();

        taskExecutor.runTask(task);

        object.setText(taskExecutor.runTask(task));

    }
}
