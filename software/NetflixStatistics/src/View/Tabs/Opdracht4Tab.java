package View.Tabs;

import Controller.ClickListener;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht4Tab extends Tab {

    public Opdracht4Tab(SqlConnection sqlConnection) {
        super(sqlConnection);
    }

    public JPanel createComponents() {

        //Hoofdpanel
        JPanel hoofdPanel = new JPanel();
        hoofdPanel.setLayout(new BoxLayout(hoofdPanel, BoxLayout.Y_AXIS));

        //Buttonpanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());


        hoofdPanel.add(buttonPanel, BorderLayout.NORTH);

        //Button

        hoofdPanel.add(buttonPanel);



        hoofdPanel.add(buttonPanel, BorderLayout.NORTH);

        //Button
        hoofdPanel.add(buttonPanel);


        JButton runButton = new JButton("Voer uit!");
        buttonPanel.add(runButton);

        //Opdracht
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.setLayout(new FlowLayout());

        JLabel opdrachtLabel = new JLabel("Geeft de film met de langste tijdsduur voor kijkers onder 16 jaar.");
        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);

        //Table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new FlowLayout());

        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"Volgnummer", "Titel", "Percentage gemiddeld bekeken"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);


        //Clicklistener
        ClickListener clickListener = new ClickListener(resultTable, super.getSqlConnection(), resultTableModel, "Opdracht4");
        runButton.addActionListener(clickListener);

        return hoofdPanel;
    }
}
