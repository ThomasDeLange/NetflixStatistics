package View.Tabs;

import Controller.ClickListener;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht2Tab extends Tab {


    public Opdracht2Tab(SqlConnection sqlConnection) {
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


        String[] serieDropdwonItems = new String[]{"Fargo", "Breaking Bad", "Sherlock"};
        JComboBox<String> serieDropdown = new JComboBox<>(serieDropdwonItems);

        String[] accountDropdownItems = new String[]{"1215426", "5602533", "5285824"};
        JComboBox<String> accountDropdown = new JComboBox<>(accountDropdownItems);

        dropdownPanel.add(new JLabel("Kies een account"));
        dropdownPanel.add(accountDropdown);
        dropdownPanel.add(new JLabel("Kies een serie"));
        dropdownPanel.add(serieDropdown);
        JButton runButton = new JButton("Voer uit!");
        dropdownPanel.add(runButton);


        hoofdPanel.add(dropdownPanel);

        //OpdrachtLabel
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.setLayout(new FlowLayout());

        JLabel opdrachtLabel = new JLabel("Voor een door de gebruiker geselecteerde account en serie, geef per aflevering het gemiddeld bekeken % van de tijdsduur.");
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
        //Eerst account dan serie
        ClickListener clickListener = new ClickListener(accountDropdown, serieDropdown, resultTable, super.getSqlConnection(), resultTableModel, "Opdracht2");
        runButton.addActionListener(clickListener);

        return hoofdPanel;
    }
}

