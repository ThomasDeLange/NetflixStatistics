package View.Tabs;

import Controller.ClickListener;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht4Tab extends Tab{

    public Opdracht4Tab(SqlConnection sqlConnection) {
        super(sqlConnection);

    }

    public JPanel createComponents() {

        //Hoofdpanel
        JPanel hoofdPanel = new JPanel();
        hoofdPanel.setLayout(new BorderLayout());

        //Buttonpanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        hoofdPanel.add(buttonPanel, BorderLayout.NORTH);



        //Button
        JButton runButton = new JButton("Voer uit!");
        buttonPanel.add(runButton);

        //Table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());

        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"Volgnummer", "Titel", "Percentage gemiddeld bekeken"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable, BorderLayout.CENTER);
        tablePanel.add(new JScrollPane(resultTable));

        //Opdracht
        tablePanel.setBorder(BorderFactory.createTitledBorder("Geef de film met de langste tijdsduur voor kijkers onder 16 jaar"));

        hoofdPanel.add(tablePanel);

        //Clicklistener
        ClickListener clickListener = new ClickListener(resultTable, super.getSqlConnection(), resultTableModel, "Opdracht4");
        runButton.addActionListener(clickListener);

        return hoofdPanel;
    }
}
