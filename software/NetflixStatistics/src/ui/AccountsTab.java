package ui;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class AccountsTab {
    private Font font;

    public AccountsTab(Font font) {
        this.font = font;
    }

    public JPanel getAccountsTab() {
        JPanel accountpanel1 = new JPanel();
        accountpanel1.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Selecteer account");
        label1.setFont(font);

        JComboBox dropdown = new JComboBox();

        topPanel.add(label1);
        topPanel.add(dropdown);

        accountpanel1.add(topPanel, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(BorderFactory.createTitledBorder("Profielen"));
        tablePanel.setLayout(new GridLayout(1, 1));

        TableColumn column1 = new TableColumn();
        column1.
        JTable table = new JTable();

        tablePanel.add(table);

        accountpanel1.add(tablePanel, BorderLayout.CENTER);

        return accountpanel1;
    }
}
