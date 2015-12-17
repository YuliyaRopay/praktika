package day8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;


public class Fr10Image extends JPanel {

    private final static String IMAGE_NAME= "index.png";
    private Image image;

    public Fr10Image(){
        try{
            image= ImageIO.read(new File(IMAGE_NAME));
        }catch (IOException e){
            System.err.println("Can't find image2 "+IMAGE_NAME);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(203,30,0));
        g.fillRect(0,0,800,600);

        g.drawImage(image, 100, 100, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame =new JFrame("Test primer");
        frame.setLocation(200,200);
        frame.setMinimumSize(new Dimension(800,600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(new Fr10Image());

        frame.pack();
        frame.setVisible(true);
        frame.repaint();
    }
}
