package day6.Frame13Shapes;

import java.awt.*;

public class Rectangle extends AbstractShape {

    private int height;
    protected int width;
    protected int x;
    protected int y;

    public Rectangle(int x, int y, int width, int height,Color color){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.color=color;
    }

    public Rectangle(int x, int y, int width, int height){
        this(x,y,width,height,Color.BLUE);
    }


    @Override
    public void draw(Graphics g) {

        Graphics2D g2d=(Graphics2D) g;
        g2d.setStroke(new BasicStroke(10));

        g.setColor(color);
        g.drawRect(x,y,width,height);
    }

    @Override
    public String toString() {
        return "I'm rectangle!";
    }
}
