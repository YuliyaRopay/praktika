package day4.tanks;

import javax.swing.*;
import java.awt.*;

public class ActionField extends JPanel{

    private final boolean COLORDED_MODE = false;

    //final int BF_WIDTH = 576;
    //final int BF_HEIGHT = 576;

    final int QUADRANT_SIZE=64;
    final int QUADRANT_COUNT_X=9;
    final int QUADRANT_COUNT_Y=9;

    final int BF_WIDTH = QUADRANT_SIZE*QUADRANT_COUNT_X;
    final int BF_HEIGHT = QUADRANT_SIZE*QUADRANT_COUNT_Y;


    private BattleField battleField;
    private Tank tank;
    private Bullet bullet;

    public ActionField()throws Exception{

        battleField=new BattleField();
        bullet=new Bullet(-100,-100,Direction.Non);
        tank=new Tank(this,battleField);
        bullet=new Bullet(-100,-100,Direction.Non);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);

        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        for (int j = 0; j < battleField.getDimentionY(); j++) {
            for (int k = 0; k < battleField.getDimentionX(); k++) {
                if (battleField.scanQuadrant(j, k).equals("B")) {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);
                }
            }
        }

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tank.getX(), tank.getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        // 1 - top, 2 - bottom, 3 - left, 4 - right
        if (tank.getDirection() == Direction.Top) {
            g.fillRect(tank.getX() + 20, tank.getY(), 24, 34);
        } else if (tank.getDirection() == Direction.Bottom) {
            g.fillRect(tank.getX() + 20, tank.getY() + 30, 24, 34);
        } else if (tank.getDirection() == Direction.Left) {
            g.fillRect(tank.getX(), tank.getY() + 20, 34, 24);
        } else {
            g.fillRect(tank.getX() + 30, tank.getY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }

    //------------------------------

    public void runTheGame() throws Exception{
        tank.moveRandom();

        //tank.clean();

        tank.fire();
        tank.fire();
        tank.fire();
        tank.move();
        tank.turn(Direction.Left);
        tank.fire();
        tank.move();
    }


    public boolean processInterception() {
        String coordinates = getQuadrantByCoordinates(bullet.getY(), bullet.getX());
        int separator = coordinates.indexOf("_");
        int x = Integer.parseInt(coordinates.substring(0, separator));
        int y = Integer.parseInt(coordinates.substring(separator + 1));

        if(y>=0 && y<QUADRANT_COUNT_Y && x>=0 && x<QUADRANT_COUNT_X){
            if(!battleField.scanQuadrant(y, x).trim().isEmpty()){
                battleField.updateQuadrant(y, x, "");
                return true;
            }
        }

        return false;
    }

    //-----
    public String getQuadrant(int x, int y){
        return y/QUADRANT_SIZE+"_"+x/QUADRANT_SIZE;
    }

    //----
    public String getQuadrantXY(int v, int h) {
        return (v - 1) * QUADRANT_SIZE + "_" + (h - 1) * QUADRANT_SIZE;
    }

    //x=h, y=v, result=x_y
    public String getQuadrantByCoordinates(int v, int h){
        return h/QUADRANT_SIZE+"_"+v/QUADRANT_SIZE;
    }

    //
    public void processTurn(Tank tank) throws Exception{
        repaint();
        //tankDirection=direction;
    }

    //
    //moving 1-up, 2-down, 3-left, 4-right
    public void processMove(Tank tank) throws Exception {

        this.tank=tank;
        Direction direction=tank.getDirection();
        int step=1;
        int covered=0;

        int tankXTmp = tank.getX();
        int tankYTmp = tank.getY();

        tank.turn(direction);

        while(covered<QUADRANT_SIZE){
            if(direction==Direction.Top){
                tank.updateY(-step);
                System.out.println("up "+tank.getX()+":"+tank.getY());
            }else if(direction==Direction.Bottom){
                tank.updateY(+step);
                System.out.println("down "+tank.getX()+":"+tank.getY());
            }else if(direction==Direction.Left){
                tank.updateX(-step);
                System.out.println("left "+tank.getX()+":"+tank.getY());
            }else if(direction==Direction.Right){
                tank.updateX(+step);
                System.out.println("right "+tank.getX()+":"+tank.getY());
            }

            covered+=step;

            if((tank.getY()>=0 && tank.getY()<BF_HEIGHT) && (tank.getX()>=0 && tank.getX()<BF_WIDTH)){
                repaint();
                Thread.sleep(tank.getSpeed());
                //System.out.println(" ; repaint "+tankX/QUADRANT_SIZE+":"+tankY/QUADRANT_SIZE);
            }else{
                tank.setX(tankXTmp);
                tank.setY(tankYTmp);
                System.out.println(" ; no repaint "+tank.getX()/QUADRANT_SIZE+":"+tank.getY()/QUADRANT_SIZE);
            }
        }

        System.out.println("RESULT MOVE: "+tank.getX()/QUADRANT_SIZE+":"+tank.getY()/QUADRANT_SIZE);
    }


    //
    public void processFire(Bullet bullet) throws Exception {
        this.bullet=bullet;
        //this.tank=tank;

        int step=1;

        //bullet.setX(tank.getX() + 25);
        //bullet.setY(tank.getY()+ 25);

        while (bullet.getX() > -15 && bullet.getX() < BF_WIDTH && bullet.getY() > -15 && bullet.getY() < BF_HEIGHT) {
            //System.out.println(bulletX + "----" + bulletY);
// 1 - top, 2 - bottom, 3 - left, 4 - right
            if (bullet.getDirection() == Direction.Top) {
                bullet.updateY(-step);
            } else if (bullet.getDirection() == Direction.Bottom) {
                bullet.updateY(+step);
            } else if (bullet.getDirection() == Direction.Left) {
                bullet.updateX(-step);
            } else {
                bullet.updateX(+step);
            }

            if (processInterception() == true) {
                bullet.destroy();
            }

            repaint();
            Thread.sleep(bullet.getSpeed());
        }
    }


 /*
    // moveToQuadrant(y, x)
    public void processMoveToQuadrant(int v, int h) throws Exception {
        String quadrant = getQuadrant(v, h);

        int resultX = Integer.parseInt(quadrant.substring(0,
                quadrant.indexOf("_")));
        int resultY = Integer
                .parseInt(quadrant.substring(quadrant.indexOf("_") + 1));

        while (resultX != tank.getX()) {
            if (resultX > tank.getX()) {
                runAndFire(4);
            } else {
                runAndFire(3);
            }
        }

        while (resultY != tank.getY()) {
            if (resultY > tank.getY()) {
                runAndFire(2);
            } else {
                runAndFire(1);
            }
        }
    }

    //flagFire = 0/1  no fire/fire
    public void runAndFire(int direction) throws Exception {

        int x=tank.getX()/QUADRANT_SIZE;
        int y=tank.getY()/QUADRANT_SIZE;

        int nextX=x;
        int nextY=y;

        if(direction==1){
            nextY-=1;
        }else if(direction==2){
            nextY+=1;
        }else if(direction==3){
            nextX-=1;
        }else if(direction==4){
            nextX+=1;
        }

        tank.turn(direction);
        repaint();

        int i = 0;
        if(tank.getFlagFire()==1 && isElementOnQuadrant(nextY, nextX, "B")){
            System.out.println("nextX="+nextX+"  nextY="+nextY +"  fire");
            Thread.sleep(20);
            while (i <= 1) {
                processFire(bullet);
                i++;
            }
        }

        processMove(tank);

    }


    //
    public boolean isElementOnQuadrant(int y, int x, String element){

        if(y>=0 && y<QUADRANT_COUNT_Y && x>=0 && x<QUADRANT_COUNT_X
                && battleField.scanQuadrant(y, x).equalsIgnoreCase(element)){
            System.out.println("x="+x+"  y="+y +"  element="+element);
            return true;
        }
        return false;
    }


    //
    public void processClean(Tank tank) throws Exception {
        this.tank=tank;

        for (int i = 1; i <= QUADRANT_COUNT_X; i++) {
            if (i % 2 == 0) {
                processMoveToQuadrant(1, i);
            }
            else {
                for (int j = 1; j <= QUADRANT_COUNT_Y; j++) {
                    processMoveToQuadrant(j, i);
                }
            }
        }
    }
 */


}
