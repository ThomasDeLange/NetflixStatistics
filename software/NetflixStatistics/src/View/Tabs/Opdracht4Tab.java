package View.Tabs;

import Controller.ClickListener;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht4Tab {
    private Font font;
    private SqlConnection sqlConnection;

    public Opdracht4Tab(Font font, SqlConnection sqlConnection) {
        this.font = font;
        this.sqlConnection = sqlConnection;
    }

    public JPanel createComponents() {

        //Setup hoofdpanel
        JPanel hoofdPanel = new JPanel();
        hoofdPanel.setLayout(new BorderLayout());
        hoofdPanel.setBorder(BorderFactory.createTitledBorder("Geef de film met de langste tijdsduur voor kijkers onder 16 jaar"));


<<<<<<< HEAD
        JButton runButton = new JButton("Voer uit!");
        hoofdPanel.add(runButton, BorderLayout.SOUTH);
=======
        //Components

        //Dropdown panel - Label, Dropdown
        JPanel dropdownPanel = new JPanel();
        dropdownPanel.setLayout(new FlowLayout());

        JButton runButton = new JButton("Voer uit!");
        dropdownPanel.add(runButton);


        hoofdPanel.add(dropdownPanel);

        //OpdrachtLabel
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.setLayout(new FlowLayout());

        JLabel opdrachtLabel = new JLabel("o Geef de film met de langste tijdsduur voor kijkers onder 16 jaar.");
        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);
>>>>>>> f70f5650663e2fd47909e01241e4901f5604864a

        //Table
        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);


        String[] tableColumnsName = {"Volgnummer", "Titel", "Percentage gemiddeld bekeken"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        hoofdPanel.add(resultTable);
        hoofdPanel.add(new JScrollPane(resultTable));


        //Clicklistener
        ClickListener clickListener = new ClickListener(resultTable, sqlConnection, resultTableModel, "Opdracht4");
        runButton.addActionListener(clickListener);

        return hoofdPanel;
    }
}
