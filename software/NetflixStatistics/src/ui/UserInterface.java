package ui;

import applicationlogic.DatabaseController;
import applicationlogic.TaskExecutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserInterface implements Runnable {
    private JFrame frame;
    ClickListener clickListener;
    TaskExecutor taskExecutor;
    DatabaseController databaseController;

    public UserInterface(){
        databaseController = new DatabaseController();
    }


    @Override
    public void run() {
        frame = new JFrame("NetflixStatistics");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure to close this window?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    databaseController.close();
                    System.exit(0);
                }
            }
        });

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2, 1);
        container.setLayout(layout);


        JLabel amount = new JLabel("0");
        JButton clickButton = new JButton("getboektitel");
        taskExecutor = new TaskExecutor(databaseController);
        clickListener = new ClickListener(amount, taskExecutor);

        clickButton.addActionListener(clickListener);

        container.add(amount);
        container.add(clickButton);

    }

    public JFrame getFrame() {
        return frame;
    }
}
