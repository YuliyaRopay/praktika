package day6.Frame13Shapes;

import java.awt.*;

public class Circle extends AbstractShape {
    private int radius;
    private int x;
    private int y;

    public Circle(int x, int y, int radius){
        this(x,y,radius,new Color(255,0,0));
    }

    public Circle(int x, int y, int radius,Color color){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.color=color;

    }

    @Override
    public void draw(Graphics g) {

       // Graphics2D g2d=(Graphics2D) g;
       // g2d.setStroke(new BasicStroke(5));

        g.setColor(color);
        //g.drawOval(x,y,radius,radius);

        g.fillOval(x,y,radius,radius);
    }

    @Override
    public String toString() {
        return "I'm circle!";
    }
}
