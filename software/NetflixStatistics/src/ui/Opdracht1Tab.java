package ui;

import Clicklistener.ClickListener;
import applicationlogic.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht1Tab {
    private Font font;
    private SqlConnection sqlConnection;

    public Opdracht1Tab(Font font, SqlConnection sqlConnection) {
        this.font = font;
        this.sqlConnection = sqlConnection;
    }

    public JPanel createComponents() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        //Setup
        JPanel hoofdPanel = new JPanel();

        UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());

        hoofdPanel.setLayout(new BoxLayout(hoofdPanel, BoxLayout.Y_AXIS));

        /*
        Data layout - centre
        */

        //Dropdown
        JPanel dropdownPanel = new JPanel();
        dropdownPanel.setLayout(new FlowLayout());

        String[] items = new String[]{"Fargo", "Breaking Bad", "Sherlock"};
        JComboBox Opdracht1Dropdown = new JComboBox(items);

        dropdownPanel.add(new JLabel("Kies een serie"));
        dropdownPanel.add(Opdracht1Dropdown);

        hoofdPanel.add(dropdownPanel);

        //Components
         JLabel opdrachtLabel = new JLabel("Voor een door de gebruiker geselecteerde serie, geef per aflevering het gemiddeld bekeken\n" +
                "% van de tijdsduur. Bij elke aflevering worden het volgnummer én titel getoond.");

         hoofdPanel.add(opdrachtLabel);

        JTable resultTable = new JTable();

        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"Volgnummer", "Titel", "Percentage gemiddeld bekeken"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        hoofdPanel.add(resultTable);
        hoofdPanel.add(new JScrollPane(resultTable));


        /*
        Clicklistener
        */

        ClickListener clickListener = new ClickListener(resultTable, Opdracht1Dropdown, sqlConnection, resultTableModel, "Opdracht1");

        Opdracht1Dropdown.addActionListener(clickListener);

        return hoofdPanel;
    }


}

