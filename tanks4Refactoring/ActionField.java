package tanks4Refactoring;

import sun.java2d.pipe.SpanShapeRenderer;
import tanks4Refactoring.bf.*;
import tanks4Refactoring.bf.tanks.*;
import tanks4Refactoring.bf.tanks.Action;

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

    //private Tank tank;
    private Tank defender;
    private Tank aggressor;
    private Bullet bullet;
    private BattleField battleField;


    void runTheGame() throws Exception {

        while (true) {
            if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
                processAction(aggressor.setUp(), aggressor);
            }

            if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
                processAction(defender.setUp(), defender);
            }
        }
    }

    private void processAction(Action a, Tank t) throws Exception {
        System.out.println("!!!!!!!!!!!!!!!!!acton= "+a.toString());
        if (a == Action.MOVE) {
            processMove(t);
        } else if (a == Action.FIRE) {
            processTurn(t);
            processFire(t.fire());
        }
    }

    private void processTurn(Tank tank) throws Exception {
        repaint();
    }

    private void processMove(Tank tank) throws Exception {
        processTurn(tank);
        Direction direction = tank.getDirection();
        int step = 1;

        for (int i = 0; i < tank.getMovePath(); i++) {
            int covered = 0;

            String tankQuadrant = getQuadrant(tank.getX(), tank.getY());
            int v = Integer.parseInt(tankQuadrant.split("_")[0]);
            int h = Integer.parseInt(tankQuadrant.split("_")[1]);


            // check limits x: 0, 513; y: 0, 513
            if ((direction == Direction.Top && tank.getY() == 0) || (direction == Direction.Bottom && tank.getY() >= 512)
                    || (direction == Direction.Left && tank.getX() == 0) || (direction == Direction.Right && tank.getX() >= 512)) {
                System.out.println("[illegal move] direction: " + direction
                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                return;
            }


            // check next quadrant before move
            if (direction == Direction.Top) {
                v--;
            } else if (direction == Direction.Bottom) {
                v++;
            } else if (direction == Direction.Right) {
                h++;
            } else if (direction == Direction.Left) {
                h--;
            }

            BFObject bfobject = battleField.scanQuadrant(v, h);
            System.out.println("obj!!!!!!!!!!!!!!!!!!!!!  "+bfobject.toString());


            if (!(bfobject instanceof Blank) && !bfobject.isDestroyed()) {
                System.out.println("[illegal move] direction: " + direction
                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                return;
            }


            // process move
            while (covered < 64) {
                if (direction == Direction.Top) {
                    tank.updateY(-step);
                    				System.out.println("[move up] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                } else if (direction == Direction.Bottom) {
                    tank.updateY(step);
                    				System.out.println("[move down] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                } else if (direction == Direction.Left) {
                    tank.updateX(-step);
                   				System.out.println("[move left] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                } else {
                    tank.updateX(step);
                    				System.out.println("[move right] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                }
                covered += step;

                repaint();
                Thread.sleep(tank.getSpeed());
            }
        }
    }

    private void processFire(Bullet bullet) throws Exception {

        this.bullet = bullet;
        int step = 1;

        while ((bullet.getX() > -14 && bullet.getX() < 590)
                && (bullet.getY() > -14 && bullet.getY() < 590)) {

            if (bullet.getDirection() == Direction.Top) {
                bullet.updateY(-step);
            } else if (bullet.getDirection() == Direction.Bottom) {
                bullet.updateY(step);
            } else if (bullet.getDirection() == Direction.Left) {
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

    private boolean processInterception() {
        String coordinates = getQuadrant(bullet.getX(), bullet.getY());
        int y = Integer.parseInt(coordinates.split("_")[0]);
        int x = Integer.parseInt(coordinates.split("_")[1]);


        if (y >= 0 && y < 9 && x >= 0 && x < 9) {
            BFObject bfObject = battleField.scanQuadrant(y, x);

            System.out.println("inter---obj!!!!!!!!!!!!!!!!!!!!!  "+bfObject.toString());

            if (!bfObject.isDestroyed() && !(bfObject instanceof Blank)) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!! destroy1");
                battleField.destroyObject(y, x);
                return true;
            }

            // check aggressor
            if (!aggressor.isDestroyed() && checkInterception(getQuadrant(aggressor.getX(), aggressor.getY()), coordinates)) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!! destroy2");
                battleField.destroyObject(aggressor.getY(), aggressor.getX());
                aggressor.destroy();
                return true;
            }

            // check aggressor
            if (!defender.isDestroyed() && checkInterception(getQuadrant(defender.getX(), defender.getY()), coordinates)) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!! destroy3");
                defender.destroy();
                return true;
            }
        }
        return false;
    }

    private boolean checkInterception(String object, String quadrant) {
        int oy = Integer.parseInt(object.split("_")[0]);
        int ox = Integer.parseInt(object.split("_")[1]);

        int qy = Integer.parseInt(quadrant.split("_")[0]);
        int qx = Integer.parseInt(quadrant.split("_")[1]);

        if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
            if (oy == qy && ox == qx) {
                return true;
            }
        }
        return false;
    }

    public String getQuadrant(int x, int y) {
        // input data should be correct
        return y / 64 + "_" + x / 64;
    }

    public ActionField() throws Exception {
        battleField = new BattleField();
        defender = new T34(battleField);

        String location = battleField.getAggressorLocation();
        aggressor = new BT7(battleField,
                Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.Right);

        bullet = new Bullet(-100, -100, Direction.Non);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 7");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleField.getBfWidth(), battleField.getBfHeight() + 22));
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

        battleField.draw(g);

        defender.draw(g);
        aggressor.draw(g);
        bullet.draw(g);
    }

  /*
    public ActionField() throws Exception{

        battleField=new BattleField();
        bullet=new Bullet(-100,-100, Direction.Non);

        defender=new T34(battleField);

        String location = battleField.getAggressorLocation();
        aggressor=new BT7(battleField,
                Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.Top);

        JFrame frame = new JFrame("BATTLE FIELD");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
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
        battleField.draw(g);

        defender.draw(g);
        aggressor.draw(g);
        bullet.draw(g);

    }


    //run
    public void runTheGame() throws Exception{
         while (true) {
            if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
                processAction(aggressor.setUp(), aggressor);
            }
            if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
                processAction(defender.setUp(), defender);
            }
        }
    }

    //!!!!!!!!!!!!!!!!
    private void processAction(Action a, Tank t) throws Exception {
        if (a == Action.MOVE) {
            processMove(t);
        } else if (a == Action.FIRE) {
            processTurn(t);
            processFire(t.fire());
        }
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
            BFObject bfObject = battleField.scanQuadrant(y, x);
            if (!bfObject.isDestroyed() && !(bfObject instanceof Blank)) {
                battleField.destroyObject(y, x);
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
    public void processMove(Tank tank) throws Exception {

        //this.defender=tank;
        processTurn(tank);
        Direction direction = tank.getDirection();
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
                processTurn(tank);
                Thread.sleep(tank.getSpeed());
            }else{
                System.out.println(" !!!!!!! no repaint "+direction+" "+tank.getX()/QUADRANT_SIZE+":"+tank.getY()/QUADRANT_SIZE);
                tank.setX(tankXTmp);
                tank.setY(tankYTmp);
            }
        }

        System.out.println("RESULT MOVE: "+tank.getX()/QUADRANT_SIZE+":"+tank.getY()/QUADRANT_SIZE);
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

    }

    //

    private boolean isElementOnQuadrant(int y, int x, BFObject element){
        BFObject bfObject = battleField.scanQuadrant(y, x);
        if(y>=0 && y<QUADRANT_COUNT_Y && x>=0 && x<QUADRANT_COUNT_X
                && (!bfObject.isDestroyed() && bfObject.equals(element))){
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


*/

}
