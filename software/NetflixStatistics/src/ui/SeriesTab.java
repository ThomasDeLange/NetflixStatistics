package ui;

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

        JPanel subpanel1 = new JPanel();
        subpanel1.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Selecteer serie");
        label1.setFont(font);
        JComboBox dropdown = new JComboBox();

        subpanel1.add(label1);
        subpanel1.add(dropdown);
        seriesPanel.add(subpanel1, BorderLayout.NORTH);

        JPanel subpanel2 = new JPanel();
        subpanel2.setBorder(BorderFactory.createTitledBorder("Gemiddeld percentage bekeken per aflevering"));
        subpanel2.setLayout(new GridLayout(1, 1));


        JTable table = new JTable();
        subpanel2.add(table);
        seriesPanel.add(subpanel2, BorderLayout.CENTER);

        return seriesPanel;
    }
}
