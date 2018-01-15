package View.Tabs;

import Controller.ClickListener;
import Model.ComboBoxEditor;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

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

        /*
        DataPanel - Dropdown Panel, OpdrachtLabel, Table
        */

        //Components

        //Dropdown panel - Label, Dropdown
        JPanel dropdownPanel = new JPanel();
        dropdownPanel.setLayout(new FlowLayout());

        JComboBox accountDropdown = null;
        accountDropdown = comboBoxEditor.fillCombobox(accountDropdown, "AccountNRs");


        dropdownPanel.add(new JLabel("Kies een account"));
        dropdownPanel.add(accountDropdown);

        //JButton runButton = new JButton("Voer uit!");
        //dropdownPanel.add(runButton);


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
