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
        JLabel opdrachtLabel = new JLabel("Dit overzicht geeft de accounts met één profiel.");
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);

        JLabel noDataLabel = new JLabel("Helaas er is geen resultaat voor het overzicht");
        JPanel noDataLabelPanel = new JPanel();
        noDataLabel.setVisible(false);
        hoofdPanel.add(noDataLabelPanel);


        //Table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(1,1));

        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"Accountnummer", "Accountnaam", "Profielnaam"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);

        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


        //Clicklistener
        ClickListener clickListener = new ClickListener(resultTable, super.getSqlConnection(), resultTableModel, "Opdracht5", noDataLabel);
        runButton.addActionListener(clickListener);

        runButton.doClick();

        return hoofdPanel;
    }
}
