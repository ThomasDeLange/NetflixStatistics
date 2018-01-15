package View.Tabs;

import Controller.ClickListener;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/*
Opdracht5Tab:
1. Extend de Tab class

createComponents():
1. Elke tab maakt components aan die in de hoofdlayout gezet worden
2. Volgorde is altijd:
Setup van het hoofdpaneel
een Dropdown of Button of geen panel waar de gebruiker input kan selecteren
Een infoPanel waar de informatie over de opdracht wordt getoont en waar staat als een zoekopdracht geen resultaat heeft
Een table waar de data in komt
Een clicklistener die wordt toegevoeg aan een button of een combobox
*/

public class Opdracht5Tab extends Tab {

    public Opdracht5Tab(SqlConnection sqlConnection) {
        super(sqlConnection);
    }

    @Override
    public JPanel createComponents() {

        //Setup hoofdpanel
        JPanel hoofdPanel = new JPanel();
        hoofdPanel.setLayout(new BoxLayout(hoofdPanel, BoxLayout.Y_AXIS));

        //Components

        //Button
        JButton runButton = new JButton("Voer uit!");

        //Info Panel
        JLabel opdrachtLabel = new JLabel("Helaas er is geen data beschikbaar om te laten zien");
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);

        JLabel noDataLabel = new JLabel("Helaas met de opgegeven zoektermen zijn er geen resultaaten");
        JPanel noDataLabelPanel = new JPanel();
        noDataLabelPanel.add(noDataLabel);
        noDataLabel.setVisible(false);
        hoofdPanel.add(noDataLabelPanel);

        //Table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new FlowLayout());

        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"Accountnummer", "Accountnaam", "Profielnaam"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);

        //Clicklistener
        ClickListener clickListener = new ClickListener(resultTable, super.getSqlConnection(), resultTableModel, "Opdracht5", noDataLabel);
        runButton.addActionListener(clickListener);

        runButton.doClick();

        return hoofdPanel;
    }
}
