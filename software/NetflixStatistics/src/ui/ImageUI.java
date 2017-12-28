package ui;

import javax.swing.*;

public class ImageUI extends JFrame{

    private ImageIcon image;
    private JLabel label;

    ImageUI() {
        ImageIcon image = new ImageIcon(getClass().getResource("/Users/thomas/School/Periode 2/NetflixStatistics/software/NetflixStatistics/NetflixStatistics.iml"));
        JLabel label = new JLabel(image);
        add(label);
    }
}
