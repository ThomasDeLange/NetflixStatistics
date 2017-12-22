package ui;

import applicationlogic.SqlConnection;
import applicationlogic.TaskExecutor;

import javax.swing.*;
import java.awt.*;

public class FilmsTab {
    private Font font;
    private SqlConnection sqlConnection;

    public FilmsTab(Font font, SqlConnection sqlConnection) {
        this.font = font;
        this.sqlConnection = sqlConnection;
    }

    public JPanel getFilmsTab() {

        JPanel filmsPanel = new JPanel();
        filmsPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Selecteer film");
        label1.setFont(font);

        JComboBox dropdown = new JComboBox();

        topPanel.add(label1);
        topPanel.add(dropdown);


        filmsPanel.add(topPanel, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(BorderFactory.createTitledBorder("Gemiddeld percentage bekeken per account"));
        tablePanel.setLayout(new GridLayout(3, 1));

        JTable table = new JTable();

        tablePanel.add(table);

        filmsPanel.add(tablePanel, BorderLayout.CENTER);

        JButton button = new JButton("GetAccountNummers");
        JLabel label = new JLabel("laallalalalalal");

        UserInterface userInterface = new UserInterface(sqlConnection);
        TaskExecutor taskExecutor = new TaskExecutor(sqlConnection);
        //ClickListener clickListener = new ClickListener(label, taskExecutor);

        //button.addActionListener(clickListener);
        tablePanel.add(label);
        tablePanel.add(button);



        return filmsPanel;
    }
}
