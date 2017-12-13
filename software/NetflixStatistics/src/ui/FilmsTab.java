package ui;

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
        subpanel2.setLayout(new GridLayout(1, 1));


        JTable table = new JTable();
        subpanel2.add(table);
        filmsPanel.add(subpanel2, BorderLayout.CENTER);


        return filmsPanel;
    }
}
