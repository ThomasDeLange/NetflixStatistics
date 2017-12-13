package ui;

import applicationlogic.SqlConnection;
import applicationlogic.TaskExecutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserInterface implements Runnable {
    private JFrame frame;
    ClickListener clickListener;
    TaskExecutor taskExecutor;
    SqlConnection SqlConnection;

    public UserInterface() {
        SqlConnection = new SqlConnection();
    }


    @Override
    public void run() {
        frame = new JFrame("NetflixStatistics");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure to close this window?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(1, 1);
        container.setLayout(layout);
        Font font = new Font("serif", Font.BOLD, 24);

        JTabbedPane tabs = new JTabbedPane();

        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();


        tabs.add(seriesTab(font), "Series");
        tabs.add(panel2, "Films");
        tabs.add(panel3, "Accounts");


//        taskExecutor = new TaskExecutor(SqlConnection);

        container.add(tabs);
    }

    private JPanel seriesTab(Font font) {
        JPanel seriesPanel = new JPanel();
        seriesPanel.setLayout(new BorderLayout());

        JPanel subpanel1 = new JPanel();
        subpanel1.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Selecteer serie");
        label1.setFont(font);
        JComboBox dropdown = new JComboBox();

        subpanel1.add(label1);
        subpanel1.add(dropdown);
        seriesPanel.add(subpanel1, BorderLayout.NORTH);

        JPanel subpanel2 = new JPanel();
        subpanel2.setBorder(BorderFactory.createTitledBorder("Gemiddeld percentage bekeken per aflevering"));
        subpanel2.setLayout(new GridLayout(1,1));


        JTable table = new JTable();
        subpanel2.add(table);
        seriesPanel.add(subpanel2, BorderLayout.CENTER);

        JPanel subpanel3 = new JPanel();
        subpanel3.setLayout(new GridLayout(1, 2));
        JLabel label3 = new JLabel("Netflix Statistix");
        JLabel label4= new JLabel("text, text, text, text, text, text, text, text, ");
        subpanel3.add(label3);
        subpanel3.add(label4);

        seriesPanel.add(subpanel3, BorderLayout.SOUTH);

        return seriesPanel;
    }

    private JPanel filmsTab(Font font) {
        JPanel filmsPanel = new JPanel();
        filmsPanel.setLayout(new BorderLayout());

        JPanel subpanel1 = new JPanel();
        subpanel1.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Selecteer film");
        label1.setFont(font);
        JComboBox dropdown = new JComboBox();

        subpanel1.add(label1);
        subpanel1.add(dropdown);
        filmsPanel.add(subpanel1, BorderLayout.NORTH);

        JPanel subpanel2 = new JPanel();
        subpanel2.setBorder(BorderFactory.createTitledBorder("Gemiddeld percentage bekeken per account"));
        subpanel2.setLayout(new GridLayout(1,1));


        JTable table = new JTable();
        subpanel2.add(table);
        filmsPanel.add(subpanel2, BorderLayout.CENTER);

        JPanel subpanel3 = new JPanel();
        subpanel3.setLayout(new GridLayout(1, 2));
        JLabel label3 = new JLabel("Netflix Statistix");
        JLabel label4= new JLabel("text, text, text, text, text, text, text, text, ");
        subpanel3.add(label3);
        subpanel3.add(label4);

        filmsPanel.add(subpanel3, BorderLayout.SOUTH);

        return filmsPanel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
