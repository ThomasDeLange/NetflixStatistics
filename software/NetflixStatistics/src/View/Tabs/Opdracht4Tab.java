package View.Tabs;

import Controller.ClickListener;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht4Tab {
    private Font font;
    private SqlConnection sqlConnection;

    public Opdracht4Tab(Font font, SqlConnection sqlConnection) {
        this.font = font;
        this.sqlConnection = sqlConnection;
    }

    public JPanel createComponents() {

        //Setup hoofdpanel
        JPanel hoofdPanel = new JPanel();
        hoofdPanel.setLayout(new BorderLayout());
        
        //Opdracht
        hoofdPanel.setBorder(BorderFactory.createTitledBorder("Geef de film met de langste tijdsduur voor kijkers onder 16 jaar"));

        //Button
        JButton runButton = new JButton("Voer uit!");
        hoofdPanel.add(runButton, BorderLayout.SOUTH);

        //Table
        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"Volgnummer", "Titel", "Percentage gemiddeld bekeken"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        hoofdPanel.add(resultTable);
        hoofdPanel.add(new JScrollPane(resultTable));


        //Clicklistener
        ClickListener clickListener = new ClickListener(resultTable, sqlConnection, resultTableModel, "Opdracht4");
        runButton.addActionListener(clickListener);

        return hoofdPanel;
    }
}
