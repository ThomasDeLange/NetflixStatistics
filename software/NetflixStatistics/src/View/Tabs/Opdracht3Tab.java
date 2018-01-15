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
        JPanel infoLabelPanelFlow = new JPanel();
        infoLabelPanelFlow.setLayout(new FlowLayout());

        JPanel infoLabelPanelBox = new JPanel();
        infoLabelPanelBox.setLayout(new BoxLayout(infoLabelPanelBox, BoxLayout.Y_AXIS));


        JLabel opdrachtLabel = new JLabel("Dit overzicht toont alle films die door een geselecteerde gebruiker is bekeken.");

        JLabel noDataLabel = new JLabel("Helaas de opgegeven zoektermen zijn er geen resultaaten");
        noDataLabel.setVisible(false);

        infoLabelPanelBox.add(noDataLabel);
        infoLabelPanelBox.add(opdrachtLabel);

        infoLabelPanelFlow.add(infoLabelPanelBox);
        hoofdPanel.add(infoLabelPanelFlow);


        //Table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new FlowLayout());

        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"Volgnummer", "Titel"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);

        //Clicklistener
        ClickListener clickListener = new ClickListener(accountDropdown,resultTable, super.getSqlConnection(), resultTableModel, "Opdracht3", noDataLabel);
        accountDropdown.addActionListener(clickListener);

        return hoofdPanel;
    }
}
