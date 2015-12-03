package day4.tanks;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ActionField extends JPanel {

    private final boolean COLORDED_MODE = false;

    private final int QUADRANT_SIZE=64;

    private final int QUADRANT_COUNT_X=9;
    private final int QUADRANT_COUNT_Y=9;

    private final int BF_WIDTH = QUADRANT_SIZE*QUADRANT_COUNT_X;
    private final int BF_HEIGHT = QUADRANT_SIZE*QUADRANT_COUNT_Y;

    private Tank tank;
   // private T34 defender;
    private Bullet bullet;
    private BattleField battleField;

    public ActionField() throws Exception{

        battleField=new BattleField();
        bullet=new Bullet(-100,-100,Direction.Non);
        tank=new Tank(this,battleField);
        //defender=new T34(this,battleField);

        JFrame frame = new JFrame("BATTLE FIELD");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 50));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
                    String coordinates = getCoordinates(j + 1, k + 1);
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


    //run
    public void runTheGame() throws Exception{
        //System.out.println(getCoordinates(1, 2));
        //System.out.println(getQuadrant(tank.getY(),tank.getX()));

        tank.turn(Direction.Right);
        tank.move();
        tank.fire();
        tank.fire();
        tank.turn(Direction.Bottom);
        tank.move();

       // tank.moveRandom();
        tank.moveToQuadrant(2,2);


        tank.clean();
    }

    //get coordinates by quadrant v-vertical, h-horizontal
    //result=y_x
    //public String getQuadrantXY(int v, int h) {
    public String getCoordinates(int v, int h) {
        return (v - 1) * QUADRANT_SIZE + "_" + (h - 1) * QUADRANT_SIZE;
    }

    //get quadrant by coordinates x,y
    //result=y_x
    public String getQuadrant(int y, int x){
        return y/QUADRANT_SIZE+"_"+x/QUADRANT_SIZE;
    }

    //repaint field
    public void processTurn(Tank tank) throws Exception{
        repaint();
    }

    //checks the intersection of bullet with objects battlefield
    private boolean processInterception() {
        String coordinates = getQuadrant(bullet.getY(), bullet.getX());
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));

        if(y>=0 && y<QUADRANT_COUNT_Y && x>=0 && x<QUADRANT_COUNT_X){
            if(!battleField.scanQuadrant(y, x).trim().isEmpty()){
                battleField.updateQuadrant(y, x, "");
                return true;
            }
        }
        return false;
    }

    //
    public void processMove(Tank tank) throws Exception {

        this.tank=tank;
        Direction direction=tank.getDirection();
        int step=1;
        int covered=0;

        int tankXTmp = tank.getX();
        int tankYTmp = tank.getY();


        // check limits x: 0, 513; y: 0, 513
        if ((direction == Direction.Top && tank.getY() == 0) || (direction == Direction.Bottom && tank.getY() >= 512)
                || (direction == Direction.Left && tank.getX() == 0) || (direction == Direction.Right && tank.getX() >= 512)) {
            System.out.println("[illegal move] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            return;
        }

        tank.turn(direction);

        while (covered < 64) {
            if (direction == Direction.Top) {
                tank.updateY(-step);
                System.out.println("[move up] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            } else if (direction == Direction.Bottom) {
                tank.updateY(+step);
                System.out.println("[move down] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            } else if (direction == Direction.Left) {
                tank.updateX(-step);
                System.out.println("[move left] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            } else {
                tank.updateX(+step);
                System.out.println("[move right] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            }
            covered += step;

            tank.turn(direction);
            Thread.sleep(tank.getSpeed());
        }
        //tank.turn(direction);

    }

    //
    public void processFire(Bullet bullet) throws Exception {
        this.bullet=bullet;
        int step=1;

        while (bullet.getX() > -15 && bullet.getX() < BF_WIDTH && bullet.getY() > -15 && bullet.getY() < BF_HEIGHT) {
            //System.out.println(bulletX + "----" + bulletY);
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

    public void processMoveRandom(Tank tank) throws Exception{
        this.tank=tank;
        Random r=new Random();
        int i;
        while(true){
            i=r.nextInt(4)+1;
            // 1 - top, 2 - bottom, 3 - left, 4 - right
            tank.turn(Direction.values()[i]);
            tank.move();
            Thread.sleep(tank.getSpeed());
        }

    }

    //
    public void processMoveToQuadrant(Tank tank, int v, int h) throws Exception {
        this.tank=tank;
        String quadrant = getCoordinates(v, h);

        int resultY = Integer.parseInt(quadrant.substring(0,
                quadrant.indexOf("_")));
        int resultX = Integer
                .parseInt(quadrant.substring(quadrant.indexOf("_") + 1));


        while (resultX != tank.getX()) {
            if (resultX > tank.getX()) {
                tank.turn(Direction.Right);
                tank.move();
                tank.fire();
            } else {
                tank.turn(Direction.Left);
                tank.move();
                tank.fire();
            }
        }

        while (resultY != tank.getY()) {
            if (resultY > tank.getY()) {
                tank.turn(Direction.Bottom);
                tank.move();
                tank.fire();
            } else {
                tank.move();
                tank.fire();
                tank.turn(Direction.Top);
            }
        }
        System.out.println(quadrant+"#"+resultX + "="+resultY+" #" + tank.getX()+"="+tank.getY());
    }

    //
    public void processClean() throws Exception {
        tank.turn(Direction.Right);
        for (int i = 1; i <= QUADRANT_COUNT_X; i++) {
//            if (i % 2 == 0) {
//                tank.moveToQuadrant(1, i);
//            }
//            else {
                for (int j = 1; j <= QUADRANT_COUNT_Y; j++) {
                    tank.moveToQuadrant(j, i);
//                }
            }
        }
    }


}
