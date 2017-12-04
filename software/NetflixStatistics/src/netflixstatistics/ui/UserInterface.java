package netflixstatistics.ui;

import netflixstatistics.applicationlogic.TaskExecutor;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    ClickListener clickListener;
    TaskExecutor taskExecutor;

    public UserInterface(){}


    @Override
    public void run() {
        frame = new JFrame("NetflixStatistics");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2, 1);
        container.setLayout(layout);


        JLabel amount = new JLabel("0");
        JButton clickButton = new JButton("getboektitel");
        taskExecutor = new TaskExecutor();
        clickListener = new ClickListener(amount, taskExecutor);

        clickButton.addActionListener(clickListener);

        container.add(amount);
        container.add(clickButton);

    }

    public JFrame getFrame() {
        return frame;
    }
}
