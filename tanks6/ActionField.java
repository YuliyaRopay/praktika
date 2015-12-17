package tanks6;


import tanks6.bf.BFObject;
import tanks6.bf.BattleField;
import tanks6.bf.Blank;
import tanks6.bf.tanks.*;
import tanks6.bf.tanks.Action;

import javax.swing.*;
import java.awt.*;

public class ActionField extends JPanel {

    private boolean COLORDED_MODE = false;

    private BattleField battleField;
    private Tank defender;
    private Tank aggressor;
    private Bullet bullet;


    public ActionField() throws Exception {
        battleField = new BattleField();
        defender = new T34(battleField);

        String location = battleField.getAggressorLocation();
        aggressor = new BT7(battleField,
                Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.RIGHT);

        bullet = new Bullet(-100, -100, Direction.NONE);

        JFrame frame = new JFrame("BATTLE FIELD");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleField.getBfWidth()+16, battleField.getBfHeight() + 39));
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
        for (int v = 0; v < battleField.QUADRANT_COUNT_X; v++) {
            for (int h = 0; h < battleField.QUADRANT_COUNT_Y; h++) {
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
                g.fillRect(h * battleField.QUADRANT_SIZE, v * battleField.QUADRANT_SIZE, battleField.QUADRANT_SIZE, battleField.QUADRANT_SIZE);
            }
        }

        battleField.draw(g);
        defender.draw(g);
        aggressor.draw(g);
        bullet.draw(g);
    }

    void runTheGame() throws Exception {


/*
        processFire(aggressor);
        processFire(aggressor);
        processMove(aggressor);
        processMove(aggressor);
        processMove(aggressor);
        processMove(aggressor);
        processMove(aggressor);
        processMove(aggressor);
        processMove(aggressor);
        processMove(aggressor);
*/


        //processMoveToQuadrant(defender, 9,9);


        while (true) {
            if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
                processAction(aggressor.setUp(), aggressor);
            }

            //if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
            //    processAction(defender.setUp(), defender);
            //}
        }

    }

    private void processAction(Action a, Tank tank) throws Exception {
        if (a == Action.MOVE) {
            processMove(tank);
        } else if (a == Action.FIRE) {
            processTurn(tank);
            processFire(tank);
        }
    }

    private void processTurn(Tank tank) throws Exception {
        repaint();
    }


    //
    private void processMove(Tank tank) throws Exception {

        processTurn(tank);
        Direction direction = tank.getDirection();
        int step = 1;

        for (int i = 0; i < tank.getMovePath(); i++) {

            int covered = 0;

            int v = battleField.getQuadrant(tank.getY());
            int h = battleField.getQuadrant(tank.getX());
            System.out.println("v="+v+"  h="+h);

            if ((direction == Direction.TOP && tank.getY() == 0)
                    || (direction == Direction.BOTTOM && tank.getY() >= battleField.getBfHeight()-battleField.QUADRANT_SIZE)
                    || (direction == Direction.LEFT && tank.getX() == 0)
                    || (direction == Direction.RIGHT && tank.getX() >= battleField.getBfWidth()-battleField.QUADRANT_SIZE)) {
                System.out.println("Error move: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                return;
            }


            if (direction == Direction.BOTTOM) {
                v++;
            } else if (direction == Direction.TOP) {
                v--;
            } else if (direction == Direction.RIGHT) {
                h++;
            } else if (direction == Direction.LEFT) {
                h--;
            }

            BFObject bfobject = battleField.scanQuadrant(v, h);

            if (!(bfobject instanceof Blank) && !bfobject.isDestroyed()) {
                System.out.println("Error move: " + direction+ " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                return;
            }


            while (covered < battleField.QUADRANT_SIZE) {
                if (direction == Direction.TOP) {
                    tank.updateY(-step);
                    //System.out.println("> up "+tank.getX()+":"+tank.getY());
                } else if (direction == Direction.BOTTOM) {
                    tank.updateY(step);
                    //System.out.println("> down "+tank.getX()+":"+tank.getY())
                } else if (direction == Direction.LEFT) {
                    tank.updateX(-step);
                    //System.out.println("> left "+tank.getX()+":"+tank.getY())
                } else {
                    tank.updateX(step);
                    //System.out.println("> right "+tank.getX()+":"+tank.getY())
                }
                covered += step;

                repaint();
                Thread.sleep(tank.getSpeed());
            }
        }
    }

    //
    private void processMove2(Tank tank) throws Exception {

        Direction direction=tank.getDirection();
        int step=1;
        int covered=0;

        int tankXTmp = tank.getX();
        int tankYTmp = tank.getY();

        while(covered<battleField.QUADRANT_SIZE){


            if(direction==Direction.TOP){
                tank.updateY(-step);
                //System.out.println("> up "+tank.getX()+":"+tank.getY());
            }else if(direction==Direction.BOTTOM){
                tank.updateY(+step);
                //System.out.println("> down "+tank.getX()+":"+tank.getY());
            }else if(direction==Direction.LEFT){
                tank.updateX(-step);
                //System.out.println("> left "+tank.getX()+":"+tank.getY());
            }else if(direction==Direction.RIGHT){
                tank.updateX(+step);
                //System.out.println("> right "+tank.getX()+":"+tank.getY());
            }

            covered+=step;

            if(isProcessMove(tank.getY(),tank.getX())){
                processTurn(tank);
                Thread.sleep(tank.getSpeed());
            }else{
                System.out.println(" ERROR: no repaint "+direction+" "+tank.getX()/battleField.QUADRANT_SIZE+":"+tank.getY()/battleField.QUADRANT_SIZE);
                tank.setX(tankXTmp);
                tank.setY(tankYTmp);
                return;
            }
        }

        System.out.println("RESULT MOVE: "+tank.getX()/battleField.QUADRANT_SIZE+":"+tank.getY()/battleField.QUADRANT_SIZE);
    }

    //
    private boolean isProcessMove(int y, int x){

        BFObject bfobject = battleField.scanCoordinates(y,x);
        //System.out.println(battleField.getQuadrant(y,x));
        //System.out.println("y="+y+" x="+x+"  "+bfobject.toString());

        if((y>=0 && y<=battleField.getBfHeight()-battleField.QUADRANT_SIZE)
                && (x>=0 && x<=battleField.getBfWidth()-battleField.QUADRANT_SIZE)
                && (bfobject instanceof Blank || bfobject.isDestroyed())){
            //System.out.println("true");
            return true;
        }
        //System.out.println("false");
        return false;
    }

    //
    private void processFire(Tank tank) throws Exception {

        bullet = tank.fire();
        int step = 1;
        while ((bullet.getX() > -15 && bullet.getX() < battleField.getBfWidth())
                && (bullet.getY() > -15 && bullet.getY() < battleField.getBfHeight())) {
            if (bullet.getDirection() == Direction.TOP) {
                bullet.updateY(-step);
            } else if (bullet.getDirection() == Direction.BOTTOM) {
                bullet.updateY(step);
            } else if (bullet.getDirection() == Direction.LEFT) {
                bullet.updateX(-step);
            } else {
                bullet.updateX(step);
            }

            if (processInterception()) {
                bullet.destroy();
            }

            repaint();
            Thread.sleep(bullet.getSpeed());
            if (bullet.isDestroyed()) {
                break;
            }
        }
    }


    //
    private boolean processInterception() {

        int y = battleField.getQuadrant(bullet.getY());
        int x = battleField.getQuadrant(bullet.getX());

        if (y >= 0 && y < battleField.QUADRANT_COUNT_Y && x >= 0 && x < battleField.QUADRANT_COUNT_X) {

            BFObject bfObject = battleField.scanQuadrant(y, x);
            String quadrant_bullet = battleField.getQuadrant( bullet.getY(), bullet.getX());

            if (!bfObject.isDestroyed() && !(bfObject instanceof Blank)) {
                battleField.destroyObject(y, x);
                return true;
            }

            if (!aggressor.isDestroyed() && checkInterception(aggressor, bullet)) {
                aggressor.destroy();
                return true;
            }

            if (!defender.isDestroyed() && checkInterception(defender, bullet)) {
                defender.destroy();
                return true;
            }
        }
        return false;
    }


    //
    private boolean checkInterception(Tank tank, Bullet bullet) {

        int tankY = battleField.getQuadrant(tank.getY());
        int tankX = battleField.getQuadrant(tank.getX());

        int bulletY = battleField.getQuadrant(bullet.getY());
        int bulletX = battleField.getQuadrant(bullet.getX());

        if (tankY >= 0 && tankY < battleField.QUADRANT_COUNT_Y && tankX >= 0 && tankX < battleField.QUADRANT_COUNT_X) {
            if (tankY == bulletY && tankX == bulletX) {
                return true;
            }
        }
        return false;
    }


    //
    private void processMoveToQuadrant(Tank tank, int v, int h)throws Exception {

        int resultY=battleField.getCoordinate(v);
        int resultX=battleField.getCoordinate(h);

        while (resultX != tank.getX()) {
            if (resultX > tank.getX()) {
                tank.turn(Direction.RIGHT);
                processTurn(tank);
                processFire(tank);
                processMove(tank);
            } else {
                tank.turn(Direction.LEFT);
                processTurn(tank);
                processFire(tank);
                processMove(tank);
            }
        }

        while (resultY != tank.getY()) {
            if (resultY > tank.getY()) {
                tank.turn(Direction.BOTTOM);
                processTurn(tank);
                processFire(tank);
                processMove(tank);
            } else {
                tank.turn(Direction.TOP);
                processTurn(tank);
                processFire(tank);
                processMove(tank);
            }
        }

    }
    //
    /*
    public void processMoveToQuadrant(AbstractTank tank, int v, int h) throws Exception {

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




    */
}
