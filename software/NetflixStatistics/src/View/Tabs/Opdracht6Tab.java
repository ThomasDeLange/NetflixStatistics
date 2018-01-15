package View.Tabs;

import Controller.ClickListener;
import Model.ComboBoxEditor;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

/*
Opdracht6Tab:
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

public class Opdracht6Tab extends Tab {

    private SqlConnection sqlConnection;
    private ComboBoxEditor comboBoxEditor;

    public Opdracht6Tab(SqlConnection sqlConnection) {
        super(sqlConnection);
        this.sqlConnection = sqlConnection;
        comboBoxEditor = new ComboBoxEditor(sqlConnection);
    }

    public JPanel createComponents() throws SQLException {

        //Setup hoofdpanel
        JPanel hoofdPanel = new JPanel();
        hoofdPanel.setLayout(new BoxLayout(hoofdPanel, BoxLayout.Y_AXIS));

        //Components

        //Dropdown panel - Label, Dropdown
        JPanel dropdownPanel = new JPanel();
        dropdownPanel.setLayout(new FlowLayout());

        JComboBox filmDropdown = null;
        filmDropdown = comboBoxEditor.fillCombobox(filmDropdown, "FilmTitels");

        dropdownPanel.add(new JLabel("Kies een film"));
        dropdownPanel.add(filmDropdown);

        hoofdPanel.add(dropdownPanel);

        //Info Panel
        JLabel opdrachtLabel = new JLabel("Dit overzicht toont hoeveel gebruikers een geselecteerde film af hebben gekeken");
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

        String[] tableColumnsName = {"FilmID", "Titel", "Aantal gebruikers"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);

        //Clicklistener
        ClickListener clickListener = new ClickListener(filmDropdown, resultTable, sqlConnection, resultTableModel, "Opdracht6", noDataLabel);
        filmDropdown.addActionListener(clickListener);
        filmDropdown.setSelectedIndex(0);

        return hoofdPanel;
    }
}
