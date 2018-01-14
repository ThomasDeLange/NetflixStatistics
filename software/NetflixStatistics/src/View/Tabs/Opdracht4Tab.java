package View.Tabs;

import Controller.ClickListener;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht4Tab {
    private SqlConnection sqlConnection;

    public Opdracht4Tab(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

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

        JButton runButton = new JButton("Voer uit!");
        dropdownPanel.add(runButton);


        hoofdPanel.add(dropdownPanel);

        //OpdrachtLabel
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.setLayout(new FlowLayout());

        JLabel opdrachtLabel = new JLabel("Geef de film met de langste tijdsduur voor kijkers onder 16 jaar.");
        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);

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
