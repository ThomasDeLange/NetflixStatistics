package View.Tabs;

import Controller.ClickListener;
import Model.ComboBoxEditor;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
/*
Opdracht7Tab:
Een extra opdracht

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
public class Opdracht7Tab extends Tab {

    private ComboBoxEditor comboBoxEditor;
    private SqlConnection sqlConnection;

    public Opdracht7Tab(SqlConnection sqlConnection) {
        super(sqlConnection);
        comboBoxEditor = new ComboBoxEditor(sqlConnection);
        this.sqlConnection = sqlConnection;
    }

    @Override
    public JPanel createComponents() throws SQLException {

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


        JComboBox serieDropdown = null;
        serieDropdown = comboBoxEditor.fillCombobox(serieDropdown, "SerieTitels");
        
        dropdownPanel.add(new JLabel("Kies een serie"));
        dropdownPanel.add(serieDropdown);

        hoofdPanel.add(dropdownPanel);

        //Info Panel
        JLabel opdrachtLabel = new JLabel("Dit overzicht toont voor een geselecteerde serie het totaal en gemiddeld bekeken persentage van alle afleveringen van die serie.");
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

        String[] tableColumnsName = {"Serie", "Seizoen", "Totaal gemiddeld gezien in %"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);

        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


        //Clicklistener
        ClickListener clickListener = new ClickListener(serieDropdown, resultTable, sqlConnection, resultTableModel, "Opdracht7", noDataLabel);
        serieDropdown.addActionListener(clickListener);
        serieDropdown.setSelectedIndex(0);

        return hoofdPanel;
    }
}
