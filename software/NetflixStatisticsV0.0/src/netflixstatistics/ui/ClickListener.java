package netflixstatistics.ui;

import netflixstatistics.applicationlogic.TaskExecutor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClickListener implements ActionListener {
    private JLabel object;
    private TaskExecutor taskExecutor;

    public ClickListener(JLabel object, TaskExecutor taskExecutor){
        this.object = object;
        this.taskExecutor = taskExecutor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String r = e.getActionCommand();
        ArrayList<String> result = taskExecutor.runTask(r);
        for (String s : result) {
            System.out.println(s);

        }


        object.setText("efef");
    }
}
