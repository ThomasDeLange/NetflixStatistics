package View;

import Model.SqlConnection;
import View.Tabs.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
UI

Maakt het frame voor alle tabs
Regelt het afsluiten van het programma
*/
public class UserInterface implements Runnable {
    private JFrame frame;
    private SqlConnection sqlConnection;

    public UserInterface(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }


    @Override
    public void run() {
        frame = new JFrame("NetflixStatistics");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(750, 400));
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

        try {
            createComponents(frame.getContentPane());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setVisible(true);
    }


    private void createComponents(Container hoofdContainer) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        //Font
        Font font = new Font("arial", Font.BOLD, 24);

        /*
        Hoofd Layout
        */
        BorderLayout hoofdLayout = new BorderLayout();
        hoofdContainer.setLayout(hoofdLayout);

        /*
        Navigatie layout - North
        */

        //Buttons
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.add(new Opdracht1Tab(sqlConnection).createComponents(), "Overzicht 1");
        tabbedPane.add(new Opdracht2Tab(sqlConnection).createComponents(), "Overzicht 2");
        tabbedPane.add(new Opdracht3Tab(sqlConnection).createComponents(), "Overzicht 3");
        tabbedPane.add(new Opdracht4Tab(sqlConnection).createComponents(), "Overzicht 4");
        tabbedPane.add(new Opdracht5Tab(sqlConnection).createComponents(), "Overzicht 5");
        tabbedPane.add(new Opdracht6Tab(sqlConnection).createComponents(), "Overzicht 6");
        tabbedPane.add(new Opdracht7Tab(sqlConnection).createComponents(), "Extra overzicht 7");

        //Labels
        JLabel projectNaam = new JLabel("Netflix Statistics");
        JLabel namen = new JLabel("Thomas, Tim, Jan-Paul");

        //Setup

        JPanel infoTextPanel = new JPanel();


        infoTextPanel.setLayout(new BoxLayout(infoTextPanel, BoxLayout.X_AXIS));

        //Add text
        infoTextPanel.add(projectNaam);
        infoTextPanel.add(namen);

        projectNaam.setForeground(Color.WHITE);
        namen.setForeground(Color.WHITE);
        namen.setHorizontalTextPosition(SwingConstants.RIGHT);


        //color
        infoTextPanel.setBackground(Color.getHSBColor(0F, 0.93f, 0.86f));
        hoofdContainer.add(infoTextPanel, BorderLayout.SOUTH);
        hoofdContainer.add(tabbedPane, BorderLayout.CENTER);


//        BorderLayout layout = new BorderLayout();
//        hoofdContainer.setLayout(layout);
//        Font font = new Font("arial", Font.BOLD, 24);
//
//        JTabbedPane tabs = new JTabbedPane();
//
//        SeriesTab seriesTab = new SeriesTab(font, sqlConnection);
//        FilmsTab filmsTab = new FilmsTab(font, sqlConnection);
//        AccountsTab accountsTab = new AccountsTab(font);
//
//        tabs.add(seriesTab.getSeriesTab(), "Series");
//        tabs.add(filmsTab.getFilmsTab(), "Films");
//        tabs.add(accountsTab.getAccountsTab(), "Accounts");
//
//        JPanel bottomPanel = new JPanel();
//        bottomPanel.setLayout(new BorderLayout());
//        JLabel title = new JLabel("Netflix Statistix");
//        JLabel names = new JLabel("text, text, text, text, text, text, text, text, ");
//        bottomPanel.add(title, BorderLayout.WEST);
//        bottomPanel.add(names, BorderLayout.EAST);
//
//        hoofdContainer.add(bottomPanel, BorderLayout.SOUTH);
//        hoofdContainer.add(tabs, BorderLayout.CENTER);
    }


    public JFrame getFrame() {
        return frame;
    }
}
