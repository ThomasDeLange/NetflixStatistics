package ui;

import javax.swing.*;
/*
Main
1. Roept de UserInterface aan om een UserInterface te tonen op het scherm

 */
public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }


}
