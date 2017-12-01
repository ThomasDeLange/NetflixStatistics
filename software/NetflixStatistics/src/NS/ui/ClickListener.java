package NS.ui;

import NS.applicationlogic.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {


    private Calculator calc;
    private JLabel label;
    public ClickListener(Calculator calc, JLabel label){
        this.calc = calc;
        this.label = label;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        calc.increase();
        label.setText("" + calc.giveValue());
    }
}

