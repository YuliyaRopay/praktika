package tanks4Refactoring.bf.tanks;

import tanks4Refactoring.Direction;
import tanks4Refactoring.bf.Destroyable;
import tanks4Refactoring.bf.Drawable;

public interface Tank  extends Drawable, Destroyable {
    public Action setUp();

    public void move();

    public Bullet fire();

    public int getX();

    public int getY();

    public void setX(int x);

    public void setY(int y);

    public Direction getDirection();

    public void updateX(int x);

    public void updateY(int y);

    public int getSpeed();

    public int getMovePath();
}
