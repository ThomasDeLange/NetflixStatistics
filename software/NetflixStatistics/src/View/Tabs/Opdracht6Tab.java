package View.Tabs;

import Controller.ClickListener;
import Model.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Opdracht6Tab {

    private SqlConnection sqlConnection;

    public Opdracht6Tab(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public JPanel createComponents() {

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



        String[] accountDropdownItems = new String[]{"The Abominable Bride", "The Life of Brian", "Pulp Fiction", "Pruimebloesem", "Reservoir Dogs", "The Good, the Bad and the Ugly", "Andy Warhol's Dracula", "Ober", "Der Untergang", "De helaasheid der dingen", "A Clockwork Orange"};
        JComboBox accountDropdown = new JComboBox(accountDropdownItems);

        dropdownPanel.add(new JLabel("Kies een film"));
        dropdownPanel.add(accountDropdown);
        JButton runButton = new JButton("Voer uit!");
        dropdownPanel.add(runButton);


        hoofdPanel.add(dropdownPanel);

        //OpdrachtLabel
        JPanel opdrachtLabelPanel = new JPanel();
        opdrachtLabelPanel.setLayout(new FlowLayout());

        JLabel opdrachtLabel = new JLabel("Voor een door de gebruiker geselecteerde film, hoeveel kijkers hebben deze in zín geheel bekeken?");
        opdrachtLabelPanel.add(opdrachtLabel);
        hoofdPanel.add(opdrachtLabelPanel);

        //Table
        JTable resultTable = new JTable();
        resultTable.setDragEnabled(true);

        String[] tableColumnsName = {"FilmID", "Titel", "Aantal gebruikers"};
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        resultTableModel.setColumnIdentifiers(tableColumnsName);

        hoofdPanel.add(resultTable);
        hoofdPanel.add(new JScrollPane(resultTable));


        //Clicklistener
        ClickListener clickListener = new ClickListener(accountDropdown,resultTable, sqlConnection, resultTableModel, "Opdracht6");
        runButton.addActionListener(clickListener);

        return hoofdPanel;
    }
}
