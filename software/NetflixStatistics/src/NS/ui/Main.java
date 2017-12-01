package NS.ui;

import NS.applicationlogic.Calculator;
import NS.applicationlogic.PersonalCalculator;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.



        Calculator calc = new PersonalCalculator();

        UserInterface ui = new UserInterface(calc);
        SwingUtilities.invokeLater(ui);
    }
}