package View.Tabs;

import Controller.ClickListener;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht1Tab extends Tab {

    public Opdracht1Tab(SqlConnection sqlConnection) {
        super(sqlConnection);
    }

    @Override
    public JPanel createComponents() {

        //Setup hoofdpanel
        JPanel hoofdPanel = new JPanel();
        hoofdPanel.setLayout(new BoxLayout(hoofdPanel, BoxLayout.Y_AXIS));

        /*
        DataPanel - Dropdown Panel, OpdrachtLabel, Table
        */

        //Components

        //Dropdown panel - Label, Dropdown
        JPanel dropdownPanel = new JPanel();
        dropdownPanel.setLayout(new FlowLayout());

        dropdownPanel.add(new JLabel("Kies een serie"));

        String[] items = new String[]{"Fargo", "Breaking Bad", "Sherlock"};
        JComboBox<String> opdracht1Dropdown = new JComboBox<>(items);

        dropdownPanel.add(opdracht1Dropdown);

        hoofdPanel.add(dropdownPanel);

        //OpdrachtLabel
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.setLayout(new FlowLayout());
        JLabel opdrachtLabel = new JLabel("Geeft per aflevering het gemiddeld bekeken percentage van de tijdsduur.");

        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);

        //Table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new FlowLayout());

        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"Volgnummer", "Titel", "Percentage gemiddeld bekeken"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);

        //Clicklistener
        ClickListener clickListener = new ClickListener(opdracht1Dropdown, resultTable, super.getSqlConnection(), resultTableModel, "Opdracht1");
        opdracht1Dropdown.addActionListener(clickListener);

        return hoofdPanel;
    }


}

