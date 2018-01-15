package View.Tabs;

import Controller.ClickListener;
import Model.ComboBoxEditor;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

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

        dropdownPanel.add(serieDropdown);
        dropdownPanel.add(new JLabel("Kies een serie"));

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

<<<<<<< HEAD
        JLabel opdrachtLabel = new JLabel("Geeft het gemiddeld bekeken percentage van een aflevering van de geselecteerde serie.");
=======
        infoLabelPanelBox.add(noDataLabel);
        infoLabelPanelBox.add(opdrachtLabel);
>>>>>>> 75d0db83f20579265aa93e553005d467a4eae36f

        infoLabelPanelFlow.add(infoLabelPanelBox);
        hoofdPanel.add(infoLabelPanelFlow);

        //Table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new FlowLayout());

        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

<<<<<<< HEAD
        String[] tableColumnsName = {"Serie", "Seizoen", "Totaal gemiddeld gezien in %"};
=======
        String[] tableColumnsName = {"AfleveringID", "Titel", "Percentage gemiddeld bekeken"};
>>>>>>> e5d69bfcab0dd8ccec5758d08ef5eae02a55ef55
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);

        //Clicklistener
        ClickListener clickListener = new ClickListener(serieDropdown, resultTable, sqlConnection, resultTableModel, "Opdracht7", noDataLabel);
        serieDropdown.addActionListener(clickListener);

        return hoofdPanel;
    }
}
