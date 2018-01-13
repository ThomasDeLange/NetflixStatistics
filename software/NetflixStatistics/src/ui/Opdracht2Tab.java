package ui;

import applicationlogic.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht2Tab {
    private Font font;
    private SqlConnection sqlConnection;

    public Opdracht2Tab(Font font, SqlConnection sqlConnection) {
        this.font = font;
        this.sqlConnection = sqlConnection;
    }

    public JPanel createComponents() {


        //Setup
        JPanel hoofdPanel = new JPanel();
        hoofdPanel.setLayout(new BoxLayout(hoofdPanel, BoxLayout.Y_AXIS));
        
        /*
        Data layout - centre
        */

        //Setup
        JPanel dataPanel = new JPanel();
        hoofdPanel.add(dataPanel, BorderLayout.CENTER);

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
//        Opdracht1Listener opdracht1Listener = new Opdracht1Listener(resultTable, dropdo, sqlConnection, resultTableModel);

        return hoofdPanel;
    }
}

