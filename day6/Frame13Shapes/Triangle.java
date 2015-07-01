package day6.Frame13Shapes;

import java.awt.*;

/**
 * Created by julia on 22.06.2015.
 */
public class Triangle extends AbstractShape {

    private int xpoints[];
    private int ypoints[];
    private int npoints;

    public Triangle(int xpoints[], int ypoints[], Color color){
        this.xpoints=xpoints;
        this.ypoints=ypoints;
        this.npoints=3;
        this.color=color;
    }

    public Triangle(int xpoints[], int ypoints[]){
       this(xpoints, ypoints,Color.GREEN);
    }


    @Override
    public void draw(Graphics g) {

        thickness=5;
        Graphics2D g2d=(Graphics2D) g;
        g2d.setStroke(new BasicStroke(thickness));

        g.setColor(color);
        g.drawPolygon(xpoints, ypoints, npoints);

     }

    @Override
    public String toString() {
        return "I'm triangle!";
    }
}
