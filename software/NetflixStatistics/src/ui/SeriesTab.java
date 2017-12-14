package ui;

import applicationlogic.TaskExecutor;

import javax.swing.*;
import java.awt.*;

public class SeriesTab {
    private Font font;

    public SeriesTab(Font font) {
        this.font = font;
    }


    public JPanel getSeriesTab() {
        JPanel seriesPanel = new JPanel();
        seriesPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Selecteer serie");
        label1.setFont(font);

        JComboBox dropdown = new JComboBox();

        topPanel.add(label1);
        topPanel.add(dropdown);

        seriesPanel.add(topPanel, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(BorderFactory.createTitledBorder("Gemiddeld percentage bekeken per aflevering"));
        tablePanel.setLayout(new GridLayout(1, 3));

        JTable table = new JTable();

        tablePanel.add(table);

        seriesPanel.add(tablePanel, BorderLayout.CENTER);

        //Test knoppen hoi plz dont remove github

        JButton button = new JButton("GetAccountNummers");
        JLabel label = new JLabel("Plz werk");

        UserInterface userInterface = new UserInterface();
        TaskExecutor taskExecutor = new TaskExecutor(userInterface);
        ClickListener clickListener = new ClickListener(label, taskExecutor);

        button.addActionListener(clickListener);

        tablePanel.add(label);
        tablePanel.add(button);

        return seriesPanel;
    }
}
