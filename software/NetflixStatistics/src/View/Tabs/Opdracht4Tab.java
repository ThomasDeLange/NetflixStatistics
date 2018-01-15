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

        hoofdPanel.add(buttonPanel);



        hoofdPanel.add(buttonPanel, BorderLayout.NORTH);

        //Button
        hoofdPanel.add(buttonPanel);


        JButton runButton = new JButton("Voer uit!");
        buttonPanel.add(runButton);

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

        String[] tableColumnsName = {"Volgnummer", "Titel", "Percentage gemiddeld bekeken"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        tablePanel.add(resultTable);
        tablePanel.add(new JScrollPane(resultTable));
        hoofdPanel.add(tablePanel);


        //Clicklistener
        ClickListener clickListener = new ClickListener(resultTable, super.getSqlConnection(), resultTableModel, "Opdracht4", noDataLabel);
        runButton.addActionListener(clickListener);

        return hoofdPanel;
    }
}
