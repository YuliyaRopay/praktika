package tanks4Refactoring.bf;

import java.awt.*;


public class Brick extends SimpleBFObject implements Destroyable{

    public Brick(int x, int y) {
        super(x, y);
        color = new Color(100, 0, 20);
    }
}
