package View.Tabs;

import Controller.ClickListener;
import Model.ComboBoxEditor;
import Model.SqlConnection;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

/*
Opdracht8Tab:
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

public class Opdracht8Tab extends Tab {

    private ComboBoxEditor comboBoxEditor;

    public Opdracht8Tab(SqlConnection sqlConnection) {
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

        JComboBox filmTitelDropdown = null;
        filmTitelDropdown = comboBoxEditor.fillCombobox(filmTitelDropdown, "FilmTitels");

        dropdownPanel.add(new JLabel("Kies een film"));
        dropdownPanel.add(filmTitelDropdown);

        hoofdPanel.add(dropdownPanel);

        //Info Panel

        JLabel opdrachtLabel = new JLabel("Geeft het gemiddeld percentage kijkers en absoluut aantal kijkers die de geselecteerde film afkeken en geeft het totaal aantal kijkers die de film keken.");
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

        String[] tableColumnsName = {"Titel", "Totaal Aantal gebruikers gezien", "Totaal aantal gebruikers helemaal afgezien", "Percentage gebruikers hele film afgekeken"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);

        //Clicklistener
        ClickListener clickListener = new ClickListener(filmTitelDropdown, resultTable, super.getSqlConnection(), resultTableModel, "Opdracht8", noDataLabel);
        filmTitelDropdown.addActionListener(clickListener);
        filmTitelDropdown.setSelectedIndex(0);

        return hoofdPanel;
    }
}
