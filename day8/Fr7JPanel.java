package day8;

import javax.swing.*;
import java.awt.*;

public class Fr7JPanel extends JPanel{


    public Fr7JPanel(){

        JFrame frame =new JFrame("Test primer");
        frame.setLocation(200,200);
        frame.setMinimumSize(new Dimension(600,400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        JLabel label = new JLabel("<html>HTML-форматирование: " +
                "<ul><li> <i>text </i>," +
                "<li><b>text bold</b> <li><font size = +2> размер </font>" +
                "<li>список </ul>");

        this.add(label);

        frame.pack();
        frame.setVisible(true);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(0,0,600,400);

        g.setColor(Color.orange);
        g.fill3DRect(100,100,50,50,true);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        g.drawString("My first text !!!!",10,20);

    }

    public static void main(String[] args) {
        Fr7JPanel fr=new Fr7JPanel();
    }
}
