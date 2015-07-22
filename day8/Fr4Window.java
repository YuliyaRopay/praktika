package day8;


import javax.swing.*;
import java.awt.*;

public class Fr4Window {
    public static void main(String[] args) {
        JFrame f =new JFrame();
        f.setLocation(300,100);
        f.setMinimumSize(new Dimension(800,600));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
