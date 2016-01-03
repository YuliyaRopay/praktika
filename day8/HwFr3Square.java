package day8;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class HwFr3Square extends JPanel {

    private int r;
    private int b;

    public static void main(String[] args) {
        HwFr3Square fr3=new HwFr3Square();
    }

    public HwFr3Square(){
        JFrame frame=new JFrame();
        frame.setLocation(100,200);
        frame.setMinimumSize(new Dimension(800,600));

        b=0;
        r=0;
        frame.getContentPane().add(this);
        this.addMouseListener(new ChangeColor());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(r, 200, b));
        g.fillRect(250, 50, 300, 300);
    }


    class ChangeColor implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            Random randomColor=new Random();
            b=randomColor.nextInt(255);
            r=randomColor.nextInt(255);
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


}
