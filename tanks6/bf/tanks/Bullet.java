package tanks6.bf.tanks;

import tanks6.Direction;
import tanks6.bf.BFObject;
import tanks6.bf.Destroyable;
import tanks6.bf.Drawable;

import java.awt.*;

public class Bullet implements  Drawable,Destroyable{

    private int speed;
    private int x;
    private int y;
    private Direction direction;
    private boolean destroyed;

    public Bullet(int x, int y, Direction direction) {
        this.speed=10;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void updateX(int x){
        this.x+=x;
    }

    public void updateY(int y){
        this.y+=y;
    }

    public void destroy(){
        destroyed = true;
    }


    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public void draw(Graphics g) {
        if (!destroyed) {
            g.setColor(new Color(255, 255, 0));
            g.fillRect(this.x, this.y, 14, 14);
        }
    }
}
