package View.Tabs;

import Controller.ClickListener;
import Model.ComboBoxEditor;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

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

        /*
        DataPanel - Dropdown Panel, OpdrachtLabel, Table
        */

        //Components

        //Dropdown panel - Label, Dropdown
        JPanel dropdownPanel = new JPanel();
        dropdownPanel.setLayout(new FlowLayout());

        JComboBox filmDropdown = null;
        filmDropdown = comboBoxEditor.fillCombobox(filmDropdown, "FilmTitels");

        dropdownPanel.add(new JLabel("Kies een film"));
        dropdownPanel.add(filmDropdown);

        hoofdPanel.add(dropdownPanel);

        //OpdrachtLabel
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.setLayout(new FlowLayout());

        JLabel opdrachtLabel = new JLabel("Voor een door de gebruiker geselecteerde film, hoeveel kijkers hebben deze in zín geheel bekeken?");
        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);

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
        ClickListener clickListener = new ClickListener(filmDropdown, resultTable, sqlConnection, resultTableModel, "Opdracht6");
        filmDropdown.addActionListener(clickListener);

        return hoofdPanel;
    }
}
