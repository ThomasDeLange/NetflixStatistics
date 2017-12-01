package clicker.ui;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    ClickListener clickListener;

    public UserInterface(){}


    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2, 1);
        container.setLayout(layout);

        JLabel amount = new JLabel("0");
        JButton clickButton = new JButton("Click!");
        clickListener = new ClickListener(amount);
        clickButton.addActionListener(clickListener);

        container.add(amount);
        container.add(clickButton);

    }

    public JFrame getFrame() {
        return frame;
    }
}
