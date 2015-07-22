package tanks3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ActionField extends JPanel {

    private final boolean COLORDED_MODE = false;

    private final int QUADRANT_SIZE=64;

    private final int QUADRANT_COUNT_X=9;
    private final int QUADRANT_COUNT_Y=9;

    //final int BF_WIDTH = 576;
    //final int BF_HEIGHT = 576;
    private final int BF_WIDTH = QUADRANT_SIZE*QUADRANT_COUNT_X;
    private final int BF_HEIGHT = QUADRANT_SIZE*QUADRANT_COUNT_Y;

    //private Tank tank;
    private T34 defender;
    private Tiger aggressor;
    private Bullet bullet;
    private BattleField battleField;



    public ActionField() throws Exception{

        battleField=new BattleField();
        bullet=new Bullet(-100,-100, Direction.Non);
        //tank=new Tank(this,battleField);
        defender=new T34(this,battleField);

        String location = battleField.getAggressorLocation();
        aggressor=new Tiger(this,battleField,
                Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.Top);

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

        /*
        g.setColor(new Color(0, 255, 0));
        g.fillRect(defender.getX(), defender.getY(), 64, 64);

        g.setColor(new Color(255, 0, 0));
        // 1 - top, 2 - bottom, 3 - left, 4 - right
        if (defender.getDirection() == Direction.Top) {
            g.fillRect(defender.getX() + 20, defender.getY(), 24, 34);
        } else if (defender.getDirection() == Direction.Bottom) {
            g.fillRect(defender.getX() + 20, defender.getY() + 30, 24, 34);
        } else if (defender.getDirection() == Direction.Left) {
            g.fillRect(defender.getX(), defender.getY() + 20, 34, 24);
        } else {
            g.fillRect(defender.getX() + 30, defender.getY() + 20, 34, 24);
        }*/
        defender.draw(g);
        aggressor.draw(g);
        bullet.draw(g);

/*
        //aggressor
        g.setColor(new Color(255, 0, 0));
        g.fillRect(aggressor.getX(), aggressor.getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        // 1 - top, 2 - bottom, 3 - left, 4 - right
        if (aggressor.getDirection() == Direction.Top) {
            g.fillRect(aggressor.getX() + 20, aggressor.getY(), 24, 34);
        } else if (aggressor.getDirection() == Direction.Bottom) {
            g.fillRect(aggressor.getX() + 20, aggressor.getY() + 30, 24, 34);
        } else if (aggressor.getDirection() == Direction.Left) {
            g.fillRect(aggressor.getX(), aggressor.getY() + 20, 34, 24);
        } else {
            g.fillRect(aggressor.getX() + 30, aggressor.getY() + 20, 34, 24);
        }
*/
/*
        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
        */
    }


    //run
    public void runTheGame() throws Exception{
        //System.out.println(getCoordinates(1, 2));
        //System.out.println(getQuadrant(tank.getY(),tank.getX()));

/*
        tank.turn(Direction.Left);
        tank.move();
        tank.move();
        tank.move();
        tank.move();
        tank.turn(Direction.Right);
        tank.move();
        tank.move();
        tank.turn(Direction.Top);
        tank.move();
        tank.move();
        tank.move();
        tank.turn(Direction.Bottom);
        tank.move();
        tank.move();
        tank.move();
        tank.move();
        tank.move();
        tank.turn(Direction.Right);
        tank.fire();
        tank.fire();
        tank.fire();
        tank.fire();
*/

        //tank.moveToQuadrant(5,8);

        //tank.moveRandom();
        //tank.cleanRandom();

        //tank.clean();

        defender.fire();
        defender.fire();
        defender.fire();
        defender.fire();
        defender.fire();
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
    public void processTurn(AbstractTank tank) throws Exception{
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

            if(aggressor.getX()/QUADRANT_SIZE==x && aggressor.getY()/QUADRANT_SIZE==y){
                aggressor.destroy();
                return true;
            }
        }




        return false;
    }

    //
    public void processMove(AbstractTank tank) throws Exception {

        //this.defender=tank;
        Direction direction=tank.getDirection();
        int step=1;
        int covered=0;

        int tankXTmp = tank.getX();
        int tankYTmp = tank.getY();

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

            if((tank.getY()>=0 && tank.getY()<=BF_HEIGHT-QUADRANT_SIZE) && (tank.getX()>=0 && tank.getX()<=BF_WIDTH-QUADRANT_SIZE)){
                tank.turn(direction);
                Thread.sleep(tank.getSpeed());
            }else{
                System.out.println(" !!!!!!! no repaint "+direction+" "+tank.getX()/QUADRANT_SIZE+":"+tank.getY()/QUADRANT_SIZE);
                tank.setX(tankXTmp);
                tank.setY(tankYTmp);
            }
        }

        System.out.println("RESULT MOVE: "+tank.getX()/QUADRANT_SIZE+":"+tank.getY()/QUADRANT_SIZE);

        /*
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
        */
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
            } else if (bullet.getDirection() ==Direction.Bottom) {
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

    public void processMoveRandom(AbstractTank tank) throws Exception{
        //this.tank=tank;
        Random r=new Random();
        int i;
        while(true){
            i=r.nextInt(4)+1;
            // 1 - top, 2 - bottom, 3 - left, 4 - right
            tank.turn(Direction.values()[i]);
            tank.move();
            //runAndFire(i);
            Thread.sleep(tank.getSpeed());
        }

    }

    //
    public void processMoveToQuadrant(AbstractTank tank, int v, int h) throws Exception {
        //this.tank=tank;
        String quadrant = getCoordinates(v, h);

        int resultY = Integer.parseInt(quadrant.substring(0,
                quadrant.indexOf("_")));
        int resultX = Integer
                .parseInt(quadrant.substring(quadrant.indexOf("_") + 1));

        while (resultX != tank.getX()) {
            if (resultX > tank.getX()) {

                tank.turn(Direction.Right);
                tank.runAndFire();
                //tank.move();
            } else {
                tank.turn(Direction.Left);
                tank.runAndFire();
                //tank.move();
            }
        }


        while (resultY != tank.getY()) {
            if (resultY > tank.getY()) {
                tank.turn(Direction.Bottom);
                tank.runAndFire();
                //tank.move();
            } else {
                tank.turn(Direction.Top);
                tank.runAndFire();
                //tank.move();
            }
        }
        //System.out.println("quadrant="+quadrant+"#"+"result="+resultX + "="+resultY+" # stop=" + tank.getX()+"="+tank.getY());
    }


    //
    public void processRunAndFire(AbstractTank tank) throws Exception {
        //this.tank=tank;
        Direction direction=tank.getDirection();

        int x=tank.getX()/QUADRANT_SIZE;
        int y=tank.getY()/QUADRANT_SIZE;

        int nextX=x;
        int nextY=y;

        if(direction==Direction.Top){
            nextY-=1;
        }else if(direction==Direction.Bottom){
            nextY+=1;
        }else if(direction==Direction.Left){
            nextX-=1;
        }else if(direction==Direction.Right){
            nextX+=1;
        }

        tank.turn(direction);

        int i = 0;


        if(tank.getFlagFire()==FlagFire.Fire && isElementOnQuadrant(nextY, nextX, "B")){
            tank.fire();
            bullet.destroy();
        }

        if(tank.getFlagFire()==FlagFire.Fire && isElementOnQuadrant(nextY, nextX, aggressor)){
            tank.fire();
            //aggressor.destroy();
            bullet.destroy();
        }
        tank.turn(direction);
        tank.move();

    }

    //

    private boolean isElementOnQuadrant(int y, int x, String element){
        if(y>=0 && y<QUADRANT_COUNT_Y && x>=0 && x<QUADRANT_COUNT_X
                && battleField.scanQuadrant(y,x).equalsIgnoreCase(element)){
            System.out.println("x="+x+"  y="+y +"  element="+element);
            return true;
        }
        return false;
    }

    private boolean isElementOnQuadrant(int y, int x, AbstractTank tank){
        AbstractTank target=tank;
        if(y>=0 && y<QUADRANT_COUNT_Y && x>=0 && x<QUADRANT_COUNT_X
                && target.getX()/QUADRANT_SIZE==x && target.getY()/QUADRANT_SIZE==y){
            System.out.println("x="+x+"  y="+y +"  element=tank");
            return true;
        }
        return false;
    }


    //
    public void processCleanRandom(AbstractTank tank) throws Exception {
        //this.tank=tank;

        Random r=new Random();
        int randomX;
        int randomY;

        while(true){
            randomX=r.nextInt(9)+1;
            randomY=r.nextInt(9)+1;
            tank.moveToQuadrant(randomY,randomX);
        }
    }

    //
    public void processClean(AbstractTank tank) throws Exception {

        //this.tank=tank;
        tank.turn(Direction.Right);

        for (int i = 1; i <= QUADRANT_COUNT_X; i++) {
            if (i % 2 == 0) {
                tank.moveToQuadrant(1, i);
            }
            else {
                for (int j = 1; j <= QUADRANT_COUNT_Y; j++) {
                    tank.moveToQuadrant(j, i);
                }
            }
        }
    }

}
