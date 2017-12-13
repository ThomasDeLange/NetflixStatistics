package ui;

import Repositories.AccountRepository;
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
    SqlConnection sqlConnection;
    AccountRepository accountRepository = new AccountRepository(sqlConnection);

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public SqlConnection getSqlConnection() {
        return sqlConnection;
    }

    public UserInterface(){
        sqlConnection = new SqlConnection();
        sqlConnection.connectDatabase("jdbc:sqlserver://thomasserver.database.windows.net:1433;database=NetflixStatistics;user=Thomas@thomasserver;password={admin123!};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        accountRepository = new AccountRepository(sqlConnection);
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
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    sqlConnection.disconnectDatabase();
                    System.exit(0);
                }
            }
        });

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2, 1);
        container.setLayout(layout);


        JLabel amount = new JLabel("0");
        JButton accountAbonneeNR = new JButton("GetAccountNummers");
        JButton accountNaam = new JButton("GetAccountName");
        JButton accountWoonplaats = new JButton("AddUser");

        taskExecutor = new TaskExecutor(this);
        clickListener = new ClickListener(amount, taskExecutor);

        accountAbonneeNR.addActionListener(clickListener);
        accountNaam.addActionListener(clickListener);
        accountWoonplaats.addActionListener(clickListener);

        container.add(amount);
        container.add(accountAbonneeNR);
        container.add(accountNaam);
        container.add(accountWoonplaats);
    }

    public JFrame getFrame() {
        return frame;
    }
}
