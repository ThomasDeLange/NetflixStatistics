package ui;

import applicationlogic.SqlConnection;

import javax.swing.*;
/*
Main
1. Roept de UserInterface aan om een UserInterface te tonen op het scherm

 */
public class Main {

    public static void main(String[] args) {

        //sql connectie
        SqlConnection sqlConnection = new SqlConnection();
        sqlConnection.connectDatabase("jdbc:sqlserver://thomasserver.database.windows.net:1433;database=NetflixStatistics;user=Thomas@thomasserver;password={admin123!};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");


        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }


}
