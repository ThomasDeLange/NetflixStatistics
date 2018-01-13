package ui;

import Clicklistener.Opdracht1Listener;
import applicationlogic.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Array;
import java.sql.ResultSet;

public class Opdracht1Tab {
    private Font font;
    private SqlConnection sqlConnection;

    public Opdracht1Tab(Font font, SqlConnection sqlConnection) {
        this.font = font;
        this.sqlConnection = sqlConnection;
    }

    public JPanel createComponents() {


        //Setup
        JPanel navPanel = new JPanel();

        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));

        /*
        Data layout - centre
        */

        //Dropdown
        String[] titels = new String[]{"Fargo", "Breaking Bad", "Sherlock"};
        JComboBox dropdown = new JComboBox(titels);

        navPanel.add(dropdown);
        //Setup
        JPanel dataPanel = new JPanel();
        navPanel.add(dataPanel, BorderLayout.CENTER);

        dataPanel.setLayout(new GridLayout(3, 1));
        //Components

        dataPanel.add(new JLabel("Voor een door de gebruiker geselecteerde serie, geef per aflevering het gemiddeld bekeken\n" +
                "% van de tijdsduur. Bij elke aflevering worden het volgnummer én titel getoond."));

        JTable resultTable = new JTable();

        String[] tableColumnsName = {"Volgnummer", "Titel", "Percentage gemiddeld bekeken"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        dataPanel.add(resultTable);
        dataPanel.add(new JScrollPane(resultTable));

        JTextArea opdracht1Input = new JTextArea("Voer Serie in bv: Sherlock, Breaking Bad of Fargo");
        dataPanel.add(opdracht1Input);

    /*
    Clicklistener
    */
        //clickListener = new ClickListener(resultTable, taskExecutor);
        Opdracht1Listener opdracht1Listener = new Opdracht1Listener(resultTable, opdracht1Input, sqlConnection, resultTableModel);

        return navPanel;
    }
}

