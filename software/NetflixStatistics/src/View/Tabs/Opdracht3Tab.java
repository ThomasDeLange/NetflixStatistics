package View.Tabs;

import Controller.ClickListener;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht3Tab extends Tab{


    public Opdracht3Tab(SqlConnection sqlConnection) {
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

        String[] accountDropdownItems = new String[]{"1215426", "5602533", "5285824"};
        JComboBox accountDropdown = new JComboBox(accountDropdownItems);

        dropdownPanel.add(new JLabel("Kies een account"));
        dropdownPanel.add(accountDropdown);

        //JButton runButton = new JButton("Voer uit!");
        //dropdownPanel.add(runButton);


        hoofdPanel.add(dropdownPanel);

        //OpdrachtLabel
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.setLayout(new FlowLayout());

        JLabel opdrachtLabel = new JLabel("Welke films zijn er door een door de gebruiker geselecteerd account bekeken?");
        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);

        //Table
        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"Volgnummer", "Titel"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        hoofdPanel.add(resultTable);
        hoofdPanel.add(new JScrollPane(resultTable));


        //Clicklistener
        ClickListener clickListener = new ClickListener(accountDropdown,resultTable, super.getSqlConnection(), resultTableModel, "Opdracht3");
        accountDropdown.addActionListener(clickListener);

        return hoofdPanel;
    }
}
