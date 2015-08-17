package tanks4Refactoring.bf.tanks;

import tanks4Refactoring.*;
import tanks4Refactoring.bf.BattleField;

import java.awt.*;

public abstract class AbstractTank implements Tank{

    private Direction direction;
    private FlagFire flagFire;

    // current position on BF
    private int x;
    private int y;

    protected int speed = 10;
    protected int movePath = 1;

    protected Color tankColor;
    protected Color towerColor;

    private boolean destroyed;

    private BattleField battleField;


    public AbstractTank(BattleField bf){
        this(bf,0, 512, Direction.Top);

    }

    public AbstractTank(BattleField bf, int x, int y, Direction direction){
        this.battleField=bf;
        this.x=x;
        this.y=y;
        this.direction=direction;
        this.destroyed = false;

        this.flagFire= FlagFire.DoNotFire;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public FlagFire getFlagFire() {
        return flagFire;
    }

    public void setFlagFire(FlagFire flagFire) {
        this.flagFire = flagFire;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        destroyed = true;
    }

    public void draw(Graphics g) {
        g.setColor(tankColor);
        g.fillRect(this.getX(), this.getY(), 64, 64);

        g.setColor(towerColor);
        // 1 - top, 2 - bottom, 3 - left, 4 - right
        if (this.getDirection() == Direction.Top) {
            g.fillRect(this.getX() + 20, this.getY(), 24, 34);
        } else if (this.getDirection() == Direction.Bottom) {
            g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
        } else if (this.getDirection() == Direction.Left) {
            g.fillRect(this.getX(), this.getY() + 20, 34, 24);
        } else {
            g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
        }

    }

    public void updateX(int x){
        this.x+=x;
    }

    public void updateY(int y){
        this.y+=y;
    }


    public void turn(Direction direction){
        this.direction=direction;
    }

    public void move(){
     }

    public Bullet fire(){
		int bulletX = -100;
		int bulletY = -100;
		if (direction == Direction.Top) {
			bulletX = x + 25;
			bulletY = y - 63;
		} else if (direction == Direction.Bottom) {
			bulletX = x + 25;
			bulletY = y + 63;
		} else if (direction == Direction.Left) {
			bulletX = x - 63;
            bulletY = y + 25;
		} else if (direction == Direction.Right) {
			bulletX = x + 63;
			bulletY = y + 25;
		}
		return new Bullet(bulletX, bulletY, direction);
	}


    public void moveRandom() throws Exception{
    }

    public void moveToQuadrant(int v, int h) throws Exception{
     }

    public void cleanRandom() throws Exception{
        setFlagFire(FlagFire.Fire);
    }

    public void runAndFire() throws Exception{
        Bullet bullet=new Bullet((x+25),(y+25),direction);
    }

    public void clean ()  throws Exception{
        setFlagFire(FlagFire.Fire);
    }

    @Override
    public int getMovePath() {
        return movePath;
    }

}
