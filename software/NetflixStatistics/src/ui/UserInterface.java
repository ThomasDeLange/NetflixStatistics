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
frame.setMinimumSize(new Dimension(600, 500));
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
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        Font font = new Font("arial", Font.BOLD, 24);

        JTabbedPane tabs = new JTabbedPane();

        JPanel panel3 = new JPanel();

        SeriesTab seriesTab = new SeriesTab(font);
        FilmsTab filmsTab = new FilmsTab(font);

        tabs.add(seriesTab.getSeriesTab(), "Series");
        tabs.add(filmsTab.getFilmsTab(), "Films");
        tabs.add(panel3, "Accounts");

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        JLabel title = new JLabel("Netflix Statistix");
        JLabel names = new JLabel("text, text, text, text, text, text, text, text, ");
        bottomPanel.add(title, BorderLayout.WEST);
        bottomPanel.add(names, BorderLayout.EAST);

        container.add(bottomPanel, BorderLayout.SOUTH);
        container.add(tabs, BorderLayout.CENTER);
    }


//    private JPanel accountsTab(Font font) {
//
//    }


    public JFrame getFrame() {
        return frame;
    }
}
