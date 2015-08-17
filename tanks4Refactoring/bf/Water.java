package tanks4Refactoring.bf;

import java.awt.*;

public class Water extends SimpleBFObject {

    private boolean isDestroyed=true;

    public Water(int x, int y) {
        super(x, y);
        color = new Color(100,50, 255);

    }

    @Override
    public void draw(Graphics g) {
            g.setColor(this.color);
            g.fillRect(this.getX(), this.getY(), 64, 64);
     }


}

