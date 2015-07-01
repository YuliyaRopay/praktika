package day4.tanks;


import java.util.Random;

public class Tank {
    // 1 - top, 2 - bottom, 3 - left, 4 - right
    private Direction direction;

    //0-no fire, 1-fire
    int flagFire=0;

    private int x;
    private int y;

    private int speed = 10;

    private ActionField actionField;
    private BattleField battleField;

    private ActionField af;
    private BattleField bf;

    public Tank(ActionField af, BattleField bf){
        this(af,bf,128, 512, Direction.Top);

    }

    public Tank(ActionField af, BattleField bf, int x, int y, Direction direction){
        this.af=af;
        this.bf=bf;
        this.x=x;
        this.y=y;
        this.direction=direction;
    }

    public Direction getDirection() {
        return direction;
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

    public int getSpeed() {
        return speed;
    }

    public void updateX(int x){
        this.x+=x;
    }

    public void updateY(int y){
        this.y+=y;
    }

    public int getFlagFire() {
        return flagFire;
    }

    public void setFlagFire(int flagFire) {
        this.flagFire = flagFire;
    }

    public void destroy(){
        setX(-100);
        setY(-100);
    }

    public void turn(Direction direction) throws Exception{
        this.direction=direction;
        af.processTurn(this);
    }

    public void move()throws Exception{
        af.processMove(this);
    }

    public void fire() throws Exception{
        Bullet bullet=new Bullet((x+25),(y+25),direction);
        af.processFire(bullet);
    }

    public void moveRandom() throws Exception{
        Random r=new Random();
        int i;
        while(true){
            i=r.nextInt(5)+1;
            // 1 - top, 2 - bottom, 3 - left, 4 - right
            direction=Direction.values()[i];
            //move(i);
            //runAndFire(i);
            af.processTurn(this);
            af.processMove(this);
            Thread.sleep(speed);
        }
    }

    public void moveToQuadrant(int v, int h) throws Exception{
    }

    public void clean ()  throws Exception{

    }

}
