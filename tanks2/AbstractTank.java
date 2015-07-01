package tanks2;


import java.awt.*;

public abstract class AbstractTank implements Drawable,Destroyable{

    private Direction direction;

    private int x;
    private int y;
    protected int speed = 10;

    private ActionField actionField;
    private BattleField battleField;

    protected Color tankColor;
    protected Color towerColor;

    public AbstractTank(ActionField af, BattleField bf){
        this(af,bf,128, 512, Direction.Top);

    }

    public AbstractTank(ActionField af, BattleField bf, int x, int y, Direction direction){
        this.actionField=af;
        this.battleField=bf;
        this.x=x;
        this.y=y;
        this.direction=direction;
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

    public void destroy(){
        setX(-100);
        setY(-100);
    }

    public void updateX(int x){
        this.x+=x;
    }

    public void updateY(int y){
        this.y+=y;
    }


    public void turn(Direction direction) throws Exception{
        this.direction=direction;
        actionField.processTurn(this);
    }

    public void move()throws Exception{
        actionField.processMove(this);
    }

    public void fire() throws Exception{
        Bullet bullet=new Bullet((x+25),(y+25),direction);
        actionField.processFire(bullet);

        /*
        int bulletX=-100;
        int bulletY=-100;
        if(direction==Direction.Top){
            bulletX=x+25;
            bulletY=y-64;
        }else if(direction==Direction.Bottom){
            bulletX=x+25;
            bulletY=y+64;
        }else if(direction==Direction.Left){
            bulletX=x-64;
            bulletY=y+25;
        }else if(direction==Direction.Right){
            bulletX=x+64;
            bulletY=y+25;
        }

        Bullet bullet=new Bullet(bulletX,bulletY,direction);
        actionField.processFire(bullet);
       */
    }

    public void moveRandom() throws Exception{
        actionField.processMoveRandom(this);
    }

    public void moveToQuadrant(int v, int h) throws Exception{
        actionField.processMoveToQuadrant(this,v,h);
    }

    /*
    public void clean ()  throws Exception{

    }
     */

    public void draw(Graphics g){
        g.setColor(tankColor);
        g.fillRect(this.getX(), this.getY(), 64, 64);

        g.setColor(towerColor);
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
}
