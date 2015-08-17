package tanks4Refactoring.bf;

import java.awt.*;

public class Rock extends SimpleBFObject {

    private boolean isDestroyed = false;

    public Rock(int x, int y) {
        super(x, y);
        color = new Color(10, 50, 100);
    }

    @Override
    public void destroy() {
        isDestroyed = false;
    }
}
