package netflixstatistics.ui;

import netflixstatistics.applicationlogic.TaskExecutor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {
    private JLabel object;
    private TaskExecutor taskExecutor;

    public ClickListener(JLabel object, TaskExecutor taskExecutor){
        this.object = object;
        this.taskExecutor = taskExecutor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String result = taskExecutor.runTask(e.getActionCommand());
        object.setText(result);
    }
}
