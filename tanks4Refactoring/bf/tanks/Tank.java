package tanks4Refactoring.bf.tanks;


import tanks5.Direction;
import tanks5.bf.Destroyable;
import tanks5.bf.Drawable;

public interface Tank  extends Drawable, Destroyable {
    public Action setUp();

    public void move();

    public Bullet fire();

    public int getX();

    public int getY();

    public void setX(int x);

    public void setY(int y);

    public tanks4Refactoring.Direction getDirection();

    public void updateX(int x);

    public void updateY(int y);

    public int getSpeed();

    public int getMovePath();
}
