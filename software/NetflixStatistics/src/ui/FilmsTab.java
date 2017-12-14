package ui;

import applicationlogic.SqlConnection;
import applicationlogic.TaskExecutor;

import javax.swing.*;
import java.awt.*;

public class FilmsTab {
    private Font font;

    public FilmsTab(Font font) {
        this.font = font;
    }

    public JPanel getFilmsTab() {

        JPanel filmsPanel = new JPanel();
        filmsPanel.setLayout(new BorderLayout());

        JPanel subpanel1 = new JPanel();
        subpanel1.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Selecteer film");
        label1.setFont(font);
        JComboBox dropdown = new JComboBox();

        subpanel1.add(label1);
        subpanel1.add(dropdown);
        filmsPanel.add(subpanel1, BorderLayout.NORTH);

        JPanel subpanel2 = new JPanel();
        subpanel2.setBorder(BorderFactory.createTitledBorder("Gemiddeld percentage bekeken per account"));
        subpanel2.setLayout(new GridLayout(3, 1));


        JTable table = new JTable();
        subpanel2.add(table);
        filmsPanel.add(subpanel2, BorderLayout.CENTER);

        JButton button = new JButton("GetAccountNummers");
        JLabel label = new JLabel("laallalalalalal");
        ClickListener clickListener = new ClickListener(label, new TaskExecutor(new UserInterface()));

        button.addActionListener(clickListener);
        subpanel2.add(label);
        subpanel2.add(button);



        return filmsPanel;
    }
}
