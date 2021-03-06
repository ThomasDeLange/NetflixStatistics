package View.Tabs;

import Controller.ClickListener;
import Model.ComboBoxEditor;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

/*
Opdracht3Tab:
1. Extend de Tab class

createComponents():
1. Elke tab maakt components aan die in de hoofdlayout gezet worden
2. Volgorde is altijd:
Setup van het hoofdpaneel
Een Dropdown of Button of geen panel waar de gebruiker input kan selecteren
Elke combobox wordt gevuld vanuit de database
Een infoPanel waar de informatie over de opdracht wordt getoont en waar staat als een zoekopdracht geen resultaat heeft
Een table waar de data in komt
Een clicklistener die wordt toegevoeg aan een button of een combobox
 */

public class Opdracht3Tab extends Tab{

    private ComboBoxEditor comboBoxEditor;

    public Opdracht3Tab(SqlConnection sqlConnection) {
        super(sqlConnection);
        comboBoxEditor = new ComboBoxEditor(sqlConnection);
    }

    @Override
    public JPanel createComponents() throws SQLException {

        //Setup hoofdpanel
        JPanel hoofdPanel = new JPanel();
        hoofdPanel.setLayout(new BoxLayout(hoofdPanel, BoxLayout.Y_AXIS));

        //Components

        //Dropdown panel - Label, Dropdown
        JPanel dropdownPanel = new JPanel();
        dropdownPanel.setLayout(new FlowLayout());

        JComboBox accountDropdown = null;
        accountDropdown = comboBoxEditor.fillCombobox(accountDropdown, "AccountNRs");


        dropdownPanel.add(new JLabel("Kies een account"));
        dropdownPanel.add(accountDropdown);

        hoofdPanel.add(dropdownPanel);

        //Info Panel
        JLabel opdrachtLabel = new JLabel("Dit overzicht toont alle films die door een geselecteerde gebruiker is bekeken.");
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);

        JLabel noDataLabel = new JLabel("Helaas met de opgegeven zoektermen zijn er geen resultaaten");
        JPanel noDataLabelPanel = new JPanel();
        noDataLabelPanel.add(noDataLabel);
        hoofdPanel.add(noDataLabelPanel);

        //Table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(1,1));

        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"Volgnummer", "Titel"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);

        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); 


        //Clicklistener
        ClickListener clickListener = new ClickListener(accountDropdown,resultTable, super.getSqlConnection(), resultTableModel, "Opdracht3", noDataLabel);
        accountDropdown.addActionListener(clickListener);
        accountDropdown.setSelectedIndex(0);

        return hoofdPanel;
    }
}
