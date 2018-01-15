package View;

import Model.SqlConnection;
import View.Tabs.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

/*
UI

run():
Maakt het eerste frame aan
Regelt het afsluiten van het programma

createComponents():
1. Maakt de hoofdlayout aan
2. Maakt een tab bar aan en vult die met de opdrachten 1 - 7
3. Maakt een panel aan met gegevens over de groepsleden, met de achtergrondkleur van netflix
*/
public class UserInterface implements Runnable {
    private JFrame frame;
    private SqlConnection sqlConnection;

    public UserInterface(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }


    @Override
    public void run() {
        frame = new JFrame("Netflix Statistix");
        frame.setMinimumSize(new Dimension(750, 400));
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Wil u het programma afsluiten?", "Echt sluiten?",
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setVisible(true);
    }


    private void createComponents(Container hoofdContainer) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, SQLException {
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
        tabbedPane.add(new Opdracht7Tab(sqlConnection).createComponents(), "overzicht 7");
        

        //Labels
        JLabel projectNaam = new JLabel("Netflix Statistix   ");
        JLabel namen = new JLabel("Thomas de Lange (2125564), Tim Welter (2125099), Jan-Paul Mosterdijk (2131602)");

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

    }


    public JFrame getFrame() {
        return frame;
    }
}
