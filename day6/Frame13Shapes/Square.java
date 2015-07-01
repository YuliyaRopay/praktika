package day6.Frame13Shapes;

import java.awt.*;

public class Square extends Rectangle {

    public Square(int x, int y, int width, Color color){
        super(x,y,width,width,color);
    }

    public Square(int x, int y, int width){
        this(x,y,width,Color.DARK_GRAY);
    }


}
