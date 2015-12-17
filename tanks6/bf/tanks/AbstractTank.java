package tanks6.bf.tanks;


import tanks6.Direction;
import tanks6.bf.BattleField;

import java.awt.*;

public class AbstractTank implements Tank {

    private int speed = 10;
    protected int movePath = 1;

    private Direction direction;

    private int x;
    private int y;

    private boolean destroyed;

    private BattleField bf;

    protected Color tankColor;
    protected Color towerColor;


    public AbstractTank(BattleField bf) {
        this(bf, 0, 512, Direction.TOP);
    }

    public AbstractTank(BattleField bf, int x, int y, Direction direction) {
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;
    }

    @Override
    public void draw(Graphics g) {
        if (!destroyed) {
            g.setColor(tankColor);
            g.fillRect(this.getX(), this.getY(), 64, 64);

            g.setColor(towerColor);
            if (this.getDirection() == Direction.TOP) {
                g.fillRect(this.getX() + 20, this.getY(), 24, 34);
            } else if (this.getDirection() == Direction.BOTTOM) {
                g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
            } else if (this.getDirection() == Direction.LEFT) {
                g.fillRect(this.getX(), this.getY() + 20, 34, 24);
            } else {
                g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
            }
        }
    }

    public void turn(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public void destroy() {
        destroyed = true;
    }

    @Override
    public Bullet fire(){
        int bulletX = -100;
        int bulletY = -100;
        if (direction == Direction.TOP) {
            bulletX = x + 25;
            bulletY = y - 63;
        } else if (direction == Direction.BOTTOM) {
            bulletX = x + 25;
            bulletY = y + 63;
        } else if (direction == Direction.LEFT) {
            bulletX = x - 63;
            bulletY = y + 25;
        } else if (direction == Direction.RIGHT) {
            bulletX = x + 63;
            bulletY = y + 25;
        }
        return new Bullet(bulletX, bulletY, direction);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void updateX(int x) {
        this.x += x;
    }

    @Override
    public void updateY(int y) {
        this.y += y;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getMovePath() {
        return movePath;
    }


    @Override
    public Action setUp() {
        return null;
    }

    @Override
    public void move() {

    }

    /*

	public void move() {
	}

	public void moveToQuadrant(int v, int h) throws Exception {
	}

	public void moveRandom() throws Exception {
	}

	public void clean() throws Exception {
	}

     */
}
