package day6.Frame13Shapes;

import java.awt.*;

public abstract class AbstractShape implements Drawable {

    protected Color color;

    protected int thickness;

    public Color getColor() {
        return color;
    }

    public int getThickness() {
        return thickness;
    }
}
