package tanks5.bf;

import tanks5.bf.Destroyable;
import tanks5.bf.SimpleBFObject;

import java.awt.*;

public abstract class DestroyBFObject extends SimpleBFObject implements Destroyable {

    private boolean isDestroyed = false;

    public DestroyBFObject(int x, int y) {
        super(x, y);
    }

    @Override
    public void destroy() {
        isDestroyed = true;
    }

    @Override
    public void draw(Graphics g) {
        if (!isDestroyed) {
            g.setColor(this.color);
            g.fillRect(this.getX(), this.getY(), 64, 64);
        }
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }
}
