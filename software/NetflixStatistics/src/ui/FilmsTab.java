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

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Selecteer film");
        label1.setFont(font);

        JComboBox dropdown = new JComboBox();

        topPanel.add(label1);
        topPanel.add(dropdown);

        filmsPanel.add(topPanel, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(BorderFactory.createTitledBorder("Gemiddeld percentage bekeken per account"));
        tablePanel.setLayout(new GridLayout(1, 1));

        JTable table = new JTable();

        tablePanel.add(table);

        filmsPanel.add(tablePanel, BorderLayout.CENTER);


        return filmsPanel;
    }
}
