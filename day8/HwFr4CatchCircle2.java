package day8;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class HwFr4CatchCircle2 {
    int x;
    int y;
    CirclePanel panel;

    public static void main(String[] args) {

        HwFr4CatchCircle2 catchCircle=new HwFr4CatchCircle2();
    }

    public HwFr4CatchCircle2(){
        JFrame frame=new JFrame();
        frame.setLocation(100,100);
        frame.setMinimumSize(new Dimension(800,600));

        x=10;
        y=10;
        panel=new CirclePanel();
        frame.add(panel);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                Random random=new Random();
                double mouseX=panel.getMousePosition().getX();
                double mouseY=panel.getMousePosition().getY();
                if(mouseX>x-30 && mouseX<x+30 && mouseY>y-30 && mouseY<y+30){
                    x=random.nextInt(600);
                    y=random.nextInt(500);
                    panel.repaint();
                }
            }
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    class CirclePanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.blue);
            g.fillOval(x,y,30,30);
        }
    }
}
