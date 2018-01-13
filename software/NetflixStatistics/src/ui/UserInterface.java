package ui;

import Clicklistener.ClickListener;
import Clicklistener.Opdracht1Listener;
import applicationlogic.SqlConnection;
import applicationlogic.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

/*
UI

Maakt het frame voor alle tabs
Regelt het afsluiten van het programma
Zet de connectie op van de database
*/
public class UserInterface implements Runnable {
    private JFrame frame;
    private ClickListener clickListener;
    private TaskExecutor taskExecutor;
    private SqlConnection sqlConnection;

    public UserInterface(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
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




    private void createComponents(Container hoofdContainer) {

        //Taskexecutor
        TaskExecutor taskExecutor = new TaskExecutor(sqlConnection);

        //Font
        Font font = new Font("arial", Font.BOLD, 24);

        /*
        Hoofd Layout
        */
        BorderLayout hoofdLayout = new BorderLayout();
        hoofdContainer.setLayout(hoofdLayout);

        /*
        Navigatie layout - west
        */

        //Buttons
        JButton button1 = new JButton("Opdracht 1");
        JButton button2 = new JButton("Opdracht 2");
        JButton button3 = new JButton("Opdracht 3");
        JButton button4 = new JButton("Opdracht 4");
        JButton button5 = new JButton("Opdracht 5");


        //Setup
        JPanel navPanel = new JPanel();
        hoofdContainer.add(navPanel, BorderLayout.WEST);

        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));


        //Add buttons
        navPanel.add(button1);
        navPanel.add(button2);
        navPanel.add(button3);
        navPanel.add(button4);
        navPanel.add(button5);

        int navButtonSizeX = 200;
        int navButtonSizeY = 200;

        button1.setPreferredSize(new Dimension(navButtonSizeX, navButtonSizeY));
        button2.setPreferredSize(new Dimension(navButtonSizeX, navButtonSizeY));
        button3.setPreferredSize(new Dimension(navButtonSizeX, navButtonSizeY));
        button4.setPreferredSize(new Dimension(navButtonSizeX, navButtonSizeY));
        button5.setPreferredSize(new Dimension(navButtonSizeX, navButtonSizeY));

        SwingUtilities.updateComponentTreeUI(frame);

        /*
        Text layout - south
        */

        //Labels
        JLabel projectNaam = new JLabel("Netflix Statistics");
        JLabel namen = new JLabel("Thomas, Tim, Jan-Paul");


        //Setup
        JPanel infoTextPanel = new JPanel();
        hoofdContainer.add(infoTextPanel, BorderLayout.SOUTH);

        infoTextPanel.setLayout(new BoxLayout(infoTextPanel, BoxLayout.X_AXIS));

        //Add text
        infoTextPanel.add(projectNaam);
        infoTextPanel.add(namen);

        projectNaam.setForeground(Color.WHITE);
        namen.setForeground(Color.WHITE);
        namen.setHorizontalTextPosition(SwingConstants.RIGHT);


        //color
        infoTextPanel.setBackground(Color.getHSBColor(0F, 0.93f, 0.86f));


        /*
        Data layout - centre
        */

        //Setup
        JPanel dataPanel = new JPanel();
        hoofdContainer.add(dataPanel, BorderLayout.CENTER);

        dataPanel.setLayout(new GridLayout(3,1));
        //Components

        dataPanel.add(new JLabel("Voor een door de gebruiker geselecteerde serie, geef per aflevering het gemiddeld bekeken\n" +
                "% van de tijdsduur. Bij elke aflevering worden het volgnummer én titel getoond."));

        JTable resultTable = new JTable();

       String[] tableColumnsName = {"Volgnummer", "Titel", "Percentage gemiddeld bekeken"};
       DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
       resultTableModel.setColumnIdentifiers(tableColumnsName);

        dataPanel.add(resultTable);
        dataPanel.add(new JScrollPane(resultTable));

        JTextArea opdracht1Input = new JTextArea("Voer Serie in bv: Sherlock, Breaking Bad of Fargo");
        dataPanel.add(opdracht1Input);

        /*
        Clicklistener
        */
        //clickListener = new ClickListener(resultTable, taskExecutor);
        Opdracht1Listener opdracht1Listener = new Opdracht1Listener(resultTable, opdracht1Input, sqlConnection, resultTableModel);

        //setup
        button1.addActionListener(opdracht1Listener);
        button2.addActionListener(clickListener);
        button3.addActionListener(clickListener);


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
