package tanks2;

import java.awt.*;


public class Bullet implements Drawable,Destroyable{

    private int speed=10;
    private int x;
    private int y;
    private Direction direction;

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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
        this.x=-100;
        this.y=-100;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(255,255,0));
        g.fillRect(this.x,this.y,14,14);
    }

}
