package NS.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {
    private JLabel object;

    public ClickListener(JLabel object){
        this.object = object;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        object.setText("test");
    }
}
