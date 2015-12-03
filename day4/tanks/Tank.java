package day4.tanks;

public class Tank {

    private Direction direction;

    private int x;
    private int y;
    protected int speed = 10;

    private ActionField actionField;
    private BattleField battleField;

    private int flagFire=0;

    public Tank(ActionField af, BattleField bf){
        this(af,bf,128, 512, Direction.Top);

    }

    public Tank(ActionField af, BattleField bf, int x, int y, Direction direction){
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
    }

    public void moveRandom() throws Exception{
        actionField.processMoveRandom(this);
    }

    public void moveToQuadrant(int v, int h) throws Exception{
        actionField.processMoveToQuadrant(this,v,h);
    }


    public void clean ()  throws Exception{
        actionField.processClean();
    }

}
