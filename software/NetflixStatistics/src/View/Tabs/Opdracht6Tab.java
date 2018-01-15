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

        //Info Panel
        //Het info panel beval een boxlayout waar aan twee labels worden toegevoegd:
        //De omschrijving van de opdracht en daarboven eventueel een foutmelding label die zichtbaar wordt als er geen gegevens zijn
        //De boxlayout wordt in een flowlayout gestopt om zo de text mooi te centreren
        //Het panel met de flowlayout wordt vervolgends als eerste aan de hoofdlayout toegevoegd


        JPanel infoLabelPanelFlow = new JPanel();
        infoLabelPanelFlow.setLayout(new FlowLayout());

        JPanel infoLabelPanelBox = new JPanel();
        infoLabelPanelBox.setLayout(new BoxLayout(infoLabelPanelBox, BoxLayout.Y_AXIS));


        JLabel opdrachtLabel = new JLabel("Voor een door de gebruiker geselecteerde account en serie, geef per aflevering het gemiddeld bekeken % van de tijdsduur.");

        JLabel noDataLabel = new JLabel("Helaas de opgegeven zoektermen zijn er geen resultaaten");
        noDataLabel.setVisible(false);

        infoLabelPanelBox.add(noDataLabel);
        infoLabelPanelBox.add(opdrachtLabel);

<<<<<<< HEAD
        JLabel opdrachtLabel = new JLabel("Geeft de hoeveelheid gebruikers die de geselecteerde film hebben bekeken.");
        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);
=======
        infoLabelPanelFlow.add(infoLabelPanelBox);
        hoofdPanel.add(infoLabelPanelFlow);
>>>>>>> 75d0db83f20579265aa93e553005d467a4eae36f

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

        return hoofdPanel;
    }
}
