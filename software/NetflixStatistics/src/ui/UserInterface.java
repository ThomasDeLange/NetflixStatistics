package ui;

import applicationlogic.*;
import sun.awt.AWTIcon32_java_icon16_png;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

/*
UI

Maakt het frame voor alle tabs
Regelt het afsluiten van het programma
Zet de connectie op van de database
*/
public class UserInterface implements Runnable {
    private JFrame frame;
    ClickListener clickListener;
    TaskExecutor taskExecutor;
    SqlConnection sqlConnection;

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
        ImageUI imageUI = new ImageUI();
        imageUI.setVisible(true);
        imageUI.pack();


        JButton button1 = new JButton("Account info");
        JButton button2 = new JButton("Account info per id");
        JButton button3 = new JButton("Langste film onder de 16");
        JButton button4 = new JButton("Button4");
        JButton button5 = new JButton("Button5");



        //Setup
        JPanel navPanel = new JPanel();
        hoofdContainer.add(navPanel, BorderLayout.WEST);

        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));


        //Add buttons
        navPanel.add(imageUI);
        navPanel.add(button1);
        navPanel.add(button2);
        navPanel.add(button3);
        navPanel.add(button4);
        navPanel.add(button5);

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



        //button
        JTextArea resultsTextArea = new JTextArea("Hier komt de informatie");
        dataPanel.add(resultsTextArea);
        dataPanel.add(new JButton("test"));
        dataPanel.add(new JButton("testtestets"));

        //Clicklistener
        ClickListener clickListener = new ClickListener(resultsTextArea, taskExecutor);

        //setup
        button1.addActionListener(clickListener);
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
