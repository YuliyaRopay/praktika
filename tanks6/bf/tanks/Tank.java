package tanks6.bf.tanks;

import tanks6.Direction;
import tanks6.bf.BFObject;
import tanks6.bf.Destroyable;
import tanks6.bf.Drawable;

public interface Tank extends Drawable,Destroyable {

    public Action setUp();

    public void move();

    public Bullet fire();

    public int getX();

    public int getY();

    public void setX(int x);

    public void setY(int y);

    public Direction getDirection();

    public void turn(Direction direction);

    public void updateX(int x);

    public void updateY(int y);

    public int getSpeed();

    public int getMovePath();

}
