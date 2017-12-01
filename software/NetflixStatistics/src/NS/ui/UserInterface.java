package NS.ui;

import NS.applicationlogic.Calculator;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private Calculator calc;
    private JFrame frame;


    public UserInterface(Calculator calc){
        this.calc = calc;
    }


    @Override
    public void run() {
        frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    private void createComponents(Container container) {
        container.setLayout(new GridLayout(2, 1));

        JLabel label = new JLabel("" + calc.giveValue());
        container.add(label);

        JButton button = new JButton("Click!");
        container.add(button);

        ClickListener listener = new ClickListener(calc, label);
        button.addActionListener(listener);

    }
}


